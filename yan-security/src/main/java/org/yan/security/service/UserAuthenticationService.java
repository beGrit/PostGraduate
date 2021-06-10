package org.yan.security.service;

public interface UserAuthenticationService {
    boolean authentication(String username, String password);
}
