package uz.ages.appclickup.payload;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RegisterDto {

    @NotNull
    private String fullName;

    @NotNull
    private String email;

    @NotNull
    private String password;
}
