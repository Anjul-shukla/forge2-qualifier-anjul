package com.forge.repository;

import com.forge.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, UUID> {
    List<Project> findByOwnerId(UUID ownerId);
    List<Project> findByMembersId(UUID userId);
}
