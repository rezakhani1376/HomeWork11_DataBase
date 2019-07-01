package ir.maktab.HomeWork11_DataBase.Base;

import java.io.Serializable;

public interface BaseDao<E extends Serializable> {

    void create(E e);

    void update(E e);

    void read(Serializable id);

    void delete(Serializable id);
}