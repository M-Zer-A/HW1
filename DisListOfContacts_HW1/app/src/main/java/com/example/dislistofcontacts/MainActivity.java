package com.example.dislistofcontacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.dislistofcontacts.tasks.TaskListContent;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity
        implements
        TaskFragment.OnListFragmentInteractionListener,
        DeleteDialog.OnDeleteDialogInteractionListener
{

    public static final String taskExtra = "taskExtra";
    private int currentItemPosition = -1;


    private void showDeleteDialog(){
        DeleteDialog.newInstance().show(getSupportFragmentManager(),getString(R.string.delete_dialog_tag));

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



            FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AddNewTask();
            }
        });
    }

    private void setSupportActionBar(Toolbar toolbar) {

    }





    private void startSecondActivity(TaskListContent.Task task, int position){
        Intent intent = new Intent ( this, TaskInfoActivity.class);
        intent.putExtra(taskExtra, (Parcelable) task);
        startActivity(intent);
    }




    private void displayTaskInFragment(TaskListContent.Task task){

        TaskInfoFragment taskInfoFragment = ((TaskInfoFragment) getSupportFragmentManager().findFragmentById(R.id.displayFragment));
        if(taskInfoFragment != null){
            taskInfoFragment.displayTask(task);
        }
    }

    @Override
    public void onListFragmentClickInteraction(TaskListContent.Task task, int position){
        Toast.makeText(this, getString(R.string.item_selected_msg) + position, Toast.LENGTH_SHORT).show();

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            displayTaskInFragment(task);
        }else {
            startSecondActivity(task, position);
        }

    }

    @Override
    public void onListFragmentLongClickInteraction(TaskListContent.Task task, int position) {

        Toast.makeText(this,getString(R.string.long_click_msg) + position, Toast.LENGTH_SHORT).show();
        showDeleteDialog();
        currentItemPosition = position;
    }


    @Override
    public void onDialogPositiveClick(DeleteDialog deleteDialog) {
        if(currentItemPosition != -1 && currentItemPosition < TaskListContent.ITEMS.size()){
            TaskListContent.removeItem(currentItemPosition);
            ((TaskFragment) getSupportFragmentManager().findFragmentById(R.id.taskFragment)).notifyDataChange();

        }
    }


    private int getIndexOfSelectedContact(View view) {
        ViewParent a = view.getParent();
        ViewParent b = a.getParent();
        return ((RecyclerView)b).indexOfChild((View)a);
    }



    @Override
    public void onDialogNegativeClick(DeleteDialog deleteDialog) {
        View v = findViewById(R.id.addButton);
        if(v !=null){
            Snackbar snackbar = null;
            Snackbar.make(v, getString(R.string.delete_cancel_msg), Snackbar.LENGTH_LONG)
                    .setAction(getString(R.string.retry_msg), new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            showDeleteDialog();
                        }
                    }) .show();

        }
    }






}
