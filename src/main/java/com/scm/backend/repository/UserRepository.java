package com.scm.backend.repository;

import com.scm.backend.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
//By default, one end point with /users will be created
////    Spring Data REST uses the HAL format for JSON output. It is flexible
////    and offers a convenient way to supply links adjacent to the data that is served.

    @Modifying
    @Query(value = "delete from users where user_name = :userName; ", nativeQuery = true)
    @Transactional
    public int deleteUser(@Param("userName") String userName);
}
