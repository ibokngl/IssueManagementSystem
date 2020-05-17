package com.ibcaka.issuemanagement.service;

import com.ibcaka.issuemanagement.dto.IssueDto;
import com.ibcaka.issuemanagement.util.TPage;
import org.springframework.data.domain.Pageable;

//Bussiness logic için class eklicem bu repositoryler üzerinden direk dbye erişmicem
//araya bir katman daha koyucam bu katman üzerinde validasyonlar koycam adı boş olamaz küçük harf içeremez gibi.
//uygulamama özel mantıklar Service diye nitelendireceğim Layerda tutucam
//bu servisler interface olduğu için metod imzası taşıyacak metod body olmucak
public interface IssueService {

    //Issue save(Issue issue); // Bir issue kaydını parametre aldık ve onu geri döndük
    //Issue getById(Long id); //bir Id verdik veritabanında o Id yi bulup geri dönecek
    //Page<Issue> getAllPageable(Pageable pageable); // arayüz implemente edildiğinde sayfa gösterimi için kullancam
    //Boolean delete(Issue issue);

//Bir save isteği yapılırken servisime dtosu verilsin serviste geriye dto döndürsün ama servis kendi içerisinde gitsin entity ile çalışsın.
//Servis katmanından itibaren frontendle restcontroller konuşma aşamasına geçiyoruz.
    IssueDto save(IssueDto issue);
    IssueDto getById(Long id);
    TPage<IssueDto> getAllPageable(Pageable pageable);
    Boolean delete(Long isssue);
    IssueDto update(Long id, IssueDto issue);
}
