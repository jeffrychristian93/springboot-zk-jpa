package com.jeffrychristian.app.controller.ui.utils;

import org.zkoss.zul.Label;

/**
 * Created by jeffry.christian on 12/9/2016.
 */
public class LabelUtil {

    public static void setValue(Label[] labels, String[] strings){
        int i = 0;
        for (Label label : labels) {
            label.setValue(strings[i]);
            i++;
        }
    }

}
