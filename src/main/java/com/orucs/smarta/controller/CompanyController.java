package com.orucs.smarta.controller;

import com.orucs.smarta.db.CompanyDao;
import com.orucs.smarta.db.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CompanyController {

    @Autowired
    private CompanyDao companyDao;

    @RequestMapping(value = "/company/create", method = RequestMethod.POST)
    public void createCompany(@PathVariable Company company) {
        companyDao.insert(company);
    }

    @RequestMapping(value = "/company/getAll", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Company> getAllCompanies() {
        return companyDao.getAll();
    }


}

