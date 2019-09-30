package com.example.magicsquare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.*;
import android.content.Intent;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText jet;
    Button jbn;
    Bundle bdl;
    Intent itn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jet = (EditText) findViewById(R.id.xet);
        jbn = (Button) findViewById(R.id.xbn);
        jbn.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                itn = new Intent(MainActivity.this, SegundaActivity.class);
                bdl = new Bundle();
                bdl.putString("Numero", jet.getText().toString());
                itn.putExtras(bdl);
                startActivity(itn);
            }
        });
    }
}
