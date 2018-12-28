package com.amal.devopsaws.test.integration;


import com.amal.devopsaws.DevopsawsApplication;
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
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.HashSet;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DevopsawsApplication.class)
public class RepositoriesIntegrationTest {

   // private static final int BASIC_PLAN_ID = 1;


    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void init() {
        Assert.assertNotNull(planRepository);
        Assert.assertNotNull(roleRepository);
        Assert.assertNotNull(userRepository);
    }


    @Test
    public void testCreateNewPlan() throws Exception {
        Plan basicPlan = createPlan(PlansEnum.BASIC);
        planRepository.save(basicPlan);
        Plan retrievedPlan = planRepository.findById(PlansEnum.BASIC.getId());
        Assert.assertNotNull(retrievedPlan);
    }

    @Test
    public void testCreatenewRole()  throws Exception {
        Role userRole = createRole(RolesEnum.BASIC);
        roleRepository.save(userRole);
        Role retrievedRole = roleRepository.findById(RolesEnum.BASIC.getId());
        Assert.assertNotNull(retrievedRole);


    }

    @Test
    public void testDeleteUser() throws Exception {
        User basicUser = createUser();
        userRepository.delete(basicUser.getId());
    }

    @Test
    public void createNewUser() throws Exception{

        User basicUser = createUser();

        User newlyCreatedUser = userRepository.findById(RolesEnum.BASIC.getId());

        Assert.assertNotNull(newlyCreatedUser);
        Assert.assertTrue(newlyCreatedUser.getId() != 0);
        Assert.assertNotNull(newlyCreatedUser.getPlan());
        Assert.assertNotNull(newlyCreatedUser.getPlan().getId());
        Set<UserRole> newlyCreatedUserUserRoles = newlyCreatedUser.getUserRoles();
        for (UserRole ur : newlyCreatedUserUserRoles) {
            Assert.assertNotNull(ur.getRole());
            Assert.assertNotNull(ur.getRole().getId());
        }
    }

    private Role createRole(RolesEnum rolesEnum) {
        return new Role(rolesEnum);
    }

    private Plan createPlan(PlansEnum plansEnum) {
       return new Plan(plansEnum);
    }

    private User createUser() {
        Plan basicPlan = createPlan(PlansEnum.BASIC);
        planRepository.save(basicPlan);

        User basicUser = UserUtils.createBasicUser();
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

}
