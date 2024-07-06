package org.diduk.Services;

import jakarta.persistence.Query;
import org.diduk.Models.Creature;
import org.diduk.database.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class CreatureService {

    public List<Creature> getAllCreatures() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Creature ", Creature.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


    public List<Creature> getCreaturesWithParameters(String name, String surname, String country, String status, String type, String dangerLevel) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            StringBuilder queryString = new StringBuilder("from Creature cr where 1=1");
            if (name != null && !name.isEmpty()) queryString.append(" and cr.person.name = :name");
            if (surname != null && !surname.isEmpty()) queryString.append(" and cr.person.surname = :surname");
            if (country != null && !country.isEmpty()) queryString.append(" and cr.country = :country");
            if (status != null && !status.isEmpty()) queryString.append(" and cr.person.status = :status");
            if (type != null && !type.isEmpty()) queryString.append(" and cr.type = :type");
            if (dangerLevel != null && !dangerLevel.isEmpty()) queryString.append(" and cr.dangerLevel.id = :dangerLevel");

            Query query = session.createQuery(queryString.toString(), Creature.class);
            if (name != null && !name.isEmpty()) query.setParameter("name", name);
            if (surname != null && !surname.isEmpty()) query.setParameter("surname", surname);
            if (country != null && !country.isEmpty()) query.setParameter("country", country);
            if (status != null && !status.isEmpty()) query.setParameter("status", status);
            if (type != null && !type.isEmpty()) query.setParameter("type", type);
            if (dangerLevel != null && !dangerLevel.isEmpty()) query.setParameter("dangerLevel", Integer.parseInt(dangerLevel));

            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
