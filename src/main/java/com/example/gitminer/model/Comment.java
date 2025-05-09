package com.example.gitminer.model;

import jakarta.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String commentId;
    private String content;

    @ManyToOne
    private Issue issue;

    public Comment() {}

    public Comment(String commentId, String content, Issue issue) {
        this.commentId = commentId;
        this.content = content;
        this.issue = issue;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCommentId() { return commentId; }
    public void setCommentId(String commentId) { this.commentId = commentId; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public Issue getIssue() { return issue; }
    public void setIssue(Issue issue) { this.issue = issue; }
}