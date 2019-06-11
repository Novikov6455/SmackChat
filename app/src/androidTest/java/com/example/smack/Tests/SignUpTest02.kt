package com.example.smack.Tests

import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.smack.Controller.MainActivity
import com.example.smack.Screens.Lev00AppToolbarScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.text.SimpleDateFormat
import java.util.*

@LargeTest
@RunWith(AndroidJUnit4::class)
class SignUpTest02 {
    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun userSignUp() {
        val toCreateUserName = "tester"
        val validCreatedUserName = (toCreateUserName + dateString())
        val toCreateUserEmail = "@test.com"
        val validCreatedUserEmail = dateString().plus(toCreateUserEmail)
        val validCreatedUserPassword = "654321"

        val lev00AppToolbarScreen = Lev00AppToolbarScreen()
        val lev01NavHeaderScreen = lev00AppToolbarScreen.tapToolbarBtn()
        Thread.sleep(1000)
        val lev02LoginScreen = lev01NavHeaderScreen.tapLogInBtn()
        Thread.sleep(1000)
        val lev03SignUpScreen = lev02LoginScreen.tapSignUpHereBtn()
        Thread.sleep(1000)
        lev03SignUpScreen.enterUserName(validCreatedUserName)
        Thread.sleep(1000)
        lev03SignUpScreen.enterUserEmail(validCreatedUserEmail)
        Thread.sleep(1000)
        lev03SignUpScreen.enterUserPassword(validCreatedUserPassword)
        Thread.sleep(1000)
        lev03SignUpScreen.tapAvatarImageViewBtn()
        lev03SignUpScreen.tapAvatarImageViewBtn()
        lev03SignUpScreen.tapAvatarImageViewBtn()
        lev03SignUpScreen.generateBackgroundColor()
        lev03SignUpScreen.generateBackgroundColor()
        lev03SignUpScreen.generateBackgroundColor()
        Thread.sleep(2000)

        val lev03MainActivityScreen = lev03SignUpScreen.createUser() // relocate to lev03MainActivityScreen
        println(validCreatedUserName)

        Thread.sleep(3000)
        lev03MainActivityScreen.validUserNameIsDisplayed(validCreatedUserName)
        Thread.sleep(1000)
        lev03MainActivityScreen.submitLogOut()
    }

    private fun dateString(): String {
        var convertedDate = Date()
        val outDateString = SimpleDateFormat("yyyyMMdd HH:mm:ss", Locale.getDefault())
        return outDateString.format(convertedDate)
    }
}