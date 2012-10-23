package knitting.counter;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	int rowcounter = 0;
	int repeatcounter = 0;
	
	TextView text;
	TextView repeatText;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(this);
        rowcounter = app_preferences.getInt("rowcounter", 0);
        repeatcounter = app_preferences.getInt("repeatcounter", 0);
        text = (TextView) findViewById(R.id.rowNumber);
        repeatText = (TextView) findViewById(R.id.repeatNumber);
        repeatText.setText (Integer.toString(repeatcounter));
		text.setText(Integer.toString(rowcounter));
        countRowsUp();
        countRepeatsUp();
        clearButton();
        countRowsDown();
        countRepeatsDown();
    }
    
    @Override
    protected void onPause(){
    	super.onPause();
    SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(this);
    SharedPreferences.Editor editor = app_preferences.edit();
    editor.putInt("rowcounter", rowcounter);
    editor.putInt("repeatcounter", repeatcounter);
    editor.commit();
    }
    
    public void countRowsUp(){
    	Button button = (Button) findViewById(R.id.rowPlusButton);
    	text = (TextView) findViewById(R.id.rowNumber);
    	button.setOnClickListener(new OnClickListener(){
    		
    		public void onClick(View v){
    			rowcounter++; 
    			text.setText(Integer.toString(rowcounter));
    		}
    	});
    	
    }
    public void countRowsDown(){
    	Button button = (Button) findViewById(R.id.minusRowButton);
    	text = (TextView) findViewById(R.id.rowNumber);
    	button.setOnClickListener(new OnClickListener(){
    		public void onClick(View v){
    			rowcounter--;
    			text.setText(Integer.toString(rowcounter));
    		}
    	});
    }
    
    public void countRepeatsUp(){
    	Button button = (Button) findViewById(R.id.repeatPlusButton);
    	repeatText = (TextView) findViewById(R.id.repeatNumber);
    	button.setOnClickListener(new OnClickListener(){
    		
    		public void onClick(View v){
    			repeatcounter++; 
    			repeatText.setText(Integer.toString(repeatcounter));
    		}
    	});
    }
    
    public void countRepeatsDown(){
    	Button button = (Button) findViewById(R.id.minusRepeatButton);
    	repeatText = (TextView) findViewById(R.id.repeatNumber);
    	button.setOnClickListener(new OnClickListener(){
    		
    		public void onClick(View v){
    			repeatcounter--;
    			repeatText.setText(Integer.toString(repeatcounter));
    		}
    	});
    }
    
    public void clearButton(){
    	Button button = (Button) findViewById(R.id.clearButton);
    	button.setOnClickListener(new OnClickListener(){
    		
    		public void onClick(View v){
    			repeatcounter = 0;
    			rowcounter = 0;
    			repeatText.setText (Integer.toString(repeatcounter));
    			text.setText(Integer.toString(rowcounter));
    		
    		}
    	});
    }
    
}
