package net.javawookies.laundryShop.controller;

import lombok.AllArgsConstructor;
import net.javawookies.laundryShop.DataTransferObject.RegisteredDTO;
import net.javawookies.laundryShop.DataTransferObject.RegistrationDto;
import net.javawookies.laundryShop.entity.RegisterUser;
import net.javawookies.laundryShop.service.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class RegistrationController {

    private RegistrationService registrationService;

    // Create Registration
    @PostMapping("/register")
    public ResponseEntity<RegistrationDto> createRegisterUser(@RequestBody RegistrationDto registrationDto){
        RegistrationDto savedRegisterUser = registrationService.createRegisterUser(registrationDto);
        return new ResponseEntity<RegistrationDto>(savedRegisterUser, HttpStatus.CREATED);
    }

    @GetMapping("/registered/{id}")
    public ResponseEntity<RegistrationDto> getRegisterUserById(@PathVariable("id") Long registerUserId){
        RegistrationDto registrationDto = registrationService.getRegisterUserById(registerUserId);
        return ResponseEntity.ok(registrationDto);
    }

    @GetMapping("/allRegistered")
    public ResponseEntity<List<RegisteredDTO>> getAllRegisterUsers(){
        List<RegisteredDTO> registeredDTO = registrationService.getAllRegisterUsers();
        return ResponseEntity.ok(registeredDTO);
    }

    @PutMapping("/register/update/{id}")
    public ResponseEntity<String> updateRegisterUser(@PathVariable("id") Long registerUserId,
                                                              @RequestBody RegistrationDto updatedRegisterUser){
        registrationService.updateRegisterUser(registerUserId, updatedRegisterUser);
        return ResponseEntity.ok("Successfully Updated Credentials");
    }

    @DeleteMapping("/register/delete/{id}")
    public ResponseEntity<String> deleteRegisterUser(@PathVariable("id") Long registerUserId){
        registrationService.deleteRegisterUser(registerUserId);
        return ResponseEntity.ok("Deleted Successfully");
    }

}
