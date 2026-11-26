package dev.michalaniol.github_analytics.entity;

import jakarta.persistence.*;

import java.time.Instant;


@Entity
@Table(name = "repositories")
public class RepositoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "github_id", nullable = false, unique = true)
    private Long githubId;

    @Column(nullable = false)
    private String owner;

    @Column(nullable = false)
    private String name;

    @Column(name = "full_name", nullable = false, unique = true, length = 512)
    private String fullName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "primary_language", length = 100)
    private String primaryLanguage;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;


    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @PrePersist
    protected void onCreate() {
        Instant now = Instant.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = Instant.now();
    }

    protected RepositoryEntity() {
    }

    public RepositoryEntity(Long githubId, String owner, String name, String fullName, String description, String primaryLanguage) {
        this.githubId = githubId;
        this.owner = owner;
        this.name = name;
        this.fullName = fullName;
        this.description = description;
        this.primaryLanguage = primaryLanguage;
    }

    public Long getId() {
        return id;
    }

    public Long getGithubId() {
        return githubId;
    }

    public String getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDescription() {
        return description;
    }

    public String getPrimaryLanguage() {
        return primaryLanguage;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPrimaryLanguage(String primaryLanguage) {
        this.primaryLanguage = primaryLanguage;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

