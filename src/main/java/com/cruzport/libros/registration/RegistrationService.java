package com.cruzport.libros.registration;

import com.cruzport.libros.appuser.AppUser;
import com.cruzport.libros.appuser.AppUserRole;
import com.cruzport.libros.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if(!isValidEmail){
            throw new IllegalStateException("Email Not Valid");
        }
        return appUserService.signUpUser(new AppUser(request.getFirstName(), request.getLastName(), request.getEmail(),request.getPassword(), AppUserRole.USER));
    }
}
