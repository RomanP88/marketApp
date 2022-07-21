package ru.market.marketApp.spring_rest2.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class SignUpRequestDto {

    @NotNull(message = "Юзернэйм должен иметь имя")
    @Length(min = 3, max = 255, message = "Длина юзернэйма должна состовлять от 3 до 255 символов")
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String passwordRepeat;
    @NotNull
    private String email;

    public SignUpRequestDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

}
