package com.jeffrychristian.app.controller.ui.utils;

import com.jeffrychristian.app.domain.menu.Menu;
import org.zkoss.zul.AbstractTreeModel;

/**
 * Created by jeffry.christian on 11/15/2016.
 */
public class MenuTreeModel extends AbstractTreeModel<Menu> {

    public MenuTreeModel(Menu tree) {
        super(tree);
    }

    @Override
    public boolean isLeaf(Menu e) {
        return e.isLeaf();
    }

    @Override
    public Menu getChild(Menu e, int i) {
        return e.getChildMenus().get(i);
    }

    @Override
    public int getChildCount(Menu e) {
        return e.getChildMenus().size();
    }
}