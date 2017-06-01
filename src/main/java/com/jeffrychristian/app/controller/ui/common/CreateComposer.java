package com.jeffrychristian.app.controller.ui.common;

import org.zkoss.zul.Messagebox;

/**
 * Created by jeffry.christian on 12/6/2016.
 */
public abstract class CreateComposer extends BaseComposer{

    protected void showPleaseFillAllInput(){
        Messagebox.show("Please fill all input", "Warning", Messagebox.OK, Messagebox.ERROR);
    }
}
