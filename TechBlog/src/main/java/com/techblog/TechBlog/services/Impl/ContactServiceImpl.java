package com.techblog.TechBlog.services.Impl;

import com.techblog.TechBlog.dtos.contact.ContactDashboardDto;
import com.techblog.TechBlog.dtos.contact.ContactSendDto;
import com.techblog.TechBlog.model.Contact;
import com.techblog.TechBlog.repositories.ContactRepository;
import com.techblog.TechBlog.services.ContactService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final ModelMapper modelMapper;

    @Override
    public void sendEmail(ContactSendDto contactSendDto) {
        Contact contact = new Contact();
        contact.setName(contactSendDto.getName());
        contact.setEmail(contactSendDto.getEmail());
        contact.setNumber(contactSendDto.getName());
        contact.setSubject(contactSendDto.getSubject());
        contact.setMessage(contactSendDto.getMessage());
        contactRepository.save(contact);
    }

    @Override
    public List<ContactDashboardDto> getAllContacts() {
        List<Contact> contacts = contactRepository.findAllByOrderByIdASC();
        return contacts.stream().map(a ->modelMapper.map(a, ContactDashboardDto.class)).toList();
    }
}
