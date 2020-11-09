package com.example.videorentering;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    EditText tbName;
    // EditText startdate;
    EditText tbaddress;
    EditText nic;
    Spinner age;
    CheckBox chackbox1;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private TextView startdate;
    private static final String TAG = "MainActivity";
    String NICPattern = "^[0-9]{11}[vVxX]$||^[0-9]{9}[vVxX]$";
    Button bsubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbName = (EditText) findViewById(R.id.tbName);
        startdate = (EditText) findViewById(R.id.startdate);
        tbaddress = (EditText) findViewById(R.id.tbaddress);
        nic = (EditText) findViewById(R.id.NIC);

        radioSexGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        bsubmit = (Button)  findViewById(R.id.bSubmit);
        bsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SubmitPage.class);
                startActivity(intent);
            }
        });

        startdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
               // dialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                dialog.show();
            }
        });


//        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//
//                month = month + 1;
//                String months = String.format("%02d", month);
//                String days = String.format("%02d", day);
//                Log.d(TAG, "onDateSet: yyyy/mm/dd: " + year + "-" + months + "-" + day);
//
//                String date = year + "-" + months + "-" + days;
//                startdate.setText(date);
//            }
//        };

        age = (Spinner) findViewById(R.id.Age);
        ArrayAdapter<CharSequence> spinner = ArrayAdapter.createFromResource(this, R.array.age, android.R.layout.simple_spinner_item);
        spinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        age.setAdapter(spinner);

//        if (nic.getText().toString().isEmpty()) {
//            Toast.makeText(getApplicationContext(), "enter NIC", Toast.LENGTH_SHORT).show();
//        } else {
//            if (nic.getText().toString().trim().matches(NICPattern)) {
//                Toast.makeText(getApplicationContext(), "valid NIC", Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(getApplicationContext(), "Invalid NIC", Toast.LENGTH_SHORT).show();
//            }

        }
    }

