package com.programmic.twechy.githublap.Login_Registration.register.register_presenter;

public interface RegisterPresenter {

    void registerUserData(
            String userName, String password,
            String name, String lastName,
            String age, String mobile,
            String email, String job,
            String date);

    void registerUserDataWithImage(
            String userName, String password,
            String name, String lastName,
            String age, String mobile,
            String email, String job,
            String title, String image,
            String date);

}
