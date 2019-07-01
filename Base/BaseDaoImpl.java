package ir.maktab.HomeWork11_DataBase.Base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;

public abstract class BaseDaoImpl<E extends Serializable> implements BaseDao<E> {

    protected final SessionFactory factory;

    protected BaseDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    protected abstract String getEntityName();

    @Override
    public void create(E e) {
        Session session = factory.openSession();

        session.beginTransaction();

        session.save(e);

        session.getTransaction().commit();

        session.close();
    }


    @Override
    public E read(Serializable id) {

        Session session = factory.openSession();

        session.beginTransaction();

        E e = (E) session.get(getEntityName(), id);

        session.getTransaction().commit();

        session.close();

        return e;
    }


    @Override
    public E update(E e) {

        Session session = factory.openSession();

        session.beginTransaction();

        session.save(e);

        session.getTransaction().commit();

        session.close();

        return e;
    }

    @Override
    public void delete(Serializable id) {

        Session session = factory.openSession();

        session.beginTransaction();

        session.createQuery("delete from" + getEntityName() + "as entity where entity id =" + id);

        session.getTransaction().commit();

        session.close();
    }
}