package ir.maktab.HomeWork11_DataBase.model.dao;

import ir.maktab.HomeWork11_DataBase.Base.BaseDaoImpl;
import ir.maktab.HomeWork11_DataBase.model.Address;
import org.hibernate.SessionFactory;

public class AddressDaoImpl  extends BaseDaoImpl<Address> implements AddressDao  {


    public AddressDaoImpl(SessionFactory factory) {
        super(factory);
    }

    @Override
    protected String getEntityName() {
        return "Address";
    }
}
