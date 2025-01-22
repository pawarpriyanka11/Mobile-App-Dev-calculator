package com.example.easycalci;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
public class MainActivity extends AppCompatActivity implements
View.OnClickListener {
 TextView resultTv, solutionTv;
 MaterialButton buttonC, buttonBrackOpen, buttonBrackClose;
 MaterialButton buttonDivide, buttonMultiply, buttonPlus, buttonMinus,
buttonEquals;
 MaterialButton button0, button1, button2, button3, button4, button5, button6,
button7, button8, button9;
 MaterialButton buttonAC, buttonDot;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 resultTv = findViewById(R.id.result_tv);
 solutionTv = findViewById(R.id.solution_tv);
 assignId(buttonC, R.id.button_c);
 assignId(buttonBrackOpen, R.id.button_open_bracket);
 assignId(buttonBrackClose, R.id.button_close_bracket);
 assignId(buttonDivide, R.id.button_divide);
 assignId(buttonMultiply, R.id.button_multiply);
 assignId(buttonPlus, R.id.button_add);
 assignId(buttonMinus, R.id.button_minus);
 assignId(buttonEquals, R.id.button_equal);
 assignId(button0, R.id.button_zero);
 assignId(button1, R.id.button_one);
 assignId(button2, R.id.button_two);
 assignId(button3, R.id.button_three);
14
 assignId(button4, R.id.button_four);
 assignId(button5, R.id.button_five);
 assignId(button6, R.id.button_six);
 assignId(button7, R.id.button_seven);
 assignId(button8, R.id.button_eight);
 assignId(button9, R.id.button_nine);
 assignId(buttonC, R.id.button_c);
 assignId(buttonAC, R.id.button_ac);
 assignId(buttonDot, R.id.button_dot);
 }
 void assignId(MaterialButton btn, int id) {
 btn = findViewById(id);
 btn.setOnClickListener(this);
 }
 @Override
 public void onClick(View view) {
 MaterialButton button = (MaterialButton) view;
 String buttonText = button.getText().toString();
 String dataToCalculate = solutionTv.getText().toString();
 if (buttonText.equals("AC")) {
 solutionTv.setText("");
 resultTv.setText("0");
 } else if (buttonText.equals("=")) {
 String result = getResult(dataToCalculate);
 resultTv.setText(result);
 solutionTv.setText("");
 } else if (buttonText.equals("C")) {
 if (!dataToCalculate.isEmpty()) {
 dataToCalculate = dataToCalculate.substring(0, dataToCalculate.length() -
1);
 solutionTv.setText(dataToCalculate);
 }
 } else {
 if (dataToCalculate.equals("0")) {
15
 // If current text is "0", replace it with the new input
 solutionTv.setText(buttonText);
 } else {
 dataToCalculate = dataToCalculate + buttonText;
 solutionTv.setText(dataToCalculate);
 }
 }
 }
 String getResult(String data) {
 try {
 // Split the input string by operators (+, -, *, /)
 String[] tokens = data.split("(?<=[-+*/])|(?=[-+*/])");
 double result = Double.parseDouble(tokens[0]); // Initialize result with the
first number
 // Iterate through the tokens and perform calculations
 for (int i = 1; i < tokens.length - 1; i += 2) {
 String operator = tokens[i];
 double operand = Double.parseDouble(tokens[i + 1]);
 switch (operator) {
 case "+":
 result += operand;
 break;
 case "-":
 result -= operand;
 break;
 case "*":
 result *= operand;
 break;
 case "/":
 if (operand != 0) {
 result /= operand;
 } else {
 return "Error: Division by zero";
 }
16
 break;
 }
 }
 // Return the result as a string
 return String.valueOf(result);
 } catch (Exception e) {
 // Handle any exceptions (e.g., invalid input)
 return "Error: Invalid input";
 }
 }
}
