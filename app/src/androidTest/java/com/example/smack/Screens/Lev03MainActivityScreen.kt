package com.example.smack.Screens

import android.content.Context
import android.support.test.espresso.DataInteraction
import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onData
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ScrollToAction
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.swipeUp
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.*
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RelativeLayout
import com.example.smack.Controller.MainActivity
import com.example.smack.Model.Channel
import com.example.smack.R
import com.example.smack.Utilities.RecyclerViewItemMatcher
import org.hamcrest.CoreMatchers.*
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.Matchers.hasEntry
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf

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

    // tap first channel in list of channels ***************************
    private val listOfChannels: DataInteraction = Espresso.onData(Matchers.anything())
        .inAdapterView(
            Matchers.allOf(
                withId(R.id.channel_list),
                childAtPosition(
                    withClassName(Matchers.`is`("android.widget.RelativeLayout")),
                    1
                )
            )
        )
        .atPosition(0)

    fun chooseChannelFromList(atPosition: Int): Lev04ChannelContentScreen {
        listOfChannels.atPosition(atPosition).perform(click())
        return Lev04ChannelContentScreen()
    }

    // chose channel from list of channels *******************************
//    fun channelNameIsInListOfChannels(channelName: String) {
//        onData(allOf(`is`(instanceOf(String::class.java),
//
//            `is`(channelName)))).perform(click())
//    }


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
    // **********************************************
    private val channelRow: (String) -> ViewInteraction = { channelName ->
        onView(RecyclerViewItemMatcher.channelNameMatches(channelName))
    }

    fun tapChannel(channelName: String): Lev04ChannelContentScreen  {
//        println(channelRow)
        channelRow("#$channelName").perform(click())

        return Lev04ChannelContentScreen()
    }



    //   *****************************************************************
    fun validChannelNameCellIsDisplayed(channelName: String): Lev03MainActivityScreen {
        onView(
            allOf(
                withId(android.R.id.text1),
                withText("#$channelName")
            )
        )
            .check(matches(isDisplayed()))
        return this
    }


    // right LOGOUT *******************************************************
    private val navHeaderLogoutBtn = onView(
        Matchers.allOf(
            withId(R.id.loginBtnNavHeader), withText("Logout"),
            isDisplayed()
        )
    )

    // logout ****************************
    fun submitLogOut(){
        navHeaderLogoutBtn.perform(click())
    }

    //  service matcher function *********************************************
    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }

}