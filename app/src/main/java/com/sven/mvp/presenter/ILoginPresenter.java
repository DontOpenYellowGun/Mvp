package com.sven.mvp.presenter;

/**
 * Created by Sven on 2016/9/12 0012.
 */

public interface ILoginPresenter {
    void login(String name, String passwd);
    void clear();
}
