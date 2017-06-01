package com.jeffrychristian.app.controller.ui.common;

import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jeffry.christian on 11/17/2016.
 */
@VariableResolver(DelegatingVariableResolver.class)
public class BaseComposer extends SelectorComposer<Window> {

    @Override
    public void doAfterCompose(Window comp) throws Exception {
        super.doAfterCompose(comp);
    }

    protected Window window(String zulKey, HashMap<String, Object> param){
        return (Window) Executions.createComponents(Labels.getLabel(zulKey), null, param);
    }
    //    @WireVariable protected SettingCategoryRepository settingCategoryRepository;
//
//    protected Object getArg(String argName) {
//        return Executions.getCurrent().getArg().get(argName);
//    }
//
//    @Override
//    public void doAfterCompose(Window comp) throws Exception {
//        super.doAfterCompose(comp);
//    }
//
//    protected void back(String prevPage, Object data) {
//        Map<String , Object> map = new HashMap<>();
//        map.put("object", data);
//        navigateTo(prevPage, map);
//    }
//
//    protected void back(String prevPage) {
//        navigateTo(prevPage, null);
//    }
//
//    protected void close(){
//        Messagebox.show("Close Tab",
//                "Tes", Messagebox.YES | Messagebox.NO,
//                Messagebox.QUESTION,
//                event -> {
//                    if (event.getData().equals(Messagebox.YES)) {
//                        Events.postEvent("onClose", getSelf(), null);
//                    }
//                }
//        );
//    }
//
//
//    protected void showConfirm(String msg, final String navigateURL, final Map<String, Object> param) {
//        Messagebox.show(msg, "title.confirmation",
//                Messagebox.OK, Messagebox.QUESTION,
//                event -> navigateTo(navigateURL, param)
//        );
//    }
//
//    protected void showInfo(String msg, final String navigateURL, final Map<String, Object> param) {
//        Messagebox.show(msg, "title.information",
//                Messagebox.OK, Messagebox.INFORMATION,
//                event -> navigateTo(navigateURL, param)
//        );
//    }
//
//    protected boolean showInfoSuccess(String msg) {
//        Messagebox.show(msg, "Information", Messagebox.OK, Messagebox.INFORMATION);
//        return true;
//    }
//
//    protected void showError(String msg) {
//        Messagebox.show(msg, "Error", Messagebox.OK, Messagebox.ERROR);
//    }
//
//    protected void navigateTo(String url, Map<String, Object> parameter) {
//        if (parameter == null) {
//            parameter = new HashMap<>();
//        }
//        parameter.put("url", url);
//        Events.postEvent("onForward", getSelf(), parameter);
//    }
//
//    protected User getCurrentUser() {
//        return (User) Sessions.getCurrent().getAttribute("currentUser");
//    }
//
//    protected void goTo(String nextPage, String currentPage, Object data, Object otherData, String mode) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("mode", mode);
//        map.put("object", data);
//        map.put("currentPage", currentPage);
//        map.put("other", otherData);
//        navigateTo(nextPage, map);
//    }
//
//    /**
//     * Check null and return string value
//     * @param o
//     * @return
//     */
//    protected String toString(Object o){
//        if(o == null){
//            return "";
//        } else {
//            return o.toString();
//        }
//    }
}