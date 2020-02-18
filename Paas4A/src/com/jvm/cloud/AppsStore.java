package com.jvm.cloud;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.mysql.jdbc.Driver;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jvm.cloud.util.DbConstant;
import com.jvm.cloud.util.XMLResponseUtil;

@Controller
@RequestMapping("/AppsStore")
public class AppsStore 
{
	
    public String apps_list;
    public String apps_name;
    public  String user_name;
    public String pwd;
    
    Integer i;
    
    @RequestMapping("/chooseapps")
    public String choose_apps(Model m)
    {
    	/*System.out.println("AppsStore.choose_apps()1");
    
    	File f = new File("webapps/ROOT/Apps.xml");
    	
    	try {
		
    		f.createNewFile();
			System.out.println(f.getAbsolutePath());
    		FileWriter ff = new FileWriter(f);
			ff.write("<data><value>"+LD("sadf", "asdfadfs")+"</value></data>");
			ff.close();
		
			System.out.println("File Written Successfully");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	*/
    	return "Apps1";
    }
    
    
    
    @RequestMapping("/checkreg")
    public void check_registration()
    {
    
    }

    @RequestMapping("/getapps1")
    public void get_purchased_apps()
    {
    	/*Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        
        try {
    	
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cloud", "root", "sony");
        	st = con.createStatement();
        	rs = st.executeQuery("select * from login");
        
        	while(rs.next()) {
        		System.out.println("pwd: " + rs.getString("password"));
        		System.out.println("username: " + rs.getString("username"));
        		//System.out.println("userPk: " + rs.getString("userPk"));
        	}
        	 
        } catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	} finally {
    		try {
    			
    			if(rs != null) {rs.close();}
    			if(st != null) {st.close();}
    			if(con != null) {con.close();}
    			
    		} catch (SQLException e) 
    		{
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
    	}
    
File f = new File("webapps/ROOT/Apps.xml");
    	
    	try {
		
    		f.createNewFile();
			System.out.println(f.getAbsolutePath());
    		FileWriter ff = new FileWriter(f);
			ff.write("<data><value>"+"a a"+"</value></data>");
			ff.close();
		
			System.out.println("File Written Successfully");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    	return;
    	
    	*/
        
	}
    

    
    
    @RequestMapping("/")
    public void purchase_apps()
    {
    
    }
     
    @RequestMapping("/")
    public void get_expired_list()
    {
    
    }
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping("/LD")
    public String LD(@RequestParam Map params, ModelMap m1) {
    	
    System.out.println("AppsStore.LD()");    	
    
    System.out.println(params);
    
    String s = params.get("firstValue").toString();
    String t =params.get("secondValue").toString();
       
  	  int d[][]; // matrix
  	  int n ; // length of s
  	  int m ;// length of t
  	  int i; // iterates through s
  	  int j; // iterates through t
  	  char s_i; // ith character of s
  	  char t_j; // jth character of t
  	  int cost; // cost

  	    // Step 1

  	    n = s.length ();
  	    m = t.length ();
  	    if (n == 0) 
  	    {
  	       System.out.println(m);
  	    }
  	    if (m == 0) {
  	    	System.out.println(n);
  	    }
  	    d = new int[n+1][m+1];

  	    // Step 2

  	    for (i = 0; i <= n; i++) {
  	      d[i][0] = i;
  	    }

  	    for (j = 0; j <= m; j++) {
  	      d[0][j] = j;
  	    }

  	    // Step 3

  	    for (i = 1; i <= n; i++) {

  	      s_i = s.charAt (i - 1);

  	      // Step 4

  	      for (j = 1; j <= m; j++) {

  	        t_j = t.charAt (j - 1);

  	        // Step 5

  	        if (s_i == t_j) {
  	          cost = 0;
  	        }
  	        else {
  	          cost = 1;
  	        }

  	        // Step 6

  	        d[i][j] = Minimum (d[i-1][j]+1, d[i][j-1]+1, d[i-1][j-1] + cost);

  	      }

  	    }

  	    // Step 7

  	  System.out.println(d[n][m]);
 
    Integer distance = d[n][m];
    
    XMLResponseUtil util = new XMLResponseUtil();
  
    List<String> returnAns = new ArrayList<String>();
    returnAns.add(distance.toString());
    
    util.writeXMLResponse(returnAns, "LDAns");
    	
    System.out.println("Values returned: " + returnAns);
    
    return "Apps";
    }
    private int Minimum (int a, int b, int c) {
    	  int mi;

    	    mi = a;
    	    if (b < mi) {
    	      mi = b;
    	    }
    	    if (c < mi) {
    	      mi = c;
    	    }
    	    return mi;

    	  }
 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @RequestMapping("/sin")
    public String sin(@RequestParam Map params, ModelMap m) {
    	
    System.out.println("AppsStore.sin()");    	
    
    System.out.println(params);
      
    Double inputValue = Double.parseDouble(params.get("firstValue").toString());
    
    Double toRadian_doubleEditTextMsg = Math.toRadians(inputValue);
    
    Double afterSin =Math.sin(toRadian_doubleEditTextMsg);
    
    XMLResponseUtil util = new XMLResponseUtil();
  
    List<String> returnAns = new ArrayList<String>();
    returnAns.add(afterSin.toString());
    
    util.writeXMLResponse(returnAns, "sinAns");
    	
    System.out.println("Values returned: " + returnAns);
    
    return "Apps";
    }
    
    @RequestMapping("/cos")
    public String cos(@RequestParam Map params, ModelMap m) {
    	
    System.out.println("AppsStore.cos()");    	
    
    System.out.println(params);
    
    Double inputValue = Double.parseDouble(params.get("firstValue").toString());
    
    Double toRadian_doubleEditTextMsg = Math.toRadians(inputValue);
    
    Double afterCos =Math.cos(toRadian_doubleEditTextMsg);
    
    XMLResponseUtil util = new XMLResponseUtil();
  
    List<String> returnAns = new ArrayList<String>();
    returnAns.add(afterCos.toString());
    
    util.writeXMLResponse(returnAns, "cosAns");
    	
    System.out.println("Values returned: " + returnAns);
    
    return "Apps";
    }
    

    @RequestMapping("/tan")
    public String tan(@RequestParam Map params, ModelMap m) {
    	
    System.out.println("AppsStore.tan()");    	
    

    System.out.println(params);
    
    Double inputValue = Double.parseDouble(params.get("firstValue").toString());
    
    Double toRadian_doubleEditTextMsg = Math.toRadians(inputValue);
    
    Double afterTan =Math.tan(toRadian_doubleEditTextMsg);
    
    XMLResponseUtil util = new XMLResponseUtil();
  
    List<String> returnAns = new ArrayList<String>();
    returnAns.add(afterTan.toString());
    
    util.writeXMLResponse(returnAns, "tanAns");
    	
    System.out.println("Values returned: " + returnAns);
    
    return "Apps";
    }


    @RequestMapping("/square_2")
    public String square_2(@RequestParam Map params, ModelMap m) {
    	
    System.out.println("AppsStore.square_2()");    	
    
    System.out.println(params);
    
    Double inputValue = Double.parseDouble(params.get("firstValue").toString());
    
    Double doubleEditTextMsg = Math.pow(inputValue,2);
    
   Double after_squared_2 =Math.pow(doubleEditTextMsg,2);
    
    XMLResponseUtil util = new XMLResponseUtil();
  
    List<String> returnAns = new ArrayList<String>();
    returnAns.add(after_squared_2.toString());
    
    util.writeXMLResponse(returnAns, "square_2Ans");
    	
    System.out.println("Values returned: " + returnAns);
    
    return "Apps";
    }


    @RequestMapping("/qube")
    public String qube(@RequestParam Map params, ModelMap m) {
    	
    System.out.println("AppsStore.qube()");    	
    System.out.println(params);
    
    Double inputValue = Double.parseDouble(params.get("firstValue").toString());
    
    Double doubleEditTextMsg = Math.pow(inputValue,3);
    
    Double after_qube =Math.pow(doubleEditTextMsg,3);
    
    XMLResponseUtil util = new XMLResponseUtil();
  
    List<String> returnAns = new ArrayList<String>();
    returnAns.add(after_qube.toString());
    
    util.writeXMLResponse(returnAns, "qubeAns");
    	
    System.out.println("Values returned: " + returnAns);
    
    return "Apps";
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private CalcBean bean = new CalcBean();
    
    
    
    @Autowired
    public void setBean(CalcBean bean) {
		this.bean = bean;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping("/root")
    public String root(@RequestParam Map params, ModelMap m) {
    	
    System.out.println("AppsStore.root()");    	
    
    System.out.println(params);
    
    Double inputValue = Double.parseDouble(params.get("firstValue").toString());
    
    Double doubleEditTextMsg = Math.sqrt(inputValue);
    
  
    XMLResponseUtil util = new XMLResponseUtil();
  
    List<String> returnAns = new ArrayList<String>();
    returnAns.add(doubleEditTextMsg.toString());
    
    util.writeXMLResponse(returnAns, "rootAns");
    	
    System.out.println("Values returned: " + returnAns);
    
    return "Apps";
    }


    @RequestMapping("/plus")
    public String plus(@RequestParam Map params, ModelMap m) {
    	
    System.out.println("AppsStore.plus()");    	
    System.out.println(params);
    
   
    Float inputValue1 = Float.parseFloat(params.get("firstValue").toString());
    Float inputValue2 = Float.parseFloat(params.get("secondValue").toString());
    
    Float answer = inputValue1 + inputValue2;
    
    XMLResponseUtil util = new XMLResponseUtil();
  
    List<String> returnAns = new ArrayList<String>();
    
    returnAns.add(answer.toString());
    
    util.writeXMLResponse(returnAns, "plusAns");
    	
    System.out.println("Values returned: " + returnAns);
    
    return "Apps";
    }


    @RequestMapping("/minus")
    public String minus(@RequestParam Map params, ModelMap m) {
    	
    System.out.println("AppsStore.minus()");    	
    System.out.println(params);
    
    
    Float inputValue1 = Float.parseFloat(params.get("firstValue").toString());
    Float inputValue2 = Float.parseFloat(params.get("secondValue").toString());
     Float answer;
        
     answer = inputValue1 - inputValue2;
      	
    XMLResponseUtil util = new XMLResponseUtil();
  
    List<String> returnAns = new ArrayList<String>();
    
    returnAns.add(answer.toString());
    
    util.writeXMLResponse(returnAns, "minusAns");
    	
    System.out.println("Values returned: " + returnAns);
    
    return "Apps";
    }


    @RequestMapping("/multiply")
    public String multiply(@RequestParam Map params, ModelMap m) {
    	
    System.out.println("AppsStore.multiply()");    	
    System.out.println(params);
    
    
    Float inputValue1 = Float.parseFloat(params.get("firstValue").toString());
    Float inputValue2 = Float.parseFloat(params.get("secondValue").toString());
    
    Float answer = inputValue1 * inputValue2;
    
    XMLResponseUtil util = new XMLResponseUtil();
  
    List<String> returnAns = new ArrayList<String>();
    
    returnAns.add(answer.toString());
    
    util.writeXMLResponse(returnAns, "multiplyAns");
    	
    System.out.println("Values returned: " + returnAns);
    
    return "Apps";
    }


    @RequestMapping("/divide")
    public String divide(@RequestParam Map params, ModelMap m) {
    	
    System.out.println("AppsStore.divide()");    	
    System.out.println(params);
    
    
    Float inputValue1 = Float.parseFloat(params.get("firstValue").toString());
    Float inputValue2 = Float.parseFloat(params.get("secondValue").toString());
    
    Float answer;
	
    try {
		
		answer = inputValue1 / inputValue2;
		
	} catch (ArithmeticException e) {
		answer = 0f;
	}
    
    
    XMLResponseUtil util = new XMLResponseUtil();
  
    List<String> returnAns = new ArrayList<String>();
    
    returnAns.add(answer.toString());
    
    util.writeXMLResponse(returnAns, "divideAns");
    	
    System.out.println("Values returned: " + returnAns);
    
    return "Apps";
    }


    public static void main(String[] args) {
		
    	String value = "-FF";
    	Integer ans = Integer.parseInt(value, 16);
    	
    	System.out.println(ans);
    	
    	  try {
    			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cloud", "root", "sony");
    			System.out.println("connected");
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	
	}
    

    @RequestMapping("/dec")
    public String dec(@RequestParam Map params, ModelMap m) {
    	
    System.out.println("AppsStore.dec()");    	
        
    System.out.println(params);
    
    String inputValue = params.get("firstValue").toString();
    
    Integer integerEditTextMsg = Integer.parseInt(inputValue,10);
    
   
    XMLResponseUtil util = new XMLResponseUtil();
  
    List<String> returnAns = new ArrayList<String>();
    returnAns.add(integerEditTextMsg.toString());
    
    util.writeXMLResponse(returnAns, "decAns");
    	
    System.out.println("Values returned: " + returnAns);
    
    return "Apps";
    }



    @RequestMapping("/bin")
    public String bin(@RequestParam Map params, ModelMap m) {
    	
    System.out.println("AppsStore.bin()");    	

    System.out.println(params);
    
    String inputValue = params.get("firstValue").toString();
    
    Integer integerEditTextMsg = Integer.parseInt(inputValue.toString());
      
    String bin_num=Integer.toBinaryString(integerEditTextMsg);
    
   
    XMLResponseUtil util = new XMLResponseUtil();
  
    List<String> returnAns = new ArrayList<String>();
    returnAns.add(bin_num);
    
    util.writeXMLResponse(returnAns, "binAns");
    	
    System.out.println("Values returned: " + returnAns);
    
    return "Apps";
    }


    @RequestMapping("/hex")
    public String hex(@RequestParam Map params, ModelMap m) {
    	
    System.out.println("AppsStore.hex()");    	
    

    System.out.println(params);
    
    String inputValue = params.get("firstValue").toString();
    
   
    Integer integerEditTextMsg = Integer.parseInt(inputValue.toString());
      
    String hex_num=Integer.toHexString(integerEditTextMsg);
    
   
    XMLResponseUtil util = new XMLResponseUtil();
  
    List<String> returnAns = new ArrayList<String>();
    returnAns.add(hex_num);
    
    util.writeXMLResponse(returnAns, "hexAns");
    	
    System.out.println("Values returned: " + returnAns);
    
    return "Apps";
    }



    @RequestMapping("/oct")
    public String oct(@RequestParam Map params, ModelMap m) {
    	
    System.out.println("AppsStore.oct()");    	
    

    System.out.println(params);
    
    String inputValue = params.get("firstValue").toString();
    
    Integer integerEditTextMsg = Integer.parseInt(inputValue.toString());
      
    String oct_num=Integer.toOctalString(integerEditTextMsg);
    
   
    XMLResponseUtil util = new XMLResponseUtil();
  
    List<String> returnAns = new ArrayList<String>();
    returnAns.add(oct_num);
    
    util.writeXMLResponse(returnAns, "octAns");
    	
    System.out.println("Values returned: " + returnAns);
    
    return "Apps";
    }
 
    
    DataSource dataSource;
    
    @RequestMapping("/db")
    public String checkDbConnection() {
    	
    	System.out.println(java.lang.System.getenv("VCAP_SERVICES"));
    	
    	try {
    		
    		//dataSource.getConnection().createStatement();
			
		} catch (Exception e) {
e.printStackTrace();
		}
    	
    	
    try {
    	
    	System.out.println("Connecting to Db1");
    	
    	Class.forName("com.mysql.jdbc.Driver").newInstance();
    	
		Connection con = DriverManager.getConnection(DbConstant.url, DbConstant.username, DbConstant.password);
		
		System.out.println("Connection done");
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
    	
    	return "";
    }

}