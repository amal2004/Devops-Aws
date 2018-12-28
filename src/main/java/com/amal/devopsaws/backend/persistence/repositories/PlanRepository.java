package com.amal.devopsaws.backend.persistence.repositories;

import com.amal.devopsaws.backend.persistence.domain.backend.Plan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlanRepository extends CrudRepository<Plan, Integer> {

     Plan findById(int i);
}