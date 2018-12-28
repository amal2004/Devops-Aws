package com.amal.devopsaws.backend.persistence.repositories;

import com.amal.devopsaws.backend.persistence.domain.backend.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findById(long id);

    User findByUsername(String userName);
}
