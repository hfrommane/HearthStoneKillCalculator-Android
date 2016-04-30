package com.fun.hearthstonekillcalculatorv20;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.fun.hearthstonekillcalculatorv20.fishmen.FishMenActivity;

public class MainActivity extends AppCompatActivity {

    private Button fishMen;
    private Button waiting;
    private Button noCards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fishMen = (Button) findViewById(R.id.fishMen);
        waiting = (Button) findViewById(R.id.waiting);
        noCards = (Button) findViewById(R.id.noCards);

        fishMen.setOnClickListener(new FishManOnClickListener());

        noCards.setOnClickListener(new NoCardsOnClickListener());

        waiting.setOnClickListener(new WaittingOnClickListener());
    }

    class FishManOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, FishMenActivity.class);
            startActivity(intent);
        }
    }

    class NoCardsOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "努力开发中。。。。", Toast.LENGTH_SHORT).show();
        }
    }

    class WaittingOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "期待中。。。。", Toast.LENGTH_SHORT).show();
        }
    }

}
