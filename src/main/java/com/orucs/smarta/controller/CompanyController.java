package com.orucs.smarta.controller;

import com.orucs.smarta.db.CompanyDao;
import com.orucs.smarta.db.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CompanyController {

    @Autowired
    private CompanyDao companyDao;

    @RequestMapping(value = "/companies/create", method = RequestMethod.POST)
    public
    @ResponseBody
    List<Company> createCompany(@RequestBody Company company) {
        return companyDao.insert(company);
    }

    @RequestMapping(value = "/companies/getAll", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Company> getAllCompanies() {
        return companyDao.getAll();
    }
}

