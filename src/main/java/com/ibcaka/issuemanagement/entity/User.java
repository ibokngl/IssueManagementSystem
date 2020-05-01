package com.ibcaka.issuemanagement.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

//@OneToMany(fetch = FetchType.LAZY) : bir tane kullanıcıya birden fazla iisue bağlanabilir
//Ve onları çekmek istediğimde de private List<Issue> issues; bu fieldı çağırıcam bu fieldın getter otomatikmen orayı çağıyor olcak ihtiyç duyudlupunda çünkü LAZY

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "uname",length = 100,unique = true)
    private String username;

    @Column(name = "pwd",length = 200)
    private String password;

    @Column(name = "name_Surname",length = 200)
    private String nameSurname;

    @Column(name = "email",length = 100)
    private String email;

    @JoinColumn(name = "assignee_user_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Issue> issues;
}
