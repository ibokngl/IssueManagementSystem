package com.ibcaka.issuemanagement.service;

import com.ibcaka.issuemanagement.entity.Issue;
import com.ibcaka.issuemanagement.entity.IssueHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

//Bussiness logic için class eklicem bu repositoryler üzerinden direk dbye erişmicem
//araya bir katman daha koyucam bu katman üzerinde validasyonlar koycam adı boş olamaz küçük harf içeremez gibi.
//uygulamama özel mantıklar Service diye nitelendireceğim Layerda tutucam
//bu servisler interface olduğu için metod imzası taşıyacak metod body olmucak
public interface IssueHistoryService {

    IssueHistory save(IssueHistory issuehistory); // Bir issue kaydını parametre aldık ve onu geri döndük
    IssueHistory getById(Long id); //bir Id verdik veritabanında o Id yi bulup geri dönecek
    Page<IssueHistory> getAllPageable(Pageable pageable); // arayüz implemente edildiğinde sayfa gösterimi için kullancam
    Boolean delete(IssueHistory issueHistory);
}
