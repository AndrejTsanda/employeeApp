package com.tsanda.employeeApp.dao;

import com.tsanda.employeeApp.exception.DatabaseException;

import java.util.List;

public interface DAO <Domain, Key> {

    public void save(final Domain domain) throws DatabaseException;
    public void delete(final Key key) throws DatabaseException;
    public void update(final Domain domain) throws DatabaseException;
    public Domain getById(final Key key) throws DatabaseException;
    public List<Domain> getAll() throws DatabaseException;
}
