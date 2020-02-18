package com.jvm.cloud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloudfoundry.db.helper.DbHelper;
import com.jvm.cloud.util.DbConstant;

@Controller
@RequestMapping("/AUG")
public class AuditGUI 
{
    public String user_name;
    public String pwd;
    public String apps_list;
    public String apps_name;
    
    public AppsStore apps;
    public AuditController auc;
    
    

    @RequestMapping("/vupwd")
    public void verify_userid_pwd()
    {/*
              DbHelper database = new DbHelper();
              							name,email,username,password
    	      insert into login values("shruti","shruti@gmail.com","do","do")
    	*/
    	
    }
    
    @RequestMapping("/iaur")
    public void init_audit_report()
    {
    
    }
    
    @RequestMapping("/getapps")
    public void get_purchased_apps_list()
    {
    
    }
    
    @RequestMapping("/chooseapps")
    public void choose_apps(String apps_name)
    {
    
    }
    
    @RequestMapping("/sapps")
    public void start_apps()
    {
    
    }
    
    @RequestMapping("/oapps")
    public void stop_apps()
    {
    
    }
    
    @RequestMapping("/getdetails")
    public void get_details()
    {
    
    }
    
    @RequestMapping("/disrpt")
    public void display_report()
    {
    
    }
    
    @RequestMapping("/choose oapps")
    public void choose_apps_to_stop()
    {
    
    }
}

