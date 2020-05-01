package com.ibcaka.issuemanagement.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

//Bu ortak bir classtır tüm entitylerde kullanılacaktır.
//Bu classtaki nesneler hibernatede bir orm nesnesi olarak tutulacağı için serializable interface i edilmesi gereklidir
//Bu ne anlama gelir bu nesnenin network taşınması diske yazılmasını sağlar yani BaseEntity classına bu özellikleri kazandırır.
//@Data : class içerisindeki 5 fieldın getter setter metodlarını otomatik oluşturuyor.
//@MappedSuperclass : diğer tüm classlarda BaseEntity classının extend edilmesini sağlar
//Abstract: bazı özelliklerin override edilmesi ve bunda da bazen metod body bulunmak için
@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "created_by", length = 100)
    private String createdBy;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "updated_by", length = 100)
    private String updatedBy;
    @Column(name = "status")
    private Boolean status;
}
