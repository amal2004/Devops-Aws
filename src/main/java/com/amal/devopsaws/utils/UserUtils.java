package com.amal.devopsaws.utils;

import com.amal.devopsaws.backend.persistence.domain.backend.User;
import com.amal.devopsaws.web.controllers.ForgotMyPasswordController;

import javax.servlet.http.HttpServletRequest;

public class UserUtils {

    private UserUtils(){
        throw new AssertionError("Non instantiable");
    }


    /**
     * Creates a user with basic attributes set.
     * @return A User entity
     */
    public static User createBasicUser(String username, String email) {

        User user = new User();
        user.setUsername(username);
        user.setPassword("password");
        user.setEmail(email);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setPhoneNumber("123456789123");
        user.setCountry("GB");
        user.setEnabled(true);
        user.setDescription("A basic user");
        user.setProfileImageUrl("https://blabla.images.com/basicuser");

        return user;
    }

    /**
     * Builds and returns the URL to reset the user password.
     * @param request The Http Servlet Request
     * @param userId The user id
     * @param token The token
     * @return the URL to reset the user password.
     */
    public static String createPasswordResetUrl(HttpServletRequest request, long userId, String token) {
        String passwordResetUrl =
                request.getScheme() +
                        "://" +
                        request.getServerName() +
                        ":" +
                        request.getServerPort() +
                        request.getContextPath() +
                        ForgotMyPasswordController.CHANGE_PASSWORD_PATH +
                        "?id=" +
                        userId +
                        "&token=" +
                        token;

        return passwordResetUrl;
    }
}
