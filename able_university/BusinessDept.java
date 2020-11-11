package com.example.able_university;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class BusinessDept extends AppCompatActivity {

    private TextView business;//local variable for the title

    /**
     * creates the page for the user to view the faculty members in the business department
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_dept);

        business = (TextView) findViewById(R.id.business);//sets the title of the page
        business.setText("Business");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);//creates the toolbar
        setSupportActionBar(toolbar);

        //this object is the facutly member information
        StaffMember jill = new StaffMember("Jill Jillerton", "Head of Business", "jill.jillerton@able.edu", "Jill " +
                "has been working for the department for 23 years and has been a valuable consultant to business in the area.");

        TextView name1 = findViewById(R.id.textView16);//start of the faculty member
        name1.setText(jill.name);//name
        TextView title1 = findViewById(R.id.textView17);
        title1.setText(jill.title);//title
        TextView email1 = findViewById(R.id.textView18);
        email1.setText(jill.email);//email
        TextView bio1 = findViewById(R.id.textView19);
        bio1.setText(jill.bio);//biography
    }

    /**
     * Helper method for routing the to the departments
     * @param department
     */
    public void routeToDepartment(StaffMember.Department department) {//helper function to direct to activities
        Intent intent;
        switch (department) {
            case AdminDept:
                startActivity(new Intent(this, AdminDept.class));
                break;
            case ArtDept:
                startActivity(new Intent(this, ArtDept.class));
                break;
            case BusinessDept:
                startActivity(new Intent(this, BusinessDept.class));
                break;
            case ScienceDept:
                startActivity(new Intent(this, ScienceDept.class));
                break;
        }
    }

    /**
     * Creates the search menu in the toolbar
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu){//creates a menu for the toolbar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        MenuItem userSearch = menu.findItem(R.id.search_view);
        SearchView searchView = (SearchView) userSearch.getActionView();//implements the search function
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String o) {
                StaffMember.Department match = StaffMember.getInstance().search(o);//looks for a match in StaffMember class
                if (match == null) {
                    String results = o + "Not Found in Directory";//displays if nothing matches
                    BusinessDept.this.business.setText(results);
                }
                else {
                    BusinessDept.this.routeToDepartment(match);//if match, sends to correct activity
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String o) {
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

}
