package com.orucs.smarta.controller;

import com.orucs.smarta.db.CompanyDao;
import com.orucs.smarta.db.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/api/companies")
public class CompanyController extends BaseController {

    @Autowired
    private CompanyDao companyDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public
    @ResponseBody
    Response<List<Company>> getAllCompanies() throws Exception {
        return new Response<List<Company>>(companyDao.getAll());
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public
    @ResponseBody
    Response<List<Company>> insertCompany(@RequestBody Company company) throws Exception {
        return new Response<List<Company>>(companyDao.insert(company));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Response<Company> getCompany(@PathVariable("id") Long id) throws Exception {
        return new Response<Company>(companyDao.getCompany(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public
    @ResponseBody
    Response<List<Company>> updateCompany(@RequestBody Company company) throws Exception {
        return new Response<List<Company>>(companyDao.updateCompany(company));
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public
    @ResponseBody
    Response<List<Company>> test() throws Exception {
        return new Response<List<Company>>(companyDao.test());
    }
}