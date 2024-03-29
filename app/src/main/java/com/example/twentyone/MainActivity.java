package com.example.twentyone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    Button start, hit, stand;
    boolean b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv);
        start = findViewById(R.id.button);

        hit = findViewById(R.id.hitBtn);
        stand = findViewById(R.id.standBtn);

        stand.setVisibility(View.INVISIBLE);
        hit.setVisibility(View.INVISIBLE);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Game game = new Game();
                textView.setText("");
                game.startRound(textView);
                stand.setVisibility(View.VISIBLE);
                hit.setVisibility(View.VISIBLE);

                hit.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        game.makeDecision(textView, true);
                        if (game.isGameOver()) {
                            game.endRound(textView);
                            stand.setVisibility(View.INVISIBLE);
                            hit.setVisibility(View.INVISIBLE);
                        }
                    }
                });
                stand.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        game.makeDecision(textView, false);
                        if (game.isGameOver()) {
                            game.endRound(textView);
                            stand.setVisibility(View.INVISIBLE);
                            hit.setVisibility(View.INVISIBLE);
                        }
                    }
                });
            }
        });

     }
}