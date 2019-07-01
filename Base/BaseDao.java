package ir.maktab.HomeWork11_DataBase.Base;

import java.io.Serializable;


public interface BaseDao<E extends Serializable> {

    void create(E e);

    E read(Serializable id);

    E update(E e);

    void delete(Serializable id);
}