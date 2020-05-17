package com.ibcaka.issuemanagement.service.impl;

import com.ibcaka.issuemanagement.dto.ProjectDto;
import com.ibcaka.issuemanagement.entity.Project;
import com.ibcaka.issuemanagement.repository.ProjectRepository;
import com.ibcaka.issuemanagement.service.ProjectService;
import com.ibcaka.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectDto save(ProjectDto project) {
        /**if (project.getProjectCode() == null) {
         throw new IllegalArgumentException("project code cannor be null");
         }
         return projectRepository.save(project);*/

        Project projectCheck = projectRepository.getByProjectCode(project.getProjectCode());
        if (projectCheck != null)
            throw new IllegalArgumentException("Project Code Already Exist");

        Project p = modelMapper.map(project, Project.class);
        p = projectRepository.save(p);
        project.setId(p.getId());
        return project;
    }

    @Override
    public ProjectDto getById(Long id) {
        Project p = projectRepository.getOne(id);
        return modelMapper.map(p, ProjectDto.class);
    }

    @Override
    public ProjectDto getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<ProjectDto> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public TPage<ProjectDto> getAllPageable(Pageable pageable) {
        Page<Project> data = projectRepository.findAll(pageable);
        TPage page = new TPage<ProjectDto>();
        ProjectDto[] dtos = modelMapper.map(data.getContent(), ProjectDto[].class);
        page.setStat(data, Arrays.asList(dtos));
        return page;
    }

    @Override
    public Boolean delete(ProjectDto project) {
        return null;
    }
    public Boolean delete(Long id) {
        projectRepository.deleteById(id);
        return true;
    }
    @Override
    public ProjectDto update(Long id, ProjectDto project) {
        Project projectDb = projectRepository.getOne(id);
        if (projectDb == null)
            throw new IllegalArgumentException("Project Does Not Exist");

        Project projectCheck = projectRepository.getByProjectCodeAndIdNot(project.getProjectCode(),id);
        if (projectCheck != null)
            throw new IllegalArgumentException("Project Code Already Exist");

        //projectControl(project);

        projectDb.setProjectCode(project.getProjectCode());
        projectDb.setProjectName(project.getProjectName());

        projectRepository.save(projectDb);
        return modelMapper.map(projectDb, ProjectDto.class);

    }

    private void projectControl(ProjectDto project) {
        Project projectCheck = projectRepository.getByProjectCode(project.getProjectCode());
        if (projectCheck != null)
            throw new IllegalArgumentException("Project Code Already Exist");
    }

}
