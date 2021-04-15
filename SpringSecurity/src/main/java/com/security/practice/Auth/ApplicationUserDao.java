package com.security.practice.Auth;

import java.util.Optional;

public interface ApplicationUserDao{

    Optional<ApplicationUser> selectApplicationUserByUsername(String username);

}
