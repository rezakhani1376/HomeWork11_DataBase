package ir.maktab.HomeWork11_DataBase.Base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;

public abstract class BaseDaoImpl <E extends Serializable> implements BaseDao<E>{

    private final SessionFactory factory;

    public BaseDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    protected abstract String getEntityName();

    @Override
    public void create(E e) {
        Session session = factory.openSession();

        session.beginTransaction();

        session.persist(e);

        session.getTransaction().commit();

        session.close();
    }

    @Override
    public void update(E e) {

        Session session = factory.openSession();

        session.beginTransaction();

        session.update(e);

        session.getTransaction().commit();

        session.close();
    }

    @Override
    public void read(Serializable id) {

        Session session = factory.openSession();

        Object o = session.createQuery("from "+ getEntityName() +" entity where entity.ed = " + id)
                .getSingleResult();
        E e = (E) o;

        session.close();
    }

    @Override
    public void delete(Serializable id) {

        Session session = factory.openSession();

        session.beginTransaction();

        session.createQuery("delete from " + getEntityName() + " as entity where entity.id = " + id);

        session.getTransaction().commit();

        session.close();
    }
}
