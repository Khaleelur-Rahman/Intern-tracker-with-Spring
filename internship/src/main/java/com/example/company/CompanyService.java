package com.example.company;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public class CompanyService {
        private final CompanyRepository CompanyRepository;

    @Autowired
    public CompanyService(CompanyRepository CompanyRepository) {
        this.CompanyRepository = CompanyRepository;
    }

    public List<Company>  getCompanies() {
		// return new Company(1, "Khaleel", 23, LocalDate.of(2000,Month.FEBRUARY, 21)).toString();
        return CompanyRepository.findAll();
	}

    public void addNewCompany(Company Company) {
        Optional<Company> CompanyByName = CompanyRepository
                .findCompanyByName(Company.getName());
        if (CompanyByName.isPresent()) {
            throw new IllegalStateException("Name taken");
        }
        CompanyRepository.save(Company);
        System.out.println(Company);
    }

    public void removeCompany(long id) {
        boolean exists = CompanyRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Company id " + id +  " not found");
        }

        CompanyRepository.deleteById(id);
    }

    public void updateCompanyName(long id) {
        Company Company = CompanyRepository.findById(id)
                    .orElseThrow(() -> new IllegalStateException("Company id " + id + " not found"));
        
        // Company.setName();

        CompanyRepository.save(Company);
    }
}
