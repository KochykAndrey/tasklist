package by.kochyk.tasklist.service;

import by.kochyk.tasklist.web.dto.auth.JwtRequest;
import by.kochyk.tasklist.web.dto.auth.JwtResponse;

public interface AuthService {

    JwtResponse login(JwtRequest loginRequest);

    JwtResponse refresh(String refreshToken);

}
