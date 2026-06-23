package com.forge.repository;

import com.forge.entity.Task;
import com.forge.entity.KanbanStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
    List<Task> findByProjectId(UUID projectId);
    List<Task> findByStatusAndProjectId(KanbanStatus status, UUID projectId);
}
