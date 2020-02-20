package com.kodilla.hibernate.manytomany.facade.api;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Facade {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    public List<Company> retrieveCompanyLike(String nameFragment) {
        return companyDao.retrieveCompanyLike(nameFragment);
    }

    public List<Employee> retrieveEmployeeLike(String nameFragment){
        return employeeDao.retrieveEmployeeLike(nameFragment);
    }

}
