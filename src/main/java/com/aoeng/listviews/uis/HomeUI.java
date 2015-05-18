package com.aoeng.listviews.uis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.aoeng.listviews.R;


public class HomeUI extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_ui);

        findViewById(R.id.btnNormal).setOnClickListener(this);
        findViewById(R.id.btnLoardMore).setOnClickListener(this);
        findViewById(R.id.btnRefresh).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_ui, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {

            case R.id.btnNormal:
                intent = new Intent(this, NormalLvUI.class);
                break;
            case R.id.btnLoardMore:
                intent = new Intent(this, LoadMoreUI.class);
                break;
            case R.id.btnRefresh:
                intent = new Intent(this, ReflushLvUI.class);
                break;
        }
        if (null != intent) {
            startActivity(intent);
        }
    }
}
