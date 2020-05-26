package com.cdvtc.contact.dao;

import com.cdvtc.contact.data.Admin;
import com.cdvtc.contact.data.ClassInfo;
import com.cdvtc.contact.data.Contact;
import com.cdvtc.contact.data.TbUser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoImpl implements Dao {

    private Connection conn = null;

    public DaoImpl() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); //注册驱动类
            conn = DriverManager.getConnection("jdbc:mysql://localhost/contact?useUnicode=true&characterEncoding=utf8&user=root&password=111111");  //创建连接
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ClassInfo getClassInfo(int classId) {
        ClassInfo classInfo = new ClassInfo();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from classinfo where id=" + classId);

            if (rs.next()) {
                classInfo.setId(rs.getInt("id"));
                classInfo.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classInfo;
    }

    @Override
    public List<Contact> getAllContacts() {

        List<Contact> contacts = new ArrayList<Contact>();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from contact");

            while (rs.next()) {
                Contact contact = new Contact();

                contact.setId(rs.getInt("id"));
                contact.setName(rs.getString("name"));
                contact.setStuid(rs.getString("stuid"));
                contact.setSex(rs.getString("sex"));
                contact.setClassInfo(this.getClassInfo(rs.getInt("classId")));
                contact.setEmail(rs.getString("email"));
                contact.setMobile(rs.getString("mobile"));
                contact.setQq(rs.getString("qq"));
                contacts.add(contact);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contacts;
    }

    @Override
    public void addContact(Contact contact) {
        try {
            PreparedStatement pst = conn.prepareStatement("insert into contact(name, stuid, sex, classId, mobile, email,qq) values(?,?,?,?,?,?,?)");

            pst.setString(1, contact.getName());
            pst.setString(2, contact.getStuid());
            pst.setString(3, contact.getSex());
            pst.setInt(4, contact.getClassInfo().getId());
            pst.setString(5, contact.getMobile());
            pst.setString(6, contact.getEmail());
            pst.setString(7, contact.getQq());

            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ClassInfo> getAllClassInfo() {
        List<ClassInfo> classInfoList = new ArrayList<ClassInfo>();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from classinfo");

            while (rs.next()) {
                ClassInfo classInfo = new ClassInfo();
                classInfo.setId(rs.getInt("id"));
                classInfo.setName(rs.getString("name"));

                classInfoList.add(classInfo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return classInfoList;
    }

    @Override
    public boolean isStuIdExisted(String stuid) {

        try {
            PreparedStatement pst = conn.prepareStatement("select * from contact where stuid=?");
            pst.setString(1, stuid);
            ResultSet rs =  pst.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Admin getAdmin(int account, String password) {
        try {
            PreparedStatement pst = conn.prepareStatement("select * from admin where account=? && password=?");
            pst.setString(1, String.valueOf(account));
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                Admin admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setName(rs.getString("name"));
                admin.setAccount(account);
                admin.setPassword(password);

                return admin;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public TbUser getTbUser(int account, String password) {
        try {
            PreparedStatement pst = conn.prepareStatement("select * from tb_user where account=? && password=?");
            pst.setInt(1, account);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                TbUser tbUser = new TbUser();
                tbUser.setUserId(rs.getInt("id"));
                tbUser.setPassword(rs.getString("name"));
                tbUser.setAccount(account);
                tbUser.setPassword(password);
                return tbUser;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TbUser getTbUser(String account, String password) {
        return null;
    }


    @Override
    public Contact getContact(int id) {
        Contact contact = new Contact();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from contact where id=" + id);

            if (rs.next()) {
                contact.setId(rs.getInt("id"));
                contact.setName(rs.getString("name"));
                contact.setStuid(rs.getString("stuid"));
                contact.setSex(rs.getString("sex"));
                contact.setClassInfo(this.getClassInfo(rs.getInt("classId")));
                contact.setEmail(rs.getString("email"));
                contact.setMobile(rs.getString("mobile"));
                contact.setQq(rs.getString("qq"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contact;
    }

    /***
     * 更新通讯录
     * @param contact
     */
    @Override
    public void updateContact(Contact contact) {
        try {
            PreparedStatement pst = conn.prepareStatement("update contact set name=?, stuid=?, sex=?, classId=?, mobile=?, email=?,qq=?  where id=?");

            pst.setString(1, contact.getName());
            pst.setString(2, contact.getStuid());
            pst.setString(3, contact.getSex());
            pst.setInt(4, contact.getClassInfo().getId());
            pst.setString(5, contact.getMobile());
            pst.setString(6, contact.getEmail());
            pst.setString(7, contact.getQq());
            pst.setInt(8, contact.getId());

            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据id删除通讯录记录
     * @param id
     */
    @Override
    public void deleteContact(int id) {
        try {
            PreparedStatement pst = conn.prepareStatement("delete from contact where id=?");
            pst.setInt(1, id);

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /***
     * 根据 姓名，姓名，班级条件查询通讯录列表
     * @param name
     * @param sex
     * @param classId
     * @return
     */
    @Override
    public List<Contact> queryContact(String name, String sex, int classId) {
        List<Contact> contacts = new ArrayList<Contact>();

        try {
            String sql = "select * from contact where (name like ? or stuid like ? or mobile like ? or qq like ? or email like ?)";
            if("m".equals(sex) || "f".equals(sex)){
                sql += " and sex='"+sex+"'";
            }
            if(classId > 0){
                sql += " and classId="+classId;
            }

            PreparedStatement pst =  conn.prepareStatement(sql);
            String filterStr = "%" + name + "%";
            pst.setString(1, filterStr);
            pst.setString(2, filterStr);
            pst.setString(3, filterStr);
            pst.setString(4, filterStr);
            pst.setString(5, filterStr);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Contact contact = new Contact();

                contact.setId(rs.getInt("id"));
                contact.setName(rs.getString("name"));
                contact.setStuid(rs.getString("stuid"));
                contact.setSex(rs.getString("sex"));
                contact.setClassInfo(this.getClassInfo(rs.getInt("classId")));
                contact.setEmail(rs.getString("email"));
                contact.setMobile(rs.getString("mobile"));
                contact.setQq(rs.getString("qq"));
                contacts.add(contact);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contacts;
    }

    public static void main(String[] args) {
        Dao dao = new DaoImpl();
//        System.out.println(dao.getAllContacts());
//        System.out.println(dao.getAllClassInfo());
//
//        System.out.println(dao.isStuIdExisted("1830203"));
//
//        System.out.println(dao.getAdmin("admin", "123456"));
//
//        System.out.println(dao.getContact(99));

        System.out.println(dao.queryContact("176", "", 0));
    }
}
