package com.example.smack.Screens

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.*
import com.example.smack.R
import com.example.smack.Tests.BaseTest
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matchers

class Lev03MainActivityScreen {
//    private val validUseName = BaseTest().validUserName
    val textView = onView(
        Matchers.allOf(
            withId(R.id.userNameNavHeader), withText("Olga"),
            isDisplayed()
        )
    )
//    Thread.sleep(1000)
//    textView.check(matches(withText("Olga")))
//    init {
//        textView.check(matches(isDisplayed()))
//    }
    fun validUserNameIsDisplayed(validUserName: String): Lev03MainActivityScreen{
        textView.check(matches(withText("Olga")))
        return this
    }

    private val navHeaderLogoutBtn = onView(
        allOf(
            withId(R.id.loginBtnNavHeader), withText("Logout"),
            isDisplayed()
        )
    )
//    init {
//        navHeaderLogoutBtn.check(matches(isDisplayed()))
//    }
    fun submitLogOut(){
        navHeaderLogoutBtn.perform(click())
    }



}