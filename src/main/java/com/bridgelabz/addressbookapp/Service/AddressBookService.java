package com.bridgelabz.addressbookapp.Service;

import com.bridgelabz.addressbookapp.DTO.AddressBookDto;
import com.bridgelabz.addressbookapp.Exception.CustomException;
import com.bridgelabz.addressbookapp.Model.AddressBook;
import com.bridgelabz.addressbookapp.Repository.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**UC2 Second Section..................
 *
Introducing Services Layer in
        AddressBook App - Note that Controller in UC1 was
 **/

/**UC3...................
*Ability for the Services Layer to
 * store the AddressBook Data - Note that Services Layer is not storing, updating
 */
@Service
public class AddressBookService {
    @Autowired
    private ContactRepo contactRepo;
    // Method to add a new contact to the address book

    public AddressBook addContact(AddressBookDto addressBookDto) {
        AddressBook contactData = new AddressBook(addressBookDto);
        return contactRepo.save(contactData);
    }
    // Method to get a contact by ID

    public AddressBook getContactById(long id) {
        return contactRepo.findById(id).orElseThrow(() -> new CustomException("Contact with ID: " + id + " not found"));
    }
    // Method to update a contact by ID


    public AddressBook updateContact(Long id, AddressBookDto addressBookDto) {
        AddressBook contactData =getContactById(id);
        if (contactData != null) {
            contactData.updateContact(addressBookDto);
            return contactRepo.save(contactData);
        }
        return null;
    }
    // Method to get all contacts in the address book

    public List<AddressBook> findAllContact() {
        return contactRepo.findAll();
    }
    // Method to delete a contact by ID

    public boolean deleteContact(long id) {
        // Check if the Contact exists
        if (contactRepo.existsById(id)) {
            contactRepo.deleteById(id);
            return true; // Deletion successful
        }
        return false; // Contact not found
    }
}

