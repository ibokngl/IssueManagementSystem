package com.ibcaka.issuemanagement.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

//BaseEntity yi extend ettik otomatikmen bu classa beş tane kolon eklemiş olduk ve Serializable etmiş olduk kalıtım yoluyla
//Aslında JPA üzerinden bir kalıtım yapmış olduk
//IssueStatus Enumarationdır bunlar issunın statusunu belirlicek
//Issue classı bir tablodur. Bundan dolayı Entity Ano. zorunludur. Bir ORM nesnesidir Veritabanında bir tabloya karşılık gelecek
//Veritabanı anoları  javax.persistence kütüphanesinde gelir.
//@Id : primarykey
//@GeneratedValue(strategy = GenerationType.AUTO) : otomatik artan
//@AllArgsConstructor: Sınıfın Constructorını üretir.Bu Constructor sınıftaki tüm fieldleri parametre olarak almıştır.,
//@NoArgsConstructor: Parametresiz Constructor üretir.
//@ToStirng : Bu nesnenin bir toString metodunu override ediyor.
//@EqualsAndHashCode : Equals ve HashCode metodlarını override ediyor
//@ManyToOne(optional = true : yani bir issue nesnesş yaratılırken onun assignesini vermesekte olur. Null kalsada olur.
// FetchType.LAZY : Bilgiyi ancak ilişkili nesnenin çağırımı ile birlikte getirir. Burada get metodunun çağırımı ile proxy devreye girer ve ilgili sorguyu gerçekleştirir.


@Entity
@Table(name = "issue")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Issue extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "description",length = 400)
    private String description;

    @Column(name = "details",length = 400)
    private String details;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "issue_status")
    @Enumerated(EnumType.STRING)
    private IssueStatus issueStatus;

    @JoinColumn(name = "assignee_user_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private User assignee;

    @JoinColumn(name = "project_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private Project project;
}
