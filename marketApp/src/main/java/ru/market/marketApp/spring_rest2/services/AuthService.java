package ru.market.marketApp.spring_rest2.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.market.marketApp.spring_rest2.converters.UserConverter;
import ru.market.marketApp.spring_rest2.dto.AuthResponse;
import ru.market.marketApp.spring_rest2.dto.SignUpRequestDto;
import ru.market.marketApp.spring_rest2.model.User;
import ru.market.marketApp.spring_rest2.utils.JwtTokenUtil;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserConverter userConverter;


    @Transactional
    public AuthResponse signUp(SignUpRequestDto signUpRequestDto){
        String hashedPassword = passwordEncoder.encode(signUpRequestDto.getPassword());
        SignUpRequestDto registeredUserDtoWithHashedPassword = new SignUpRequestDto(signUpRequestDto.getUsername(),
                hashedPassword, signUpRequestDto.getEmail());
        User user = userService.save(userConverter.dtoToEntity(registeredUserDtoWithHashedPassword));
        UserDetails userDetails = userService.loadUserByUsername(user.getUsername());
        String token = jwtTokenUtil.generateToken(userDetails);
        return new AuthResponse(token);
    }




}
