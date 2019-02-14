package com.example.android.secondassigmentapp3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Takes the userid from the editext
                EditText editTextID = findViewById(R.id.editText);
                String userid = editTextID.getText().toString();

                //give to the Map Activity the userid so it can find the pins
                Intent intent = new Intent();
                intent.putExtra("userid",userid);
                intent.setClassName("com.example.android.secondassigmentapp3","com.example.android.secondassigmentapp3.MapsActivity");
                startActivity(intent);
            }
        });
    }
}
