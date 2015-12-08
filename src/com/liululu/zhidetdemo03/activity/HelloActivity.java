package com.liululu.zhidetdemo03.activity;

import com.liululu.zhidetdemo03.R;
import com.liululu.zhidetdemo03.utils.PathUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;

public class HelloActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hello);

		new Handler().postDelayed(new Runnable() {  
            public void run() {  
                Intent intent = new Intent(HelloActivity.this,  
                		MainActivity.class); 
                intent.putExtra("url", PathUtils.index);
                startActivity(intent);
                HelloActivity.this.finish();  
            }  
        }, 2000);

	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		return false;
	}

}
