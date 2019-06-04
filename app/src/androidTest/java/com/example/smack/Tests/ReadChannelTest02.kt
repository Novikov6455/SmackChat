package com.example.smack.Tests

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.smack.Controller.MainActivity
import com.example.smack.Screens.Lev00AppToolbarScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ReadChannelTest02 : BaseTest() {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun userAbleSelectChannel() {
        val lev00AppToolbarScreen = Lev00AppToolbarScreen()
        val lev01NavHeaderScreen = lev00AppToolbarScreen.tapToolbarBtn()
        Thread.sleep(1000)
        val lev02LoginScreen = lev01NavHeaderScreen.tapLogInBtn()
        Thread.sleep(1000)
        lev02LoginScreen.enterLoginEmail(validEmail)
        Thread.sleep(1000)
        lev02LoginScreen.enterLoginPassword(validPassword)
        Thread.sleep(3000)
        val lev03MainActivityScreen = lev02LoginScreen.tapLoginSubmitBtn()
        Thread.sleep(3000)

        val lev04ChannelContent= lev03MainActivityScreen.chooseChannelFromList(0)
        Thread.sleep(5000)
        lev04ChannelContent.checkValidChannelIsPresent(validChannelName01)
        Thread.sleep(1000)

        lev04ChannelContent.tapToolbarBtn()
        Thread.sleep(1000)
        lev03MainActivityScreen.submitLogOut()
    }

    @Test
    fun userAbleReplaceChannel() {
        val lev00AppToolbarScreen = Lev00AppToolbarScreen()
        val lev01NavHeaderScreen = lev00AppToolbarScreen.tapToolbarBtn()
        Thread.sleep(1000)
        val lev02LoginScreen = lev01NavHeaderScreen.tapLogInBtn()
        Thread.sleep(1000)
        lev02LoginScreen.enterLoginEmail(validEmail)
        Thread.sleep(1000)
        lev02LoginScreen.enterLoginPassword(validPassword)
        Thread.sleep(3000)
        val lev03MainActivityScreen = lev02LoginScreen.tapLoginSubmitBtn()
        Thread.sleep(3000)

        val lev04ChannelContent= lev03MainActivityScreen.chooseChannelFromList(0)
        Thread.sleep(5000)
        lev04ChannelContent.checkValidChannelIsPresent(validChannelName01)
        Thread.sleep(1000)
        lev04ChannelContent.tapToolbarBtn()  // return to level03
        Thread.sleep(1000)
        lev03MainActivityScreen.chooseChannelFromList(2)
        Thread.sleep(1000)
        lev04ChannelContent.checkValidChannelIsPresent(validChannelName03)

        lev04ChannelContent.tapToolbarBtn()
        Thread.sleep(1000)
        lev03MainActivityScreen.submitLogOut()
    }

}
