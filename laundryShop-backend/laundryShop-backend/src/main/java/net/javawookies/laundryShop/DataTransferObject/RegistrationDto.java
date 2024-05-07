package net.javawookies.laundryShop.DataTransferObject;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDto {
    private long userId;
    private String userName;
    private String password;
    private String email;
}
