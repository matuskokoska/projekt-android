package com.example.dominik.organizer.controllers;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by matus.kacmar on 5/10/2016.
 */
public class FileHandler {

    private final String fileName = "noteData.data";
    private String path;
    private Context context;
    private File file;
    private FileInputStream inputStream;
    private FileOutputStream outputStream;
    private ObjectInputStream objectInput;
    private ObjectOutputStream objectOutput;

    public FileHandler(Context context) {
        this.context = context;
        path = String.valueOf(this.context.getFilesDir());
        file = new File(path,fileName);
    }

    public void saveNotes(NoteHandler noteHandler) {
        try {
            outputStream = new FileOutputStream(file);
            objectOutput = new ObjectOutputStream(outputStream);
            objectOutput.writeObject(noteHandler);
            objectOutput.close();
            outputStream.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public NoteHandler getNotes() {
        NoteHandler noteHandler;

        try {
            if(file.exists()) {
                inputStream = new FileInputStream(file);
                objectInput = new ObjectInputStream(inputStream);
                noteHandler = (NoteHandler) objectInput.readObject();
                objectInput.close();
                inputStream.close();

                return noteHandler;
            }
        } catch(IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return new NoteHandler();
    }
}
