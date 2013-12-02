package com.orucs.smarta.db;

import com.orucs.smarta.db.model.Company;

import java.util.List;

public interface CompanyDao {
    public void insert(Company company);
    public List<Company> getAll();
}
