package com.example.digitallemonade

import androidx.test.core.app.launchActivity
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class LemonadeTests : BaseTest() {

  @Before
  fun setup(){
    launchActivity<MainActivity>()
  }

  @Test
  fun test_initial_state(){
    testState(R.string.click_to_select_a_lemon, R.drawable.lemon_tree)
  }

}