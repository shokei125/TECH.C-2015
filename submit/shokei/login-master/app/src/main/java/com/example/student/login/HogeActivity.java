package com.example.student.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.student.login.util.Preference;
import com.example.student.login.util.User;


public class HogeActivity extends ActionBarActivity {

    private Button mButton;
    private TextView mTextMessage;
    private TextView mTextView;
    private EditText mEditText1;
    private EditText mEditText2;
    private EditText mEditText3;
    private EditText mEditText4;
    private EditText mEditText5;
    private EditText mEditText6;
    private EditText mEditText7;
    private EditText mEditText8;
    private User user = new User();
    private User newUser = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoge);

        final Preference pf = new Preference();
        final String loginPassword = pf.getLoginPassword(getApplicationContext());

        mButton = (Button) findViewById(R.id.changeBtn);
        mTextView = (TextView) findViewById(R.id.textView);
        mTextMessage = (TextView) findViewById(R.id.textMessage);
        mEditText1 = (EditText) findViewById(R.id.editText1);
        mEditText2 = (EditText) findViewById(R.id.editText2);
        mEditText3 = (EditText) findViewById(R.id.editText3);
        mEditText4 = (EditText) findViewById(R.id.editText4);
        mEditText5 = (EditText) findViewById(R.id.editText5);
        mEditText6 = (EditText) findViewById(R.id.editText6);
        mEditText7 = (EditText) findViewById(R.id.editText7);
        mEditText8 = (EditText) findViewById(R.id.editText8);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (kara_check(mEditText1) && kara_check(mEditText2) && kara_check(mEditText3)
                    && kara_check(mEditText4) && kara_check(mEditText5) && kara_check(mEditText6)
                    && kara_check(mEditText7) && kara_check(mEditText8)) {
                    user.set_pwd(Integer.parseInt(String.valueOf(mEditText1.getText())));
                    user.set_pwd(Integer.parseInt(String.valueOf(mEditText2.getText())));
                    user.set_pwd(Integer.parseInt(String.valueOf(mEditText3.getText())));
                    user.set_pwd(Integer.parseInt(String.valueOf(mEditText4.getText())));
                    newUser.set_pwd(Integer.parseInt(String.valueOf(mEditText5.getText())));
                    newUser.set_pwd(Integer.parseInt(String.valueOf(mEditText6.getText())));
                    newUser.set_pwd(Integer.parseInt(String.valueOf(mEditText7.getText())));
                    newUser.set_pwd(Integer.parseInt(String.valueOf(mEditText8.getText())));
                    showToast(loginPassword);
                    showToast(user.get_pwd());
                    showToast(newUser.get_pwd());
                    if (loginPassword.equals(user.get_pwd())) {
                        pf.putLoginPassword(getApplicationContext(), newUser.get_pwd());
                        showToast(newUser.get_pwd() + "設定しました。");
                        Intent intent = new Intent(HogeActivity.this,MainActivity.class);
                        startActivity(intent);
                    } else {
                        reset_input();
                    }
                }


            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hoge, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void reset_input() {
        mEditText1.setText("");
        mEditText2.setText("");
        mEditText3.setText("");
        mEditText4.setText("");
        mEditText5.setText("");
        mEditText6.setText("");
        mEditText7.setText("");
        mEditText8.setText("");
        mTextMessage.setText("入力エラーだよ");
        user.reset_pwd();
    }


    public boolean kara_check(EditText editText) {
        if (editText.getText().toString().equals("")) {
            return false;
        }
        return true;
    }

    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
