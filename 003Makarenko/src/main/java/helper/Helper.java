package helper;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class Helper<E> {
    protected SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    protected Session session;

    public abstract E getById(int id);

    public abstract void add(E element);

    public abstract void update(int id, E element);

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
