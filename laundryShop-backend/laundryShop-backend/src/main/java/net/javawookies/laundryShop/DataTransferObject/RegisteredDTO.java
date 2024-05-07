package net.javawookies.laundryShop.DataTransferObject;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisteredDTO {
    private long id;
    private String userName;
    private String email;
}
