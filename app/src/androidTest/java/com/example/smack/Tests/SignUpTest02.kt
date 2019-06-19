package com.example.smack.Tests

import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.smack.Controller.MainActivity
import com.example.smack.Screens.Lev00AppToolbarScreen
import com.example.smack.Screens.Lev02LoginScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.text.SimpleDateFormat
import java.util.*

@LargeTest
@RunWith(AndroidJUnit4::class)
class SignUpTest02 : BaseTest() {
    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun userSignUp() {
        val lev02LoginScreen: Lev02LoginScreen = startAppAndGoToLoginScreen()

        val toCreateUserName = "tester"
        val validCreatedUserName = (toCreateUserName + dateString())
        val toCreateUserEmail = "@test.com"
        val validCreatedUserEmail = dateString().plus(toCreateUserEmail)
        val validCreatedUserPassword = "654321"

        val lev03SignUpScreen = lev02LoginScreen.tapSignUpHereBtn()
        lev03SignUpScreen.enterUserName(validCreatedUserName)
        lev03SignUpScreen.enterUserEmail(validCreatedUserEmail)
        lev03SignUpScreen.enterUserPassword(validCreatedUserPassword)
        lev03SignUpScreen.tapAvatarImageViewBtn()
        lev03SignUpScreen.tapAvatarImageViewBtn()
//        lev03SignUpScreen.tapAvatarImageViewBtn()
        lev03SignUpScreen.generateBackgroundColor()
        lev03SignUpScreen.generateBackgroundColor()
//        lev03SignUpScreen.generateBackgroundColor()

        val lev03MainActivityScreen = lev03SignUpScreen.createUser() // relocate to lev03MainActivityScreen
        println(validCreatedUserName)

        lev03MainActivityScreen.validUserNameIsDisplayed(validCreatedUserName)
        lev03MainActivityScreen.submitLogOut()
    }

    private fun dateString(): String {
        var convertedDate = Date()
        val outDateString = SimpleDateFormat("yyyyMMdd HH:mm:ss", Locale.getDefault())
        return outDateString.format(convertedDate)
    }
}