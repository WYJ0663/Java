package com.example.AndroidAnt;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2015-08-07.
 */
public class AntTest {

    Context context;

    public AntTest(Context context) {
        this.context = context;
    }

    public void makeText() {
        Toast.makeText(context, "Ant 测试方法", Toast.LENGTH_SHORT).show();
    }
}