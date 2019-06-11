package com.example.smack.Tests

import android.support.test.espresso.action.ViewActions.swipeUp
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.smack.Controller.MainActivity
import com.example.smack.Screens.Lev00AppToolbarScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.text.SimpleDateFormat
import java.util.*

@RunWith(AndroidJUnit4::class)
class AddChannelTest02 : BaseTest() {
    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)
    private val toCreateChannelName = " Test channel"
    var validCreatedChannelName = (dateString() + toCreateChannelName)
    val validCreatedChannelDescription = "Today Test Channel"

    @Test
    fun addChannelTest() {
    //      setup
        val lev00AppToolbarScreen = Lev00AppToolbarScreen()
        val lev01NavHeaderScreen = lev00AppToolbarScreen.tapToolbarBtn()
        Thread.sleep(1000)
        val lev02LoginScreen = lev01NavHeaderScreen.tapLogInBtn()
        Thread.sleep(1000)
        lev02LoginScreen.enterLoginEmail(validEmail)
        Thread.sleep(1000)
        lev02LoginScreen.enterLoginPassword(validPassword)
        Thread.sleep(3000)
        var lev03MainActivityScreen = lev02LoginScreen.tapLoginSubmitBtn()
        Thread.sleep(3000)

    //      test functionalities
        val lev04AddChannelScreen = lev03MainActivityScreen.tapAddChannelBtn()
        Thread.sleep(1000)
        lev04AddChannelScreen.enterChannelName(validCreatedChannelName)
        Thread.sleep(1000)
        lev04AddChannelScreen.enterChannelDescription(validCreatedChannelDescription)
        Thread.sleep(1000)
        lev04AddChannelScreen.addChannelSubmit()
        Thread.sleep(2000)
        swipeUp()
        Thread.sleep(2000)
        swipeUp()
        Thread.sleep(2000)
        lev03MainActivityScreen.validChannelNameCellIsDisplayed(validCreatedChannelName)

    //      teardown
        Thread.sleep(1000)
        lev03MainActivityScreen.submitLogOut()

    }

    //      service functions
    private fun dateString(): String {
        var convertedDate = Date()
//        val outDateString = SimpleDateFormat("yyyyMMdd HH:mm:ss", Locale.getDefault())
        val outDateString = SimpleDateFormat("yy/MM/dd HH:mm:ss", Locale.getDefault())
        return outDateString.format(convertedDate)
    }


}