package com.techblog.TechBlog.repositories;

import com.techblog.TechBlog.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact,Long> {

    @Query("select n from Contact n order by n.id")
    List<Contact> findAllByOrderByIdASC();
}
