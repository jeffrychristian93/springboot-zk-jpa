package com.jeffrychristian.app.common.types;

/**
 * Created by jeffry.christian on 4/30/2017.
 */
public enum GenreType {

    ACTION      ("Action"),
    ADVENTURE   ("Adventure"),
    ANIMATION   ("Animation"),
    BIOGRAPHY   ("Biography"),
    COMEDY      ("Comedy"),
    CRIME       ("Crime"),
    DOCUMENTARY ("Documentary"),
    DRAMA       ("Drama"),
    FAMILY      ("Family"),
    FANTASY     ("Fantasy"),
    FILM_NOIR   ("Film-Noir"),
    GAME_SHOW   ("Game-Show"),
    HISTORY     ("History"),
    HORROR      ("Horror"),
    MUSIC       ("Music"),
    MUSICAL     ("Musical"),
    MYSTERY     ("Mystery"),
    NEWS        ("News"),
    REALITY_TV  ("Reality-TV"),
    ROMANCE     ("Romance"),
    SCI_FI      ("Sci-Fi"),
    SERIAL      ("Serial"),
    SPORT       ("Sport"),
    TALK_SHOW   ("Talk-Show"),
    THRILLER    ("Thriller"),
    WAR         ("War"),
    WESTERN     ("Western"),
    ZOMBIES     ("Zombies");

    private String value;

    GenreType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
