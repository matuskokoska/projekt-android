package com.example.dominik.organizer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dominik.organizer.models.Note;

import java.util.LinkedList;

/**
 * Created by Matus on 10.05.2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private LinkedList<Note> notes;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title,notePreview,date;
        private Context context;

        public ViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.noteTitle);
            notePreview = (TextView) view.findViewById(R.id.notePreview);
            date = (TextView) view.findViewById(R.id.date);
            this.context = context;
        }
    }

    public RecyclerAdapter(LinkedList<Note> notes) {
        this.notes = notes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_row,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.title.setText(note.TITLE);
        holder.notePreview.setText(note.PREVIEW);
        holder.date.setText(note.DATEADDED);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}
