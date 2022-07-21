package ru.market.marketApp.spring_rest2.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.market.marketApp.spring_rest2.dto.SignUpRequestDto;
import ru.market.marketApp.spring_rest2.model.User;

@Component
@RequiredArgsConstructor
public class UserConverter {


        public User dtoToEntity(SignUpRequestDto signUpRequestDto) {
            return new User(signUpRequestDto.getUsername(), signUpRequestDto.getPassword(), signUpRequestDto.getEmail());
        }

        public SignUpRequestDto entityToDto(User user) {
            return new SignUpRequestDto(user.getUsername(), user.getPassword(), user.getEmail());
        }

}
