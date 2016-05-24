package com.example.dominik.organizer;


import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dominik.organizer.models.Note;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class CreateNoteFragment extends Fragment {

    private Toolbar toolbar;
    private MainActivity activity;
    private FloatingActionButton fab;
    private EditText titleInputField, textInputField;
    private Button createNoteButton;

    public CreateNoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View createNoteView = inflater.inflate(R.layout.fragment_create_note, container, false);
        activity = (MainActivity) getActivity();
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                fab.setVisibility(View.VISIBLE);
                getFragmentManager().popBackStack();
            }
        });

        titleInputField = (EditText) createNoteView.findViewById(R.id.titleInput);
        textInputField = (EditText) createNoteView.findViewById(R.id.noteInput);
        createNoteButton = (Button) createNoteView.findViewById(R.id.createNoteButton);

        createNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titleInput = titleInputField.getText().toString();
                String noteInput = textInputField.getText().toString();

                if(!titleInput.equals("") && !noteInput.equals("")) {
                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = new Date();

                    activity.addNote(new Note(titleInput,noteInput,dateFormat.format(date)));
                    activity.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                    fab.setVisibility(View.VISIBLE);
                    getFragmentManager().popBackStack();
                }
            }
        });

        return createNoteView;
    }

    public void setToolbar(Toolbar toolbar) {
        this.toolbar = toolbar;
    }
    
    public void setFab(FloatingActionButton fab) {
        this.fab = fab;
    }
}
