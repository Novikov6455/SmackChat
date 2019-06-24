package com.example.smack.Screens

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.matcher.ViewMatchers
import com.example.smack.R
import org.hamcrest.Matchers

class Lev03SignUpScreen {
    val createUserNameTxtBtn = Espresso.onView(
        Matchers.allOf(
            ViewMatchers.withId(R.id.createUserNameTxt),
            ViewMatchers.isDisplayed()
        )
    )
    fun enterUserName(validCreatedUserName: String) {
        createUserNameTxtBtn.perform(replaceText(validCreatedUserName), closeSoftKeyboard())
    }

    val createUserEmailTxtBtn = Espresso.onView(
        Matchers.allOf(
            ViewMatchers.withId(R.id.createEmailTxt),
            ViewMatchers.isDisplayed()
        )
    )
    fun enterUserEmail(validCreatedUserEmail: String) {
        createUserEmailTxtBtn.perform(replaceText(validCreatedUserEmail), closeSoftKeyboard())
    }

    val createUserPasswordTxtBtn = Espresso.onView(
        Matchers.allOf(
            ViewMatchers.withId(R.id.createPasswordTxt),
            ViewMatchers.isDisplayed()
        )
    )
    fun enterUserPassword(validCreatedUserPassword: String) {
        createUserPasswordTxtBtn.perform(replaceText(validCreatedUserPassword), closeSoftKeyboard())
    }

    val avatarImageViewBtn = Espresso.onView(
        Matchers.allOf(
            ViewMatchers.withId(R.id.createAvatarImageView),
            ViewMatchers.withContentDescription("AvatarImageView"),
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
            ViewMatchers.isDisplayed()
        )
    )
    fun createUser(): Lev03MainActivityScreen {
        createUserBtn.perform(click())
        return Lev03MainActivityScreen()
    }
}