package com.cdvtc.contact.dao;

import com.cdvtc.contact.data.Admin;
import com.cdvtc.contact.data.ClassInfo;
import com.cdvtc.contact.data.Contact;
import com.cdvtc.contact.data.TbUser;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class HibernateDaoImpl implements Dao {
    private static final SessionFactory ourSessionFactory;
    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    @Override
    public List<Contact> getAllContacts() {
        final Session session = getSession();
        List<Contact> contactList=new ArrayList<Contact>();
        try {
            contactList= session.createQuery("from Contact").list();
        } finally {
            session.close();
        }
        return contactList;
    }

    @Override
    public void addContact(Contact contact) {
        final Session session = getSession();
        Transaction transaction=session.beginTransaction();
        session.save(contact);
        transaction.commit();
        session.close();
    }

    @Override
    public List<ClassInfo> getAllClassInfo() {
        List<ClassInfo> classInfoList=new ArrayList<ClassInfo>();
        final Session session = getSession();
        try {
            classInfoList=session.createQuery("from ClassInfo").list();
        } finally {
            session.close();
        }
        return classInfoList;
    }

    @Override
    public boolean isStuIdExisted(String stuid) {
        final Session session = getSession();
        try {
            //第一种方式
            Query query1=session.createQuery("from Contact c where c.stuid=?1");
            query1.setParameter(1,stuid);
            //第二种方式
            Query query=session.createQuery("from Contact c where c.stuid=:stuid");
            query.setParameter("stuid",stuid);
            Contact contact= (Contact) query.uniqueResult();
            if(contact!=null){
                return true;
            }
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public Admin getAdmin(int account, String password) {
        final Session session = getSession();
        Admin admin=new Admin();
        try {
            Query query=session.createQuery("from Admin a where a.account=?1 and a.password=?2");
            query.setParameter(1,account);
            query.setParameter(2,password);
            admin= (Admin) query.uniqueResult();
        } finally {
            session.close();
        }
        return admin;
    }

    @Override
    public TbUser getTbUser(int account, String password) {
        return null;
    }

    @Override
    public TbUser getTbUser(String account, String password) {
        return null;
    }

    @Override
    public Contact getContact(int id) {
        final Session session = getSession();
        Contact contact=session.get(Contact.class,id);
        session.close();
        return contact;
    }

    @Override
    public void updateContact(Contact contact) {
        final Session session = getSession();
        Transaction transaction=session.beginTransaction();
        session.update(contact);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteContact(int id) {
        final Session session = getSession();
        Transaction transaction=session.beginTransaction();
        Contact contact=session.get(Contact.class,id);
        session.delete(contact);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Contact> queryContact(String name, String sex, int classId) {
        List<Contact> contactList=new ArrayList<Contact>();
        final Session session = getSession();
        //String hql = "from Contact c where (c.name like :name or c.stuid like :name or c.mobile like :name or c.qq like :name or c.email like :name)";


        String hql="from Contact c where c.name like '%"+name+"%'";
        if("m".equals(sex) || "f".equals(sex)){
            hql += " and c.sex='"+sex+"'";
        }
        if(classId > 0){
            hql += " and c.classInfo.id="+classId;
        }
        Query query=session.createQuery(hql);
        //String filter="'%"+name+"%'";
        //query.setParameter("name",filter);

        contactList=query.getResultList();
        session.close();
        return contactList;
    }
}
