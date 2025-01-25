package com.scm.backend.repository;

import com.scm.backend.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
// IN ORDER TO, expose API to different path, except for default = contacts
//Change it, here.. OR IF NOT -REQUIRED to expose , set exported to false
//exported = false,
@RepositoryRestResource( path = "user-contacts", collectionResourceRel = "user-contacts")
public interface ContactRepository extends JpaRepository<Contact, String> {
//    By default, one end point with /contacts will be created
//    Spring Data REST uses the HAL format for JSON output. It is flexible
//    and offers a convenient way to supply links adjacent to the data that is served.

    @RestResource(path = "findByEmailId", rel = "findByEmail")
    Contact findByEmail(@Param("email") String email);

    @RestResource(path = "findByPhoneNum", rel = "findByPhoneNumber")
    Contact findByPhoneNumber(@Param("phone") String phoneNumber);

}
