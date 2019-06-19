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
//            childAtPosition(
//                childAtPosition(
//                    ViewMatchers.withId(R.id.custom),
//                    0
//                ),
//                1
//            ),
            ViewMatchers.isDisplayed()
        )
    )
    fun enterChannelName (channelName: String) {
            addChannelNameTxt.perform(replaceText(channelName), closeSoftKeyboard())
    }

    private val addChannelDescTxt = Espresso.onView(
        Matchers.allOf(
            ViewMatchers.withId(R.id.addChannelDescTxt),
//            childAtPosition(
//                childAtPosition(
//                    ViewMatchers.withId(R.id.custom),
//                    0
//                ),
//                2
//            ),
            ViewMatchers.isDisplayed()
        )
    )
    fun enterChannelDescription(channelDescription: String) {
        addChannelDescTxt.perform(replaceText(channelDescription), closeSoftKeyboard())
    }

    private val submitAddChannelBtn = Espresso.onView(
        Matchers.allOf(
            ViewMatchers.withId(android.R.id.button1),
            ViewMatchers.withText("Add")
//            childAtPosition(
//                childAtPosition(
//                    ViewMatchers.withId(R.id.buttonPanel),
//                    0
//                ),
//                3
//            )
        )
    )
    fun addChannelSubmit(): Lev03MainActivityScreen {
        submitAddChannelBtn.perform(scrollTo(), click())
        return Lev03MainActivityScreen()
    }




    fun childAtPosition(
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