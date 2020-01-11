package helper;

import entity.ElectricityItem;
import org.hibernate.Criteria;

import java.util.List;

public class ElectricityItemHelper extends HelperItem<ElectricityItem> {
    @Override
    public List<ElectricityItem> getAll() {
        session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(ElectricityItem.class);
        List<ElectricityItem> electricityItems = criteria.list();
        session.close();
        return electricityItems;
    }

    @Override
    public ElectricityItem getById(int id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        ElectricityItem electricityItem = session.get(ElectricityItem.class, id);
        session.close();
        return electricityItem;
    }

    @Override
    public void add(ElectricityItem element) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(element);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(int id, ElectricityItem element) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        ElectricityItem temp = session.get(ElectricityItem.class, id);
        if (temp != null) {
            element.setId(id);
            session.merge(element);
        }
        else
            session.save(element);
        session.getTransaction().commit();
    }
}
