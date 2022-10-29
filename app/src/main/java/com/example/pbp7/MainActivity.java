package com.example.pbp7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvResult;
    private EditText etWidth;
    private EditText etLength;
    private EditText etHeight;
    private final String KEY_RESULT = "key_result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tv_result);
        etWidth = findViewById(R.id.et_width);
        etLength = findViewById(R.id.et_length);
        etHeight = findViewById(R.id.et_height);
        Button btnCalculate_volume = findViewById(R.id.btn_calculate_volume);
        Button btnCalculate_area = findViewById(R.id.btn_calculate_area);
        Button btnCalculate_perimeter = findViewById(R.id.btn_calculate_perimeter);

        btnCalculate_volume.setOnClickListener(this);
        btnCalculate_area.setOnClickListener(this);
        btnCalculate_perimeter.setOnClickListener(this);

        if (savedInstanceState != null) {
            String result = savedInstanceState.getString(KEY_RESULT);
            tvResult.setText(result);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_calculate_volume) {
            // Ambil nilai yang diberikan pengguna pada seluruh EditText
            String inputLength = etLength.getText().toString().trim();
            String inputWidth = etWidth.getText().toString().trim();
            String inputHeight = etHeight.getText().toString().trim();

            boolean isEmptyFields = false;
            if (inputLength.isEmpty()) {
                isEmptyFields = true;
                etLength.setError("Field ini tidak boleh kosong");
            }
            if (inputWidth.isEmpty()) {
                isEmptyFields = true;
                etWidth.setError("Field ini tidak boleh kosong");
            }
            if (inputHeight.isEmpty()) {
                isEmptyFields = true;
                etHeight.setError("Field ini tidak boleh kosong");
            }
            if (!isEmptyFields) {
                // Hitung volume balok
                double volume = Double.parseDouble(inputLength) *
                        Double.parseDouble(inputWidth) *
                        Double.parseDouble(inputHeight);

                // Tampilkan hasil perhitungan ke TextView -> tvResult
                tvResult.setText(String.format("Volume: %s",
                        volume));
            }
        }
        if (view.getId() == R.id.btn_calculate_area) {
            // Ambil nilai yang diberikan pengguna pada seluruh EditText
            String inputLength = etLength.getText().toString().trim();
            String inputWidth = etWidth.getText().toString().trim();
            String inputHeight = etHeight.getText().toString().trim();

            boolean isEmptyFields = false;
            if (inputLength.isEmpty()) {
                isEmptyFields = true;
                etLength.setError("Field ini tidak boleh kosong");
            }
            if (inputWidth.isEmpty()) {
                isEmptyFields = true;
                etWidth.setError("Field ini tidak boleh kosong");
            }
            if (inputHeight.isEmpty()) {
                isEmptyFields = true;
                etHeight.setError("Field ini tidak boleh kosong");
            }
            if (!isEmptyFields) {
                // Hitung luas permukaan balok
                double area = 2 * ((Double.parseDouble(inputLength) *
                        Double.parseDouble(inputWidth)) +
                        (Double.parseDouble(inputLength) *
                        Double.parseDouble(inputHeight)) +
                        (Double.parseDouble(inputWidth) *
                        Double.parseDouble(inputHeight)));

                // Tampilkan hasil perhitungan ke TextView -> tvResult
                tvResult.setText(String.format("Luas: %s",
                        area));
            }
        }
        if (view.getId() == R.id.btn_calculate_perimeter) {
            // Ambil nilai yang diberikan pengguna pada seluruh EditText
            String inputLength = etLength.getText().toString().trim();
            String inputWidth = etWidth.getText().toString().trim();
            String inputHeight = etHeight.getText().toString().trim();

            boolean isEmptyFields = false;
            if (inputLength.isEmpty()) {
                isEmptyFields = true;
                etLength.setError("Field ini tidak boleh kosong");
            }
            if (inputWidth.isEmpty()) {
                isEmptyFields = true;
                etWidth.setError("Field ini tidak boleh kosong");
            }
            if (inputHeight.isEmpty()) {
                isEmptyFields = true;
                etHeight.setError("Field ini tidak boleh kosong");
            }
            if (!isEmptyFields) {
                // Hitung keliling balok
                double perimeter = 4 * (Double.parseDouble(inputLength) +
                        Double.parseDouble(inputWidth) +
                        Double.parseDouble(inputHeight));

                // Tampilkan hasil perhitungan ke TextView -> tvResult
                tvResult.setText(String.format("Keliling: %s",
                        perimeter));
            }
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String calculationResult = tvResult.getText().toString();
        outState.putString(KEY_RESULT, calculationResult);
    }
}