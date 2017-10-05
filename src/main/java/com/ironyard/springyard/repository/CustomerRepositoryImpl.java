package com.ironyard.springyard.repository;

import com.ironyard.springyard.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_SQL = "INSERT INTO customer (firstName, lastName, phone, email) VALUES (?,?,?,?)";
    private final String UPDATE_SQL = "UPDATE customer SET firstName=?, lastName=?, phone=?, email=? WHERE id=?";
    private final String SELECT_BY_ID_SQL = "select * from customer where id = ?";
    private final String SELECT_SQL = "select * from customer";
    private final String DELETE_SQL = "delete from customer where id=?";

    @Override
    public void add(Customer customer) {
        jdbcTemplate.update(INSERT_SQL, customer.getFirstName(), customer.getLastName(), customer.getPhone(), customer.getEmail());
    }

    @Override
    public void update(Customer customer) {
        jdbcTemplate.update(UPDATE_SQL, customer.getFirstName(), customer.getLastName(), customer.getPhone(), customer.getEmail(), customer.getId());
    }

    @Override
    public Customer getById(int id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID_SQL, new CustomerMapper(), id);
    }

    @Override
    public List<Customer> get() {
        return jdbcTemplate.query(SELECT_SQL, new CustomerMapper());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE_SQL, id);
    }

    private static class CustomerMapper implements RowMapper<Customer> {
        @Override
        public Customer mapRow(ResultSet resSet, int rowNum) throws SQLException {
            Customer customer = new Customer();
            customer.setId(resSet.getInt("id"));
            customer.setFirstName(resSet.getString("firstName"));
            customer.setLastName(resSet.getString("lastName"));
            customer.setPhone(resSet.getString("phone"));
            customer.setEmail(resSet.getString("email"));
            return customer;
        }

    }
}
