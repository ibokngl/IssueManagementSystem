package com.ibcaka.issuemanagement.repository;

import com.ibcaka.issuemanagement.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
//Bu entiyler bir interface kaydedip okunup veya bir çok condition ile sorguşanması veya
//update eidlmesi silnmesi gibi işlemler yapıcaz
//bunun için Data JPA bize sunmuş olduğu en önemli şey repositorylerdir.
//Ben bunu JPARepository interface türüticem.
//JpaRepository<Issue : Jpa hangi tabloya hizmet edicek -- , Long> : tablomuzun @Id mizin tipi neyse o yazılır
//JpaRepository O tabloya aslında bir çok özellik kazandırmaktadır delete save sorting update
public interface IssueRepository extends JpaRepository<Issue,Long> {

    Issue getBydescription(String description);
    Issue getBydetails(String details);
    Issue getByissueStatus(String issueStatus);
}
