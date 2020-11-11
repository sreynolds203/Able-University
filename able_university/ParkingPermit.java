package com.example.able_university;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ParkingPermit extends AppCompatActivity {
    /**
     * local variables that are final and used in the methods of the class
     */
    public static final String NAME = "com.example.Able_University.MESSAGE1";
    public static final String EMAIL = "com.example.Able_University.MESSAGE2";
    public static final String ADDRESS = "com.example.Able_University.MESSAGE3";
    public static final String CITY = "com.example.Able_University.MESSAGE4";
    public static final String STATE = "com.example.Able_University.MESSAGE5";
    public static final String ZIP_CODE = "com.example.Able_University.MESSAGE6";
    public static final String VEH_MAKE = "com.example.Able_University.MESSAGE7";
    public static final String VEH_MODEL = "com.example.Able_University.MESSAGE8";
    public static final String STATE_REGISTERED = "com.example.Able_University.MESSAGE9";
    public static final String PLATE_NUMBER = "com.example.Able_University.MESSAGE10";

    /**
     * Creates the page and provides the information to the user
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_permit);

    }

    /**
     * Displays the form of the required information for the request
     * @param view
     */
    //All EditText objects are set to the respective elements of the form
    public void parkingPermitInfo(View view){
        Intent permitInfo = new Intent(this, PermitConfirm.class);
        EditText nameText = (EditText) findViewById(R.id.editText22);
        String name = nameText.getText().toString();
        permitInfo.putExtra(NAME, name);
        EditText emailText = (EditText) findViewById(R.id.editText23);
        String email = emailText.getText().toString();
        permitInfo.putExtra(EMAIL, email);
        EditText addressText = (EditText) findViewById(R.id.editText24);
        String address = addressText.getText().toString();
        permitInfo.putExtra(ADDRESS, address);
        EditText cityText = (EditText) findViewById(R.id.editText25);
        String city = cityText.getText().toString();
        permitInfo.putExtra(CITY, city);
        EditText stateText = (EditText) findViewById(R.id.editText26);
        String state = stateText.getText().toString();
        permitInfo.putExtra(STATE, state);
        EditText zipText = (EditText) findViewById(R.id.editText27);
        String zip = zipText.getText().toString();
        permitInfo.putExtra(ZIP_CODE, zip);
        EditText makeText = (EditText) findViewById(R.id.editText28);
        String vehMake = makeText.getText().toString();
        permitInfo.putExtra(VEH_MAKE, vehMake);
        EditText modelText = (EditText) findViewById(R.id.editText29);
        String model = modelText.getText().toString();
        permitInfo.putExtra(VEH_MODEL, model);
        EditText stateRegText = (EditText) findViewById(R.id.editText30);
        String stateReg = stateRegText.getText().toString();
        permitInfo.putExtra(STATE_REGISTERED, stateReg);
        EditText plateText = (EditText) findViewById(R.id.editText31);
        String plate = plateText.getText().toString();
        permitInfo.putExtra(PLATE_NUMBER, plate);

        startActivity(permitInfo);
    }
}
