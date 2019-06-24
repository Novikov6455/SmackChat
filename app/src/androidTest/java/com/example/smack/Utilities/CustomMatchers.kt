package com.example.smack.Utilities

import android.support.test.espresso.matcher.ViewMatchers
import android.support.v7.widget.RecyclerView
import android.view.View
import org.hamcrest.Description
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher

class RecyclerViewItemMatcher private constructor(private val channelName: String) : TypeSafeMatcher<View>() {
    override fun describeTo(description: Description?) {
        description?.appendText("The item text for the RecyclerView equals : $channelName")
    }

    override fun matchesSafely(item: View?): Boolean {
        return Matchers.allOf(
            ViewMatchers.isDescendantOfA(ViewMatchers.isAssignableFrom(RecyclerView::class.java)),
            ViewMatchers.withText(channelName))
            .matches(item)
    }

    companion object {
        fun channelNameMatches(channelName: String): RecyclerViewItemMatcher {
            return RecyclerViewItemMatcher(channelName)
        }
    }
}
