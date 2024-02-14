package org.example.models;

public class Course {
    private int courseId;

    public Course(int courseId, String name, int yhp, String description) {
        this.courseId = courseId;
        this.name = name;
        this.yhp = yhp;
        this.description = description;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYhp() {
        return yhp;
    }

    public void setYhp(int yhp) {
        this.yhp = yhp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String name;
    private int yhp;
    private String description;
}
