package com.ibcaka.issuemanagement.entity;

import lombok.*;

import javax.persistence.*;

//Her issue yu bir projecte bağlıcam
@Entity
@Table(name = "project")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Project extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "project_code",length = 400)
    private String projectCode;
    @Column(name = "project_name",length = 400)
    private String projectName;
    @JoinColumn(name = "manager_user_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private User manager;

}
