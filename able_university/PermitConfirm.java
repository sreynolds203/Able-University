package com.example.able_university;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PermitConfirm extends AppCompatActivity {
    static int count = 0;

    /**
     * counts the number of times the page is accessed.
     * acts as a database number for the parking permits to issue the number
     * that the information is assigned to in the database.
     * This section is out of the scope of the project and shows the permit number by the count
     */
    private int permitConfirm() {
        count = count + 1;
        return count;
    }

    /**
     * creates the page that displays the information entered by the user on the previous page and shows the permit number
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permit_confirm);

    Intent permitInfo = getIntent();
    String name = permitInfo.getStringExtra(ParkingPermit.NAME);//name
    TextView textName = findViewById(R.id.textView22);
    textName.setText(name);
    String email = permitInfo.getStringExtra(ParkingPermit.EMAIL);//email
    TextView textEmail = findViewById(R.id.textView23);
    textEmail.setText(email);
    String address = permitInfo.getStringExtra(ParkingPermit.ADDRESS);//address
    TextView textAddress = findViewById(R.id.textView24);
    textAddress.setText(address);
    String city = permitInfo.getStringExtra(ParkingPermit.CITY);//city
    TextView textCity = findViewById(R.id.textView25);
    textCity.setText(city);
    String state = permitInfo.getStringExtra(ParkingPermit.STATE);//state
    TextView textState = findViewById(R.id.textView26);
    textState.setText(state);
    String zip = permitInfo.getStringExtra(ParkingPermit.ZIP_CODE);//zip code
    TextView textZip = findViewById(R.id.textView27);
    textZip.setText(zip);
    String make = permitInfo.getStringExtra(ParkingPermit.VEH_MAKE);//vehicle make
    TextView textMake = findViewById(R.id.textView28);
    textMake.setText(make);
    String model = permitInfo.getStringExtra(ParkingPermit.VEH_MODEL);//vehicle model
    TextView textModel = findViewById(R.id.textView29);
    textModel.setText(model);
    String stateReg = permitInfo.getStringExtra(ParkingPermit.STATE_REGISTERED);//state vehicle is registered
    TextView textStateReg = findViewById(R.id.textView30);
    textStateReg.setText(stateReg);
    String plate = permitInfo.getStringExtra(ParkingPermit.PLATE_NUMBER);//license plate number
    TextView textPlate = findViewById(R.id.textView31);
    textPlate.setText(plate);
    TextView textComma = findViewById(R.id.textView32);//comma between the city and state
    textComma.setText(",");
    TextView counter = findViewById(R.id.textView34);
    counter.setText("Permit # " + permitConfirm());
    /*the acting parking permit number. If the user goes back and enters information and submits again, a new permit
    number appears. This could be fixed in a SQL database by checking the database for duplicate user information
    */
    TextView addInfo = findViewById(R.id.textView10);
    addInfo.setText("You will receive an email when the permit is ready for pick up. Please go to the parking building " +
            "room #110 after email is received. You must bring your drivers license in order to obtain your permit.");
    }
    public void home(View view) {//directs the user to the main activity
        Intent dept = new Intent(this, MainActivity.class);
        startActivity(dept);
    }
}
