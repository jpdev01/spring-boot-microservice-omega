package onroad.dao;

import onroad.entity.Address;

import java.util.Set;

public interface AddressDAO {

    public void save(Address address);
    public void remove(Integer id);
    public Address getById(Integer id);
    public Set<Address> getAll();

}
