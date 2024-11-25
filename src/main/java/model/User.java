package model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "User")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;



    @Column(nullable = false, unique = true)
    @Email(message = "Email should be validated")
    private String email;

    @Column(nullable = false)
    @Size(min = 8, message = "Password is at least 8 character")
    private String password;


//    @OneToOne
//    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
//    private Role role;

    @ManyToMany
    List<Role> roles;
//    @JoinTable(
//            name = "users_roles",
//            joinColumns = @JoinColumn(
//                    name = "user_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(
//                    name = "role_id", referencedColumnName = "id"))
//    private List<Role> role;


    @ManyToOne
    private Department department;


    @Column(name = "FirstName")
    private String firstName;

    @Column
    private String lastName;

//    @OneToMany(mappedBy = "user")
//    private List<Invoice> invoices;

//    @Column(updatable = false)
//    @CreatedDate
//    private Date createdAt;
//
//    @Column
//    @LastModifiedDate
//    private Date updatedAt;


    public User(String mail, String password, List<Role> roles) {
        this.email = mail;
        this.roles = roles;
        this.password = password;
    }


}