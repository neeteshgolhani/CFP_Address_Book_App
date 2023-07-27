package com.bridgelabz.addressbookapp.Repository;

import com.bridgelabz.addressbookapp.Model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepo extends JpaRepository<AddressBook,Long> {

}
