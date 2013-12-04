package com.orucs.smarta.db;

import com.orucs.smarta.db.model.Manager;

import java.util.List;

public interface ManagerDao {

    public List<Manager> getManagersForCompany(Long companyId);
    public List<Manager> create(Long companyId, Manager manager);
}
