package com.orucs.smarta.db;

import com.orucs.smarta.db.model.Company;

import java.util.List;

public interface CompanyDao {
    public void insert(Company company) throws Exception;
    public List<Company> getAll() throws Exception;
    public Company getCompany(Long id) throws Exception;
    public void updateCompany(Company company) throws Exception;
}
