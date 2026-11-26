package dev.michalaniol.github_analytics.repository;

import dev.michalaniol.github_analytics.entity.RepositoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositoryJpaRepository extends JpaRepository<RepositoryEntity, Long> {
    Optional<RepositoryEntity> findByGithubId(Long githubId);
    Optional<RepositoryEntity> findByFullName(String fullName);
    boolean existsByGithubId(Long githubId);
}
