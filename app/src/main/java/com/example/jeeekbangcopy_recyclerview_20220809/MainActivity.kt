package com.example.jeeekbangcopy_recyclerview_20220809

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.jeeekbangcopy_recyclerview_20220809.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // 멤버변수 binding 에 ActivityMainBinding 자료형을 넣을거라 선언
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
}