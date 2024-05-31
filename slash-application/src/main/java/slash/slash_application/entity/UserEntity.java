package slash.slash_application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user_details")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_details_generator")
    @SequenceGenerator(name="user_details_generator", sequenceName = "user_details_user_id_seq", allocationSize=1)
    @Column(name="user_id")
    private Long userId;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="name")
    private String name;

    @Column(name="dateofbirth")
    private String dateOfBirth;

    @Column(name="phonenumber")
    private String phoneNumber;

    @Column(name="gender")
    private String gender;
}
