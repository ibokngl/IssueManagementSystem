
package com.ibcaka.issuemanagement.dto;

import com.ibcaka.issuemanagement.entity.IssueStatus;
import lombok.Data;

import java.util.Date;

//Model Mapper PropertyNameleri örtüştürüyoz
//issue nesnemizi api üzerinden clientlarla konuşmasını istemiyoruz entity üzerinden.
//o yüzden araya dto dediğimiz bir nesne koyduk aslında represtation nesneleri yaratıcaz.Sebebi issue nesnenin şemasını dışarı tamamen açmak istemiyoruz.
//dtodan da clientlara gönderim sağlıcaz.
//Aslında oluşturduğumuz entiylerdeki fieldlardan hangilerini clienta göndercez onları seçiyoruz.
// ISSUE ENTITY İÇERİSİNDEKİ FİELDLADAN EKLEMEK İSTEDİĞİMİZ BURAYA KOYARIZ
@Data // Dışa açtık getter setterını oluşturduk
public class IssueDto {
    private Long id;
    private String description;
    private String details;
    private Date date;
    private IssueStatus issueStatus;
    private UserDto assignee;  //User'ı koyarsak User Entitysi içindeki diğer nesnelerde clienta gider ondan dolayı UserDto yaptık
    private ProjectDto project;
}
