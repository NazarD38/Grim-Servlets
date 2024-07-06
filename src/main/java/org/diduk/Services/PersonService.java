package org.diduk.Services;

import jakarta.persistence.Query;
import org.diduk.Models.Person;
import org.diduk.database.HibernateUtil;
import org.hibernate.Session;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class PersonService {

    public List<Person> getAllPersons() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Person  ", Person.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Person> getPersonsWithParameters(String name, String surname, String status) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            StringBuilder queryBuilder = new StringBuilder("from Person p where 1=1 ");
            if (name != null && !name.isEmpty()) queryBuilder.append("and p.name=:name ");
            if (surname != null && !surname.isEmpty()) queryBuilder.append("and p.surname=:surname ");
            if (status != null && !status.isEmpty()) queryBuilder.append("and p.status=:status");
            Query query = session.createQuery(queryBuilder.toString(), Person.class);
            if (name != null && !name.isEmpty()) query.setParameter("name", name);
            if (surname != null && !surname.isEmpty()) query.setParameter("surname", surname);
            if (status != null && !status.isEmpty()) query.setParameter("status", status);

            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
