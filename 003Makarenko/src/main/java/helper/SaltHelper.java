package helper;

import entity.Salt;

public class SaltHelper extends Helper<Salt> {
    @Override
    public Salt getById(int id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Salt salt = session.get(Salt.class, id);
        session.close();
        return salt;
    }

    @Override
    public void add(Salt element) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(element);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(int id, Salt element) {
        //can't change the password
    }
}
