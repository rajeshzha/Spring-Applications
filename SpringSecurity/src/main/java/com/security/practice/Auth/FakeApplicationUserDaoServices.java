package com.security.practice.Auth;

import com.google.common.collect.Lists;
import com.security.practice.Security.ApplicationUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("fake")
public class FakeApplicationUserDaoServices implements ApplicationUserDao {
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationUserDaoServices(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                new ApplicationUser(
                        "rajesh",
                        passwordEncoder.encode("password"),
                        ApplicationUserRole.STUDENT.getGrantedAuthority(),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        "lynda",
                        passwordEncoder.encode("password123"),
                        ApplicationUserRole.ADMIN.getGrantedAuthority(),
                        true,
                        true,
                        true,
                        true
                    ),
                new ApplicationUser(
                        "tom",
                         passwordEncoder.encode("password123"),
                        ApplicationUserRole.ADMINTRAINEE.getGrantedAuthority(),
                        true,
                        true,
                        true,
                        true
                        )
        );
                return applicationUsers;

    }

}