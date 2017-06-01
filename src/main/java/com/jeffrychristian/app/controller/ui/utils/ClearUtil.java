package com.jeffrychristian.app.controller.ui.utils;

import org.zkoss.zul.*;

import java.util.Date;

/**
 * Created by jeffry.christian on 12/9/2016.
 */
public class ClearUtil {

    public static void clear(Textbox[] textboxs){
        for (Textbox textbox : textboxs) {
            textbox.setValue("");
        }
    }

    public static void clear(Textbox[] textboxs, Intbox[] intboxes){
        for (Textbox textbox : textboxs) {
            textbox.setValue("");
        }
        for (Intbox intbox : intboxes) {
            intbox.setRawValue(null);
        }
    }

    public static void clear(Textbox[] textboxs, Intbox[] intboxes, Decimalbox[] decimalboxes, Datebox[] dateboxes, Timebox[] timeboxes){
        for (Textbox textbox : textboxs) {
            textbox.setValue("");
        }
        for (Intbox intbox : intboxes) {
            intbox.setRawValue(null);
        }
        for (Decimalbox decimalbox : decimalboxes) {
            decimalbox.setRawValue(null);
        }
        for (Datebox datebox : dateboxes) {
            datebox.setValue(new Date());
        }
        for (Timebox timebox : timeboxes) {
            timebox.setValue(new Date());
        }
    }

    public static void clear(Textbox[] textboxs, Intbox[] intboxes, Checkbox[] checkboxes){
        for (Textbox textbox : textboxs) {
            textbox.setValue("");
        }
        for (Intbox intbox : intboxes) {
            intbox.setRawValue(null);
        }
        for (Checkbox checkbox : checkboxes) {
            checkbox.setChecked(false);
        }
    }

    public static void clear(Textbox[] textboxs, Intbox[] intboxes, Checkbox[] checkboxes, Radio[] radios){
        for (Textbox textbox : textboxs) {
            textbox.setValue("");
        }
        for (Intbox intbox : intboxes) {
            intbox.setRawValue(null);
        }
        for (Checkbox checkbox : checkboxes) {
            checkbox.setChecked(false);
        }
        for (Radio radio : radios) {
            radio.setSelected(true);
        }
    }

    public static void clear(Textbox[] textboxs, Intbox[] intboxes, Checkbox[] checkboxes, Radio[] radios, Image[] images){
        for (Textbox textbox : textboxs) {
            textbox.setValue("");
        }
        for (Intbox intbox : intboxes) {
            intbox.setRawValue(null);
        }
        for (Checkbox checkbox : checkboxes) {
            checkbox.setChecked(false);
        }
        for (Radio radio : radios) {
            radio.setSelected(true);
        }
        for (Image image : images) {
            image.setWidth("0px");
            image.setHeight("0px");
        }

    }

    public static void clear(Textbox[] textboxs, Intbox[] intboxes, Radio[] radios, Image[] images){
        for (Textbox textbox : textboxs) {
            textbox.setValue("");
        }
        for (Intbox intbox : intboxes) {
            intbox.setRawValue(null);
        }
        for (Radio radio : radios) {
            radio.setSelected(true);
        }
        for (Image image : images) {
            image.setWidth("0px");
            image.setHeight("0px");
        }

    }

}
