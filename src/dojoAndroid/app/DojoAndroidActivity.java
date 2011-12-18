package dojoAndroid.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class DojoAndroidActivity extends Activity {
    /** Called when the activity is first created. */
	
	private Button button1;
	private EditText editText1;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        button1=(Button)findViewById(R.id.button1);
        editText1=(EditText)findViewById(R.id.editText1);
        button1.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		HttpClient httpclient = new DefaultHttpClient();
        	    HttpPost httppost = new HttpPost("http://machinesentience.com/php/androidtest01/databasetest.php");
        	    try {
        	    	 List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
        	         nameValuePairs.add(new BasicNameValuePair("tt", editText1.getText().toString()));
        	         httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        	        // Execute HTTP Post Request
        	        httpclient.execute(httppost);
        	        
        	    } catch (ClientProtocolException e) {
        	    	editText1.setText("Error 1: "+e.getMessage());
        	        // TODO Auto-generated catch block
        	    } catch (IOException e) {
        	    	editText1.setText("Error 2: "+e.getMessage());
        	        // TODO Auto-generated catch block
        	    }
        	    
        	    //editText1.setText("NO ERROR");
        	}
        });
        
    }
}