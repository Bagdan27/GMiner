package com.example.gitminer.controller;

import com.example.gitminer.model.*;
import com.example.gitminer.service.GitMinerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GitMinerController {
    private final GitMinerService gitMinerService;

    public GitMinerController(GitMinerService gitMinerService) {
        this.gitMinerService = gitMinerService;
    }

    @PostMapping("/projects")
    public ResponseEntity<Project> addProject(@RequestBody Project project) {
        Project savedProject = gitMinerService.saveProject(project);
        return ResponseEntity.ok(savedProject);
    }

    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getAllProjects() {
        return ResponseEntity.ok(gitMinerService.getAllProjects());
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        Project project = gitMinerService.getProjectById(id);
        return project != null ? ResponseEntity.ok(project) : ResponseEntity.notFound().build();
    }

    @GetMapping("/commits")
    public ResponseEntity<List<Commit>> getAllCommits() {
        return ResponseEntity.ok(gitMinerService.getAllCommits());
    }

    @GetMapping("/commits/{id}")
    public ResponseEntity<Commit> getCommitById(@PathVariable Long id) {
        Commit commit = gitMinerService.getCommitById(id);
        return commit != null ? ResponseEntity.ok(commit) : ResponseEntity.notFound().build();
    }

    @GetMapping("/issues")
    public ResponseEntity<List<Issue>> getAllIssues() {
        return ResponseEntity.ok(gitMinerService.getAllIssues());
    }

    @GetMapping("/issues/{id}")
    public ResponseEntity<Issue> getIssueById(@PathVariable Long id) {
        Issue issue = gitMinerService.getIssueById(id);
        return issue != null ? ResponseEntity.ok(issue) : ResponseEntity.notFound().build();
    }

    @GetMapping("/issues/status/{status}")
    public ResponseEntity<List<Issue>> getIssuesByStatus(@PathVariable String status) {
        return ResponseEntity.ok(gitMinerService.getIssuesByStatus(status));
    }

    @GetMapping("/comments")
    public ResponseEntity<List<Comment>> getAllComments() {
        return ResponseEntity.ok(gitMinerService.getAllComments());
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long id) {
        Comment comment = gitMinerService.getCommentById(id);
        return comment != null ? ResponseEntity.ok(comment) : ResponseEntity.notFound().build();
    }
}