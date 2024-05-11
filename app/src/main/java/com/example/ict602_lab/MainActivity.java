package com.example.ict602_lab;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnCalculate, btnClear;
    //clear
    //change 2
    EditText etNumber1, etNumber2;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btnCalculate = findViewById(R.id.btnCalculate);
        etNumber1 = findViewById(R.id.etNumber1);
        etNumber2 = findViewById(R.id.etNumber2);
        btnClear = findViewById(R.id.btnClear);

        btnCalculate.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int selected = item.getItemId();

        if(selected == R.id.menuAbout) {
            Toast.makeText(this, "about clicked", Toast.LENGTH_SHORT).show();
            return true;
        } else if(selected == R.id.menuSettings) {
            Toast.makeText(this, "settings clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public void onClick(View view) {
        if (view == btnCalculate) {
            String number1 = etNumber1.getText().toString();
            String number2 = etNumber2.getText().toString();

            double num1, num2;
            double total = 0;
            try {
                num1 = Double.parseDouble(number1);
                num2 = Double.parseDouble(number2);
                total = num1 + num2;
            } catch (NumberFormatException nfe) {
                Toast.makeText(this, "Please enter numbers in the input field", Toast.LENGTH_SHORT).show();
            } catch (Exception exception) {
                Toast.makeText(this, "Please enter numbers in the input field - unspecific error", Toast.LENGTH_SHORT).show();
            }

            textView.setText("Total: " + total);
        } else if (view == btnClear) {
            etNumber1.setText(""); // Clearing number1 EditText
            etNumber2.setText(""); // Clearing number2 EditText
        }
    }
}