package com.example.comunicatingfragmentexample;

import com.example.simplefragmentexample.R;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class SampleFragment extends Fragment implements OnSeekBarChangeListener {

	public View view;
	public int seekvalue = 10;
	public EditText edittext;
	public SeekBar seekbar;
	public Button button;

	SampleListener activityCallback;

	public interface SampleListener {
		public void onButtonClick(int position, String text);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			activityCallback = (SampleListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement SampleListener");
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, 
			ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout for this fragment

		view =  inflater.inflate(R.layout.sample_fragment_view, container, false);
		edittext = (EditText) view.findViewById(R.id.editText1);
		seekbar = (SeekBar) view.findViewById(R.id.seekBar1);
		seekbar.setOnSeekBarChangeListener(this);
		button = (Button) view.findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				buttonClicked(v);
			}
		});

		return view;
	}

	public void buttonClicked (View view) {
		activityCallback.onButtonClick(seekvalue, edittext.getText().toString());
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		seekvalue = progress;
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

}
