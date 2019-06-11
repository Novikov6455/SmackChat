package com.example.smack.Screens

import android.support.test.espresso.Espresso
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import com.example.smack.R
import org.hamcrest.CoreMatchers
import org.hamcrest.Matchers

class Lev04ChannelContentScreen {
    private val toolbarBtn: ViewInteraction = Espresso.onView(
        CoreMatchers.allOf(
            // withId(R.id.toolbar),
            ViewMatchers.withContentDescription("Open navigation drawer"),
            ViewMatchers.isDisplayed()
        )
    )

    init {
        toolbarBtn.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
    fun tapToolbarBtn(): Lev03MainActivityScreen {
        toolbarBtn.perform(ViewActions.click())
        return Lev03MainActivityScreen()
    }

    // check what main Channel name is as suppose to be
    private val mainChannelName = Espresso.onView(
        Matchers.allOf(
            ViewMatchers.withId(R.id.mainChannelName),
//                withText("#first forever "),
            ViewMatchers.isDisplayed()
        )
    )
    fun checkValidChannelIsPresent(ChannelName: String) {
        mainChannelName.check(ViewAssertions.matches(ViewMatchers.withText(ChannelName)))
    }

}