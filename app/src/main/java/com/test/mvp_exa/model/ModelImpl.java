package com.test.mvp_exa.model;

import com.test.mvp_exa.presenter.ModelPresenter;
import com.test.mvp_exa.presenter.ViewPresenter;

public class ModelImpl implements ModelPresenter {

    ViewPresenter viewPresenter;

    public ModelImpl(ViewPresenter viewPresenter) {
        this.viewPresenter = viewPresenter;
    }

    @Override
    public void increaseCounter(int count) {
        count += 1;
        viewPresenter.setIncrement(count);
    }

    @Override
    public void decreaseCounter(int count) {
        count -= 1;
        viewPresenter.setDecrement(count);
    }
}
