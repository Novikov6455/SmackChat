package com.example.smack.Tests

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

@RunWith(AndroidJUnit4::class)
class ReadWrightChannelTest02 : BaseTest() {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)
    val testMessage = "I test this channel at " + dateString()


    @Test
    fun userAbleSelectChannel() {
        //      setup
        val lev02LoginScreen: Lev02LoginScreen = startAppAndGoToLoginScreen()
        var lev03MainActivityScreen = loginWithValidCredentials()

        //      test functionalities
        val lev04ChannelContent= lev03MainActivityScreen.chooseChannelFromList(0)
        lev04ChannelContent.checkValidChannelIsPresent(validChannelName01)

        lev04ChannelContent.tapToolbarBtn()
        lev03MainActivityScreen.submitLogOut()
    }

    @Test
    fun userAbleReplaceChannel() {
        //      setup
        val lev02LoginScreen: Lev02LoginScreen = startAppAndGoToLoginScreen()
        var lev03MainActivityScreen = loginWithValidCredentials()

        //      test functionalities
        val lev04ChannelContent= lev03MainActivityScreen.chooseChannelFromList(0)
        lev04ChannelContent.checkValidChannelIsPresent(validChannelName01)
        lev04ChannelContent.tapToolbarBtn()  // return to level03
        lev03MainActivityScreen.chooseChannelFromList(2)
        lev04ChannelContent.checkValidChannelIsPresent(validChannelName03)

        lev04ChannelContent.tapToolbarBtn()
        lev03MainActivityScreen.submitLogOut()
    }

    @Test
    fun userAbleWrightInChannel() {
        //      setup
        val lev02LoginScreen: Lev02LoginScreen = startAppAndGoToLoginScreen()
        var lev03MainActivityScreen = loginWithValidCredentials()

        //      test functionalities
        val lev04ChannelContent= lev03MainActivityScreen.chooseChannelFromList(2)
        lev04ChannelContent.checkValidChannelIsPresent(validChannelName03)
        lev04ChannelContent.typeTextMessage(testMessage)
        lev04ChannelContent.submitMessage()
        lev04ChannelContent.isMessageVisible(testMessage)

        // teardown
        lev04ChannelContent.tapToolbarBtn()
        lev03MainActivityScreen.submitLogOut()
    }
        // service function
    private fun dateString(): String {
        var convertedDate = Date()
        val outDateString = SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault())
        return outDateString.format(convertedDate)
    }



}
