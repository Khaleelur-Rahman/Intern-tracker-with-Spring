package com.example.company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/Company")
public class CompanyController {

    private final CompanyService SERVICE;

    @Autowired
    public CompanyController(CompanyService service) {
        this.SERVICE = service;
    }
    
    @GetMapping
	public List<Company> displaySampleCompany() {
		return SERVICE.getCompanies();
	}

    @PostMapping
    public void registerNewCompany(@RequestBody Company Company) {
        SERVICE.addNewCompany(Company);
    }

    @DeleteMapping(path = "{CompanyId}")
    public void deleteCompany(@PathVariable("CompanyId") long id) {
        SERVICE.removeCompany(id);
    }

    @PutMapping(path = "{CompanyId}")
    public void updateCompanyDOB(@PathVariable("CompanyId") long id) {
        SERVICE.updateCompanyName(id);
    }
}

