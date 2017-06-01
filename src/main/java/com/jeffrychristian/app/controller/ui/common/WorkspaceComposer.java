package com.jeffrychristian.app.controller.ui.common;

import com.jeffrychristian.app.controller.ui.utils.MenuTreeModel;
import com.jeffrychristian.app.domain.menu.Menu;
import com.jeffrychristian.app.repository.MenuRepository;
import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Tree;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;
import java.util.*;

/**
 * Created by jeffry.christian on 11/11/2016.
 */
public class WorkspaceComposer extends BaseComposer {

    @WireVariable
    private MenuRepository menuRepository;

    @Wire
    private Tree treeMenu;
    private MenuTreeModel treeModel;

    @Wire("#tabbox")
    private Tabbox tabBox;

    private int rightSelectedTabIdx;
    private int selectedTabIdx;


    @Override
    public void doBeforeComposeChildren(Window comp) throws Exception {
        super.doBeforeComposeChildren(comp);

    }

    public void doAfterCompose(Window comp) throws Exception {
        super.doAfterCompose(comp);

        Menu menu = menuRepository.findByCode("ROOT");
        for (Menu c1 : menu.getChildMenus()) {
            c1.setParentMenu(null);
            for (Menu c2 : c1.getChildMenus()) {
                c2.setParentMenu(null);
                for (Menu c3 : c2.getChildMenus()) {
                    c3.setParentMenu(null);
                }
            }
        }

        treeModel = new MenuTreeModel(menu);
        treeMenu.setModel(treeModel);

         /* Dashboard */
        Component panel = tabBox.getTabpanels().getChildren().get(0);
        if (panel != null) {
            initPanel((Window) panel.getChildren().get(0).getChildren().get(0));
        }

    }

    @Listen("onSelect = #treeMenu")
    public void treeMenuSelect() {
        Menu selectedMenu = treeModel.getSelection().iterator().next();
        selectedMenu.setLeaf(selectedMenu.getChildMenus().isEmpty());
        if (treeModel.isLeaf(selectedMenu)) {
            Tab tab = getTabByName(selectedMenu.getTabName());
            if (tab == null) {
                tab = newTab(selectedMenu.getTabName());
                tabBox.getTabs().appendChild(tab);
                Tabpanel tabPanel = new Tabpanel();
                tabPanel.setStyle("overflow:auto;");
                tabBox.getTabpanels().appendChild(tabPanel);

                Map<String , Object> arg = new HashMap<>();
                arg.put("selectedMenu", selectedMenu);

                Window comp = (Window) Executions.createComponents(Labels.getLabel(selectedMenu.getUrl()), tabPanel, arg);
                tabPanel.appendChild(comp);
                initPanel(comp);
            }
            tabBox.setSelectedTab(tab);
            selectedTabIdx = tabBox.getSelectedIndex();
        } else {
            if (treeModel.isObjectOpened(selectedMenu)) {
                treeModel.removeOpenObject(selectedMenu);
            } else {
                treeModel.addOpenPath(treeModel.getPath(selectedMenu));
                int[] path = treeModel.getPath(selectedMenu);
                int[] openPath = new int[]{};
                for (int i = 0; i < path.length; i++) {
                    openPath = Arrays.copyOf(openPath, openPath.length + 1);
                    openPath[openPath.length - 1] = path[i];
                    treeModel.addOpenPath(openPath);
                }
            }
        }
        treeMenu.clearSelection();
    }

    private void initPanel(Window window) {
        window.addEventListener("onForward", event -> forwardTab(event.getTarget().getParent(), (HashMap<String, Object>) event.getData()));
        window.addEventListener("onOpenModule", event -> openTab((HashMap<String, Object>) event.getData()));
        window.addEventListener("onClose", event -> tabBox.getSelectedTab().close());
    }

    private void closeTab(final int index) {
        Messagebox.show(Labels.getLabel("common.question.close.tab"), Labels.getLabel("common.title.confirmation"),
                Messagebox.YES | Messagebox.NO, Messagebox.QUESTION,
                event -> {
                    if (event.getData().equals(Messagebox.YES)) {
                        Tab tab = (Tab) tabBox.getTabs().getChildren().get(index);
                        tab.close();
                    }
                }
        );
    }

    private void forwardTab(Component tabPanel, Map<String, Object> param) {
        if (tabPanel != null) {
            if (param == null) {
                param = new HashMap<>();
            }
            tabPanel.getChildren().clear();
            Window comp = (Window) Executions.createComponents(Labels.getLabel(param.get("url").toString()), tabPanel, param);
            initPanel(comp);
            tabPanel.appendChild(comp);
        }
    }

    private void openTab(Map<String, Object> param) {
        String title = (String) param.get("title");
        String url = (String) param.get("url");
        Tab tab = getTabByName(title);
        if (tab == null) {
            tab = newTab(title);
            tabBox.getTabs().appendChild(tab);
            Tabpanel tabPanel = new Tabpanel();
            tabPanel.setStyle("overflow:auto;");
            tabBox.getTabpanels().appendChild(tabPanel);
            Window comp = (Window) Executions.createComponents(Labels.getLabel(url), tabPanel, param);
            initPanel(comp);
            tabPanel.appendChild(comp);
        }
        tabBox.setSelectedTab(tab);
        selectedTabIdx = tabBox.getSelectedIndex();
    }

    private Tab getTabByName(String name) {
        Tab result = null;
        for (Component tab : tabBox.getTabs().getChildren()) {
            if (tab instanceof Tab) {
                if (((Tab) tab).getLabel().equals(name)) {
                    result = (Tab) tab;
                    break;
                }
            }
        }
        return result;
    }

    private Tab newTab(String tabName) {
        Tab tab = new Tab(tabName);
        tab.setClosable(true);
        tab.setContext("popupClose");
        tab.setSelected(true);
        tab.addEventListener(Events.ON_CLOSE, event -> {
            if (event.getName().equals(Events.ON_CLOSE)) {
                event.stopPropagation();
                Tab tab1 = (Tab) event.getTarget();
                closeTab(tab1.getIndex());
            }
        });
        tab.addEventListener(Events.ON_RIGHT_CLICK, event -> rightSelectedTabIdx = ((Tab) event.getTarget()).getIndex());
        tab.addEventListener(Events.ON_SELECT, event -> selectedTabIdx = tabBox.getSelectedIndex());
        return tab;
    }

    @Listen("onClick = #menuRightTabClose")
    public void menuRightTabCloseClick() {
        closeTab(rightSelectedTabIdx);
    }

    @Listen("onClick = #menuRightTabCloseAll")
    public void menuRightTabCloseAllClick() {
        Messagebox.show(Labels.getLabel("common.question.close.all"), Labels.getLabel("common.title.confirmation"),
                Messagebox.YES | Messagebox.NO, Messagebox.QUESTION,
                event -> {
                    if (event.getData().equals(Messagebox.YES)) {
                        List<Tab> tabs = new ArrayList<>();
                        List<Tab> tempTabs = tabBox.getTabs().getChildren();
                        tabs.addAll(tempTabs);
                        tabs.remove(0);
                        for (Tab tab : tabs) {
                            tab.close();
                        }
                    }
                }
        );
    }

    @Listen("onClick = #menuRightTabCloseOther")
    public void menuRightTabCloseOtherClick() {
        Messagebox.show(Labels.getLabel("common.question.close.other"), Labels.getLabel("common.title.confirmation"),
                Messagebox.YES | Messagebox.NO, Messagebox.QUESTION,
                event -> {
                    if (event.getData().equals(Messagebox.YES)) {
                        List<Tab> tabs = new ArrayList<>();
                        List<Tab> tempTabs = tabBox.getTabs().getChildren();
                        tabs.addAll(tempTabs);
                        tabs.remove(rightSelectedTabIdx);
                        tabs.remove(0);
                        for (Tab tab : tabs) {
                            tab.close();
                        }
                    }
                }
        );
    }

    @Listen("onClick = #logout")
    public void linkLogoutClick() {

    }
}
