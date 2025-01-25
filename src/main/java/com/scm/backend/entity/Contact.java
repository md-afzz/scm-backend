package com.scm.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_contact")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
// @Data = Getter, Setter, ToString, EqualsAndHashCode and RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "contact_id")
    private String contactId;

    private String name;

    private String email;

    private String phoneNumber;

    private String address;

    private String picture;

    @Lob
    private String description;

    private boolean favorite = false;

    private String websiteLink;

    private String linkedInLink;

    private String instagramLink;

    private String cloudinaryImagePublicId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "email_id", nullable = false)
    private User user;
}
