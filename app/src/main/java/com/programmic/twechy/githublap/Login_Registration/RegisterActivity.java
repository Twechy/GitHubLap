package com.programmic.twechy.githublap.Login_Registration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.programmic.twechy.githublap.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.regUserName) EditText regUserName;
    @BindView(R.id.regPassword) EditText regPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnUserData)
    public void goToUserData(){
        String name = regUserName.getText().toString();
        String pass = regPassword.getText().toString();

        Intent intent = new Intent(getApplicationContext(), LoginUserInfo.class);
        intent.putExtra("userName", name);
        intent.putExtra("password", pass);
        startActivity(intent);
    }

}
