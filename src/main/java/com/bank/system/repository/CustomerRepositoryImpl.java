package com.bank.system.repository;

import com.bank.system.entity.Customer;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CustomerRepositoryImpl extends AbstractRepository<Integer, Customer> implements CustomerRepository {

    @Override
    public List<Customer> getListCustomers() {
        return getList();
    }

    @Override

    public Customer getCustomer(int id) {
        return getSession().get(Customer.class,id);
    }

    @Override
    public void createCustomer(Customer customer) {
        save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        getSession().update(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        delete(customer);
    }

}
