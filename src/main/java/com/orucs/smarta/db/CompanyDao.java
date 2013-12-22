package com.orucs.smarta.db;

import com.orucs.smarta.db.model.Company;

import java.util.List;

public interface CompanyDao {
    public List<Company> insert(Company company);
    public List<Company> getAll();
    public Company getCompany(Long id) throws Exception;
    public List<Company> updateCompany(Company company);
    public List<Company> test() throws Exception;
}
