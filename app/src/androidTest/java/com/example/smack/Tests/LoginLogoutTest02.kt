package com.example.smack.Tests

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.smack.Controller.MainActivity
import com.example.smack.Screens.Lev00AppToolbarScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Thread.sleep

@RunWith(AndroidJUnit4::class)
class LoginLogoutTest02 : BaseTest() {

    @get:Rule
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun userLogInOutHappyPath() {
        val lev00AppToolbarScreen = Lev00AppToolbarScreen()
        val lev01NavHeaderScreen = lev00AppToolbarScreen.tapToolbarBtn()
        sleep(1000)
        val lev02LoginScreen = lev01NavHeaderScreen.tapLogInBtn()
        sleep(1000)
        lev02LoginScreen.enterLoginEmail(validEmail)
        sleep(1000)
        lev02LoginScreen.enterLoginPassword(validPassword)
        sleep(3000)
        val lev03MainActivityScreen = lev02LoginScreen.tapLoginSubmitBtn()
        sleep(3000)
        lev03MainActivityScreen.validUserNameIsDisplayed(validUserName)
        sleep(8000)
        lev03MainActivityScreen.submitLogOut()


    }


}