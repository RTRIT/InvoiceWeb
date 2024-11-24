package model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Role")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    //    @ManyToMany
//    @JoinTable(
//            name = "privilege_detail",
//            joinColumns = @JoinColumn(name = "roleId"),
//            inverseJoinColumns = @JoinColumn(name = "privilegeId")
//    )
//    List<Privilege> privileges;
    @ManyToMany
    List<Privilege> privileges;


    @Column(unique = true)
    String roleName;

}
