package com.example.digitallemonade

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
  enum class State {
    TREE, SQUEEZE, RESTART, DRINK
  }

  private lateinit var screenState: State
  private lateinit var imageView: ImageView
  private lateinit var textView: TextView
  private var squeezeCount: Int = 0

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    screenState = State.TREE
    imageView = findViewById(R.id.imageButton)
    textView = findViewById(R.id.textView)

    imageView.setOnClickListener {
      changeToNextScreen()
    }
  }

  private fun changeToNextScreen() {
    when (screenState) {
      State.TREE -> {
        imageView.setImageResource(R.drawable.lemon_squeeze)
        textView.text = getString(R.string.click_to_juice_a_lemon)
        screenState = State.SQUEEZE
        squeezeCount = (1..6).random()
      }
      State.SQUEEZE -> {
        if (squeezeCount == 0) {
          imageView.setImageResource(R.drawable.lemon_drink)
          textView.text = getString(R.string.click_to_drink_a_lemon)
          screenState = State.DRINK
        } else squeezeCount--
      }
      State.DRINK -> {
        imageView.setImageResource(R.drawable.lemon_restart)
        textView.text = getString(R.string.click_to_start_again)
        screenState = State.RESTART
      }
      State.RESTART -> {
        imageView.setImageResource(R.drawable.lemon_tree)
        textView.text = getString(R.string.click_to_select_a_lemon)
        screenState = State.TREE
      }
    }
  }
}