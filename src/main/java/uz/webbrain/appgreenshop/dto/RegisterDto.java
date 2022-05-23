package uz.webbrain.appgreenshop.dto;


import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
public class RegisterDto {

    @NotNull
    @NotBlank
    @Size(min = 3, max = 15)
    private String firstname;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 15)
    private String lastname;

    @Email
    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private Set<Long> roleIds;

}
