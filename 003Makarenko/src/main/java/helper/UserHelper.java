package helper;

import entity.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserHelper extends HelperUser<User> {
    @Override
    public Set<User> getAll() {
        session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        List<User> temp = criteria.list();
        Set<User> users = new HashSet(temp);
        session.close();
        return users;
    }

    @Override
    public User getByLogin(String login) {
        session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Expression.eq("login", login));
        User user = (User) criteria.uniqueResult();
        session.close();
        return user;
    }

    @Override
    public User getById(int id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    @Override
    public void add(User element) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(element);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(int id, User element) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        User temp = session.get(User.class, id);
        if (temp != null) {
            element.setId(id);
            session.merge(element);
        }
        else
            session.save(element);
        session.getTransaction().commit();
    }
}
