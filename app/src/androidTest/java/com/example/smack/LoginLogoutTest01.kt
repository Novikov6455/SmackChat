package com.example.smack


import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.smack.Controller.MainActivity
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Thread.sleep

@LargeTest
@RunWith(AndroidJUnit4::class)
class LoginLogoutTest01 {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)
    @Test
    fun loginLogoutBaseTest() {
        // tap toolbar button
        val toolbarBtn = onView(
            allOf(
                withContentDescription("Open navigation drawer"),
//                withId(R.id.toolbar),
                isDisplayed()
            )
        )
        toolbarBtn.perform(click())
        sleep(3000)

        // tap login button
        val navHeaderLoginBtn = onView(
            allOf(
                withId(R.id.loginBtnNavHeader), withText("Login"),
                isDisplayed()
            )
        )
        navHeaderLoginBtn.perform(click())
        sleep(1000)

        // type email address
        val loginEmailTxt = onView(
            allOf(
                withId(R.id.loginEmailTxt),
                isDisplayed()
            )
        )
        loginEmailTxt.perform(replaceText("o@o.com"), closeSoftKeyboard())

        // type password
        val loginPasswordTxt = onView(
            allOf(
                withId(R.id.loginPasswordTxt),
                isDisplayed()
            )
        )
        loginPasswordTxt.perform(replaceText("123456"), closeSoftKeyboard())

        // tap login button at Login Screen/layout
        val loginScreenLoginBtn = onView(
            allOf(
                withId(R.id.loginLoginBtn), withText("login"),
                isDisplayed()
            )
        )
        loginScreenLoginBtn.perform(click())
        sleep(2000)

        // check what user name is displayed
        val textView = onView(
            allOf(
                withId(R.id.userNameNavHeader), withText("Olga"),
                isDisplayed()
            )
        )
        sleep(3000)
        textView.check(matches(withText("Olga")))

        // teardown part of test: user logout
        val navHeaderLogoutBtn = onView(
            allOf(
                withId(R.id.loginBtnNavHeader), withText("Logout"),
                isDisplayed()
            )
        )
        navHeaderLogoutBtn.perform(click())
        Thread.sleep(1000)

        // check what Navigator Header Screen login button is displayed
        navHeaderLoginBtn.check(matches(isDisplayed()))
    }
}
