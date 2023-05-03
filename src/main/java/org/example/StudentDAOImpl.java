package org.example;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public void save(Student student) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateSession.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void update(Student student) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateSession.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(int id) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateSession.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Student student = session.get(Student.class, id);
            if (student != null) {
                session.delete(student);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Student findById(int id) {
        Session session = null;
        try {
            session = HibernateSession.getSessionFactory().openSession();
            return session.get(Student.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Student> findAll() {
        Session session = null;
        try {
            session = HibernateSession.getSessionFactory().openSession();
            return session.createQuery("from Student", Student.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}