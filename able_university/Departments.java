package com.example.able_university;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;


public class Departments extends AppCompatActivity {

    private TextView textView35;//variable for page title


    /**
     * Begins the actions of the page and presents the user with options
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departments);

        textView35 = (TextView) findViewById(R.id.departments);//sets title of page
        textView35.setText("Departments");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);//creates the toolbar on page
        setSupportActionBar(toolbar);
    }

    /**
     * Helper method to route to the different departments
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
                    Departments.this.textView35.setText(results);
                }
                else {
                    Departments.this.routeToDepartment(match);//if match, sends to correct activity
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


    /**
     * sends the user to the faculty admin page
     * @param view
     */
    public void adminPage(View view) {//redirects to admin page
        Intent adminPage = new Intent(this, AdminDept.class);
        startActivity(adminPage);
    }

    /**
     * sends the user to the faculty arts page
     * @param view
     */
    public void artsPage(View view) {//redirects to arts page
        Intent artsPage = new Intent(this, ArtDept.class);
        startActivity(artsPage);
    }

    /**
     * sends the user to the faculty business page
     * @param view
     */
    public void businessPage(View view) {//redirects to business page
        Intent businessPage = new Intent(this, BusinessDept.class);
        startActivity(businessPage);
    }
    /**
     * sends the user to the faculty business page
     * @param view
     */
    public void sciencePage(View view) {//redirects to business page
        Intent sciencePage = new Intent(this, ScienceDept.class);
        startActivity(sciencePage);
    }
}

