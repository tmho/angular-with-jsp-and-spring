package com.orucs.smarta.controller;

import com.orucs.smarta.db.ManagerDao;
import com.orucs.smarta.db.model.Company;
import com.orucs.smarta.db.model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ManagerController {

    @Autowired
    private ManagerDao managerDao;

    @RequestMapping(value = "/manager/create", method = RequestMethod.POST)
    public
    @ResponseBody
    List<Manager> createManager(@RequestBody Manager manager, Long companyId) {
        managerDao.create(companyId, manager);
        return getManagersForCompany(companyId);
    }

    @RequestMapping(value = "/managers/getManagersForCompany", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Manager> getManagersForCompany(@RequestParam Long companyId) {
        return managerDao.getManagersForCompany(companyId);
    }
}