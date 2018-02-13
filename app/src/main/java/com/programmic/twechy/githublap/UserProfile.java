package com.programmic.twechy.githublap;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserProfile extends AppCompatActivity {

    private static final String TAG = UserProfile.class.getSimpleName();
    String nameTx, lastNameTx, ageTx, jobTx, mobileTx, emailTx , imagePath, dateTx;

    int idTx;

    @BindView(R.id.profile_userName)
    TextView profileName;
    @BindView(R.id.profileEmail)
    TextView profileEmail;
    @BindView(R.id.profileMobile)
    TextView profileMobile;
    @BindView(R.id.profileJob)
    TextView profileJob;
    @BindView(R.id.user_profile_image)
    ImageView userProfileImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);
        ButterKnife.bind(this);

        Intent i = getIntent();
        idTx = i.getIntExtra("id",-1);
        nameTx = i.getStringExtra("name");
        lastNameTx = i.getStringExtra("lastName");
        ageTx = i.getStringExtra("age");
        jobTx = i.getStringExtra("job");
        mobileTx = i.getStringExtra("mobile");
        emailTx = i.getStringExtra("email");
        imagePath = i.getStringExtra("image_path");
        dateTx = i.getStringExtra("date");

        Log.d(TAG, "onCreate: imagePath is :"+imagePath);

        profileName.setText(String.format("%s %s", nameTx, lastNameTx));
        profileEmail.setText(emailTx);
        profileJob.setText(jobTx);
        profileMobile.setText(mobileTx);
        Picasso.with(UserProfile.this).load(imagePath).into(userProfileImage);


    }

    @OnClick(R.id.contextMenu)
    public void onViewClicked() {


    }
}
