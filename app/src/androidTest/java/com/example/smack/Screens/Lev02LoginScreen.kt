package com.example.smack.Screens

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions.*
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

    fun enterLoginEmail(emailTxt: String) {
        loginEmailTxt.perform(replaceText(emailTxt), closeSoftKeyboard())
    }

    private val loginPasswordTxt = onView(
        allOf(
            withId(R.id.loginPasswordTxt),
            isDisplayed()
        )
    )

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

    fun tapLoginSubmitBtn(): Lev03MainActivityScreen {
        loginScreenLoginBtn.perform(click())
        return Lev03MainActivityScreen()
    }

    fun loginResult(result: Boolean = App.prefs.isLoggedIn): Boolean {
        return !result
    }

    private val loginScreenSignUpHereBtn = Espresso.onView(
        Matchers.allOf(
            withId(R.id.loginCreateUserBtn), withText("Sign Up Here"),
            isDisplayed()
        )
    )
    fun tapSignUpHereBtn(): Lev03SignUpScreen {
        loginScreenSignUpHereBtn.perform(click())
        return Lev03SignUpScreen()
    }
}