package me.johnyu.converter;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class ConverterActivity extends ActionBarActivity implements SeekBar.OnSeekBarChangeListener{
    public double cTemp = getCelsius(32);
    public double fTemp = getFahrenheit(0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.converter_activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

//        SeekBar seekBar = (SeekBar)ConverterActivity.this.findViewById(R.id.seekBar);
//        seekBar.setOnSeekBarChangeListener(this);

        // Initialize celsius and fahrenheit text box
//        EditText celsiusBox = (EditText) findViewById(R.id.celsiusBox);
//        celsiusBox.setText("askj;saf");
//        EditText fahrenheitBox = (EditText) findViewById(R.id.fahrenheitBox);
//        fahrenheitBox.setText("asjd;jk;");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.converter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        fTemp = progress / 10.0;
        cTemp = getCelsius(fTemp);

        EditText celsiusBox = (EditText) findViewById(R.id.celsiusBox);
        celsiusBox.setText(Double.toString(cTemp));

        EditText fahrenheitBox = (EditText) findViewById(R.id.fahrenheitBox);
        fahrenheitBox.setText(Double.toString(fTemp));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.converter_fragment_main, container, false);
            return rootView;
        }
    }

    // Change the value in both celsius and fahrenheit text box when plus is pressed
    public void plusPressed(View view)
    {
        cTemp++;
        fTemp = getFahrenheit(cTemp);

        EditText celsiusBox = (EditText) findViewById(R.id.celsiusBox);
        celsiusBox.setText(Double.toString(cTemp));

        EditText fahrenheitBox = (EditText) findViewById(R.id.fahrenheitBox);
        fahrenheitBox.setText(Double.toString(fTemp));

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setProgress((int)fTemp*10);
    }

    // Change the value in both celsius and fahrenheit text box when minus is pressed
    public void minusPressed(View view)
    {
        cTemp--;
        fTemp = getFahrenheit(cTemp);

        EditText celsiusBox = (EditText) findViewById(R.id.celsiusBox);
        celsiusBox.setText(Double.toString(cTemp));

        EditText fahrenheitBox = (EditText) findViewById(R.id.fahrenheitBox);
        fahrenheitBox.setText(Double.toString(fTemp));

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setProgress((int) fTemp * 10);
    }

    // Calculate corresponding celsius value with given fahrenheit value
    public double getCelsius(double fahrenheit)
    {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }

    // Calculate corresponding fahrenheit value with given celsius value
    public double getFahrenheit(double celsius)
    {
        return celsius * 9.0 / 5.0 + 32;
    }

}
