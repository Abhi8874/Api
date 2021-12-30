package com.aws.apiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.aws.apiproject.model.SocialLoginModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private EditText nameEdt, jobEdt;
    private Button postDataBtn;
    private TextView responseTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEdt = findViewById(R.id.idEdtName);
        jobEdt = findViewById(R.id.idEdtJob);
        postDataBtn = findViewById(R.id.idBtnPost);
        responseTV = findViewById(R.id.idTVResponse);

        postDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nameEdt.getText().toString().isEmpty() && jobEdt.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter both the values", Toast.LENGTH_SHORT).show();
                    return;
                }


                loginAPI(nameEdt.getText().toString(), jobEdt.getText().toString());
            }
        });
    }

    private void loginAPI(String email, String aouth) {
        RetrofitAPI retrofitAPI = RetrofitClient.initRetrofit().create(RetrofitAPI.class);

        retrofitAPI.socialLogin(
                "" + email,
                "" + aouth
        ).enqueue(new Callback<SocialLoginModel>() {
            @Override
            public void onResponse(Call<SocialLoginModel> call, Response<SocialLoginModel> response) {
                if (response.code() == 200) {
                    //success
                    if (response.body() != null) {
                        if (response.body().getSuccess() != null) {
                            if (response.body().getSuccess()) {
                                Toast.makeText(MainActivity.this, "Login successful " + response.body().getData().getHello(), Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MainActivity.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                } else if (response.code() == 401) {
                    //logout
                } else {

                }
            }

            @Override
            public void onFailure(Call<SocialLoginModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "We have error", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "this is error in API = " + t.getMessage());
            }
        });
    }
}