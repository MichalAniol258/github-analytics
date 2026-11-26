package dev.michalaniol.github_analytics.repository;

import dev.michalaniol.github_analytics.entity.RepositorySnapshotEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositorySnapshotJpaRepository extends JpaRepository<RepositorySnapshotEntity, Long> {
    List<RepositorySnapshotEntity> findByRepositoryIdOrderByCapturedAtDesc(Long repositoryId);
}
