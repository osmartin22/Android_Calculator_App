package com.ozmar.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editTextResult;
    EditText editTextInput;
    TextView textViewOperation;

    Double operand1 = null;
    Double operand2 = null;
    String pendingOperation = "=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextResult = (EditText) findViewById(R.id.editTextResult);
        editTextInput = (EditText) findViewById(R.id.editTextInput);
        textViewOperation = (TextView) findViewById(R.id.textViewOperation);

        Button button0 = (Button) findViewById(R.id.button0);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);
        Button buttonDecimal = (Button) findViewById(R.id.buttonDecimal);

        Button buttonEquals = (Button) findViewById(R.id.buttonEquals);
        Button buttonDivide = (Button) findViewById(R.id.buttonDivide);
        Button buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
        Button buttonSubtract = (Button) findViewById(R.id.buttonSubtract);
        Button buttonAdd = (Button) findViewById(R.id.buttonAdd);

        View.OnClickListener numberListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                editTextInput.append(b.getText().toString());
            }
        };

        button0.setOnClickListener(numberListener);
        button1.setOnClickListener(numberListener);
        button2.setOnClickListener(numberListener);
        button3.setOnClickListener(numberListener);
        button4.setOnClickListener(numberListener);
        button5.setOnClickListener(numberListener);
        button6.setOnClickListener(numberListener);
        button7.setOnClickListener(numberListener);
        button8.setOnClickListener(numberListener);
        button9.setOnClickListener(numberListener);
        buttonDecimal.setOnClickListener(numberListener);


        View.OnClickListener operationListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                String operation = b.getText().toString();
                String value = editTextInput.getText().toString();
                if(value.length() != 0) {
                    performOperation(value, operation);
                }

                pendingOperation = operation;
                textViewOperation.setText(pendingOperation);
            }
        };

        buttonEquals.setOnClickListener(operationListener);
        buttonDivide.setOnClickListener(operationListener);
        buttonMultiply.setOnClickListener(operationListener);
        buttonSubtract.setOnClickListener(operationListener);
        buttonAdd.setOnClickListener(operationListener);

    } // onCreate() end

    private void performOperation(String value, String operation) {
        textViewOperation.setText(operation);
    }
}
