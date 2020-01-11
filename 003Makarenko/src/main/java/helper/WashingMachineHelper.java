package helper;

import entity.WashingMachine;
import org.hibernate.Criteria;

import java.util.List;

public class WashingMachineHelper extends HelperItem<WashingMachine> {
    @Override
    public List<WashingMachine> getAll() {
        session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(WashingMachine.class);
        List<WashingMachine> washingMachines = criteria.list();
        session.close();
        return washingMachines;
    }

    @Override
    public WashingMachine getById(int id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        WashingMachine washingMachine = session.get(WashingMachine.class, id);
        session.close();
        return washingMachine;
    }

    @Override
    public void add(WashingMachine element) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(element);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(int id, WashingMachine element) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        WashingMachine temp = session.get(WashingMachine.class, id);
        if (temp != null) {
            element.setId(id);
            session.merge(element);
        }
        else
            session.save(element);
        session.getTransaction().commit();
    }
}
