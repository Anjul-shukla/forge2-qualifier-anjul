package com.forge.dto;

import lombok.Data;

/** Authentication requests */
@Data
public class RegisterRequest {
    private String username;
    private String email;
    private String password;
}

@Data
public class LoginRequest {
    private String username;
    private String password;
}

@Data
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    public JwtResponse(String token) { this.token = token; }
}

/** User DTO */
@Data
public class UserResponse {
    private String id;
    private String username;
    private String email;
    private Set<String> roles;
}

/** Project DTOs */
@Data
public class ProjectCreateRequest {
    private String name;
    private String description;
}

@Data
public class ProjectUpdateRequest {
    private String name;
    private String description;
}

@Data
public class ProjectResponse {
    private String id;
    private String name;
    private String description;
    private String ownerId;
    private Set<String> memberIds;
}

/** Task DTOs */
@Data
public class TaskCreateRequest {
    private String title;
    private String description;
    private String assigneeId;
    private String status; // TODO, IN_PROGRESS, etc.
    private Double estimateHours;
}

@Data
public class TaskUpdateRequest {
    private String title;
    private String description;
    private String assigneeId;
    private String status;
    private Double estimateHours;
}

@Data
public class TaskResponse {
    private String id;
    private String title;
    private String description;
    private String assigneeId;
    private String status;
    private String projectId;
    private Double estimateHours;
    private Instant createdAt;
    private Instant updatedAt;
}

/** AI DTOs */
@Data
public class AiTaskGenerationRequest {
    private String prompt; // e.g., "Create a task for implementing login"
}

@Data
public class AiTaskGenerationResponse {
    private String generatedDescription;
}
