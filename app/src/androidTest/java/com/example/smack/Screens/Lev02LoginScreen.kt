package com.example.smack.Screens

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.*
import com.example.smack.Controller.App
import com.example.smack.R
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matchers

class Lev02LoginScreen {

    private val loginEmailTxt = onView(
        allOf(
            withId(R.id.loginEmailTxt),
            isDisplayed()
        )
    )
    init {
        loginEmailTxt.check(matches(isDisplayed()))
    }
    fun enterLoginEmail(emailTxt: String){
        loginEmailTxt.perform(replaceText(emailTxt), closeSoftKeyboard())
    }

    private val loginPasswordTxt = onView(
        allOf(
            withId(R.id.loginPasswordTxt),
            isDisplayed()
        )
    )
    init {
        loginPasswordTxt.check(matches(isDisplayed()))
    }
    fun enterLoginPassword(passwordTxt: String): Lev02LoginScreen {
        loginPasswordTxt.perform(replaceText(passwordTxt), closeSoftKeyboard())
        return this
    }

    private val loginScreenLoginBtn: ViewInteraction = onView(
        allOf(
            withId(R.id.loginLoginBtn),
            withText("login"),
            isDisplayed()
        )
    )
    init {
        loginScreenLoginBtn.check(matches(isDisplayed()))
    }
    fun tapLoginSubmitBtn(): Lev03MainActivityScreen {
        loginScreenLoginBtn.perform(click())
        return Lev03MainActivityScreen()
    }

    fun loginResult(result: Boolean = App.prefs.isLoggedIn): Boolean {
        return !result
    }

    private val loginScreenSignUpHereBtn = Espresso.onView(
        Matchers.allOf(
            ViewMatchers.withId(R.id.loginCreateUserBtn), ViewMatchers.withText("Sign Up Here"),
//            childAtPosition(
//                childAtPosition(
//                    ViewMatchers.withId(android.R.id.content),
//                    0
//                ),
//                4
//            ),
            ViewMatchers.isDisplayed()
        )
    )
    fun tapSignUpHereBtn() : Lev03SignUpScreen {
        loginScreenSignUpHereBtn.perform(click())
        return Lev03SignUpScreen()
    }


}