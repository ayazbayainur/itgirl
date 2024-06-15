package itgirl.libraryproject.service.impl;

import itgirl.libraryproject.config.MyUserDetails;
import itgirl.libraryproject.model.MyUser;
import itgirl.libraryproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUser> user = userRepository.findByUsername(username);
        return user.map(MyUserDetails::new)
                .orElseThrow(()-> new UsernameNotFoundException(username + " not found"));
    }

    public void addUser(MyUser user) {
        userRepository.save(user);
    }
}
