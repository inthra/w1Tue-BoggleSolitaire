package com.epicodus.solitaireboggle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private Button mGenerateBoggleLettersButton;
    private TextView mShowLetters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGenerateBoggleLettersButton = (Button) findViewById(R.id.playBoggle);
        mShowLetters = (TextView) findViewById(R.id.showLetters);
        mGenerateBoggleLettersButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String setOfCharacters = "ABCDEFGHJKLMNOPQRSTUVWXYZ";
                String boggleLetters = "";
                int countVowels = 0;

                do {
                    boggleLetters = "";
                    for (int i = 0; i <= 7; i++) {
                        boggleLetters += setOfCharacters.charAt(new Random().nextInt(setOfCharacters.length()));
                    }
                    Log.d(TAG, boggleLetters);

                    countVowels = 0;
                    for (int i =0; i <= boggleLetters.length() - 1; i++) {
                        char checkEachLetter = boggleLetters.charAt(i);
                        if (checkEachLetter == 'A' || checkEachLetter == 'E' || checkEachLetter == 'I' || checkEachLetter == 'O' || checkEachLetter == 'U') {
                            countVowels++;
                        }
                    }
                } while (countVowels < 2);

                mShowLetters.setText(boggleLetters);
            }
        });
    }
}
