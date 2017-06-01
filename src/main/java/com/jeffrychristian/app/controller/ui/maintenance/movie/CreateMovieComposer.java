package com.jeffrychristian.app.controller.ui.maintenance.movie;

import com.jeffrychristian.app.common.types.MovieFilterType;
import com.jeffrychristian.app.common.utils.DateUtil;
import com.jeffrychristian.app.common.utils.JUtil;
import com.jeffrychristian.app.controller.ui.common.CreateComposer;
import com.jeffrychristian.app.domain.cover.Cover;
import com.jeffrychristian.app.domain.genre.Genre;
import com.jeffrychristian.app.domain.movie.Movie;
import com.jeffrychristian.app.domain.movie.MovieFile;
import com.jeffrychristian.app.domain.parameter.Parameter;
import com.jeffrychristian.app.domain.region.Country;
import com.jeffrychristian.app.repository.*;
import org.apache.commons.io.input.ReaderInputStream;
import org.springframework.beans.BeanUtils;
import org.zkoss.image.AImage;
import org.zkoss.io.Files;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.event.*;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.*;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.imageio.stream.MemoryCacheImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.*;

/**
 * Created by jeffry.christian on 4/29/2017.
 */
public class CreateMovieComposer extends CreateComposer{

    @Wire
    private Combobox cbReleaseYear, cbFilter, cbCountry, cbSubtitle;
    @Wire
    private Textbox tbTitle,tbSynopsis,tbProduction,tbTrailer,tbWriters,tbDirectors,tbActors,tbProducers;
    @Wire
    private Intbox ibMinute;
    @Wire
    private Label lblFileCoverName,errAddGenre,errAddFile;
    @Wire
    private Doublebox dbRating;
    @Wire
    private Datebox tbReleaseDate;
    @Wire
    private Button btnBrowseCover,btnAddGenre,btnAddFile,btnSubmit,btnClose;
    @Wire
    private Grid gridGenres,gridFiles;

    @WireVariable private CountryRepository countryRepository;
    @WireVariable private ParameterRepository parameterRepository;
    @WireVariable private MovieRepository movieRepository;
    @WireVariable private MovieFileRepository movieFileRepository;
    @WireVariable private GenreRepository genreRepository;

    private ListModelList<String> modelYear = new ListModelList<>();
    private final ListModelList<Country> modelCountry = new ListModelList<>();
    private final ListModelList<Parameter> modelSubtitle = new ListModelList<>();
    private final ListModelList<MovieFilterType> modelFilter = new ListModelList<>(Arrays.asList(MovieFilterType.values()));

    private ListModelList<String> modelWriter = new ListModelList<>();

    public CreateMovieComposer() {
    }

    @Override
    public void doAfterCompose(Window comp) throws Exception {
        super.doAfterCompose(comp);

        init();
    }

    private void init(){
        tbReleaseDate.setValue(new Date());
        tbReleaseDate.setConstraint("before " + DateUtil.dateToString(new Date(), "yyyyMMdd"));

        for (int i = 0; i < 99; i++) {
            modelYear.add(DateUtil.dateToString(DateUtil.addYears(new Date(), -i), "yyyy"));
        }

        modelCountry.addAll(countryRepository.findAll());
        modelSubtitle.addAll(parameterRepository.findAllByCategoryCode("MOVIE_SUBTITLE"));
        cbReleaseYear.setModel(modelYear);
        cbFilter.setModel(modelFilter);
        cbCountry.setModel(modelCountry);
        cbSubtitle.setModel(modelSubtitle);
        gridGenres.setModel(genres);
        gridFiles.setModel(movieFiles);
    }

    private String fileFormatCover,fileTypeCover, fileExt;
    private Media mediaCover;
    private Cover cover;
    private String coverFileName;

    @Listen("onUpload = #btnBrowseCover")
    public void onBrowse(UploadEvent event){
        mediaCover = event.getMedia();

        if (mediaCover instanceof Image || mediaCover instanceof AImage) {
            String fileName = mediaCover.getName(); //ambil nama tanpa format/ext
            fileName = fileName.substring(0, fileName.lastIndexOf("."));
            fileExt = mediaCover.getName();
            fileExt = fileExt.substring(fileExt.lastIndexOf(".")+1);

            fileFormatCover = mediaCover.getFormat();
            fileTypeCover = mediaCover.getContentType();

            cover = new Cover();
            coverFileName = UUID.randomUUID().toString()+fileName;
            coverFileName.toLowerCase().replace(" ", "").trim();
            cover.setFileName(coverFileName);
            cover.setFormat(fileFormatCover);
            cover.setType(fileTypeCover);
            cover.setExt(fileExt);

            lblFileCoverName.setValue(mediaCover.getName());
            lblFileCoverName.setStyle("color:black");
        } else
            Messagebox.show("Not an image: " + mediaCover.getName(), "Error", Messagebox.OK, Messagebox.ERROR);
    }

    @Listen("onClick = #btnAddGenre")
    public void onAddGenre(){
        HashMap<String, Object> param = new HashMap<>();
        Window popUp = window("mntc.popup.moviegenre.zul", param);
        popUp.addEventListener("onResult", event -> {
            Parameter p = (Parameter) event.getData();
            if (genres.isEmpty()){
                genres.add(new Genre(p.getCode(), p.getValue(), null));
            } else {
                boolean found = false;
                for (Genre genre : genres) {
                    if (genre.getCode().equals(p.getCode())){
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    genres.add(new Genre(p.getCode(), p.getValue(), null));
                }
            }
            errAddGenre.setValue("");
        });
        popUp.doModal();
    }

    private ListModelList<Genre> genres = new ListModelList<>();
    private ListModelList<MovieFile> movieFiles = new ListModelList<>();

    @Listen("onClick = #btnAddFile")
    public void onAddFile(){
        HashMap<String, Object> param = new HashMap<>();
        Window popUp = window("mntc.popup.moviefile.zul", param);
        popUp.addEventListener("onResult", event -> {
            MovieFile mf = (MovieFile) event.getData();
            if (movieFiles.isEmpty()){
                movieFiles.add(mf);
            } else {
                boolean found = false;
                for (MovieFile file : movieFiles) {
                    if (file.getFileName().equals(mf.getFileName()) && file.getQuality().equals(mf.getQuality())){
                        found = true;
                        break;
                    }
                }
                if (!found){
                    movieFiles.add(mf);
                }
            }
            errAddFile.setValue("");
        });
        popUp.doModal();
    }

    @Listen("onDelete = #gridGenres")
    public void onDeleteGenre(ForwardEvent event){
        genres.remove(event.getData());
        gridGenres.setModel(genres);
    }

    @Listen("onDelete = #gridFiles")
    public void onDeleteFile(ForwardEvent event){
        movieFiles.remove(event.getData());
        gridFiles.setModel(movieFiles);
    }

    @Listen("onBlur = #dbRating")
    public void dbRating(){
        if (dbRating.getText().trim().isEmpty() || dbRating.getValue() < 0 || dbRating.getValue() > 10){
            dbRating.setValue(0);
        }
    }

    @Listen("onBlur = #ibMinute")
    public void ibMinute(){
        if (ibMinute.getText().trim().isEmpty() || ibMinute.getValue() < 0 || ibMinute.getValue() > 600){
            ibMinute.setValue(0);
        }
    }

    private boolean validate(){
        lblFileCoverName.setStyle("color:black");
        lblFileCoverName.setValue("");
        errAddGenre.setValue("");
        errAddFile.setValue("");

        boolean b = true;

        if (tbTitle.getValue().trim().isEmpty()){
            b = false;
        }
        if (cbReleaseYear.getValue() == null){
            b = false;
        }
        if (tbReleaseDate.getValue() == null){
            b = false;
        }
        if (tbSynopsis.getValue().trim().isEmpty()) {
            b = false;
        }
        if (tbProduction.getValue().trim().isEmpty()) {
            b = false;
        }
        if (tbTrailer.getValue().trim().isEmpty()) {
            b = false;
        }
        if (modelFilter.isSelectionEmpty()){
            b = false;
        }
        if (tbWriters.getValue().trim().isEmpty()) {
            b = false;
        }
        if (tbDirectors.getValue().trim().isEmpty()) {
            b = false;
        }
        if (tbActors.getValue().trim().isEmpty()) {
            b = false;
        }
        if (tbProducers.getValue().trim().isEmpty()) {
            b = false;
        }
        if (mediaCover == null) {
            b = false;
            lblFileCoverName.setStyle("color:red");
            lblFileCoverName.setValue("Please select your file");
        }
        if (modelCountry.isSelectionEmpty()){
            b = false;
        }
        if (modelSubtitle.isSelectionEmpty()) {
            b = false;
        }
        if (genres.isEmpty()) {
            b = false;
            errAddGenre.setStyle("color:red");
            errAddGenre.setValue("Please select at least one genre");
        }
        if (movieFiles.isEmpty()) {
            b = false;
            errAddFile.setStyle("color:red");
            errAddFile.setValue("Please select at least one file");
        }
        return b;
    }

    public void doProcess(){
        if (validate()) {
            Movie m = new Movie();
            m.setTitle(tbTitle.getValue());
            m.setRating(dbRating.getValue());
            m.setReleaseYear(modelYear.getSelection().iterator().next());
            m.setReleaseDate(tbReleaseDate.getValue());
            m.setSynopsis(tbSynopsis.getValue());
            m.setProduction(tbProduction.getValue());
            m.setTrailer(tbTrailer.getValue());
            m.setMinute(ibMinute.getValue());
            m.setWriters(tbWriters.getValue());
            m.setDirectors(tbDirectors.getValue());
            m.setActors(tbActors.getValue());
            m.setProducers(tbProducers.getValue());
            m.setFilter(modelFilter.getSelection().iterator().next());

            m.setCover(cover);
            m.setCountry(modelCountry.getSelection().iterator().next());
            m.setSubtitle(modelSubtitle.getSelection().iterator().next());
            movieRepository.save(m);

            for (Genre g : genres) {
                g.setMovie(m);
            }
            for (MovieFile mf : movieFiles) {
                mf.setMovie(m);
            }
            genreRepository.save(genres);
            movieFileRepository.save(movieFiles);

            String coverPathTiny = parameterRepository.findByCode("VID_IMG_TINY").getValue();
            String coverPathSmall = parameterRepository.findByCode("VID_IMG_SMALL").getValue();
            String coverPathMedium = parameterRepository.findByCode("VID_IMG_MEDIUM").getValue();
            String coverPathNormal = parameterRepository.findByCode("VID_IMG_NORMAL").getValue();

            setupUploadPath(coverPathTiny, coverPathSmall, coverPathMedium, coverPathNormal);

            Media imgTiny = mediaCover;
            Media imgSmall = mediaCover;
            Media imgMedium = mediaCover;
            Media imgNormal = mediaCover;

            assert false;
            BeanUtils.copyProperties(mediaCover, imgTiny);
            BeanUtils.copyProperties(mediaCover, imgSmall);
            BeanUtils.copyProperties(mediaCover, imgMedium);
            BeanUtils.copyProperties(mediaCover, imgNormal);

            //save tiny img
            saveCover(imgTiny, coverFileName, coverPathTiny);
            //save small img
            saveCover(imgSmall, coverFileName, coverPathSmall);
            //save medium img
            saveCover(imgMedium, coverFileName, coverPathMedium);
            //save normal img
            saveCover(imgNormal, coverFileName, coverPathNormal);

            reset();
        } else
            showPleaseFillAllInput();
    }

    @Listen("onClick = #btnSubmit")
    public void onSubmit(){
        Messagebox.show("Are you sure to process this?",
                "Message",
                Messagebox.YES | Messagebox.NO,
                Messagebox.QUESTION,
                event -> {
                    if (event.getData().equals(Messagebox.YES)) {
                        doProcess();
                    }
                }
        );
    }

    private void reset(){
        JUtil.clear(tbTitle,dbRating,tbSynopsis,tbProduction,tbTrailer,ibMinute,tbWriters,tbDirectors,tbActors,tbProducers,lblFileCoverName);
        tbReleaseDate.setValue(new Date());
        modelFilter.clearSelection();
        modelYear.clearSelection();
        modelSubtitle.clearSelection();
        modelCountry.clearSelection();
        cover = new Cover();
        mediaCover = null;
        genres.clear();
        movieFiles.clear();
    }

    @Listen("onClick = #btnClose")
    public void onClose(){
        Events.postEvent("onClose", getSelf(), null);
    }

    private void setupUploadPath(String... paths) {
        for (String path : paths) {
            File baseDir = new File(path);
            if (!baseDir.exists()) {
                baseDir.mkdirs();
            }
        }
    }

    private void saveCover(Media media, String fileName, String path){
        File file = new File(path+"\\"+fileName);
        save(media, file);
    }

    private void save(Media media, File file) {
        try {
            Files.copy(file, media.isBinary() ? media.getStreamData() : new ReaderInputStream(media.getReaderData(), Charset.defaultCharset()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void compress(
            BufferedImage bufferedImage,
            OutputStream outputStream,
            float quality) throws IOException
    {
        Iterator<ImageWriter> iterator = ImageIO.getImageWritersByFormatName("jpg");
        ImageWriter imageWriter = iterator.next();
        ImageWriteParam imageWriteParam = imageWriter.getDefaultWriteParam();
        imageWriteParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        imageWriteParam.setCompressionQuality(quality); //0.05f
        ImageOutputStream imageOutputStream = new MemoryCacheImageOutputStream(outputStream);
        imageWriter.setOutput(imageOutputStream);
        IIOImage iioimage = new IIOImage(bufferedImage, null, null);
        imageWriter.write(null, iioimage, imageWriteParam);
        imageOutputStream.flush();
    }
}
