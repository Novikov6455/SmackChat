package com.example.smack.Controller


import android.os.SystemClock.sleep
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.View
import android.view.ViewGroup
import com.example.smack.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class LoginLogoutTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun loginLogoutTest() {
        val appCompatImageButton = onView(
            allOf(
                withContentDescription("Open navigation drawer"),
                childAtPosition(
                    allOf(
                        withId(R.id.toolbar),
                        childAtPosition(
                            withClassName(`is`("android.support.design.widget.AppBarLayout")),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatImageButton.perform(click())
        Thread.sleep(1000)

        val appCompatButton = onView(
            allOf(
                withId(R.id.loginBtnNavHeader), withText("Login"),
                childAtPosition(
                    allOf(
                        withId(R.id.nav_drawer_header_include),
                        childAtPosition(
                            withClassName(`is`("android.widget.RelativeLayout")),
                            0
                        )
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        appCompatButton.perform(click())

        val appCompatEditText = onView(
            allOf(
                withId(R.id.loginEmailTxt),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatEditText.perform(replaceText("o@o.com"), closeSoftKeyboard())

        val appCompatEditText2 = onView(
            allOf(
                withId(R.id.loginPasswordTxt),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText2.perform(replaceText("123456"), closeSoftKeyboard())

//        pressBack()
        Thread.sleep(2000)


        val appCompatButton2 = onView(
            allOf(
                withId(R.id.loginLoginBtn), withText("login"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        sleep(1000)
        appCompatButton2.perform(click())


        val textView = onView(
            allOf(
                withId(R.id.userNameNavHeader), withText("Olga"),
                childAtPosition(
                    allOf(
                        withId(R.id.nav_drawer_header_include),
                        childAtPosition(
                            IsInstanceOf.instanceOf(android.widget.RelativeLayout::class.java),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        Thread.sleep(3000)

        textView.check(matches(withText("Olga")))

        val appCompatButton3 = onView(
            allOf(
                withId(R.id.loginBtnNavHeader), withText("Logout"),
                childAtPosition(
                    allOf(
                        withId(R.id.nav_drawer_header_include),
                        childAtPosition(
                            withClassName(`is`("android.widget.RelativeLayout")),
                            0
                        )
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        appCompatButton3.perform(click())
        Thread.sleep(1000)


        val button = onView(
            allOf(
                withId(R.id.loginBtnNavHeader),
                childAtPosition(
                    allOf(
                        withId(R.id.nav_drawer_header_include),
                        childAtPosition(
                            IsInstanceOf.instanceOf(android.widget.RelativeLayout::class.java),
                            0
                        )
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        button.check(matches(isDisplayed()))
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
