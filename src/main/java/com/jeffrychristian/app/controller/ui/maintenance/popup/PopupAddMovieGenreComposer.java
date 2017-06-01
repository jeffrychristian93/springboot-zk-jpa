package com.jeffrychristian.app.controller.ui.maintenance.popup;

import com.jeffrychristian.app.controller.ui.common.BaseComposer;
import com.jeffrychristian.app.domain.parameter.Parameter;
import com.jeffrychristian.app.repository.ParameterRepository;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Window;


/**
 * Created by jeffry.christian on 4/30/2017.
 */
public class PopupAddMovieGenreComposer extends BaseComposer{

    @WireVariable
    private ParameterRepository parameterRepository;

    @Wire
    private Grid gridGenres;

    private final ListModelList<Parameter> genres = new ListModelList<>();

    @Override
    public void doAfterCompose(Window comp) throws Exception {
        super.doAfterCompose(comp);
        genres.addAll(parameterRepository.findAllByCategoryCode("MOVIE_GENRE"));
        gridGenres.setModel(genres);
    }

    @Listen("onSelectz = #gridGenres")
    public void onSelectGenre(ForwardEvent event){
        Events.postEvent("onResult", getSelf(), event.getData());
        getSelf().detach();
    }

    @Listen("onClick = #btnClose")
    public void onClose(){
        getSelf().detach();
    }
}
