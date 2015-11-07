package cn.exmp1.fankui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import cn.exmp1.jisuzexiaotong.R;

public class FankuiLayout extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fankui_layout);
        
        Button bt1 = (Button) findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            public Toast makeText (Context context, CharSequence text, int duration){
    			return null;
            	}
			
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Toast.makeText(FankuiLayout.this, "¸ÐÐ»ÄúµÄ·´À¡", Toast.LENGTH_SHORT).show();        
			}
			});
		}}


