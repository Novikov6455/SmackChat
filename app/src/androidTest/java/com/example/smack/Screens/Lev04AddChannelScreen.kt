package com.example.smack.Screens

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.example.smack.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf

class Lev04AddChannelScreen {

    private val addChannelNameTxt = Espresso.onView(
        Matchers.allOf(
            ViewMatchers.withId(R.id.addChannelNameTxt),
            ViewMatchers.isDisplayed()
        )
    )
    fun enterChannelName (channelName: String) {
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
            ViewMatchers.withText("Add")
        )
    )
    fun addChannelSubmit(): Lev03MainActivityScreen {
        submitAddChannelBtn.perform(scrollTo(), click())
        return Lev03MainActivityScreen()
    }
}