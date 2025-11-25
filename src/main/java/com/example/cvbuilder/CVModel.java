package com.example.cvbuilder;

public class CVModel {

    private int id;   // NEW — needed for update/delete
    private String name = "";
    private String email = "";
    private String phone = "";
    private String address = "";

    private StringBuilder education = new StringBuilder();
    private StringBuilder skills = new StringBuilder();
    private StringBuilder work = new StringBuilder();
    private StringBuilder projects = new StringBuilder();

    public CVModel() {}

    public CVModel(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public CVModel(String name, String email, String phone, String address,
                   String education, String skills, String work, String projects) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;

        addEducation(education);
        addSkills(skills);
        addWork(work);
        addProjects(projects);
    }

    // ---------- SETTERS ----------
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setAddress(String address) { this.address = address; }

    public void addEducation(String edu) {
        if (edu != null && !edu.trim().isEmpty())
            education.append("- ").append(edu.trim()).append("\n");
    }

    public void addSkills(String skill) {
        if (skill != null && !skill.trim().isEmpty())
            skills.append("- ").append(skill.trim()).append("\n");
    }

    public void addWork(String w) {
        if (w != null && !w.trim().isEmpty())
            work.append("- ").append(w.trim()).append("\n");
    }

    public void addProjects(String p) {
        if (p != null && !p.trim().isEmpty())
            projects.append("- ").append(p.trim()).append("\n");
    }

    // ---------- GETTERS ----------
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }

    public String getEducation() { return education.toString(); }
    public String getSkills() { return skills.toString(); }
    public String getWork() { return work.toString(); }
    public String getProjects() { return projects.toString(); }
}
