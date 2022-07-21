package ru.market.marketApp.spring_rest2.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.market.marketApp.spring_rest2.exceptions.ResourceNotFoundException;
import ru.market.marketApp.spring_rest2.exceptions.UserAlreadyExistsException;
import ru.market.marketApp.spring_rest2.model.Role;
import ru.market.marketApp.spring_rest2.model.User;
import ru.market.marketApp.spring_rest2.repositories.RoleRepository;
import ru.market.marketApp.spring_rest2.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;


    public Optional<User> findByUsername(String username){
       return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username).orElseThrow(()->
                new ResourceNotFoundException(String.format("User '%s' not found", username)));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                getAuthorities(user.getRoles()));
    }


    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    public User save(User user) {

        Role role = roleRepository.findByName("ROLE_USER");
        user.setRoles(List.of(role));
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);

    }

    public void isUsernameOrEmailUsedAllReady(String username, String email){
        if(userRepository.existsByUsername(username) || userRepository.existsByEmail(email)){
            throw new UserAlreadyExistsException();

        }
    }






}
