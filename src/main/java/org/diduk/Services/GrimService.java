package org.diduk.Services;

import jakarta.persistence.Query;


import org.diduk.Models.Grim;
import org.diduk.Models.GrimCreature;
import org.diduk.database.HibernateUtil;
import org.hibernate.Session;

import java.util.List;


public class GrimService {
    public List<Grim> getAllGrims() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Grim", Grim.class).list();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Grim> getGrimWithParameters(String name, String surname, String country, String status) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            StringBuilder queryBuilder = new StringBuilder("from Grim g where 1=1 ");

            if (name != null && !name.isEmpty()) queryBuilder.append(" and g.person.name = :name");
            if (surname != null && !surname.isEmpty()) queryBuilder.append(" and g.person.surname = :surname");
            if (country != null && !country.isEmpty()) queryBuilder.append(" and g.country = :country");
            if (status != null && !status.isEmpty()) queryBuilder.append(" and g.person.status = :status");

            Query query = session.createQuery(queryBuilder.toString(), Grim.class);
            if (name != null && !name.isEmpty()) query.setParameter("name", name);
            if (surname != null && !surname.isEmpty()) query.setParameter("surname", surname);
            if (country != null && !country.isEmpty()) query.setParameter("country", country);
            if (status != null && !status.isEmpty()) query.setParameter("status", status);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public List<Grim> sortByKillsDesc() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("from Grim order by killed desc ", Grim.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Grim> sortByKillsAsc() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("from Grim order by killed asc ", Grim.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<GrimCreature> getGrimCreatureByGrimName(String grimId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("from GrimCreature gc where gc.grim.id = :grimId", GrimCreature.class);
            query.setParameter("grimId", grimId);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
