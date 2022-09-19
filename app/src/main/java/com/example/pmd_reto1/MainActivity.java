package com.example.pmd_reto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pmd_reto1.calculator.Operations;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // we create the variables and we reference by ID.
    private Button button = null;
    private TextView text = null;
    private EditText userNumberString = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // we make every element visible.
        button = (Button) findViewById(R.id.checkButton);
        button.setOnClickListener(this);
        text = (TextView) findViewById(R.id.inputText);
        userNumberString = (EditText) findViewById(R.id.userTextNumber);
    }

    public void onClick(View pView) {
        String message;

        if (button.getText().equals("Check")) {
            // collect text on TextView
            String input =
                    userNumberString
                            .getText()
                                .toString();
            int check =
                    Operations
                            .isPrime(input);
            if (check == 0)
                message = "Yo is complex";
            else if (check == 1)
                message = "Yo is prime";
            else
                message = "Put a number ye cunt!";

            text.setText(message);
            userNumberString.setText("Yer number.");
            button.setText("Reset");
        }
        else if (button.getText().equals("Reset")) {
            button.setText("Check");
            text.setText("Input a prime number.");
        }




    }



}