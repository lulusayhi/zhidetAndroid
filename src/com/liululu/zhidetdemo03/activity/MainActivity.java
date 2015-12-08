package com.liululu.zhidetdemo03.activity;

import com.liululu.zhidetdemo03.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings.LayoutAlgorithm;

public class MainActivity extends Activity {

	private String url;
	private WebView wv;
	
	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		wv = (WebView) findViewById(R.id.detail_wv);
		
		Intent intent = getIntent();
		url = intent.getStringExtra("url");
		
		
					wv.loadUrl(url);
					WebChromeClient wvcc = new WebChromeClient() {
						public void onReceivedTitle(WebView view, String title) {
							super.onReceivedTitle(view, title);
//							tv.setText(title);
						}
					};
					wv.setWebChromeClient(wvcc);
					wv.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
					wv.getSettings().setUseWideViewPort(true);
					wv.getSettings().setLoadWithOverviewMode(true);

					wv.getSettings().setJavaScriptEnabled(true);
					
					wv.setWebViewClient(new WebViewClient() {
						public boolean shouldOverrideUrlLoading(WebView view, String url) {
							view.loadUrl(url);
							return true;
						}
					});
		
		
		
		
	}
	
	
	public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && wv.canGoBack()) {
        	wv.goBack();
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }
}
