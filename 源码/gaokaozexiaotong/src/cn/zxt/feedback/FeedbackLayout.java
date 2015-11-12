package cn.zxt.feedback;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import cn.exmp1.jisuzexiaotong.R;

public class FeedbackLayout extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback_layout);
        
        Button bt1 = (Button) findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            public Toast makeText (Context context, CharSequence text, int duration){
    			return null;
            	}
			
			public void onClick(View view) {
				Toast.makeText(FeedbackLayout.this, "¸ÐÐ»ÄúµÄ·´À¡", Toast.LENGTH_SHORT).show();        
			}
			});
		}}


