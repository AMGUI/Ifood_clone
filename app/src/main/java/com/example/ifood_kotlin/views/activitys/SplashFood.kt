package com.example.ifood_kotlin.views.activitys

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import com.example.ifood_kotlin.R
import com.example.ifood_kotlin.databinding.ActivitySplashFoodBinding

class SplashFood : AppCompatActivity() {
    private lateinit var binding:ActivitySplashFoodBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashFoodBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        val slideAnimation = AnimationUtils.loadAnimation(this, R.anim.slide)
        val textAnimation = AnimationUtils.loadAnimation(this, R.anim.slide)
        binding.imageViewCarinha.setImageResource(R.drawable.logo)
        binding.imageViewCarinha.startAnimation(slideAnimation)
        binding.textClone.setTextColor(Color.parseColor("#Ea1d2c"))
        Handler(Looper.getMainLooper()).postDelayed({
            binding.textClone.setTextColor(Color.WHITE)
            binding.textClone.startAnimation(textAnimation)
        },1510)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        },5000)

    }
}