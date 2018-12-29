package com.amal.devopsaws.test.integration;

import com.amal.devopsaws.DevopsawsApplication;
import com.amal.devopsaws.backend.persistence.domain.backend.Role;
import com.amal.devopsaws.backend.persistence.domain.backend.User;
import com.amal.devopsaws.backend.persistence.domain.backend.UserRole;
import com.amal.devopsaws.backend.service.UserService;
import com.amal.devopsaws.enums.PlansEnum;
import com.amal.devopsaws.enums.RolesEnum;
import com.amal.devopsaws.utils.UserUtils;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DevopsawsApplication.class)
public class UserServiceIntegrationTest {

    @Rule
    public TestName testName = new TestName();

    @Autowired
    private UserService userService;


    @Test
    public void testCreateNewUser() throws Exception{

        String username = testName.getMethodName();
        String email = testName.getMethodName() + "@devopsbuddy.com";


        Set<UserRole> userRoles = new HashSet<>();
        User basicUser = UserUtils.createBasicUser(username, email);
        userRoles.add(new UserRole(basicUser, new Role(RolesEnum.BASIC)));
        User user = userService.createUser(basicUser, PlansEnum.BASIC, userRoles);
        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getId());
    }


}
