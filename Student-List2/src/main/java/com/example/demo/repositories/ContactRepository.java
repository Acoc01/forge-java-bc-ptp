package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact,Long>{

}
