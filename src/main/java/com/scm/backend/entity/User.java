package com.scm.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
// Data contains GETTER SETTER TO-STRING EQUALS-HASHCODE REQUIRED ARGS CONSTRUCTOR
@Builder
@ToString
@EqualsAndHashCode
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private String userId;

    @Column(name = "email_id", nullable = false, unique = true)
    private String email;

    @Column(name = "user_name", length = 35)
    private String userName;

    @Column(name = "password", nullable = false)
    @Getter(value = AccessLevel.NONE)
    private String password;

    @Lob
    private String about;

    @Column(length= 100, name = "profile_pic")
    private String profilePicture;

    @Column(name = "age")
    private int age;

    @Column(name = "phone_number")
    @Getter(value = AccessLevel.NONE)
    private String phoneNumber;

//    If you don't specify @Column annotation (Optional)
//    then Hibernate uses default naming stretegy by using camel case.
//firstName field becomes first_name column in Database.
//    strategy ; Hibernate 5 defines a Physical and Implicit naming strategies. Spring Boot configures SpringPhysicalNamingStrategy by default.
//    This implementation provides the same table structure as Hibernate 4:
//   all dots are replaced by underscores and camel cases are replaced by underscores as well.

// is_enabled
    @Builder.Default
    private boolean isEnabled =false;

    @Builder.Default
    private boolean isEmailVerified = false;

    @Builder.Default
    private boolean isPhoneNumberVerified= false;

    @Enumerated(value = EnumType.STRING)
    @Builder.Default
    private Providers providers= Providers.valueOf("SELF");

    @Column(name = "email_token")
    private String emailToken;

//    @Transient
//    private int trivial;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Builder.Default
    private Set<Contact> contacts = new LinkedHashSet<>();



}
