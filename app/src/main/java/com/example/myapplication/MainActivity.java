package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button[] przycisk = new Button[12];
    TextView komunikat;
    TextView komunikat2;
    int counter =0;
    int wylosowanePrzyciski;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });
        przycisk[0] = findViewById(R.id.btn1);
        przycisk[1] = findViewById(R.id.btn2);
        przycisk[2] = findViewById(R.id.btn3);
        przycisk[3] = findViewById(R.id.btn4);
        przycisk[4] = findViewById(R.id.btn5);
        przycisk[5] = findViewById(R.id.btn6);
        przycisk[6] = findViewById(R.id.btn7);
        przycisk[7] = findViewById(R.id.btn8);
        przycisk[8] = findViewById(R.id.btn9);
        przycisk[9] = findViewById(R.id.btn10);
        przycisk[10] = findViewById(R.id.btn11);
        przycisk[11] = findViewById(R.id.btn12);
komunikat = findViewById(R.id.textV1);
komunikat2 = findViewById(R.id.textView5);
        Random random = new Random();
        wylosowanePrzyciski = random.nextInt(12);
        for (int i = 0; i < 12; i++) {
            final int number = i;
            int j =i;
            przycisk[i].setOnClickListener(
                    view -> {

                        if (number == wylosowanePrzyciski) {
                            przycisk[number].setBackgroundColor(Color.GREEN);

                           komunikat.setText("Dobrze! zgadłeś");
                           counter++;
                            komunikat2.setText("Liczba prob: "+counter);

                        } else {
                            przycisk[number].setBackgroundColor(Color.RED);
                           komunikat.setText("zle!");
                            counter++;
                            komunikat2.setText("Liczba prob: "+counter);

                        }
                        if (j<wylosowanePrzyciski) {
                            przycisk[number].setText(j+1 +"< liczba");
                        } else if (j>wylosowanePrzyciski) {
                            przycisk[number].setText(j+1 +"> liczba");
                        }
                       przycisk[number].setEnabled(false);
                       przycisk[number].setTextColor(Color.WHITE);

                    }


            );




        }

    }
}
