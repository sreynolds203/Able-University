package com.example.able_university;

import java.util.HashMap;

public class StaffMember {
    /**
     * local variables that can be access when object is created in other classes
     */
    String name;
    String title;
    String email;
    String bio;

    private static StaffMember instance = new StaffMember();//creates a new instance object

    /**
     * empty constructor
     */
    private StaffMember(){
        //Empty constructor
    }

    /**
     * creates a new instance
     * @return
     */
    public static StaffMember getInstance(){
        return instance;
    }

    /**
     * constructor for the class that allows for faculty information to be created in different classes
     * @param name faculty name
     * @param title faculty title
     * @param email faculty email
     * @param bio faculty biography
     */
    StaffMember(String name, String title, String email, String bio){
        this.name = name;
        this.title = title;
        this.email = email;
        this.bio = bio;
    }

    enum Department {
        AdminDept, ArtDept, BusinessDept, ScienceDept;
    }

    /**
     * list of keywords and associated departments for the search function
     * @param string
     * @return
     */
    protected static Department search(String string){
        HashMap<String, Department> faculty = new HashMap<>();
        faculty.put("jim", Department.AdminDept);
        faculty.put("jimerton", Department.AdminDept);
        faculty.put("jim jimerton", Department.AdminDept);
        faculty.put("kim", Department.ArtDept);
        faculty.put("kimerton", Department.ArtDept);
        faculty.put("kim kimerton", Department.ArtDept);
        faculty.put("jill", Department.BusinessDept);
        faculty.put("jillerton", Department.BusinessDept);
        faculty.put("jill jillerton", Department.BusinessDept);
        faculty.put("fred", Department.ScienceDept);
        faculty.put("frederton", Department.ScienceDept);
        faculty.put("fred frederton", Department.ScienceDept);
        faculty.put("bob", Department.ScienceDept);
        faculty.put("boberton", Department.ScienceDept);
        faculty.put("bob boberton", Department.ScienceDept);
        faculty.put("chelsea", Department.AdminDept);
        faculty.put("chelserton", Department.AdminDept);
        faculty.put("chelsea chelserton", Department.AdminDept);

        return faculty.get(string.toLowerCase());
    }
}
