package com.jvm.cloud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/GUIlang")
public class GUIdevelopinglang
{
    public String apps_list;  
    public String apps_name;
    
    public AppsStore appl;
    public AuditManager aum;
    public ProcessingRegister pr;
    
    @RequestMapping("/chooseapps")
    public void choose_apps()
    {
    
    }
    
    @RequestMapping("/selectprocess")
    public void select_process()
    {
    
    }
    
    @RequestMapping("/display")
    public void display()
    {
    
    }
    
    @RequestMapping("/sapps")
    public void start_apps()
    {
    
    }

    @RequestMapping("/reqtoprocess")
    public void req_to_process()
    {
    
    }
}
