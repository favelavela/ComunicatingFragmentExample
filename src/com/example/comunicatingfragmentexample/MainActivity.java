package com.example.comunicatingfragmentexample;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.comunicatingfragmentexample.SampleFragment.SampleListener;
import com.example.simplefragmentexample.R;

public class MainActivity extends FragmentActivity implements SampleListener  {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void onButtonClick(int fontsize, String text) {
		TextFragment textFragment = (TextFragment) getSupportFragmentManager().findFragmentById(R.id.text_fragment);		
		textFragment.changeTextProperties(fontsize, text);

	}

}
