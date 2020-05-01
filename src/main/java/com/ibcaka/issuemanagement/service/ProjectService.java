package com.ibcaka.issuemanagement.service;

import com.ibcaka.issuemanagement.entity.Issue;
import com.ibcaka.issuemanagement.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

//Bussiness logic için class eklicem bu repositoryler üzerinden direk dbye erişmicem
//araya bir katman daha koyucam bu katman üzerinde validasyonlar koycam adı boş olamaz küçük harf içeremez gibi.
//uygulamama özel mantıklar Service diye nitelendireceğim Layerda tutucam
//bu servisler interface olduğu için metod imzası taşıyacak metod body olmucak
public interface ProjectService {

    Project save(Project project); // Bir issue kaydını parametre aldık ve onu geri döndük
    Project getById(Long id); //bir Id verdik veritabanında o Id yi bulup geri dönecek
    List<Project> getByProjectCode(String projectCode);
    List<Project> getByProjectCodeContains(String projectCode);
    Page<Project> getAllPageable(Pageable pageable); // arayüz implemente edildiğinde sayfa gösterimi için kullancam
    Boolean delete(Project project);
}
