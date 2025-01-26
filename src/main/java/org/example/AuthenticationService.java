package org.example;
import java.util.List;

public class AuthenticationService {
    private final UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean register(String userId, String name, int age,
                            String gender, String email, String password)
    {
        List<User> users = userRepository.findUser(email);
        if (!users.isEmpty()) {
            System.out.println("An user with this email already exists!");
            return false;
        } else {
            User user = new User(userId,name,age,gender,email,password);
            userRepository.addUser(user);
            System.out.println("Registration successful!");
            return true;
        }
    }

    public boolean login(String email,String password)
    {
        return true;
    }
}
