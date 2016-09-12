package com.sven.mvp.view;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Toast;

import com.sven.mvp.R;
import com.sven.mvp.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    @BindView(R.id.editText)
    AppCompatEditText mEditName;
    @BindView(R.id.editText2)
    AppCompatEditText mEditPassWord;
    @BindView(R.id.button)
    AppCompatButton mBtnLogin;
    @BindView(R.id.button2)
    AppCompatButton mBtnClear;
    @BindView(R.id.activity_login)
    ConstraintLayout mRootView;

    LoginPresenter mLoginPre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mLoginPre = new LoginPresenter(this);
    }


    @OnClick({R.id.button, R.id.button2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                mLoginPre.login(mEditName.getText().toString(), mEditPassWord.getText().toString());
                break;
            case R.id.button2:
                mLoginPre.clear();
                break;
        }
    }

    @Override
    public void onClearText() {
        mEditName.setText("");
        mEditPassWord.setText("");
    }

    @Override
    public void onLoginResult(Boolean result, int code) {
        if (result) {
            Toast.makeText(this, "登陆成功!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "用户名或者密码错误~", Toast.LENGTH_SHORT).show();
        }
    }
}
