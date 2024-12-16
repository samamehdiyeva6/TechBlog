package com.techblog.TechBlog.controllers.dashboard;

import com.techblog.TechBlog.dtos.contact.ContactDashboardDto;
import com.techblog.TechBlog.services.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ContactsController {

    private final ContactService contactService;

    @GetMapping("/admin/contact")
    public String contact(Model model){
        List<ContactDashboardDto> contacts = contactService.getAllContacts();
        model.addAttribute("contacts",contacts);
        return "/dashboard/contact/contact.html";
    }
}
