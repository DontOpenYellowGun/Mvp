package com.sven.mvp.presenter;

import android.os.Handler;
import android.os.Looper;

import com.sven.mvp.model.UserModel;
import com.sven.mvp.view.ILoginView;

/**
 * Created by Sven on 2016/9/12 0012.
 */

public class LoginPresenter implements ILoginPresenter {

    UserModel mUser;
    ILoginView iLoginView;
    Handler mHandler;

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        mHandler = new Handler(Looper.getMainLooper());
        mUser = new UserModel("name", "passWord");
    }

    @Override
    public void login(final String name, final String passwd) {
        final int failCode = 100;
        final int successCode = 200;
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (name.equals("sven") && passwd.equals("123456")) {
                    iLoginView.onLoginResult(true, successCode);
                } else {
                    iLoginView.onLoginResult(false, failCode);
                }
            }
        }, 3000);
    }

    @Override
    public void clear() {
        iLoginView.onClearText();
    }
}
