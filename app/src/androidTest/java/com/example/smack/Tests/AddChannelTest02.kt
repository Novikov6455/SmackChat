package com.example.smack.Tests

import com.example.smack.Screens.Lev04ChannelContentScreen
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.*

// @RunWith(AndroidJUnit4::class)
class AddChannelTest02 : BaseTest() {

    private val toCreateChannelName = " Test channel"
    var validCreatedChannelName = (dateString() + toCreateChannelName)
    val channelDescription = "Temporary Test channel"

    @Test
    fun addChannelTest() {
    //      setup
        startAppAndGoToLoginScreen()
        var lev03MainActivityScreen = loginWithValidCredentials()

    //      test functionalities
        val lev04AddChannelScreen = lev03MainActivityScreen.tapAddChannelBtn()
        lev04AddChannelScreen.enterChannelName(validCreatedChannelName)
        lev04AddChannelScreen.enterChannelDescription(channelDescription)
        lev04AddChannelScreen.addChannelSubmit()

        lev03MainActivityScreen.channelsListIsVisible()
        lev03MainActivityScreen.openChannelByName(validCreatedChannelName)
        val lev04ChannelContent = Lev04ChannelContentScreen()
        lev04ChannelContent.checkValidChannelIsPresent("#$validCreatedChannelName")

    //      teardown
        lev04ChannelContent.tapToolbarBtn().submitLogOut()
    }

    //      service functions
    private fun dateString(): String {
        var convertedDate = Date()
        val outDateString = SimpleDateFormat("yy/MM/dd HH:mm:ss", Locale.getDefault())
        return outDateString.format(convertedDate)
    }
}