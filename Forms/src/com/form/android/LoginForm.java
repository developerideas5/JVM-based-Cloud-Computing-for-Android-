package com.form.android;



import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LoginForm extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.copyofmain1);

		Button btnLD = (Button)findViewById(R.id.btn_LD); 
	    btnLD.setOnClickListener(new OnClickListener()
	    {

				@Override
				public void onClick(View arg0)
				{

	            	System.out.println("in LD");
	            	
	            	Intent intent = new Intent("android.intent.action.MAIN");                
	            	   intent.setComponent(new ComponentName("com.algo.ld","com.algo.ld.LDActivity"));
	            	   startActivity(intent);

	            	startActivityForResult(new Intent(""),1);
					
				}  
	      });
	    

		Button btnCalc = (Button)findViewById(R.id.btn_Calc); 
	    btnCalc.setOnClickListener(new OnClickListener()
	    {

				@Override
				public void onClick(View arg0)
				{

	            	System.out.println("in Calcii");
	            	
	            	Intent intent = new Intent("android.intent.action.MAIN");                
	            	   intent.setComponent(new ComponentName("home.calculator","home.calculator.Main"));
	            	   startActivity(intent);

	            	//startActivityForResult(new Intent("home.calculator.Main"),1);
					
				}  
	      });
	    Button button1=(Button)findViewById(R.id.btn_back);
        button1.setOnClickListener(new OnClickListener()
	    {
        	@Override
			public void onClick(View v)
			{
			  
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
