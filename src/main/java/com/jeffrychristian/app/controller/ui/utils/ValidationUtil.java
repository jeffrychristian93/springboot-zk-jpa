package com.jeffrychristian.app.controller.ui.utils;

import org.zkoss.zul.Combobox;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Textbox;

/**
 * Created by jeffry.christian on 11/22/2016.
 */
public class ValidationUtil {

    public static boolean check(Textbox[] textboxes) {
        boolean b = true;
        for (int i = 0; i < textboxes.length; i++){
            if (textboxes[i].getValue().isEmpty()){
                textboxes[i].setErrorMessage("Invalid value");
                b = false;
            }
        }
        return b;
    }

    public static boolean check(Decimalbox[] decimalboxes) {
        boolean b = true;
        for (int i = 0; i < decimalboxes.length; i++){
            if (decimalboxes[i].getValue() == null){
                decimalboxes[i].setErrorMessage("Invalid value");
                b = false;
            }
        }
        return b;
    }

    public static boolean check(Textbox[] textboxes, Combobox[] comboboxes) {
        boolean b = true;

        for (int i = 0; i < textboxes.length; i++){
            if (textboxes[i].getValue().isEmpty()){
                textboxes[i].setErrorMessage("Invalid value");
                b = false;
            }
        }

        for (int i = 0; i < comboboxes.length; i++){
            if (comboboxes[i].getValue().isEmpty()){
                comboboxes[i].setErrorMessage("Please Select");
                b = false;
            }
        }

        return b;
    }

    public static boolean check(Textbox[] textboxes, Combobox[] comboboxes, Intbox[] intboxes) {
        boolean b = true;

        for (int i = 0; i < textboxes.length; i++){
            if (textboxes[i].getValue().isEmpty()){
                textboxes[i].setErrorMessage("Invalid value");
                b = false;
            }
        }

        for (int i = 0; i < comboboxes.length; i++){
            if (comboboxes[i].getValue().isEmpty()){
                comboboxes[i].setErrorMessage("Please Select");
                b = false;
            }
        }

        for (int i = 0; i < intboxes.length; i++){
            if (intboxes[i].getValue() == null){
                intboxes[i].setErrorMessage("Invalid value");
                b = false;
            }
        }

        return b;
    }

    public static boolean check(Textbox[] textboxes, Intbox[] intboxes) {
        boolean b = true;

        for (int i = 0; i < textboxes.length; i++){
            if (textboxes[i].getValue().isEmpty()){
                textboxes[i].setErrorMessage("Invalid value");
                b = false;
            }
        }

        for (int i = 0; i < intboxes.length; i++){
            if (intboxes[i].getValue() == null || ((String) intboxes[i].getRawValue()).isEmpty()){
                intboxes[i].setErrorMessage("Invalid value");
                b = false;
            }
        }

        return b;
    }


}
