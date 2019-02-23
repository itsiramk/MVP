package com.test.mvp_exa.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.test.mvp_exa.R;
import com.test.mvp_exa.model.ModelImpl;
import com.test.mvp_exa.presenter.ModelPresenter;
import com.test.mvp_exa.presenter.ViewPresenter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewPresenter {
    EditText et_count;
    Button btn_increment, btn_decrement;
    ModelPresenter modelPresenter;
    TextView tv_CountResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        modelPresenter = new ModelImpl(this);
    }
    public void init()
    {
        btn_decrement = findViewById(R.id.btn_decrement);
        btn_increment = findViewById(R.id.btn_increment);
        et_count = findViewById(R.id.et_count);
        tv_CountResult = findViewById(R.id.tv_CountResult);
        btn_increment.setOnClickListener(this);
        btn_decrement.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_increment:
                modelPresenter.increaseCounter(Integer.parseInt(et_count.getText().toString().trim()));
            break;

            case R.id.btn_decrement:
                modelPresenter.decreaseCounter(Integer.parseInt(et_count.getText().toString().trim()));
                break;
        }
    }

    @Override
    public void setIncrement(int count) {
        tv_CountResult.setText(count+"");
        et_count.setText(count+"");
    }

    @Override
    public void setDecrement(int count) {
        tv_CountResult.setText(count+"");
        et_count.setText(count+"");
    }
}
