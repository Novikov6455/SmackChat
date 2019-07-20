package com.example.smack.Tests

import android.support.test.filters.LargeTest
import android.support.test.runner.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Thread.sleep
import java.text.SimpleDateFormat
import java.util.*

//@LargeTest
class ReadWrightChannelTest : BaseTest() {

    val testMessage = "I test this channel at " + dateString()

    @Test
    fun userMainFunctionalityOfChannel() {
        //      setup
        startAppAndGoToLoginScreen()
        var lev03MainActivityScreen = loginWithValidCredentials()
        lev03MainActivityScreen.channelsListIsVisible()

        //      test functionalities:
        //              userAbleSelectChannel
        val lev04ChannelContent = lev03MainActivityScreen.openChannelByName(validChannelName01)
        lev04ChannelContent.checkValidChannelIsPresent(validChannelName01)

        //              userAbleReplaceChannel
        lev04ChannelContent.tapToolbarBtn()  // return to level03
        lev03MainActivityScreen.openChannelByName(validChannelName03)
        lev04ChannelContent.checkValidChannelIsPresent(validChannelName03)

        //              userAbleWrightInChannel
        lev04ChannelContent.typeTextMessage(testMessage)
        lev04ChannelContent.submitMessage()
        lev04ChannelContent.isMessageVisible(testMessage)

        //      teardown
        lev04ChannelContent.tapToolbarBtn()
        lev03MainActivityScreen.submitLogOut()
    }

    @Test
    fun userAbleWrightInChannel() {
        //      setup
        startAppAndGoToLoginScreen()
        var lev03MainActivityScreen = loginWithValidCredentials()

        lev03MainActivityScreen.channelsListIsVisible()

        //      test functionalities
        val lev04ChannelContent = lev03MainActivityScreen.openChannelByName(validChannelName03)
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
