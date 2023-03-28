package DAO.Impl;

import DAO.CityDAO;
import hibernate.HibernateSession;
import model.City;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CityDAOImpl implements CityDAO {
    @Override
    public void create(City city) {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();
        }
    }

    @Override
    public City read(int id) {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            return session.get(City.class, id);
        }
    }

    @Override
    public List<City> readAll() {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            List<City> cities = session.createQuery("FROM City", City.class).getResultList();
            session.getTransaction().commit();
            return cities;
        }
    }

    @Override
    public void delete(City city) {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.delete(city);
            session.getTransaction().commit();
        }

    }
}
