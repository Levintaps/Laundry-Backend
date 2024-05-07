package net.javawookies.laundryShop.mapper;

import net.javawookies.laundryShop.DataTransferObject.RegistrationDto;
import net.javawookies.laundryShop.entity.RegisterUser;

public class RegistrationMapper {
    public static RegistrationDto mapToRegistrationDto(RegisterUser registerUser){
        return new RegistrationDto(
                registerUser.getUserId(),
                registerUser.getUserName(),
                registerUser.getPassword(),
                registerUser.getEmail()
        );

    }

    public static RegisterUser mapToRegisterUser(RegistrationDto registrationDto){
        return new RegisterUser(
                registrationDto.getUserId(),
                registrationDto.getUserName(),
                registrationDto.getPassword(),
                registrationDto.getEmail()
        );
    }
}
