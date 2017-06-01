package com.jeffrychristian.app.common.utils;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventQueue;
import org.zkoss.zk.ui.event.EventQueues;
import org.zkoss.zul.*;

/**
 * Created by jeffry.christian on 5/1/2017.
 */
public class JUtil {
    private static final Boolean T = true;
    private static final Boolean F = false;

    public static void clear(Component... comps){
        for (Component c : comps) {
            if (c != null) {
                clear(c);
            }
        }
    }

    private static void clear(Component c){
        if (c instanceof Textbox) ((Textbox) c).setValue("");
        if (c instanceof Label) ((Label) c).setValue("");
        if (c instanceof Decimalbox) ((Decimalbox) c).setRawValue(0);
        if (c instanceof Doublebox) ((Doublebox) c).setRawValue(0);
        if (c instanceof Intbox) ((Intbox) c).setRawValue(0);
        if (c instanceof Longbox) ((Longbox) c).setRawValue(0);
    }

    public static void disable(Component... comps){
        disableEnables(T, comps);
    }

    public static void enable(Component... comps){
        disableEnables(F, comps);
    }

    private static void disableEnables(boolean b, Component... comps){
        for (Component c : comps) {
            if (c != null) {
                disableEnable(b, c);
            }
        }
    }

    private static void disableEnable(boolean b, Component c){
        if (c instanceof Button){
            ((Button) c).setDisabled(b);
        } else if (c instanceof Textbox){
            ((Textbox) c).setDisabled(b);
        } else if (c instanceof Longbox){
            ((Longbox) c).setDisabled(b);
        } else if (c instanceof Decimalbox){
            ((Decimalbox) c).setDisabled(b);
        } else if (c instanceof Doublebox){
            ((Doublebox) c).setDisabled(b);
        } else if (c instanceof Intbox){
            ((Intbox) c).setDisabled(b);
        } else if (c instanceof Combobox){
            ((Combobox) c).setDisabled(b);
        } else if (c instanceof Radio){
            ((Radio) c).setDisabled(b);
        } else if (c instanceof Checkbox){
            ((Checkbox) c).setDisabled(b);
        } else if (c instanceof Datebox){
            ((Datebox) c).setDisabled(b);
        } else if (c instanceof Doublespinner){
            ((Doublespinner) c).setDisabled(b);
        } else if (c instanceof Timebox){
            ((Timebox) c).setDisabled(b);
        }
    }

    public static void readOnly(Component... comps){
        readOnly(T, comps);
    }

    public static void unReadOnly(Component... comps){
        readOnly(F, comps);
    }

    private static void readOnly(boolean b, Component... comps){
        for (Component c : comps) {
            if (c != null) {
                readOnly(b, c);
            }
        }
    }

    private static void readOnly(boolean b, Component c){
        if (c instanceof Textbox){
            ((Textbox) c).setReadonly(b);
        } else if (c instanceof Longbox){
            ((Longbox) c).setReadonly(b);
        } else if (c instanceof Decimalbox){
            ((Decimalbox) c).setReadonly(b);
        } else if (c instanceof Doublebox){
            ((Doublebox) c).setReadonly(b);
        } else if (c instanceof Intbox){
            ((Intbox) c).setReadonly(b);
        } else if (c instanceof Combobox){
            ((Combobox) c).setReadonly(b);
        } else if (c instanceof Datebox){
            ((Datebox) c).setReadonly(b);
        } else if (c instanceof Doublespinner){
            ((Doublespinner) c).setReadonly(b);
        } else if (c instanceof Timebox){
            ((Timebox) c).setReadonly(b);
        }
    }

    public static void hide(Component... comps){
        for (Component c : comps) {
            if (c != null) {
                c.setVisible(F);
            }
        }
    }

    public static void unHide(Component... comps){
        for (Component c : comps) {
            if (c!=null){
                c.setVisible(T);
            }
        }
    }

    public static <T extends Event> EventQueue<T> GO(String $){
        return EventQueues.lookup($, EventQueues.APPLICATION, true);
    }
}
