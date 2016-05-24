package com.example.dominik.organizer.controllers;

import com.example.dominik.organizer.models.Note;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by matus.kacmar on 5/10/2016.
 */
public class NoteHandler implements java.io.Serializable {

    private LinkedList<Note> noteList;

    public NoteHandler() {}

    public void setList(LinkedList<Note> noteList) {
        this.noteList = noteList;
    }

    public LinkedList<Note> getList() {
        return noteList;
    }
}
