package com.ibcaka.issuemanagement.repository;

import com.ibcaka.issuemanagement.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Long> {
    Project getByProjectCode(String projectCode);

    Project getByProjectCodeAndIdNot (String projectCode, Long id);

    List<Project> getByProjectCodeContains(String projectCode);
}
