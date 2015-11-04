package com.example.gavin.testgitprj;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;

public class Main extends AppCompatActivity {


    private Button myButton;
    private Button myButton1;
    private Button myButton2;
    private Button myButton3;
    private PopupWindow myPopup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButton = (Button)findViewById(R.id.clickbutton);
        myButton1 = (Button)findViewById(R.id.button);
        myButton2 = (Button)findViewById(R.id.button2);
        myButton3 = (Button)findViewById(R.id.button3);
        LayoutInflater inflater = LayoutInflater.from(this);
        //引入窗口配置文件
        View myView = inflater.inflate(R.layout.popup_lay, null);
        //实例化popup窗口
        myPopup = new PopupWindow(myView, WindowManager.LayoutParams.WRAP_CONTENT,WindowManager.LayoutParams.WRAP_CONTENT,false);
        //点击非pop区域消失
        myPopup.setBackgroundDrawable(new BitmapDrawable());
        myPopup.setOutsideTouchable(true);
        myPopup.setFocusable(true);
        myButton.setOnClickListener(myClick);
        myButton1.setOnClickListener(myClick);
        myButton2.setOnClickListener(myClick);
        myButton3.setOnClickListener(myClick);
    }

    View.OnClickListener myClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(myPopup.isShowing()){
                myPopup.dismiss();
            }else{
                myPopup.showAsDropDown(v);
            }

        }
    };
}
