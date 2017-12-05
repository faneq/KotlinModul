package com.example.modul_main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.alibaba.android.arouter.facade.annotation.Route


@Route(path = "/test/1")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        findViewById<Button>(R.id.show).setOnClickListener(View.OnClickListener {
        })
    }
}

