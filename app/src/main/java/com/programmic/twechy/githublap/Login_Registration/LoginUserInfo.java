package com.programmic.twechy.githublap.Login_Registration;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.programmic.twechy.githublap.Login_Registration.register.register_model.RegisterImpl;
import com.programmic.twechy.githublap.Login_Registration.register.register_presenter.RegisterPresenter;
import com.programmic.twechy.githublap.Login_Registration.register.register_view.RegisterView;
import com.programmic.twechy.githublap.R;


import java.io.ByteArrayOutputStream;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginUserInfo extends AppCompatActivity implements RegisterView {

    private static final int IMG_REQUEST = 777;
    @BindView(R.id.regName)
    EditText name;
    @BindView(R.id.regLastName)
    EditText lastName;
    @BindView(R.id.regAge)
    EditText age;
    @BindView(R.id.regMobile)
    EditText mobile;
    @BindView(R.id.regEmail)
    EditText email;
    @BindView(R.id.regJob)
    EditText job;
    @BindView(R.id.userImage)
    ImageView userImage;
    String userName, password, nameTx = "", lastNameTx = "", ageTx = "", mobileTx = "", emailTx = "", jobTx = "";
    RegisterPresenter presenter;
    private Bitmap bitmap;

    @OnClick(R.id.saveUserData)
    public void onViewClicked2() {

        nameTx = name.getText().toString();
        lastNameTx = lastName.getText().toString();
        ageTx = age.getText().toString();
        mobileTx = mobile.getText().toString();
        emailTx = email.getText().toString();
        jobTx = job.getText().toString();
        String image;
        String date = "2/2/2018";




        if (!byteImageToString().isEmpty()) {

            image = byteImageToString();

            presenter.registerUserDataWithImage(userName, password, nameTx, lastNameTx,
                    ageTx, mobileTx, emailTx, jobTx, nameTx, image, date);
        } else {

            presenter.registerUserData(userName, password, nameTx, lastNameTx,
                    ageTx, mobileTx, emailTx, jobTx, date);
        }


    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        userName = intent.getStringExtra("userName");
        password = intent.getStringExtra("password");

        presenter = new RegisterImpl(LoginUserInfo.this);


    }

    private void selectImage() {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, IMG_REQUEST);
    }

    private String byteImageToString() {

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);

        byte[] imgToByte = stream.toByteArray();
        return Base64.encodeToString(imgToByte, Base64.DEFAULT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == IMG_REQUEST && resultCode == RESULT_OK && data != null) {

            Uri path = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), path);
                //Glide.with(getApplicationContext()).load(bitmap).into(userImage);
                userImage.setImageBitmap(bitmap);

                //image.setVisibility(View.VISIBLE);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @OnClick(R.id.userImage)
    public void onViewClicked() {

        selectImage();

    }

    @Override
    public void registerSuccess() {
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void registerError() {
        Toast.makeText(this, "Failure", Toast.LENGTH_SHORT).show();
    }


}
