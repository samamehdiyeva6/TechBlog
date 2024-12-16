package com.techblog.TechBlog.dtos.contact;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactSendDto {
    @NotNull
    @Size(min = 3, message = "Name is not valid")
    private String name;
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "Email is not valid")
    private String email;
    @NotNull
    @Pattern(regexp = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}",message = "Number is not valid")
    private String number;
    @NotNull
    @Size(min=1, message = "Subject is not valid")
    private String subject;
    @NotNull
    @Size(min=10, max=1000, message = "Message is not valid")
    private String message;
}
