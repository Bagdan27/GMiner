package com.example.gitminer.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String owner;
    private String repoName;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Commit> commits = new ArrayList<>();

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Issue> issues = new ArrayList<>();

    public Project() {}

    public Project(String owner, String repoName) {
        this.owner = owner;
        this.repoName = repoName;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }
    public String getRepoName() { return repoName; }
    public void setRepoName(String repoName) { this.repoName = repoName; }
    public List<Commit> getCommits() { return commits; }
    public void setCommits(List<Commit> commits) { this.commits = commits; }
    public List<Issue> getIssues() { return issues; }
    public void setIssues(List<Issue> issues) { this.issues = issues; }

    // Metod main for testing
    public static void main(String[] args) {
        // Создаем экземпляр Project
        Project project = new Project("johnDoe", "GitMiner");

        // Just info on screen
        System.out.println("Project Owner: " + project.getOwner());
        System.out.println("Repo Name: " + project.getRepoName());
    }
}
