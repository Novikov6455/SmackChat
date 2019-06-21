package com.example.smack.Tests

import android.support.test.espresso.action.ViewActions.swipeUp
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.smack.Controller.MainActivity
import com.example.smack.Screens.Lev00AppToolbarScreen
import com.example.smack.Screens.Lev02LoginScreen
import com.example.smack.Utilities.RecyclerViewItemMatcher
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
        val lev02LoginScreen: Lev02LoginScreen = startAppAndGoToLoginScreen()
        var lev03MainActivityScreen = loginWithValidCredentials()

    //      test functionalities
        val lev04AddChannelScreen = lev03MainActivityScreen.tapAddChannelBtn()
        lev04AddChannelScreen.enterChannelName(validCreatedChannelName)
        lev04AddChannelScreen.enterChannelDescription(validCreatedChannelDescription)
        lev04AddChannelScreen.addChannelSubmit()
//        swipeUp()
//        lev03MainActivityScreen.channelNameIsInListOfChannels(validCreatedChannelName)
        lev03MainActivityScreen.validChannelNameCellIsDisplayed(validCreatedChannelName)


//       in the next line is problem  ****  v   v   v   **********************************
//        lev03MainActivityScreen.tapChannel(validChannelName03)


//        val lev04ChannelContentScreen = lev03MainActivityScreen.tapChannel("#$validCreatedChannelName")
//        lev04ChannelContentScreen.checkValidChannelIsPresent("#$validCreatedChannelName")
        //      teardown
//        lev03MainActivityScreen = lev04ChannelContentScreen.tapToolbarBtn()
        lev03MainActivityScreen.submitLogOut()

    }

    //      service functions
    private fun dateString(): String {
        var convertedDate = Date()
//        val outDateString = SimpleDateFormat("yyyyMMdd HH:mm:ss", Locale.getDefault())
        val outDateString = SimpleDateFormat("yy/MM/dd HH:mm:ss", Locale.getDefault())
        return outDateString.format(convertedDate)
    }

    fun isChannelPresentInListOfChannels(channelName: String) {
        val result = RecyclerViewItemMatcher.channelNameMatches(channelName)
    }


}