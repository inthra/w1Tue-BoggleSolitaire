package com.epicodus.solitaireboggle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Button mGenerateBoggleLettersButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGenerateBoggleLettersButton = (Button) findViewById(R.id.playBoggle);
        mGenerateBoggleLettersButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick() {
                String setOfCharacters = "ABCDEFGHJKLMNOPQRSTUVWXYZ";
                String boggleLetters = "";

                for (int i = 0; i <= 7; i++) {
                    boggleLetters += setOfCharacters.charAt(new Random().nextInt(setOfCharacters.length()));
                }
                log.d(TAG, boggleLetters);
            }
        });
    }
}
