package com.example.smack.Tests

import android.support.test.filters.LargeTest
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.*

@LargeTest
// @RunWith(AndroidJUnit4::class)
class ReadWrightChannelTest02 : BaseTest() {

    val testMessage = "I test this channel at " + dateString()

    @Test
    fun userAbleSelectChannel() {
        //      setup
        startAppAndGoToLoginScreen()
        var lev03MainActivityScreen = loginWithValidCredentials()

        //      test functionalities
        val lev04ChannelContent = lev03MainActivityScreen.openChannelByName(validChannelName01)

        lev04ChannelContent.checkValidChannelIsPresent(validChannelName01)

        lev04ChannelContent.tapToolbarBtn()
        lev03MainActivityScreen.submitLogOut()
    }

    @Test
    fun userAbleReplaceChannel() {
        //      setup
        startAppAndGoToLoginScreen()
        var lev03MainActivityScreen = loginWithValidCredentials()

        //      test functionalities
        val lev04ChannelContent = lev03MainActivityScreen.openChannelByName(validChannelName01)
        lev04ChannelContent.checkValidChannelIsPresent(validChannelName01)
        lev04ChannelContent.tapToolbarBtn()  // return to level03
        lev03MainActivityScreen.openChannelByName(validChannelName03)
        lev04ChannelContent.checkValidChannelIsPresent(validChannelName03)

        lev04ChannelContent.tapToolbarBtn()
        lev03MainActivityScreen.submitLogOut()
    }

    @Test
    fun userAbleWrightInChannel() {
        //      setup
        startAppAndGoToLoginScreen()
        var lev03MainActivityScreen = loginWithValidCredentials()

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
