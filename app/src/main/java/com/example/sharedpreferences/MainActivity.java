package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity {
    TextView tv;
    EditText et;
    int count;
    SharedPreferences settings;
    SharedPreferences settings2;
    int num;
    String str;
    Intent si;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textView);
        et = (EditText) findViewById(R.id.editTextTextPersonName);
        count = 0;
        str = "";
        num=0;
        settings2=getSharedPreferences("PREFS_NAME",MODE_PRIVATE);
        num=settings2.getInt("stayConnectint",0);
        str=settings2.getString("stayConnectstr","");
        si = new Intent(this,MainActivity2.class);
        count = num;
        tv.setText(Integer.toString(num));
        et.setText(str);
    }

    /**
     * Count.
     *
     * @param view the view
     */
    public void count(View view) {
        count++;
        tv.setText(Integer.toString(count));
    }

    /**
     * Reset.
     *
     * @param view the view
     */
    public void reset(View view) {
        count=0;
        tv.setText(Integer.toString(count));
    }

    /**
     * Exit.
     *
     * @param view the view
     */
    public void exit(View view) {
        String st = et.getText().toString();
        settings=getSharedPreferences("PREFS_NAME",MODE_PRIVATE);
        SharedPreferences.Editor editor=settings.edit();
        editor.putString("stayConnectstr",st);
        editor.putInt("stayConnectint",count);
        editor.commit();
        finish();
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem){
        String st = menuItem.getTitle().toString();
        if(st.equals("credits")){
            startActivity(si);
        }
        return true;
    }
}