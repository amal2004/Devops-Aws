package com.amal.devopsaws.backend.persistence.repositories;

import com.amal.devopsaws.backend.persistence.domain.backend.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends CrudRepository<User, Long> {

    User findById(long id);


    /**
     * Returns User for given username or return null if not found
     * @param userName
     * @return User for given userName or null if not found
     */

    User findByUsername(String userName);

    /**
     * Returns User for given email or null if not found
     * @param email
     * @return User or null if not found
     */
    User findByEmail(String email);


    @Modifying
    @Query("update User u set u.password = :password where u.id = :userId")
    void updateUserPassword(@Param("userId") long userId, @Param("password") String password);

}
