package com.example.dominik.organizer.models;

import java.io.Serializable;

/**
 * Created by Matus on 08.05.2016.
 */
public class Note implements Serializable {

    public String TITLE;
    public String CONTENT;
    public String DATEADDED;
    public String PREVIEW;

    public Note(String TITLE, String CONTENT, String DATEADDED) {
        this.TITLE = TITLE;
        this.CONTENT = CONTENT;
        this.DATEADDED = DATEADDED;

        if(this.CONTENT.length() > 140) {
            PREVIEW = this.CONTENT.substring(0,140);
        }
        else PREVIEW = this.CONTENT;
    }
}
