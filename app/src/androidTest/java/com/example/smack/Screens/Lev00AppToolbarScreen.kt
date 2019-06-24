package com.example.smack.Screens

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withContentDescription
import org.hamcrest.CoreMatchers.allOf

class Lev00AppToolbarScreen {
    private val toolbarBtn: ViewInteraction = onView(
        allOf(
            // withId(R.id.toolbar),
            withContentDescription("Open navigation drawer"),
            isDisplayed()
        )
    )

    fun tapToolbarBtn(): Lev01NavHeaderScreen {
        toolbarBtn.perform(click())
        return Lev01NavHeaderScreen()
    }
}