package com.o7.resttuto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.o7.resttuto.pojomodel.RegResponse;
import com.o7.resttuto.retrofit.RestClient;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    EditText tname,temail,tpass;
    Button register,login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        tname=findViewById(R.id.name);
        tname=findViewById(R.id.name);
        temail=findViewById(R.id.email);
        tpass=findViewById(R.id.password);
        register=findViewById(R.id.register);
        login=findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=tname.getText().toString();
                String email=temail.getText().toString();
                String pass=tpass.getText().toString();
                registerData(name,email,pass);

            }
        });
    }

    public void registerData(String name,String email,String pass)
    {
        HashMap<String,String> map=new HashMap<>();
        map.put("name",name);
        map.put("email",email);
        map.put("pass",pass);

        RestClient.getApi().register(map).enqueue(new Callback<RegResponse>() {
            @Override
            public void onResponse(Call<RegResponse> call, Response<RegResponse> response) {
                if(response.code()==200)
                {
                    if(response.body().getResponse().equals("success"))
                    {
                        Toast.makeText(RegisterActivity.this, "registered", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(RegisterActivity.this, "not registered", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(RegisterActivity.this, "error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegResponse> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
