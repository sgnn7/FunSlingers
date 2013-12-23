package com.redwrench.funslingers;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class GameActivity extends Activity {
	// private SurfaceView gameSurface;
	private TextView timerText;
	private int timeLeft;
	private TimerTask task;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_activity);

		findViewById(R.id.touch_view).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});

		// gameSurface = (SurfaceView) findViewById(R.id.game_surface);
		findViewById(R.id.game_view).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});

		timerText = (TextView) findViewById(R.id.timer);
	}

	@Override
	protected void onResume() {
		super.onResume();

		timeLeft = 10;
		timerText.setText("" + timeLeft);

		Timer timerTick = new Timer("countdown", true);
		task = new TimerTask() {
			@Override
			public void run() {
				timeLeft--;

				if (timeLeft == 0) {
					finish();
					task.cancel();
				}

				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						timerText.setText("" + timeLeft);
					}
				});
			}
		};
		timerTick.scheduleAtFixedRate(task, 1000, 1000);
	}

	@Override
	protected void onPause() {
		task.cancel();
		super.onPause();
	}
}
