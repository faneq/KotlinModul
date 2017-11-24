package com.example.fanenqian.kotlinmodul

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main.setOnClickListener(View.OnClickListener {
            ARouter.getInstance().build("/test/1").navigation()
        })
    }
}
