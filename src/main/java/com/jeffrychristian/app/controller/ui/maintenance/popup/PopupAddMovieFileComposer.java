package com.jeffrychristian.app.controller.ui.maintenance.popup;

import com.jeffrychristian.app.common.types.QualityType;
import com.jeffrychristian.app.controller.ui.common.BaseComposer;
import com.jeffrychristian.app.domain.movie.MovieFile;
import org.zkoss.util.media.Media;
import org.zkoss.zk.au.http.AuUploader;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.*;

import java.util.Arrays;

/**
 * Created by jeffry.christian on 4/30/2017.
 */
public class PopupAddMovieFileComposer extends BaseComposer {

    @Wire
    private Label lblFileMovieName;
    @Wire
    private Combobox cbVideoQuality;

    private final ListModelList<QualityType> qualityTypes = new ListModelList<>(Arrays.asList(QualityType.values()));

    private Media media;

    @Override
    public void doAfterCompose(Window comp) throws Exception {
        super.doAfterCompose(comp);

        cbVideoQuality.setModel(qualityTypes);
    }

    @Listen("onUpload = #btnBrowseMovie")
    public void onBrowseMovie(UploadEvent event) {
        media = event.getMedia();
        if (media.getContentType().equals("video/mp4")) {
            lblFileMovieName.setStyle("color:black");
            lblFileMovieName.setValue(media.getName());
        } else {
            Messagebox.show("Not an video: " + media.getName(), "Error", Messagebox.OK, Messagebox.ERROR);
        }
    }

    @Listen("onClick = #btnSave")
    public void onSave() {
        if (validate()) {
            MovieFile mf = new MovieFile();
            String fileName = media.getName();
            int pos = fileName.lastIndexOf(".");
            fileName = fileName.substring(0, pos);
            mf.setFileName(fileName);
            mf.setFormat(media.getFormat());
            mf.setQuality(qualityTypes.getSelection().iterator().next());
            mf.setType(media.getContentType());
            Events.postEvent("onResult", getSelf(), mf);
            getSelf().detach();
        }
    }

    private boolean validate() {
        boolean b = true;
        if (media == null) {
            b = false;
            lblFileMovieName.setStyle("color:red");
            lblFileMovieName.setValue("Please select your file");
        }
        if (qualityTypes.isSelectionEmpty()) {
            b = false;
            cbVideoQuality.setErrorMessage("Please select at least one");
        }
        return b;
    }

    @Listen("onClick = #btnClose")
    public void onClose() {
        getSelf().detach();
    }

}