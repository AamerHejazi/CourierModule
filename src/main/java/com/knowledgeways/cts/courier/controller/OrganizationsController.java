package com.knowledgeways.cts.courier.controller;

import com.knowledgeways.cts.courier.model.Organization;
import com.knowledgeways.cts.courier.model.Organizations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app/cts/organizations")
public class OrganizationsController {

    private final Organizations organizations;

    @Autowired
    public OrganizationsController(Organizations organizations) {
        this.organizations = organizations;
    }

    @GetMapping
    public List<Organization> organizations(){
        return this.organizations.list();
    }
}
