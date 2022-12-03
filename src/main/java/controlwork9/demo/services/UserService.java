package controlwork9.demo.services;

import controlwork9.demo.entity.User;
import controlwork9.demo.entity.enums.Role;
import controlwork9.demo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean createUser(User user){
        try {
            validEmail(user);
            user.setActive(true);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.getRoles().add(Role.ROLE_ADMIN);
            userRepository.save(user);
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }

    private void validEmail(User user) throws NoSuchElementException {
        if(userRepository.findUserByEmail(user.getEmail()) != null) throw new NoSuchElementException();
    }
}
