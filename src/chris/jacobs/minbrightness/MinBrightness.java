package chris.jacobs.minbrightness;

import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MinBrightness extends Activity {

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_min_brightness);
		
		try {
			String message = "echo 1 > /sys/devices/fd900000.qcom,mdss_mdp/qcom,mdss_fb_primary.164/leds/lcd-backlight/brightness";
			Process process = Runtime.getRuntime().exec(new String[] { "su", "-c", message});
			process.waitFor();
			
		} catch (IOException e1) {

		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
		android.os.Process.killProcess(android.os.Process.myPid());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.min_brightness, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
