package tn.esprit.Microservice_User.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegistrationRequest {

    @NotBlank(message = "Firstname cannot be empty")
    private String firstname;

    @NotBlank(message = "Lastname cannot be empty")
    private String lastname;

    @Email(message = "This format is not accepted")
    @NotBlank(message = "Email cannot be empty")
    private String email;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 8, message = "Password should be more than 8 characters")
    private String password;

    private String role;


}