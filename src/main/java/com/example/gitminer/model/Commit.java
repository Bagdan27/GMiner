package com.example.gitminer.model;

import jakarta.persistence.*;

@Entity
public class Commit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String commitId;
    private String message;
    private String author;

    @ManyToOne
    private Project project;

    public Commit() {}

    public Commit(String commitId, String message, String author, Project project) {
        this.commitId = commitId;
        this.message = message;
        this.author = author;
        this.project = project;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCommitId() { return commitId; }
    public void setCommitId(String commitId) { this.commitId = commitId; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public Project getProject() { return project; }
    public void setProject(Project project) { this.project = project; }
}