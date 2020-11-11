package com.example.able_university;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    /**
     * Creates the home screen of the app
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * sends the user to the parking permit page
     * @param view
     */
    public void parkingPermit(View view){//directs the user to the parking permit acitivity
        Intent permit = new Intent(this, ParkingPermit.class);
        startActivity(permit);
    }

    /**
     * sends the user to the departments page
     * @param view
     */
    public void department(View view) {//directs the user to the departments activity
        Intent dept = new Intent(this, Departments.class);
        startActivity(dept);
    }
}
