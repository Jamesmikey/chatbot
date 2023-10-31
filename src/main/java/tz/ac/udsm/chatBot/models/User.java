package tz.ac.udsm.chatBot.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_name",length = 50,nullable = true)
    private String name;

    @Column(unique = true)
    private String email;
    private String password;

    @Column(unique = true)
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "add_id")
    private Address address;


//    @OneToMany(mappedBy = "user")
//    private List<Message> messages;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "roles_user",joinColumns = @JoinColumn(name = "user_ref_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "reoles_ref_id"))
    private Set<Role> roles;
}
