package tz.ac.udsm.chatBot.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {

    private String street;
    private String postalBox;

    private UserDto user;
}
