package com.example.digitallemonade

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
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

  @Test
  fun test_picking_lemon_proceeds_to_squeeze(){
    onView(withId(R.id.imageButton)).perform(click())
    testState(R.string.click_to_juice_a_lemon, R.drawable.lemon_squeeze)
  }

  @Test
  fun test_squeezing_proceeds_to_drink_state(){
    onView(withId(R.id.imageButton)).perform(click())
    juiceLemon()
    testState(R.string.click_to_drink_a_lemon, R.drawable.lemon_drink)
  }

}