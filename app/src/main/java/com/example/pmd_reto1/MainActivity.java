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
        text = (TextView)
                findViewById(
                        R.id.inputText);
        userNumberString = (EditText)
                findViewById(
                        R.id.userTextNumber);
        button = (Button)
                findViewById(
                        R.id.checkButton);
        // turn on button.
        button.setOnClickListener(this);
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
            int result =
                    Operations
                            .isPrime(userInput),
                outputTextKey = 0;
            // change value depending on result.
            if (result == 0)
                outputTextKey = R.string.resultComposite;
            else if (result == 1)
                outputTextKey = R.string.resultPrime;
            else
                outputTextKey = R.string.errorNotNumber;

            // put the result on TextView.
            text.setText(
                    getString(outputTextKey));
            // change button text.
            button.setText(
                    buttonPressedText);
        }
        else if (button.getText().equals(buttonPressedText)) {
            text.setText(
                    getString(
                            R.string.intructions));
            button.setText(
                    buttonDefaultText);

            userNumberString.setText("");
        }
    }
}