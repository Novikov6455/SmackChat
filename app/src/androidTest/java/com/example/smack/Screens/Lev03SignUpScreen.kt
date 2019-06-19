package com.example.smack.Screens

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.matcher.ViewMatchers
import android.view.View
import android.view.ViewGroup
import com.example.smack.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher

class Lev03SignUpScreen {
    val createUserNameTxtBtn = Espresso.onView(
        Matchers.allOf(
            ViewMatchers.withId(R.id.createUserNameTxt),
//            childAtPosition(
//                childAtPosition(
//                    ViewMatchers.withId(android.R.id.content),
//                    0
//                ),
//                0
//            ),
            ViewMatchers.isDisplayed()
        )
    )
    fun enterUserName(validCreatedUserName: String) {
        createUserNameTxtBtn.perform(replaceText(validCreatedUserName), closeSoftKeyboard())
    }

    val createUserEmailTxtBtn = Espresso.onView(
        Matchers.allOf(
            ViewMatchers.withId(R.id.createEmailTxt),
//            childAtPosition(
//                childAtPosition(
//                    ViewMatchers.withId(android.R.id.content),
//                    0
//                ),
//                1
//            ),
            ViewMatchers.isDisplayed()
        )
    )
    fun enterUserEmail(validCreatedUserEmail: String) {
        createUserEmailTxtBtn.perform(replaceText(validCreatedUserEmail), closeSoftKeyboard())
    }

    val createUserPasswordTxtBtn = Espresso.onView(
        Matchers.allOf(
            ViewMatchers.withId(R.id.createPasswordTxt),
//            childAtPosition(
//                childAtPosition(
//                    ViewMatchers.withId(android.R.id.content),
//                    0
//                ),
//                2
//            ),
            ViewMatchers.isDisplayed()
        )
    )
    fun enterUserPassword(validCreatedUserPassword: String) {
        createUserPasswordTxtBtn.perform(replaceText(validCreatedUserPassword), closeSoftKeyboard())
    }

//    pressBack()

    val avatarImageViewBtn = Espresso.onView(
        Matchers.allOf(
            ViewMatchers.withId(R.id.createAvatarImageView),
            ViewMatchers.withContentDescription("AvatarImageView"),
//            childAtPosition(
//                childAtPosition(
//                    ViewMatchers.withId(android.R.id.content),
//                    0
//                ),
//                4
//            ),
            ViewMatchers.isDisplayed()
        )
    )
    fun tapAvatarImageViewBtn() {
        avatarImageViewBtn.perform(click())
    }

    val backgroundColorBtn = Espresso.onView(
        Matchers.allOf(
            ViewMatchers.withId(R.id.backgroundColorBtn),
            ViewMatchers.withText("generate background color"),
//            childAtPosition(
//                childAtPosition(
//                    ViewMatchers.withId(android.R.id.content),
//                    0
//                ),
//                5
//            ),
            ViewMatchers.isDisplayed()
        )
    )
    fun generateBackgroundColor() {
        backgroundColorBtn.perform(click())
    }

    val createUserBtn = Espresso.onView(
        Matchers.allOf(
            ViewMatchers.withId(R.id.createUserBtn),
            ViewMatchers.withText("create user"),
//            childAtPosition(
//                childAtPosition(
//                    ViewMatchers.withId(android.R.id.content),
//                    0
//                ),
//                6
//            ),
            ViewMatchers.isDisplayed()
        )
    )
    fun createUser(): Lev03MainActivityScreen {
        createUserBtn.perform(click())
        return Lev03MainActivityScreen()
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