package com.form.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormsActivity extends Activity 
{
	 // final  FormsActivity l = this;
	 	 
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);
	    
		Button btnNew = (Button)findViewById(R.id.btn_new); 
	    btnNew.setOnClickListener(new OnClickListener()
	    {

				@Override
				public void onClick(View v)
				{

	            	System.out.println("in new");
	            	startActivityForResult(new Intent("com.form.android.NewForm"),1);
					
				}  
	      });
	    
        final EditText txtUserName = (EditText)findViewById(R.id.txt_username);  
        final EditText txtPassword = (EditText)findViewById(R.id.txt_password);  
        
        Button btnLogin = (Button)findViewById(R.id.btn_login); 
        btnLogin.setOnClickListener(new OnClickListener()
        {  
  
            @Override  
            public void onClick(View v)
            {  
           	 
                String username = txtUserName.getText().toString();  
                String password = txtPassword.getText().toString();
                
                String dbusername = "a";  
                String dbpassword = "a";
                
                
                try{  
               	 
                    if(username.length() > 0 && password.length() >0)  
                    {  
                          //private DatabaseUtils
                        if(username.equals(dbusername) && password.equals(dbpassword) ) // database.Login(username, password)  
                        {  
                        	startActivityForResult(new Intent("com.form.android.LoginForm"),1);
                            
                        }
                        else
                        {  
                            Toast.makeText(FormsActivity.this,"Invalid Username/Password", Toast.LENGTH_LONG).show();  
                        }  
                         
                    }    	
                }catch(Exception e)  
                {  
                    Toast.makeText(FormsActivity.this,e.getMessage(), Toast.LENGTH_LONG).show();  
                }  
           }
        });
        Button button2=(Button)findViewById(R.id.btn_exit);
        button2.setOnClickListener(new OnClickListener()
	    {
        	@Override
			public void onClick(View v)
			{
			  finish();
			}
	    });
	 }    
}