package com.techblog.TechBlog.dtos.user;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignInDto {
    @NotNull
    @NotEmpty
    @Size(min=2, message = "Name has to be min 2 symbols")
    private String name;
    @NotNull
    @NotEmpty
    @Size(min=3, message = "Surname has to be min 3 symbols")
    private String surname;
    @NotNull
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "Email is not valid")
    private String email;
    @NotNull
    @NotEmpty
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$",message = "Password is not secure")
    private String password;
}
