package com.redwrench.funslingers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MenuActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.menu_activity);

		Button playButton = (Button) this.findViewById(R.id.play_button);
		Button helpButton = (Button) this.findViewById(R.id.help_button);
		Button quitButton = (Button) this.findViewById(R.id.quit_button);

		playButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(view.getContext(),
						GameActivity.class);
				startActivity(intent);
			}
		});

		helpButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(view.getContext(),
						HelpActivity.class);
				startActivity(intent);
			}
		});

		quitButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				moveTaskToBack(true);
			}
		});
	}
}
