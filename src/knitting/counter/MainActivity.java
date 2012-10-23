package knitting.counter;

import android.app.Activity;
import android.os.Bundle;
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
        countRowsUp();
        countRepeatsUp();
        clearButton();
        countRowsDown();
        countRepeatsDown();
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
