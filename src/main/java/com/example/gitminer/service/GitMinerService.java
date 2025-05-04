package com.example.gitminer.service;

import com.example.gitminer.model.*;
import com.example.gitminer.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GitMinerService {
    private final ProjectRepository projectRepository;
    private final CommitRepository commitRepository;
    private final IssueRepository issueRepository;
    private final CommentRepository commentRepository;

    public GitMinerService(ProjectRepository projectRepository, CommitRepository commitRepository,
                           IssueRepository issueRepository, CommentRepository commentRepository) {
        this.projectRepository = projectRepository;
        this.commitRepository = commitRepository;
        this.issueRepository = issueRepository;
        this.commentRepository = commentRepository;
    }

    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    public List<Commit> getAllCommits() {
        return commitRepository.findAll();
    }

    public Commit getCommitById(Long id) {
        return commitRepository.findById(id).orElse(null);
    }

    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }

    public Issue getIssueById(Long id) {
        return issueRepository.findById(id).orElse(null);
    }

    public List<Issue> getIssuesByStatus(String status) {
        return issueRepository.findByStatus(status);
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }
}