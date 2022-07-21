package ru.market.marketApp.spring_rest2.validators;

import org.springframework.stereotype.Component;
import ru.market.marketApp.spring_rest2.dto.SignUpRequestDto;
@Component
public class UserValidator {

    public boolean validatePassword(SignUpRequestDto signUpRequestDto){
        if(signUpRequestDto.getPassword().equals(signUpRequestDto.getPasswordRepeat())){
            return true;
        }
        return false;
    }
}
