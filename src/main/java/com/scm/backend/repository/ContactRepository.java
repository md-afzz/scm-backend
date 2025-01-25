package com.scm.backend.repository;

import com.scm.backend.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {
//    By default, one end point with /contacts will be created
//    Spring Data REST uses the HAL format for JSON output. It is flexible
//    and offers a convenient way to supply links adjacent to the data that is served.


}
