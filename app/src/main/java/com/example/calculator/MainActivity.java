package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    //Declaring variable that could help to clean coding
    Button btnAdd,btnSub;
    EditText num1,num2;
    TextView tResult;
    //Parsing the text value to int. I used getNumberInstance to format the number from text value
    NumberFormat format = NumberFormat.getNumberInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //Instead of creating directly a view id i create their own variable above to easily find.
        btnAdd = findViewById(R.id.btAdd);
        btnSub = findViewById(R.id.btSub);
        num1 = findViewById(R.id.etNum1);
        num2 = findViewById(R.id.etNum2);
        tResult = findViewById(R.id.textView);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    //This is button for addition i create function that could easily to find same as below in subtraction
    public void ADDBUTTON(View view){
        int n1 = Integer.parseInt(String.valueOf(num1.getText()));
        int n2 = Integer.parseInt(String.valueOf(num2.getText()));
        int total = n1+n2;
        Toast.makeText(this, "We are happy because you get the total of "+total, Toast.LENGTH_SHORT).show();
        String addFormated = format.format(total);
        tResult.setText(addFormated);

    }
    //Subtraction function
    public void SUBTRABUTTON(View view){
        int n1 = Integer.parseInt(String.valueOf(num1.getText()));
        int n2 = Integer.parseInt(String.valueOf(num2.getText()));
        int total = n2-n1;
        String subFormated = format.format(total);
        tResult.setText(subFormated);
    }

    public void MULTIBUTTON(View view){
        int n1 = Integer.parseInt(String.valueOf(num1.getText()));
        int n2 = Integer.parseInt(String.valueOf(num2.getText()));
        int total = n2*n1;
        String subFormated = format.format(total);
        tResult.setText(subFormated);
    }

    public void DIVIBUTTON(View view){
        int n1 = Integer.parseInt(String.valueOf(num1.getText()));
        int n2 = Integer.parseInt(String.valueOf(num2.getText()));
        int total = n2/n1;
        String subFormated = format.format(total);
        tResult.setText(subFormated);
    }
}