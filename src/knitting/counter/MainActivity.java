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
	TextView textView1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countRows();
        countRepeats();
        clearButton();
    }
    
    public void countRows(){
    	Button button = (Button) findViewById(R.id.rowButton);
    	text = (TextView) findViewById(R.id.text);
    	button.setOnClickListener(new OnClickListener(){
    		
    		public void onClick(View v){
    			rowcounter++; 
    			text.setText("You're on row " + rowcounter);
    		}
    	});
    	
    }
    
    public void countRepeats(){
    	Button button = (Button) findViewById(R.id.repeatButton);
    	textView1 = (TextView) findViewById(R.id.textView1);
    	button.setOnClickListener(new OnClickListener(){
    		
    		public void onClick(View v){
    			repeatcounter++; 
    			textView1.setText("You're on repeat " + repeatcounter);
    		}
    	});
    }
    
    public void clearButton(){
    	Button button = (Button) findViewById(R.id.clearButton);
    	button.setOnClickListener(new OnClickListener(){
    		
    		public void onClick(View v){
    			repeatcounter = 0;
    			rowcounter = 0;
    			textView1.setText("You're on repeat " + repeatcounter);
    			text.setText("You're on row " + rowcounter);
    		
    		}
    	});
    }
    
}
