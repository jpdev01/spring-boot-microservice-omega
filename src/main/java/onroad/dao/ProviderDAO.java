package onroad.dao;

import onroad.entity.Provider;

import java.util.List;

public interface ProviderDAO {

    public void save(Provider p);
    public Provider findById(Integer id);
    public List<Provider> findAll();
    public void remove(Integer id);
}
