package ch.zmotions.linkit.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
