package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.entity.UserEntity;
import bg.softuni.mobilelele.model.service.UserLoginServiceModel;
import bg.softuni.mobilelele.repository.UserRepository;
import bg.softuni.mobilelele.service.UserService;
import bg.softuni.mobilelele.user.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, CurrentUser currentUser) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public boolean login(UserLoginServiceModel loginServiceModel) {

        Optional<UserEntity> userEntityOptional = userRepository.findByUsername(loginServiceModel.getUsername());

        if (userEntityOptional.isEmpty()) {
            logout();
            return false;
        } else {
            boolean success = passwordEncoder.matches(loginServiceModel.getRawPassword(), userEntityOptional.get().getPassword());

            if (success) {
                UserEntity loggedInUser = userEntityOptional.get();
                currentUser.
                        setLoggedIn(true).
                        setUserName(loggedInUser.getUsername()).
                        setFirstName(loggedInUser.getFirstName()).
                        setLastName(loggedInUser.getLastName());
            }

            return success;
        }
    }

    @Override
    public void logout() {
        currentUser.clean();
    }
}
