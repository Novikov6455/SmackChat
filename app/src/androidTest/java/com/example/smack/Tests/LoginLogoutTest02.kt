package com.example.smack.Tests

import android.support.test.espresso.Espresso.pressBack
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.smack.Controller.MainActivity
import com.example.smack.Screens.Lev00AppToolbarScreen
import com.example.smack.Screens.Lev02LoginScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Thread.sleep

@LargeTest
@RunWith(AndroidJUnit4::class)
class LoginLogoutTest02 : BaseTest() {

    //    @get:Rule
    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun userLogInOutHappyPath() {
        val lev02LoginScreen:Lev02LoginScreen = startAppAndGoToLoginScreen()

        lev02LoginScreen.enterLoginEmail(validEmail)
        lev02LoginScreen.enterLoginPassword(validPassword)

        val lev03MainActivityScreen = lev02LoginScreen.tapLoginSubmitBtn()
        lev03MainActivityScreen.validUserNameIsDisplayed(validUserName)
        lev03MainActivityScreen.submitLogOut()
    }

    @Test
    fun invalidLogIn() {
        val lev02LoginScreen:Lev02LoginScreen = startAppAndGoToLoginScreen()

        lev02LoginScreen.enterLoginEmail(invalidEmail)
        lev02LoginScreen.enterLoginPassword(validPassword)

        lev02LoginScreen.tapLoginSubmitBtn()
        assert(lev02LoginScreen.loginResult())
        // teardown
        pressBack()
    }

    @Test
    fun invalidPassword() {
        val lev02LoginScreen:Lev02LoginScreen = startAppAndGoToLoginScreen()

        lev02LoginScreen.enterLoginEmail(validEmail)
        lev02LoginScreen.enterLoginPassword(invalidPassword)

        lev02LoginScreen.tapLoginSubmitBtn()
        assert(lev02LoginScreen.loginResult())
        // teardown
        pressBack()
    }

    @Test
    fun emptyEmail() {
        val lev02LoginScreen:Lev02LoginScreen = startAppAndGoToLoginScreen()

        lev02LoginScreen.enterLoginEmail("")
        lev02LoginScreen.enterLoginPassword(validPassword)

        lev02LoginScreen.tapLoginSubmitBtn()
        assert(lev02LoginScreen.loginResult())
        // teardown
        pressBack()
    }

    @Test
    fun emptyPasswordl() {
        val lev02LoginScreen:Lev02LoginScreen = startAppAndGoToLoginScreen()

        lev02LoginScreen.enterLoginEmail(validEmail)
        lev02LoginScreen.enterLoginPassword("")

        lev02LoginScreen.tapLoginSubmitBtn()
        assert(lev02LoginScreen.loginResult())
        // teardown
        pressBack()
    }

    @Test
    fun emptyEmailEmptyPassword() {
        val lev02LoginScreen:Lev02LoginScreen = startAppAndGoToLoginScreen()

        lev02LoginScreen.enterLoginEmail("")
        lev02LoginScreen.enterLoginPassword("")

        lev02LoginScreen.tapLoginSubmitBtn()
        assert(lev02LoginScreen.loginResult())
        // teardown
        pressBack()
    }
}