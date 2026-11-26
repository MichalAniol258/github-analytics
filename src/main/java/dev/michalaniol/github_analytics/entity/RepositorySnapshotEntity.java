package dev.michalaniol.github_analytics.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "repository_snapshots")
public class RepositorySnapshotEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "repository_id", nullable = false)
    private RepositoryEntity repository;

    @Column(name = "stars_count", nullable = false)
    private int starsCount;

    @Column(name = "forks_count", nullable = false)
    private int forksCount;

    @Column(name = "open_issues_count", nullable = false)
    private int openIssuesCount;

    @Column(name = "watchers_count", nullable = false)
    private int watchersCount;

    @Column(name = "captured_at", nullable = false)
    private Instant capturedAt;

    @PrePersist
    protected void onCreate() {
        Instant now = Instant.now();
        this.capturedAt = now;
    }

    protected RepositorySnapshotEntity() {}

    public RepositorySnapshotEntity(RepositoryEntity repository, int starsCount, int forksCount, int openIssuesCount, int watchersCount) {
        this.repository = repository;
        this.starsCount = starsCount;
        this.forksCount = forksCount;
        this.openIssuesCount = openIssuesCount;
        this.watchersCount = watchersCount;
    }

    public Long getId() {
        return id;
    }

    public Instant getCapturedAt() {
        return capturedAt;
    }

    public int getWatchersCount() {
        return watchersCount;
    }

    public int getOpenIssuesCount() {
        return openIssuesCount;
    }

    public int getForksCount() {
        return forksCount;
    }

    public int getStarsCount() {
        return starsCount;
    }

    public RepositoryEntity getRepository() {
        return repository;
    }


}
