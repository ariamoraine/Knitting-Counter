package knitting.counter;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{
	
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
		Button rowPlusButton = (Button) findViewById(R.id.rowPlusButton);
		Button minusRowButton = (Button) findViewById(R.id.minusRowButton);
		Button repeatPlusButton = (Button) findViewById(R.id.repeatPlusButton);
		Button minusRepeatButton = (Button) findViewById(R.id.minusRepeatButton);
		Button clearButton = (Button) findViewById(R.id.clearButton);
		rowPlusButton.setOnClickListener(this);
		minusRowButton.setOnClickListener(this);
		repeatPlusButton.setOnClickListener(this);
		minusRepeatButton.setOnClickListener(this);
		clearButton.setOnClickListener(this);
		
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
    
    public void onClick(View v){
    	switch(v.getId()){
    	
    	case R.id.clearButton:
    		repeatcounter = 0;
			rowcounter = 0;
			repeatText.setText (Integer.toString(repeatcounter));
			text.setText(Integer.toString(rowcounter));
    		break;
    	
    	case R.id.rowPlusButton:
    		rowcounter++; 
			text.setText(Integer.toString(rowcounter));
    		break;
    	
    	case R.id.minusRowButton:
    		rowcounter--;
			text.setText(Integer.toString(rowcounter));
    		break;
    	
    	case R.id.repeatPlusButton:
    		repeatcounter++; 
			repeatText.setText(Integer.toString(repeatcounter));
    		break;
    	
    	case R.id.minusRepeatButton:
    		repeatcounter--;
			repeatText.setText(Integer.toString(repeatcounter));
    		break;
    	}
    }
    
}
    