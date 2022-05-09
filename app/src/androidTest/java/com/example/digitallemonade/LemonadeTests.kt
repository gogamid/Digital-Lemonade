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

  @Test
  fun test_drinking_juice_proceeds_to_restart_state(){
    onView(withId(R.id.imageButton)).perform(click())
    juiceLemon()
    onView(withId(R.id.imageButton)).perform(click())
    testState(R.string.click_to_start_again, R.drawable.lemon_restart)
  }

  @Test
  fun test_restarting_proceeds_to_pick_lemon_state(){
    onView(withId(R.id.imageButton)).perform(click())
    juiceLemon()
    onView(withId(R.id.imageButton)).perform(click())
    onView(withId(R.id.imageButton)).perform(click())
    testState(R.string.click_to_select_a_lemon, R.drawable.lemon_tree)
  }

}