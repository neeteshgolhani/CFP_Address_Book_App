package com.bridgelabz.addressbookapp.Controller;

import com.bridgelabz.addressbookapp.DTO.AddressBookDto;
import com.bridgelabz.addressbookapp.DTO.ResponseDto;
import com.bridgelabz.addressbookapp.Model.AddressBook;
import com.bridgelabz.addressbookapp.Service.AddressBookService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**UC1 First section----------------
 Create a Rest Controller to demonstrate
 the various HTTP Methods
 * */
@Slf4j
@RestController
public class AddressBookController {
    @Autowired
    private AddressBookService addressBookService;

    // Method to add a contact
    @PostMapping("/add")
    public ResponseEntity<ResponseDto> addContact(@Valid @RequestBody AddressBookDto addressBookDto) {
        log.info("Employee Data is adding");
        ResponseDto responseDto = new ResponseDto("Contact data added successfully", addressBookService.addContact(addressBookDto));
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
    // Method to get all contacts

    @GetMapping("/getAll")
    public ResponseEntity<List<AddressBook>> findAllContact() {
        List<AddressBook> addressBooks = addressBookService.findAllContact();
        return new ResponseEntity<>(addressBooks, HttpStatus.OK);
    }
    // Method to get a contact by ID

    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseDto> getContactById(@PathVariable long id) {
        ResponseDto responseDto = new ResponseDto("Contact Data Fetched Successfully", addressBookService.getContactById(id));
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
    // Method to update a contact by ID

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDto> updateContact(@PathVariable("id") long id, @Valid @RequestBody AddressBookDto addressBookDto) {
        ResponseDto responseDto = new ResponseDto("Contact Data updated", addressBookService.updateContact(id, addressBookDto));
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
    // Method to delete a contact by ID

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> deleteEmployee(@PathVariable long id) {
        boolean deleted = addressBookService.deleteContact(id);
        if (deleted) {
            ResponseDto responseDto = new ResponseDto("Contact Data Deleted Successfully", id);
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        } else {
            ResponseDto responseDto = new ResponseDto("Contact Data Not Found", id);
            return new ResponseEntity<>(responseDto, HttpStatus.NOT_FOUND);
        }
    }
}
