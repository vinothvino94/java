package com.example.mydemoapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText editText;
Button button;
TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.edittext);
        button=findViewById(R.id.button);
        textView=findViewById(R.id.textview);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getmarks();
                //generateVPattern();
            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length()==0){
                    textView.setVisibility(View.GONE);
                }else {
                    textView.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    private void getmarks() {
        String marksinput=editText.getText().toString();
        if (marksinput.isEmpty()){
            textView.setText("Please Enter Marks");
            return;
        }
        int mark = Integer.parseInt(marksinput);
        String grade=(mark >= 90)?"Grade A":
                (mark >= 80)?"Grade B":
                (mark >= 70)?"Grade C":
                (mark >= 60)?"Grade D":
                (mark >= 35)?"Grade E": "Grade U";
        String result = (mark >= 35) ? "Pass" : "Fail";
        textView.setText(grade);
        toastmethod(result,grade);
    }
    private void toastmethod(String result,String grade) {
        Toast.makeText(this, "Result: " + result + ", " + grade, Toast.LENGTH_SHORT).show();
    }

    private void generateVPattern() {
        String input = editText.getText().toString();
        if (input.isEmpty()) {
            textView.setText("Please enter a number for rows.");
            return;
        }

        int rows;
        try {
            rows = Integer.parseInt(input); // Parse the number of rows from input
        } catch (NumberFormatException e) {
            textView.setText("Invalid input. Please enter a valid number.");
            return;
        }

        if (rows <= 0) {
            textView.setText("Please enter a positive number.");
            return;
        }

        // Generate the "V" pattern
        StringBuilder pattern = new StringBuilder();
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= (rows * 2 - 1); j++) {
                if (j == i || j == (rows * 2 - i)) {
                    pattern.append("*");
                } else {
                    pattern.append(" ");
                }
            }
            pattern.append("\n");
        }
        // Display the pattern in the TextView
        textView.setText(pattern.toString());
    }
}

 /*if (mark >= 90){
            textView.setText("Grade A");
            toastmethod("Pass","Grade A");
        } else if (mark >= 80) {
            textView.setText("Grade B");
            toastmethod("Pass","Grade B");
        } else if (mark >= 70) {
            textView.setText("Grade C");
            toastmethod("Pass","Grade C");
        } else if (mark >= 60) {
            textView.setText("Grade D");
            toastmethod("Pass","Grade D");
        } else if (mark >= 35) {
            textView.setText("Grade E");
            toastmethod("Pass","Grade E");
        }else {
            textView.setText("Grade U");
            toastmethod("Fail","Grade U");
        }*/