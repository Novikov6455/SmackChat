package com.example.smack.Screens

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onData
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import com.example.smack.R
import com.example.smack.Utilities.CustomFailureHandler
import org.hamcrest.CoreMatchers.startsWith
import org.hamcrest.Matchers
import org.hamcrest.Matchers.hasToString
import java.lang.Thread.sleep

class Lev03MainActivityScreen  {

    // check what user name is displayed *****************************
    private val userNameTextView = onView(
        Matchers.allOf(
            withId(R.id.userNameNavHeader),
            isDisplayed()
        )
    )

    fun validUserNameIsDisplayed(validUserName: String) {
        userNameTextView.check(matches(withText(validUserName)))
    }

    // channelsList ***************************************************
    private  val channelsList: ViewInteraction
        get() = onView(withId(R.id.channel_list))

    fun channelsListIsVisible() {
        channelsList
            .withFailureHandler(CustomFailureHandler())
            .check(matches(isDisplayed()))
    }

    fun openChannelByName(channelName: String): Lev04ChannelContentScreen {
//        sleep(1000)
        onData(hasToString(startsWith("#$channelName")))
            .inAdapterView(withId(R.id.channel_list))
            .perform(click())
        return Lev04ChannelContentScreen()
    }

    // add channel ability ***********************************************
    private val addChannelBtn = Espresso.onView(
        Matchers.allOf(
            withId(R.id.addChannelBtn),
            isDisplayed()
        )
    )

    fun tapAddChannelBtn(): Lev04AddChannelScreen {
        addChannelBtn.perform(click())
        return Lev04AddChannelScreen()
    }

    // right LOGOUT *******************************************************
    private val navHeaderLogoutBtn = onView(
        Matchers.allOf(
            withId(R.id.loginBtnNavHeader), withText("Logout"),
            isDisplayed()
        )
    )

    fun submitLogOut() {
        navHeaderLogoutBtn.perform(click())
    }
}