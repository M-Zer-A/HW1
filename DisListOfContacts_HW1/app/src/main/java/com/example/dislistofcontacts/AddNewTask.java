package com.example.dislistofcontacts;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dislistofcontacts.tasks.TaskListContent;

import java.util.Random;

import static android.provider.Settings.System.getString;

public class AddNewTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_task);
    }

    private void setContentView(int activity_add_new_task) {

    }


    public void AddNewContact(View view) {
        EditText nameBox = findViewById(R.id.nameEditBox);
        EditText surnameBox = findViewById(R.id.surnameEditBox);
        EditText dateBox = findViewById(R.id.dateEditBox);
        EditText phoneBox = findViewById(R.id.phoneEditBox);


        if (ValidateFields(nameBox, dateBox, phoneBox)) return;

        TaskListContent.addItem(new TaskListContent.task(
                nameBox.getText().toString()+ " "+ surnameBox.getText().toString(),
                phoneBox.getText().toString(),
                dateBox.getText().toString(),

        finish();
    }

    public EditText findViewById(int nameEditBox) {
        //
    }

    public void finish() {

    }


    private boolean ValidateFields(EditText nameBox, EditText dateBox, EditText phoneBox) {
        if(nameBox.getText().toString().trim().isEmpty())
        {
            Toast.makeText(getApplicationContext(), getString(R.string.empty_name_msg), Toast.LENGTH_LONG).show();
            return true;
        }
        if(!isDateValid(dateBox.getText().toString()))
        {
            Toast.makeText(getApplicationContext(), getString(R.string.invalid_date_toast_msg), Toast.LENGTH_LONG).show();
            return true;
        }
        if(phoneBox.getText().toString().length()<6)
        {
            Toast.makeText(getApplicationContext(), getString(R.string.phone_number_invalid_msg), Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }

    private int getString(int empty_name_msg) {
        return 0;
    }

    private Context getApplicationContext() {
    }

    public boolean isDateValid(String dateStr) {
        return isDate(dateStr.trim(),"DD.MM.yyyy",true);
    }

    private boolean isDate(String trim, String s, boolean b) {
        return false;
    }

    private int getRandomAvatar() {
        switch (new Random(System.currentTimeMillis()).nextInt(10)) {
            case 0:
                return R.drawable.img0;
            case 1:
                return R.drawable.img1;
            case 2:
                return R.drawable.img2;
            case 3:
                return R.drawable.img3;
            case 4:
                return R.drawable.img4;
            case 5:
                return R.drawable.img5;
            case 6:
                return R.drawable.img6;
            case 7:
                return R.drawable.img7;
            case 8:
                return R.drawable.img8;
            case 9:
            default:
                return R.drawable.img9;
        }
    }


}
