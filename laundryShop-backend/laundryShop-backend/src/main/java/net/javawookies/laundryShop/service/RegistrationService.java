package net.javawookies.laundryShop.service;

import net.javawookies.laundryShop.DataTransferObject.RegisteredDTO;
import net.javawookies.laundryShop.DataTransferObject.RegistrationDto;

import java.util.List;

public interface RegistrationService {
    RegistrationDto createRegisterUser(RegistrationDto registrationDto);

    RegistrationDto getRegisterUserById(Long registerUserId);

    List<RegisteredDTO> getAllRegisterUsers();

    RegistrationDto updateRegisterUser(Long registerUserId, RegistrationDto updatedRegisterUser);

    void deleteRegisterUser(Long registerUserId);

    RegisteredDTO getRegisteredUserById(Long registerUserId);
}
