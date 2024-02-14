package org.example.models;


// kapslar in motsvarade databas namn
public class student {

    private String Fname;
    private String Lname;
    private String city;
    private String hobby;
    private int student_id;

    public student(int id, String fname, String lname, String city, String hobby) {
        this.student_id = id;
        this.Fname = fname;
        this.Lname = lname;
        this.city = city;
        this.hobby = hobby;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

}
