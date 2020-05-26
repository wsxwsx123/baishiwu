package com.cdvtc.contact.controller;

import com.cdvtc.contact.dao.Dao;
import com.cdvtc.contact.dao.DaoImpl;
import com.cdvtc.contact.dao.HibernateDaoImpl;
import com.cdvtc.contact.data.ClassInfo;
import com.cdvtc.contact.data.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ContactController {
    Dao dao=new HibernateDaoImpl();
    @RequestMapping("/listContacts")
    public String toMainPage(Model model){
       List<Contact> contactList=dao.getAllContacts();
       List<ClassInfo> classInfoList=dao.getAllClassInfo();
       model.addAttribute("contacts",contactList);
       model.addAttribute("classes",classInfoList);
        return "main";
    }
    @RequestMapping("/searchByCondition")
    public String filter(@RequestParam String sex,@RequestParam String name,@RequestParam int classId,Model model){
        List<Contact> contactList=dao.queryContact(name,sex,classId);
        List<ClassInfo> classInfoList=dao.getAllClassInfo();
        model.addAttribute("contacts",contactList);
        model.addAttribute("classes",classInfoList);
        return "main";
    }

    /**
     * 调整到编辑页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/toEdit/{id}")
    public String toEditPage(@PathVariable("id")int id, Model model){
        Contact contact=dao.getContact(id);
        List<ClassInfo> classInfoList=dao.getAllClassInfo();
        model.addAttribute("contact",contact);
        model.addAttribute("classes",classInfoList);
        return "edit";
    }
    @RequestMapping("/update")
    public String updateContact(@ModelAttribute Contact contact,Model model){
        String name=contact.getName();
        boolean error=false;
        if(name==null || name.length()==0){
            error=true;
            model.addAttribute("error_name","姓名不能为空！");
        }

        if(error){
            List<ClassInfo> classInfoList=dao.getAllClassInfo();
            model.addAttribute("classes",classInfoList);
            return "edit";
        }else{
            dao.updateContact(contact);
            return "redirect:/listContacts";
        }

    }
}
