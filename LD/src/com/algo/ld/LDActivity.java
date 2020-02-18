package com.algo.ld;

import java.util.List;
import com.cloud.algo.LdOnCloud;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LDActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final EditText number1 = (EditText) findViewById(R.id.editText1);
        final EditText number2 = (EditText) findViewById(R.id.editText2);
        Button button=(Button)findViewById(R.id.button1);
       final EditText editText = (EditText)findViewById(R.id.editText3);
        
        
        button.setOnClickListener(new OnClickListener()
	    {
        	@Override
			public void onClick(View v)
			{
        		String aString =number1.toString();
        		String bString =number2.toString();
        
		        System.out.println("First Value: "+aString);
		    	System.out.println("Second Value: " +bString);
		    	
		    	LdOnCloud cloud = new LdOnCloud();
		    	List<String> result = cloud.LD(aString,bString);
		    	
		             
		    	editText.setText(result.toString());
		    	String EditTextMsg=editText.getText().toString();
		    	System.out.println("answer"+EditTextMsg);
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