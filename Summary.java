package com.example.coda1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Summary extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        button = (Button) findViewById(R.id.btnClose);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Summary.this, GoogleMap.class));


            }
        });



    }
}