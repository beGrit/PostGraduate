package org.yan.security.service.impl;

import org.springframework.stereotype.Service;
import org.yan.security.service.UserAuthenticationService;

@Service
public class UserAuthenticationServiceImpl implements UserAuthenticationService {
    public boolean authentication(String username, String password) {
        if (username.equals("pocky")) {
            if (password.equals("LSFlsf123")) {
                return true;
            }
        }
        return false;
    }
}
