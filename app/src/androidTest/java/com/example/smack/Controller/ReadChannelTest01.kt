package com.example.smack.Controller

import android.os.SystemClock.sleep
import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.view.View
import android.view.ViewGroup
import com.example.smack.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test


class ReadChannelTest01 {
    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)
    @Test
    fun loginLogoutBaseTest() {
        // tap toolbar button
        val toolbarBtn = onView(
            Matchers.allOf(
                withContentDescription("Open navigation drawer"),
//                withId(R.id.toolbar),
                isDisplayed()
            )
        )
        toolbarBtn.perform(ViewActions.click())
        sleep(1000)

        // tap login button
        val navHeaderLoginBtn = onView(
            Matchers.allOf(
                withId(R.id.loginBtnNavHeader), withText("Login"),
                isDisplayed()
            )
        )
        navHeaderLoginBtn.perform(ViewActions.click())
        sleep(1000)

        // type email address
        val loginEmailTxt = onView(
            Matchers.allOf(
                withId(R.id.loginEmailTxt),
                isDisplayed()
            )
        )
        loginEmailTxt.perform(replaceText("o@o.com"), closeSoftKeyboard())

        // type password
        val loginPasswordTxt = onView(
            Matchers.allOf(
                withId(R.id.loginPasswordTxt),
                isDisplayed()
            )
        )
        loginPasswordTxt.perform(replaceText("123456"), closeSoftKeyboard())

        // tap login button at Login Screen/layout
        val loginScreenLoginBtn = onView(
            Matchers.allOf(
                withId(R.id.loginLoginBtn), withText("login"),
                isDisplayed()
            )
        )
        loginScreenLoginBtn.perform(click())
        sleep(1000)

        // tap first channel in list of channels
        val listOfChannels = Espresso.onData(Matchers.anything())
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
        listOfChannels.perform(click())
        sleep(1000)

        // check what main Channel name is as suppose to be
        val mainChannelName = onView(
            Matchers.allOf(
                withId(R.id.mainChannelName),
//                withText("#first forever "),
                isDisplayed()
            )
        )
        mainChannelName.check(ViewAssertions.matches(withText("#first forever ")))
        sleep(1000)

        // return to Navigator Header Screen
        toolbarBtn.perform(click())
        sleep(1000)

        // teardown part of test: user logout
        val navHeaderLogoutBtn = onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.loginBtnNavHeader), ViewMatchers.withText("Logout"),
                ViewMatchers.isDisplayed()
            )
        )
        navHeaderLogoutBtn.perform(click())
        sleep(1000)

        // check what Navigator Header Screen login button is displayed
        navHeaderLoginBtn.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

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