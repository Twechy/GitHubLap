package com.programmic.twechy.githublap.Login_Registration;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.programmic.twechy.githublap.DrawerActivity;
import com.programmic.twechy.githublap.Login_Registration.login.login_model.loginImpl;
import com.programmic.twechy.githublap.Login_Registration.login.login_presenter.LoginPresenter;
import com.programmic.twechy.githublap.Login_Registration.login.login_view.LoginView;
import com.programmic.twechy.githublap.POJO_Models.Users.UserResponse;
import com.programmic.twechy.githublap.R;

import java.util.List;

import static com.programmic.twechy.githublap.Login_Registration.login.login_model.loginImpl.userResponses;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private static final String TAG = LoginActivity.class.getSimpleName();
    EditText userName, password;
    TextInputLayout loginName, loginPassword;
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginName = findViewById(R.id.login_input_userName);
        userName = findViewById(R.id.logUserName);
        loginPassword = findViewById(R.id.login_input_password);
        password = findViewById(R.id.logPassword);

        loginPresenter = new loginImpl(LoginActivity.this);

        Intent intent = getIntent();

        String nameTx = intent.getStringExtra("userName");
        String passwordTx = intent.getStringExtra("password");

        if (nameTx != null && passwordTx != null) {

            userName.setText(nameTx);
            password.setText(passwordTx);
        }

    }

    public void registerUser(View view) {
        startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
    }

    public void loginUser(View view) {

        String name = userName.getText().toString();
        final String pass = password.getText().toString();

        loginPresenter.preformLogin(name, pass);


    }

    @Override
    public void loginValidation() {
        Toast.makeText(this, "Please Enter your user name and password", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void loginSuccess() {
        Intent intent = new Intent(getApplicationContext(), DrawerActivity.class);
        List<UserResponse> userFromDb = userResponses;

        if (userFromDb != null) {

            Log.d("loginActivity", "user from db is: "+userFromDb.toString());

            for (int i = 0; i < userFromDb.size(); i++) {

                Log.d(TAG, "loginSuccess: user: "+userFromDb.toString());
                String BASE_API = "http://172.26.145.49:8080/twechy_app/users/";

                String userID = userFromDb.get(i).getUserID();

                intent.putExtra("id", userID);
                intent.putExtra("name", userFromDb.get(i).getName());
                intent.putExtra("lastName", userFromDb.get(i).getLastname());
                intent.putExtra("age", userFromDb.get(i).getAge());
                intent.putExtra("job", userFromDb.get(i).getJob());
                intent.putExtra("mobile", userFromDb.get(i).getMobile());
                intent.putExtra("email", userFromDb.get(i).getEmail());
                intent.putExtra("image_path", BASE_API+userFromDb.get(i).getPath());
                intent.putExtra("date", userFromDb.get(i).getDate());
            }
            startActivity(intent);
        } else {
            Log.d("userActivity1", "null");
        }
        Toast.makeText(this, "login successful", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginError() {
        Toast.makeText(this, "Login Failure", Toast.LENGTH_SHORT).show();
    }
}