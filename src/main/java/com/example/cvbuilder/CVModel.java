package com.example.cvbuilder;

public class CVModel {
    private String name, email, phone, address, education, skills, work, projects;

    public CVModel(String name, String email, String phone, String address,
                   String education, String skills, String work, String projects) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.education = education;
        this.skills = skills;
        this.work = work;
        this.projects = projects;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
    public String getEducation() { return education; }
    public String getSkills() { return skills; }
    public String getWork() { return work; }
    public String getProjects() { return projects; }
}
