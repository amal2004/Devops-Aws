package com.amal.devopsaws.backend.persistence.repositories;

import com.amal.devopsaws.backend.persistence.domain.backend.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

    Role findById(int i);
}
