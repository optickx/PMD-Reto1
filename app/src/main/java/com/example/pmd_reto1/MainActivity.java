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
        // storing the two text values in the button.
        String
                buttonDefaultText =
                    getString(R.string.buttonDefault),
                buttonPressedText =
                        getString(R.string.buttonPressed);

        // check the state of the button
        if (button.getText().equals(buttonDefaultText)) {
            // store user input on string.
            String userInput =
                    userNumberString
                            .getText()
                                .toString();
            // save result of operation.
            int check =
                    Operations
                            .isPrime(userInput),
                key = 0;
            // change value depending on result.
            if (check == 0)
                key = R.string.resultComposite;
            else if (check == 1)
                key = R.string.resultPrime;
            else
                key = R.string.errorNotNumber;

            text.setText(
                    getString(key));
            userNumberString.setText(
                    getString(
                            R.string.userInputSample));
            button.setText(
                    buttonPressedText);
        }
        else if (button.getText().equals(buttonPressedText)) {
            button.setText(buttonDefaultText);
            text.setText(
                    getString(
                            R.string.intructions));
            userNumberString.setText("");
        }
    }
}