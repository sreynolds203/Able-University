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

public class AdminDept extends AppCompatActivity {

    private TextView textView9;//local variable for the title

    /**
     * creates the page for the user to view the faculty in the administration department
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dept);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);//creates the toolbar
        setSupportActionBar(toolbar);

        textView9 = (TextView) findViewById(R.id.textView9);//sets the title of the page
        textView9.setText("Administration");

        //each object is a faculty member for the page
        StaffMember jim = new StaffMember("Jim Jimerton", "Provost", "jim.jimerton@able.edu",
                "Jim Jimerton is the provost of the university. He cares for each student and faculty member " +
                        "and wants them to succeed to the best of their abilities.");
        StaffMember chelsea = new StaffMember("Chelsea Chelserton", "President", "chelsea.chelserton@able.edu", "Chelsea" +
                " Chelserton is the president of the university and strives to make Able university one of the top universities in the " +
                "country.");

        TextView name1 = findViewById(R.id.textView);//start of the first person
        name1.setText(jim.name);//name
        TextView title1 = findViewById(R.id.textView2);
        title1.setText(jim.title);//title
        TextView email1 = findViewById(R.id.textView3);
        email1.setText(jim.email);//email
        TextView bio1 = findViewById(R.id.textView4);
        bio1.setText(jim.bio);//biography
        TextView name2 = findViewById(R.id.business);//start of the second person
        name2.setText(chelsea.name);//name
        TextView title2 = findViewById(R.id.textView6);
        title2.setText(chelsea.title);//title
        TextView email2 = findViewById(R.id.textView7);
        email2.setText(chelsea.email);//email
        TextView bio2 = findViewById(R.id.textView8);
        bio2.setText(chelsea.bio);//biography
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
            public boolean onQueryTextSubmit(String o) {//reads search results
                StaffMember.Department match = StaffMember.getInstance().search(o);//looks for a match in StaffMember class
                if (match == null) {
                    String results = o + "Not Found in Directory";//displays if nothing matches
                    AdminDept.this.textView9.setText(results);
                }
                else {
                    AdminDept.this.routeToDepartment(match);//if match, sends to correct activity
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
