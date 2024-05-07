package net.javawookies.laundryShop.mapper;

import net.javawookies.laundryShop.DataTransferObject.RegisteredDTO;
import net.javawookies.laundryShop.entity.RegisterUser;

public class RegisteredMAPPER {
    public static RegisteredDTO mapToRegisteredDTO(RegisterUser registerUser){
        return new RegisteredDTO(
                registerUser.getUserId(),
                registerUser.getUserName(),
                registerUser.getEmail()
        );
    }
}
