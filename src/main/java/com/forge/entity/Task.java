package com.forge.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "task")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "assignee_id")
    private User assignee;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private KanbanStatus status = KanbanStatus.TODO;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    private Double estimateHours;

    private Instant createdAt = Instant.now();
    private Instant updatedAt = Instant.now();
}
