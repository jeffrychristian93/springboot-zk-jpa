package com.jeffrychristian.app.domain.menu;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeffry.christian on 11/15/2016.
 */
@Entity
@Table(name = "mst_menu")
public class Menu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")	    private Long    id;
    @Column(name = "code")      private String  code;
    @Column(name = "title")     private String  title;
    @Column(name = "url")       private String  url;
    @Column(name = "orderno")   private int     orderNo;
    @Column(name = "tabname")   private String  tabName;

    @ManyToOne
    @JoinColumn(name = "parentcode", referencedColumnName = "code")
    @NotFound(action = NotFoundAction.IGNORE)
    private Menu parentMenu;

    @OneToMany(mappedBy = "parentMenu", fetch = FetchType.EAGER)
    @OrderBy("orderNo")
    @Column private List<Menu> childMenus = new ArrayList<>();

    @Transient
    private boolean leaf;

    public Menu() {}

    public Menu(String code, String title, String url, int orderNo, String tabName, Menu parentMenu, List<Menu> childMenus) {
        this.code = code;
        this.title = title;
        this.url = url;
        this.orderNo = orderNo;
        this.tabName = tabName;
        this.parentMenu = parentMenu;
        this.childMenus = childMenus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public Menu getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(Menu parentMenu) {
        this.parentMenu = parentMenu;
    }

    public List<Menu> getChildMenus() {
        return childMenus;
    }

    public void setChildMenus(List<Menu> childMenus) {
        this.childMenus = childMenus;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

}