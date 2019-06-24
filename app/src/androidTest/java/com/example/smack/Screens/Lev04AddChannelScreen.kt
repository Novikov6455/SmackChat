package com.example.smack.Screens

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.matcher.ViewMatchers
import com.example.smack.R
import org.hamcrest.Matchers

class Lev04AddChannelScreen {

    private val addChannelNameTxt = Espresso.onView(
        Matchers.allOf(
            ViewMatchers.withId(R.id.addChannelNameTxt),
            ViewMatchers.isDisplayed()
        )
    )
    fun enterChannelName(channelName: String) {
            addChannelNameTxt.perform(replaceText(channelName), closeSoftKeyboard())
    }

    //
    private val addChannelDescTxt = Espresso.onView(
        Matchers.allOf(
            ViewMatchers.withId(R.id.addChannelDescTxt),
            ViewMatchers.isDisplayed()
        )
    )
    fun enterChannelDescription(channelDescription: String) {
        addChannelDescTxt.perform(replaceText(channelDescription), closeSoftKeyboard())
    }

    //
    private val submitAddChannelBtn = Espresso.onView(
        Matchers.allOf(
            ViewMatchers.withId(android.R.id.button1),
            ViewMatchers.isDisplayed()
        )
    )
    fun addChannelSubmit(): Lev03MainActivityScreen {
        submitAddChannelBtn.perform(click())
        return Lev03MainActivityScreen()
    }
}