package com.bridgelabz.addressbookapp.Model;

import com.bridgelabz.addressbookapp.DTO.AddressBookDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
/**Third Section
 UC1.................................
 * Use Lombok Library to auto
 * generate getters and setters for
 * the DTO - For Eclipse and
 */
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Address_Book")
public @Data class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "full_name")

    private String name;
    private String email;
    private String phoneNumber;
    private String state;
    private String city;
    private String pin;
    @ElementCollection
    @CollectionTable(name = "address", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "permanent_address")
    private List<String> address;


    public AddressBook(AddressBookDto addressBookDto) {

        this.updateContact(addressBookDto);
    }

    public void updateContact(AddressBookDto addressBookDto) {
        this.name = addressBookDto.name;
        this.email = addressBookDto.email;
        this.phoneNumber = addressBookDto.phoneNumber;
        this.address = addressBookDto.address;
        this.state = addressBookDto.state;
        this.city = addressBookDto.city;
        this.pin = addressBookDto.pin;
    }

}
