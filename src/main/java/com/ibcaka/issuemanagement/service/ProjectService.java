package com.ibcaka.issuemanagement.service;

import com.ibcaka.issuemanagement.dto.ProjectDto;
import com.ibcaka.issuemanagement.util.TPage;
import org.springframework.data.domain.Pageable;

import java.util.List;

//Bussiness logic için class eklicem bu repositoryler üzerinden direk dbye erişmicem
//araya bir katman daha koyucam bu katman üzerinde validasyonlar koycam adı boş olamaz küçük harf içeremez gibi.
//uygulamama özel mantıklar Service diye nitelendireceğim Layerda tutucam
//bu servisler interface olduğu için metod imzası taşıyacak metod body olmucak
public interface ProjectService {

    ProjectDto save(ProjectDto project); // Bir issue kaydını parametre aldık ve onu geri döndük

    ProjectDto getById(Long id); //bir Id verdik veritabanında o Id yi bulup geri dönecek

    ProjectDto getByProjectCode(String projectCode);

    List<ProjectDto> getByProjectCodeContains(String projectCode);

    TPage<ProjectDto> getAllPageable(Pageable pageable); // arayüz implemente edildiğinde sayfa gösterimi için kullancam

    Boolean delete(ProjectDto project);

    ProjectDto update(Long id, ProjectDto project);
}
