package ir.maktab.HomeWork11_DataBase.model.dao;

import ir.maktab.HomeWork11_DataBase.Base.BaseDaoImpl;
import ir.maktab.HomeWork11_DataBase.model.PhoneNumber;
import org.hibernate.SessionFactory;

public class PhoneNumberDaoImpl  extends BaseDaoImpl<PhoneNumber> implements PhoneNumberDao   {

    public PhoneNumberDaoImpl(SessionFactory factory) {
        super(factory);
    }

    @Override
    protected String getEntityName() {
        return null;
    }
}