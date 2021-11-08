package com.example.todolist;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.List;

public class EntryHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView mContentText, mDateText;
    private CheckBox mCheckBox;
    private ImageButton mDeleteButton;

    private Context context;

    public EntryHolder(@NonNull View itemView) {
        super(itemView);
        mContentText = (TextView) itemView.findViewById(R.id.contentText);
        mDateText = (TextView) itemView.findViewById(R.id.dateText);
        mCheckBox = (CheckBox) itemView.findViewById(R.id.checkBox);
        mDeleteButton = (ImageButton) itemView.findViewById(R.id.deleteButton);
        itemView.setOnClickListener(this);
        context = itemView.getContext();
    }

    public void bind(int id, String date, String content, int isFinished) {
        mContentText.setText(content);
        mDateText.setText(date);
        if (isFinished == 1) {
            mCheckBox.setChecked(true);
        } else {
            mCheckBox.setChecked(false);
        }


        mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TodoListDatabase db = Room.databaseBuilder(context,
                        TodoListDatabase.class, "todolist").allowMainThreadQueries().build();

                db.todoListDao().DeleteEntry(id);
                

            }
        });

        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                TodoListDatabase db = Room.databaseBuilder(context,
                        TodoListDatabase.class, "todolist").allowMainThreadQueries().build();

                if (isChecked == true) {
                    db.todoListDao().UpdateIsFinished(id, 1);
                } else {
                    db.todoListDao().UpdateIsFinished(id, 0);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {

    }

}
