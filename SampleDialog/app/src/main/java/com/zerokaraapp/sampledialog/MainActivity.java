package com.zerokaraapp.sampledialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity

        implements SampleDialogFragment.NoticeDialogListener

{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new ButtonClickListener());
    }

    private class ButtonClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view){
            //ダイアログフラグメントのオブジェクトを生成
            SampleDialogFragment dialogFragment = new SampleDialogFragment();
            //ダイアログの表示
            dialogFragment.show(getSupportFragmentManager(),"SampleDialogFragment");
        }

    }

    //ダイアログでボタンが押されたときに動作するコールバック関数を定義
    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        //OKメッセージの格納
        String message = getString(R.string.comment_ok);
        TextView textView = findViewById(R.id.textView);
        //TextViewにメッセージを設定
        textView.setText(message);
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        //Cancelメッセージの格納
        String message = getString(R.string.comment_cancel);
        TextView textView = findViewById(R.id.textView);
        //TextViewにメッセージを設定
        textView.setText(message);
    }

    @Override
    public void onDialogNeutralClick(DialogFragment dialog) {
        //Neutralメッセージの格納
        String message = getString(R.string.comment_neutral);
        TextView textView = findViewById(R.id.textView);
        //TextViewにメッセージを設定
        textView.setText(message);
    }

}