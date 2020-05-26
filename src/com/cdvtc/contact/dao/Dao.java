package com.cdvtc.contact.dao;

import com.cdvtc.contact.data.Admin;
import com.cdvtc.contact.data.ClassInfo;
import com.cdvtc.contact.data.Contact;
import com.cdvtc.contact.data.TbUser;

import java.util.List;

public interface Dao {

    /**
     * 获取所有通讯录
     * @return
     */
    List<Contact> getAllContacts();

    /**
     *  增加通讯录
     * @param contact
     */
    void addContact(Contact contact);

    /**
     * 获取所有班级信息
     * @return
     */
    List<ClassInfo> getAllClassInfo();


    /**
     * 判断学号是否存在
     * @param stuid
     * @return
     */
    boolean isStuIdExisted(String stuid);

    /**
     * 获取管理员信息
     * @param account
     * @param password
     * @return
     */
    Admin getAdmin(int account, String password);


    TbUser getTbUser(int account, String password);


    TbUser getTbUser(String account, String password);

    /**
     * 根据ID获取通讯录
     * @param id
     * @return
     */
    Contact getContact(int id);

    /**
     * 更新通讯录
     * @param contact
     */
    void updateContact(Contact contact);

    /**
     * 删除通讯录
     * @param id
     */
    void deleteContact(int id);

    /**
     * 模糊查询通讯录
     * @param filter
     * @return
     */
    List<Contact> queryContact(String filter, String sex, int classId);
}
