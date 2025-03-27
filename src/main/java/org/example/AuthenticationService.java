package org.example;
import java.util.List;

public class AuthenticationService {
    private final UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean register(User user)
    {
        List<User> users = userRepository.findUser(user.getEmail());
        if (!users.isEmpty()) {
            System.out.println("An user with this email already exists!");
            return false;
        } else {
            userRepository.addUser(user);
            System.out.println("Registration successful!");
            return true;
        }
    }

    public boolean login(String email,String password)
    {
        List<User> users = userRepository.findUser(email);

        if (!users.isEmpty())
        {
            User user = users.get(0);
            if(!password.equals(user.getPassword()))
            {
                System.out.println("Incorrect password!");
                return false;
            }
            else
            {
                System.out.println("Welcome " + user.getUserName());
                return true;
            }

        }
        System.out.println("Incorrect email!");
        return false;

    }
}
