package com.example.smack.Screens

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.example.smack.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf

class Lev03MainActivityScreen {
    // check what user name is displayed
    private val userNameTextView = onView(
        Matchers.allOf(
            withId(R.id.userNameNavHeader),
            childAtPosition(
                Matchers.allOf(
                    withId(R.id.nav_drawer_header_include),
                    childAtPosition(
                        IsInstanceOf.instanceOf(RelativeLayout::class.java),
                        0
                    )
                ),
                1
            ),
            isDisplayed()
        )
    )

    fun validUserNameIsDisplayed(validUserName: String) {
    userNameTextView.check(matches(withText(validUserName)))
}

    // right LOGOUT
    private val navHeaderLogoutBtn = onView(
        Matchers.allOf(
            withId(R.id.loginBtnNavHeader), withText("Logout"),
            childAtPosition(
                Matchers.allOf(
                    withId(R.id.nav_drawer_header_include),
                    childAtPosition(
                        withClassName(Matchers.`is`("android.widget.RelativeLayout")),
                        0
                    )
                ),
                3
            ),
            isDisplayed()
        )
    )
    fun submitLogOut(){
        navHeaderLogoutBtn.perform(click())
    }

    //  service matcher function
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