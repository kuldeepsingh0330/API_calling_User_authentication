package com.ransankul.apicalling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ransankul.apicalling.ModelResponse.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText formnumber , password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        formnumber = findViewById(R.id.etform);
        password = findViewById(R.id.etpassword);
        login = findViewById(R.id.btnlogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogin();
            }
        });


        Window window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.login));
    }

    private void userLogin() {
        String userformnumber=formnumber.getText().toString();
        String userpassword=password.getText().toString();

        if (userformnumber.isEmpty()){
            formnumber.requestFocus();
            formnumber.setError("Please enter your form number");
            return;
        }
        if (userpassword.isEmpty()) {
            password.requestFocus();
            password.setError("please enter your password");
            return;
        }

        Call<LoginResponse> call = RetrofitClient.getInstance().getApi().login(userformnumber,userpassword);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse=response.body();
                if (response.isSuccessful()) {

                    if (loginResponse.getError().equals("200")) {

                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        Toast.makeText(LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(LoginActivity.this, "check your details and try again", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

                Log.d("jjjj",t.getMessage());
                Toast.makeText(LoginActivity.this, t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });


    }
}