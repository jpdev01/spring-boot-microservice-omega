package onroad.dao;

import onroad.entity.Reservation;

import java.util.Set;

public interface ReservationDAO {

    public void save(Reservation reservation);
    public void remove(Integer id);
    public Reservation getById(Integer id);
    public Set<Reservation> getAll();

}
