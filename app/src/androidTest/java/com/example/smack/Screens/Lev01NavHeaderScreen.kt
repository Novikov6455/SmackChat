package com.example.smack.Screens

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.*
import com.example.smack.R
import org.hamcrest.CoreMatchers.allOf

class Lev01NavHeaderScreen {

    private val navHeaderLoginBtn: ViewInteraction = onView(
        allOf(
            withId(R.id.loginBtnNavHeader),
            withText("Login"),
            isDisplayed()
        )
    )

    fun tapLogInBtn(): Lev02LoginScreen {
        navHeaderLoginBtn.perform(click())
        return Lev02LoginScreen()
    }
}