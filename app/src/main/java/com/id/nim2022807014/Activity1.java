package com.id.nim2022807014;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

public class Activity1 extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        // Elemen UI
        editTextUsername = findViewById(R.id.editTextText2);
        editTextPassword = findViewById(R.id.editTextText);
        buttonLogin = findViewById(R.id.button);

        // Menambahkan onClickListener pada tombol Login
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Mendapatkan nilai dari EditText
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                // Memeriksa username dan password
                if (username.equals("admin") && password.equals("123456")) {
                    // Jika benar, pindah ke Activity berikutnya
                    Intent intent = new Intent(Activity1.this, Activity2.class);
                    startActivity(intent);
                    Toast.makeText(Activity1.this, "Login berhasil", Toast.LENGTH_SHORT).show();
                } else {
                    // Jika salah, tampilkan pesan kesalahan
                    Toast.makeText(Activity1.this, "Username/password tidak dikenal", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}