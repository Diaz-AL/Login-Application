package com.id.nim2022807014;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.text.DecimalFormat;
import android.text.InputType;
import android.view.inputmethod.InputMethodManager;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    private EditText editTextNim;
    private EditText editTextNama;
    private EditText editTextSemester;
    private RadioGroup radioGroup;
    private RadioButton radioButtonPagi;
    private RadioButton radioButtonMalam;
    private EditText editTextTotalBiaya;
    private Button buttonHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        // Elemen UI
        editTextNim = findViewById(R.id.editTextText1);
        editTextNama = findViewById(R.id.editTextText2);
        editTextSemester = findViewById(R.id.editTextText3);
        radioGroup = findViewById(R.id.radioGroup);
        radioButtonPagi = findViewById(R.id.radioButton1);
        radioButtonMalam = findViewById(R.id.radioButton0);
        editTextTotalBiaya = findViewById(R.id.editTextText4);
        buttonHitung = findViewById(R.id.button);

        editTextNim.setInputType(InputType.TYPE_CLASS_NUMBER);
        editTextSemester.setInputType(InputType.TYPE_CLASS_NUMBER);
        showKeyboard(editTextNim);

        // Menambahkan onClickListener pada button Hitung
        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Mendapatkan nilai dari EditText dan RadioButton
                String nim = editTextNim.getText().toString();
                String nama = editTextNama.getText().toString();
                String semesterStr = editTextSemester.getText().toString();
                showKeyboard(editTextNim);

                if (!nim.isEmpty() && !nama.isEmpty() && !semesterStr.isEmpty()) {
                    int semester = Integer.parseInt(semesterStr);

                    // Memeriksa apakah Kelas dipilih
                    if (radioGroup.getCheckedRadioButtonId() == -1) {
                        // Kelas tidak dipilih
                        Toast.makeText(Activity2.this, "Kelas Harus Dipilih", Toast.LENGTH_SHORT).show();
                    } else {
                        // Kelas dipilih, lanjutkan perhitungan biaya
                        double biayaSemester = 0;

                        // Menentukan biaya berdasarkan semester
                        switch (semester) {
                            case 1:
                                biayaSemester = 5000000;
                                break;
                            case 2:
                                biayaSemester = 4750000;
                                break;
                            case 3:
                                biayaSemester = 4500000;
                                break;
                            case 4:
                                biayaSemester = 4250000;
                                break;
                            case 5:
                                biayaSemester = 4000000;
                                break;
                            case 6:
                                biayaSemester = 3375000;
                                break;
                            case 7:
                                biayaSemester = 3500000;
                                break;
                            case 8:
                                biayaSemester = 3250000;
                                break;
                        }

                        // Menentukan biaya perkuliahan berdasarkan kelas
                        double biayaPerkuliahan;
                        if (radioButtonPagi.isChecked()) {
                            biayaPerkuliahan = biayaSemester;
                        } else {
                            biayaPerkuliahan = biayaSemester * 1.25;
                        }

                        DecimalFormat decimalFormat = new DecimalFormat("#,###");
                        String formattedBiaya = decimalFormat.format(biayaPerkuliahan);

                        // Menampilkan hasil total biaya
                        editTextTotalBiaya.setText(formattedBiaya);
                    }
                } else {
                    // Jika ada field yang kosong
                    Toast.makeText(Activity2.this, "Semua field harus diisi", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void showKeyboard(EditText editText) {
        editText.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
    }
}