package com.example.todolist;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EntryAdapter extends RecyclerView.Adapter<EntryHolder> {
    @NonNull
    private List<TodoListEntry> mItems = new ArrayList<>();

    @NonNull
    @Override
    public EntryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EntryHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_entry, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EntryHolder holder, int position) {
        holder.bind(mItems.get(position).id, mItems.get(position).entryTime, mItems.get(position).content, mItems.get(position).isFinished);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void notifyItems(List<TodoListEntry> items) {
        mItems.clear();
        mItems.addAll(items);
        notifyDataSetChanged();
    }

}
