package net.javawookies.laundryShop.DataTransferObject;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {
    private long id;
    private String firstName;
    private String lastName;
    private String address;
    private long kgs;
    private long contactNumber;
    private String mode;
    private String status;
}
