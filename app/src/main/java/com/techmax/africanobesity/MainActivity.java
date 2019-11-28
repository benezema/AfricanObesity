package com.techmax.africanobesity;


import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
@Override
protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    myButtonListenerMethod();
    }

public void myButtonListenerMethod() {
    final Button button = findViewById(R.id.Calculate);
    button.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        try {
            InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            mgr.hideSoftInputFromWindow(button.getWindowToken(), 0);

            final EditText heightText = findViewById(R.id.height);
            String heightStr = heightText.getText().toString();
            double height = Double.parseDouble(heightStr);
            final EditText weightText = findViewById(R.id.weight);
            String weightStr = weightText.getText().toString();
            double weight = Double.parseDouble(weightStr);
            double BMI = (weight) / (height * height);
            DecimalFormat df = new DecimalFormat("#.##");
            double BMI_trimmed = Double.parseDouble(df.format(BMI));
            final TextView BMIResult = findViewById(R.id.BMIResult);
            BMIResult.setText(Double.toString(BMI_trimmed));

        String BMI_Cat;
        if (BMI < 15)
            BMI_Cat = "Very severely underweight";
        else if (BMI < 16)
            BMI_Cat = "Severely underweight";
        else if (BMI < 18.5)
            BMI_Cat = "Underweight";
        else if (BMI < 25)
            BMI_Cat = "Normal";
        else if (BMI < 30)
            BMI_Cat = "Overweight";
        else if (BMI < 35)
            BMI_Cat = "Obese Class 1 - Moderately Obese";
        else if (BMI < 40)
            BMI_Cat = "Obese Class 2 - Severely Obese";
        else
            BMI_Cat = "Obese Class 3 - Very Severely Obese";
        final TextView BMICategory = (TextView)
                findViewById(R.id.BMICategory);
        BMICategory.setText(BMI_Cat);

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Type a valid number", Toast.LENGTH_SHORT).show();
        }
      }
    });
  }
}

