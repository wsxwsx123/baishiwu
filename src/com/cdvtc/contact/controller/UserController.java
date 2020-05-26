package com.cdvtc.contact.controller;

import com.cdvtc.contact.dao.Dao;
import com.cdvtc.contact.dao.DaoImpl;
import com.cdvtc.contact.data.Admin;
import com.cdvtc.contact.data.ClassInfo;
import com.cdvtc.contact.data.Contact;
import com.cdvtc.contact.data.TbUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    Dao dao=new DaoImpl();

    /**
     * 跳转到注册页面
     * @param model
     * @return
     */
    @RequestMapping("/toRegister")
    public String toRegister(Model model){
        List<ClassInfo> classInfoList=dao.getAllClassInfo();
        model.addAttribute("classes",classInfoList);
        return "register";
    }

    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    /**
     * 注册
     * @param contact
     * @param model
     * @return
     */
    @RequestMapping("/register")
    public String register(@ModelAttribute Contact contact,Model model){
        String name=contact.getName();
        String stuid=contact.getStuid();
        boolean error=false;
        if(name==null || name.length()==0){
            model.addAttribute("error_name","用户名不能为空！");
            error=true;
        }
        if(dao.isStuIdExisted(stuid)){
            model.addAttribute("error_stuid","学号已经注册！");
            error=true;
        }
        if(error){
            List<ClassInfo> classInfoList=dao.getAllClassInfo();
            model.addAttribute("classes",classInfoList);
            return "register";
        }else{
            dao.addContact(contact);
            return "redirect:/listContacts";
        }
    }

    /**
     *
     * @param
     * @param session
     * @param model
     * @return
     */
    /*
    @RequestMapping("/login2")
    public String login2(@ModelAttribute Admin admin, HttpSession session,Model model){
        Admin admin1=dao.getAdmin(admin.getAccount(),admin.getPassword());
        if(admin1!=null){
            session.setAttribute("admin",admin1);
            return "redirect:/listContacts";
        }else{
            model.addAttribute("error","用户名或者密码错误！");
            return "login";
        }
    }
    */

    @RequestMapping("/login")
    public String login(@ModelAttribute TbUser tbUser, HttpSession session, Model model){
        TbUser tbUser1=dao.getTbUser(tbUser.getUserId(),tbUser.getPassword());
        if(tbUser1!=null){
            session.setAttribute("admin",tbUser1);
            return "redirect:/listContacts";
        }else{
            model.addAttribute("error","用户名或者密码错误！");
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String logOut(HttpSession session){
        session.invalidate();//清除session内容
        return "redirect:/listContacts";
    }
}
