package com.karome.homework42;

import static com.karome.homework42.LuckyTicketChecker.isLucky;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Сделано с помощью нейросетей и немного мозгов автора кода

    private EditText editText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        resultTextView = findViewById(R.id.resultTextView);
        Button checkButton = findViewById(R.id.checkButton);

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editText.getText().toString();
                if (input.isEmpty()) {
                    resultTextView.setText("Введите номер билета.");
                    return;
                }

                int number = Integer.parseInt(input);

                if (isLucky(number)) {
                    resultTextView.setText("Билет является счастливым по Питерской системе!");
                } else {
                    int nextLuckyNumber = findNextLuckyNumber(number + 1);
                    resultTextView.setText("Билет не является счастливым по Питерской системе.\n" +
                            "Следующий счастливый номер билета: " + nextLuckyNumber);
                }
            }
        });
    }


    private int findNextLuckyNumber(int number) {
        while (!isLucky(number)) {
            number++;
        }
        return number;
    }
}
