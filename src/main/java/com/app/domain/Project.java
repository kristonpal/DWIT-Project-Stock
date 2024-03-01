package com.app.domain;

import java.sql.Blob;

public class Project {

    private int id;
    private int roll;
    private String name;
    private int year;
    private String semester;
    private String category;
    private String filename;
    private String title;
    private Blob file;
    private String tags;
    private String supervisor;
    private String domain;
    private String abstraction;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Blob getFile() {
        return file;
    }

    public void setFile(Blob file) {
        this.file = file;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getAbstraction() {
        return abstraction;
    }

    public void setAbstraction(String abstraction) {
        this.abstraction = abstraction;
    }

    public Project(){ }

    public Project(int id, int roll, String name, int year, String semester, String category, String filename, String title, Blob file, String tags, String supervisor, String domain, String abstraction) {
        this.id = id;
        this.roll = roll;
        this.name = name;
        this.year = year;
        this.semester = semester;
        this.category = category;
        this.filename = filename;
        this.title = title;
        this.file = file;
        this.tags = tags;
        this.supervisor = supervisor;
        this.domain = domain;
        this.abstraction = abstraction;
    }
    public Project(int id, int roll, String name, int year, String semester, String category, String filename, String title, String tags, String supervisor, String domain, String abstraction) {
        this.id = id;
        this.roll = roll;
        this.name = name;
        this.year = year;
        this.semester = semester;
        this.category = category;
        this.filename = filename;
        this.title = title;
        this.file = null;
        this.tags = tags;
        this.supervisor = supervisor;
        this.domain = domain;
        this.abstraction = abstraction;
    }
    //    public Project(String name, String title, String category, String abstraction, String advisers, String filename, String tags, Blob file) {
//        this.name = name;
//        this.title = title;
//        this.category = category;
//        this.abstraction = abstraction;
//        this.advisers = advisers;
//        this.filename = filename;
//        this.tags = tags;
//        this.file = file;
//    }
//    public Project(String name, String title, String category, String abstraction, String advisers, String filename, String tags) {
//        this.name = name;
//        this.title = title;
//        this.category = category;
//        this.abstraction = abstraction;
//        this.advisers = advisers;
//        this.filename = filename;
//        this.tags = tags;
//        this.file = null;
//    }
//
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getCategory() {
//        return category;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }
//
//    public String getAbstraction() {
//        return abstraction;
//    }
//
//    public void setAbstraction(String abstraction) {
//        this.abstraction = abstraction;
//    }
//
//    public String getAdvisers() {
//        return advisers;
//    }
//
//    public void setAdvisers(String advisers) {
//        this.advisers = advisers;
//    }
//
//    public String getFilename() {
//        return filename;
//    }
//
//    public void setFilename(String filename) {
//        this.filename = filename;
//    }
//
//    public String getTags() {
//        return tags;
//    }
//
//    public void setTags(String tags) {
//        this.tags = tags;
//    }
//
//    public Blob getFile() {
//        return file;
//    }
//
//    public void setFile(Blob file) {
//        this.file = file;
//    }
}
