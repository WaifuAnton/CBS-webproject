package helper;

import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Set;

public abstract class HelperUser<E extends User> extends Helper<E> {
    public abstract Set<E> getAll();

    public abstract E getByLogin(String login);
}
