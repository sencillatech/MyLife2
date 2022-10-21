package com.example.mylife2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.AppCompatImageButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.mylife2.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private static final String TAG = "MainActivity";
    public EditText input;
    public List integerArray = new ArrayList<Integer>();
    boolean flag = false;
    AppDatabase db = null;
    LifePojo lifePojo = new LifePojo();
    int smileyWeight;
    ActivityMainBinding activityMainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);

        ImageButton button;
        button = activityMainBinding.imageButton;
//        button = findViewById(R.id.imageButton);
        button.setOnClickListener(this);

        ImageButton button1;
        button1 = activityMainBinding.imageButton3;

//        button1 = findViewById(R.id.imageButton3);
        button1.setOnClickListener(this);

        ImageButton button2;
        button2 = activityMainBinding.imageButton2;

//        button2 = findViewById(R.id.imageButton2);
        button2.setOnClickListener(this);

        ImageButton button3;
        button3 = activityMainBinding.imageButton4;

//        button3 = findViewById(R.id.imageButton4);
        button3.setOnClickListener(this);

        Button btn;
        btn= activityMainBinding.button;
//        btn = findViewById(R.id.button);
        btn.setOnClickListener(this);

        Button btn1;
        btn1= activityMainBinding.button2;

//        btn1 = findViewById(R.id.button2);
        btn1.setOnClickListener(this);
        integerArray.add(activityMainBinding.imageButton);
        integerArray.add(activityMainBinding.imageButton3);

        integerArray.add(activityMainBinding.imageButton2);

        integerArray.add(activityMainBinding.imageButton4);

//        integerArray.add(R.id.imageButton);
//        integerArray.add(R.id.imageButton3);
//
//        integerArray.add(R.id.imageButton2);
//
//        integerArray.add(R.id.imageButton4);
        db = AppDatabase.getDbInstance(this.getApplication());


    }

    @Override
    public void onClick(View view) {
//        input = (EditText) findViewById(R.id.textInputEditText);
        input = (EditText) activityMainBinding.textInputEditText;


//        view.getId();
        Log.d(TAG, "onClick: " + view.getId());
        switch (view.getId()) {
            case R.id.button:
                Log.d(TAG, "onClick: submit clicked");
                input = (EditText) findViewById(R.id.textInputEditText);
                final String n1 = input.getText().toString();
                if ((n1.length() == 0) || (flag == false)) {

                    Toast.makeText(getApplicationContext(), "Please fill all the fields", Toast.LENGTH_LONG).show();
                }
                lifePojo.description = n1;
                db.lifeDao().insertLife(lifePojo);

                lifePojo.rating =smileyWeight;
                db.lifeDao().insertLife(lifePojo);


                Toast.makeText(getApplicationContext(), "Submit clicked", Toast.LENGTH_LONG).show();
                break;

            case R.id.imageButton:
                Log.d(TAG, "onClick: imagebutton 1 clicked");
                emoji(view);
                flag = true;
                smileyWeight=1;

//                lifePojo.rating =1;
//                db.lifeDao().insertLife(lifePojo);
                break;

            case R.id.imageButton3:
                Log.d(TAG, "onClick: imagebutton 2 clicked");
                emoji(view);
                flag = true;
                smileyWeight=2;

//                lifePojo.rating =2;
//                db.lifeDao().insertLife(lifePojo);
                break;


            case R.id.imageButton2:
                Log.d(TAG, "onClick: imagebutton 3 clicked");
                emoji(view);
                flag = true;
                smileyWeight=3;

//                lifePojo.rating =3;
//                db.lifeDao().insertLife(lifePojo);
                break;


            case R.id.imageButton4:
                Log.d(TAG, "onClick: imagebutton 4 clicked");
                emoji(view);
                flag = true;
                smileyWeight=4;

//                lifePojo.rating =4;
//                db.lifeDao().insertLife(lifePojo);
                break;


            case R.id.button2:
                input.setText(" ");
                flag = false;
                ImageButton new1 = findViewById(R.id.imageButton);
//        new1.setImageResource(R.drawable.btn_star_big_on);
                new1.setBackgroundColor(Color.GRAY);

                ImageButton imag1 = findViewById(R.id.imageButton2);
                imag1.setBackgroundColor(Color.GRAY);


                ImageButton imag2 = findViewById(R.id.imageButton3);
                imag2.setBackgroundColor(Color.GRAY);


                ImageButton imag3 = findViewById(R.id.imageButton4);
                imag3.setBackgroundColor(Color.GRAY);


                break;
            default:
                break;

        }


    }

    public void emoji(View view) {
        for (Object item : integerArray) {
            if (Integer.valueOf((Integer) item) == view.getId()) {
                Log.d(TAG, "onClick: there is a match" + view.getId());
                ImageButton imag = findViewById(view.getId());


                imag.setBackgroundColor(Color.RED);

            } else {
                ImageButton imag = findViewById(Integer.valueOf((Integer) item));


                imag.setBackgroundColor(Color.BLUE);

            }

        }


    }


}
