package net.javawookies.laundryShop.service.Implement;

import lombok.AllArgsConstructor;
import net.javawookies.laundryShop.DataTransferObject.RegisteredDTO;
import net.javawookies.laundryShop.DataTransferObject.RegistrationDto;
import net.javawookies.laundryShop.entity.RegisterUser;
import net.javawookies.laundryShop.exception.ResourceNotFoundException;
import net.javawookies.laundryShop.mapper.RegisteredMAPPER;
import net.javawookies.laundryShop.mapper.RegistrationMapper;
import net.javawookies.laundryShop.mapper.TransactionMapper;
import net.javawookies.laundryShop.repository.RegistrationRepository;
import net.javawookies.laundryShop.service.RegistrationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RegistrationServiceImpl implements RegistrationService{

    private RegistrationRepository registrationRepository;

    @Override
    public RegistrationDto createRegisterUser(RegistrationDto registrationDto){
        RegisterUser registerUser = RegistrationMapper.mapToRegisterUser(registrationDto);
        RegisterUser savedRegisterUser = registrationRepository.save(registerUser);
        return RegistrationMapper.mapToRegistrationDto(savedRegisterUser);
    }

    @Override
    public RegistrationDto getRegisterUserById(Long registerUserId) {
        RegisterUser registerUser = registrationRepository.findById(registerUserId).orElse(null);
        if (registerUser == null) {
            throw new ResourceNotFoundException("Register with ID" + registerUserId + "not found!");
        }
        return RegistrationMapper.mapToRegistrationDto(registerUser);
    }

    @Override
    public List<RegisteredDTO> getAllRegisterUsers() {
        List<RegisterUser> registerUsers = registrationRepository.findAll();
        return registerUsers.stream().map(RegisteredMAPPER::mapToRegisteredDTO).collect(Collectors.toList());
    }

    @Override
    public RegistrationDto updateRegisterUser(Long registerUserId, RegistrationDto updatedRegisterUser) {
        RegisterUser registerUser = registrationRepository.findById(registerUserId).orElseThrow(() ->
                new ResourceNotFoundException("Registered User not found with given id: " + registerUserId));

        registerUser.setUserName(updatedRegisterUser.getUserName());
        registerUser.setPassword(updatedRegisterUser.getPassword());
        registerUser.setEmail(updatedRegisterUser.getEmail());

        RegisterUser updatedRegisterUserObj = registrationRepository.save(registerUser);
        return RegistrationMapper.mapToRegistrationDto(registerUser);
    }

    @Override
    public void deleteRegisterUser(Long registerUserId) {
        RegisterUser registerUser = registrationRepository.findById(registerUserId).orElseThrow(() ->
                new ResourceNotFoundException("Registered User not found with given id" + registerUserId));
        registrationRepository.deleteById(registerUserId);

    }

    @Override
    public RegisteredDTO getRegisteredUserById(Long registerUserId) {
        RegisterUser registerUser =registrationRepository.findById(registerUserId).orElse(null);
        if (registerUser == null) {
            throw new ResourceNotFoundException("Registered Id not found");
        }
        return RegisteredMAPPER.mapToRegisteredDTO(registerUser);
    }
}

