package com.example.dislistofcontacts;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dislistofcontacts.tasks.TaskListContent;


/**
 * A simple {@link Fragment} subclass.
 */
public class TaskInfoFragment extends Fragment {


    public TaskInfoFragment(){

    }

    public void displayTask(TaskListContent.Task task){
        FragmentActivity activity = getActivity();

        TextView taskInfoTitle = activity.findViewById(R.id.taskInfoTitle);
        TextView taskInfoDescription = activity.findViewById(R.id.taskInfoDescription);
        TextView taskInfoDescription1 = activity.findViewById(R.id.taskInfoDescription1);
        TextView taskInfoDescription2 = activity.findViewById(R.id.taskInfoDescription2);


        taskInfoTitle.setText(task.title);
        taskInfoDescription.setText(getString(R.string.phone)+" "+task.details);
        taskInfoDescription1.setText(getString(R.string.birth)+" "+task.details1);
        taskInfoDescription2.setText(getString(R.string.sound)+" "+getNameOfSound(task.details2));

        ((ImageView) activity.findViewById(R.id.taskInfoImage)).setImageDrawable(activity.getResources().getDrawable(task.picId));


    }

    private String getNameOfSound(Object details2) {
        return null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task_info, container, false);
        return view;
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        Intent intent = getActivity().getIntent();
        if(intent != null){
            TaskListContent.Task receivedTask = intent.getParcelableExtra(MainActivity.taskExtra);
            if(receivedTask != null){
                displayTask(receivedTask);
            }
        }

    }
}
