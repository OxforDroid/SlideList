package com.slide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
    }


    public void home_btn(View view) {
        startActivity(new Intent(Menu.this,
                MainActivity.class
        ));
    }

    public void dikie(View view) {
        startActivity(new Intent(Menu.this,
                Main2Activity.class
        ));
    }
}
