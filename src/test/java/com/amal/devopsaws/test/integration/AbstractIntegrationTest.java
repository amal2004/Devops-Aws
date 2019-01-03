package com.amal.devopsaws.test.integration;

import com.amal.devopsaws.backend.persistence.domain.backend.Plan;
import com.amal.devopsaws.backend.persistence.domain.backend.Role;
import com.amal.devopsaws.backend.persistence.domain.backend.User;
import com.amal.devopsaws.backend.persistence.domain.backend.UserRole;
import com.amal.devopsaws.backend.persistence.repositories.PlanRepository;
import com.amal.devopsaws.backend.persistence.repositories.RoleRepository;
import com.amal.devopsaws.backend.persistence.repositories.UserRepository;
import com.amal.devopsaws.enums.PlansEnum;
import com.amal.devopsaws.enums.RolesEnum;
import com.amal.devopsaws.utils.UserUtils;
import org.junit.rules.TestName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractIntegrationTest  {

    @Autowired
    protected PlanRepository planRepository;

    @Autowired
    protected RoleRepository roleRepository;

    @Autowired
    protected UserRepository userRepository;


    protected Role createRole(RolesEnum rolesEnum) {
        return new Role(rolesEnum);
    }

    protected Plan createPlan(PlansEnum plansEnum) {
        return new Plan(plansEnum);
    }

    protected User createUser(String username, String email) {
        Plan basicPlan = createPlan(PlansEnum.BASIC);
        planRepository.save(basicPlan);

        User basicUser = UserUtils.createBasicUser(username, email);
        basicUser.setPlan(basicPlan);

        Role basicRole = createRole(RolesEnum.BASIC);
        roleRepository.save(basicRole);

        Set<UserRole> userRoles = new HashSet<>();
        UserRole userRole = new UserRole(basicUser, basicRole);
        userRoles.add(userRole);

        basicUser.getUserRoles().addAll(userRoles);
        basicUser = userRepository.save(basicUser);
        return basicUser;
    }


    protected User createUser(TestName testName) {
        return createUser(testName.getMethodName(), testName.getMethodName() + "@devopsbuddy.com");
    }

}
