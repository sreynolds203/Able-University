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

public class ScienceDept extends AppCompatActivity {

    private TextView textView35;//variable for page title

    /**
     * creates the page for the user to view the faculty members in the science department
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science_dept);

        textView35 = (TextView) findViewById(R.id.textView35);//sets title of page
        textView35.setText("Science");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);//creates the toolbar on page
        setSupportActionBar(toolbar);

        //each object is a faculty member of the department
        StaffMember fred = new StaffMember("Fred Frederton", "Head of Science", "fred.frederton@able.edu", "Fred " +
                "has been with Able for 15 years and guides faculty on ways to improve the department.");
        StaffMember bob = new StaffMember("Bob Boberton", "Biology Professor", "bob.boberton@able.edu", "Bob obtained his B.S. " +
                "and M.S. from Able University before getting his doctorate from Able State.");

        TextView name1 = findViewById(R.id.textView36);//start of the first person
        name1.setText(fred.name);//name
        TextView title1 = findViewById(R.id.textView37);
        title1.setText(fred.title);//title
        TextView email1 = findViewById(R.id.textView38);
        email1.setText(fred.email);//email
        TextView bio1 = findViewById(R.id.textView39);
        bio1.setText(fred.bio);//biography
        TextView name2 = findViewById(R.id.textView40);//starts of the second person
        name2.setText(bob.name);//name
        TextView title2 = findViewById(R.id.textView41);
        title2.setText(bob.title);//title
        TextView email2 = findViewById(R.id.textView42);
        email2.setText(bob.email);//email
        TextView bio2 = findViewById(R.id.textView43);
        bio2.setText(bob.bio);//biography
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
                        ScienceDept.this.textView35.setText(results);
                    }
                    else {
                        ScienceDept.this.routeToDepartment(match);//if match, sends to correct activity
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
