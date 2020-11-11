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

public class ArtDept extends AppCompatActivity {

    private TextView textView5;//local variable for the title

    /**
     * Creates the page for the user to view the faculty in the art department
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_dept);

        textView5 = (TextView) findViewById(R.id.textView5);//sets the title of the page
        textView5.setText("Arts");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);//creates the toolbar
        setSupportActionBar(toolbar);

        //this object is the faculty member in the department
        StaffMember kim = new StaffMember("Kim Kimerton", "Head of Art", "kim.kimerton@able.edu", "Kim has been head " +
                "of the art department since 2007. She has been featured in numerous galleries and works with local galleries to help " +
                "promote the university.");

        TextView name = findViewById(R.id.textView11);//start of the faculty member
        name.setText(kim.name);//name
        TextView title1 = findViewById(R.id.textView12);
        title1.setText(kim.title);//title
        TextView email1 = findViewById(R.id.textView13);
        email1.setText(kim.email);//email
        TextView bio1 = findViewById(R.id.textView14);
        bio1.setText(kim.bio);//biography
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
                    ArtDept.this.textView5.setText(results);
                }
                else {
                    ArtDept.this.routeToDepartment(match);//if match, sends to correct activity
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