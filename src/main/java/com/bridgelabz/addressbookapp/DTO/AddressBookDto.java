package com.bridgelabz.addressbookapp.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**UC1................
 * Introducing DTO and Model to
        AddressBook App
 **/
/**Section 4
 *UC1--------------------
Add Validation to Name Field so
        the REST call can be validated
*/
@Validated
public class AddressBookDto {
    @NotBlank(message = "Full name is required")
    public String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    public String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\d{3}-\\d{3}-\\d{4}$", message = "Invalid phone number format. Use ###-###-####")

    public String phoneNumber;

    public String city;

    @NotNull(message = "Address list is required")

    public List<String> address;

    public String pin;
    public String state;
}