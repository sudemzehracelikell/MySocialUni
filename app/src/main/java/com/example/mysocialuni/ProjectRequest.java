package com.example.mysocialuni;

public class ProjectRequest {

    private String name;
    private String email;
    private String department;
    private String classYear;
    private String university;
    private String projectTitle;
    private int imageResId;
    private int cvResId;

    public ProjectRequest(String name, String email, String department, String classYear,
                          String university, String projectTitle, int imageResId, int cvResId) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.classYear = classYear;
        this.university = university;
        this.projectTitle = projectTitle;
        this.imageResId = imageResId;
        this.cvResId = cvResId;
    }

    // --- Getters ---
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public String getClassYear() {
        return classYear;
    }

    public String getUniversity() {
        return university;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public int getImageResId() {
        return imageResId;
    }

    public int getCvResId() {
        return cvResId;
    }
}
