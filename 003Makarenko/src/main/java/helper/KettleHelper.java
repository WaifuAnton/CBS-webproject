package helper;

import entity.Kettle;
import org.hibernate.Criteria;

import java.util.List;

public class KettleHelper extends HelperItem<Kettle> {
    @Override
    public List<Kettle> getAll() {
        session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Kettle.class);
        List<Kettle> kettles = criteria.list();
        session.close();
        return kettles;
    }

    @Override
    public Kettle getById(int id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Kettle kettle = session.get(Kettle.class, id);
        session.close();
        return kettle;
    }

    @Override
    public void add(Kettle element) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(element);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(int id, Kettle element) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Kettle temp = session.get(Kettle.class, id);
        if (temp != null) {
            element.setId(id);
            session.merge(element);
        }
        else
            session.save(element);
        session.getTransaction().commit();
    }
}
