package com.form.android;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewForm extends Activity{
	
	 @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.copyofmain);
		
		final EditText txtName=(EditText)findViewById(R.id.name);
		final EditText txtEmail=(EditText)findViewById(R.id.email);
		
		 final EditText txtUserName = (EditText)findViewById(R.id.txt_username);  
	     final EditText txtPassword = (EditText)findViewById(R.id.txt_password);  
	     
	     final EditText txtPassword1 = (EditText)findViewById(R.id.txt_password1);  
	     
	     Button btnReg = (Button)findViewById(R.id.btn_register); 
	     btnReg.setOnClickListener(new OnClickListener()
	     {  

	         @Override  
	         public void onClick(View v)
	         {      
	        	 String strName =txtName.getText().toString();
	        	 String strEmail=txtEmail.getText().toString();
	        	 String strUsername =txtUserName.getText().toString();
	             String strPass1 = txtPassword.getText().toString();
	             String strPass2 = txtPassword1.getText().toString();
	             
	             
	             
	             if (strPass1.equals(strPass2)) 
	             {
	             	 Toast.makeText(NewForm.this, "valid password", Toast.LENGTH_LONG).show(); 
	             } else 
	             {
	             	 Toast.makeText(NewForm.this,"not valid", Toast.LENGTH_LONG).show(); 
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



