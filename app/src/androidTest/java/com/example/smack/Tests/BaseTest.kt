package com.example.smack.Tests

import android.support.test.espresso.IdlingRegistry
import android.support.test.rule.ActivityTestRule
import com.example.smack.Controller.MainActivity
import com.example.smack.Services.IdlingResourceHelper
import org.junit.After
import org.junit.Before
import org.junit.Rule

open class BaseTest {

    val validEmail = "o@o.com"
    val validPassword = "123456"
    val validUserName = "Olga"
    val invalidEmail = "xxxxxx@x.com"
    val validChannelName01 = "#first forever "
    val validChannelName03 = "#Olga news channel"

    @Before
    fun setup() {
        IdlingRegistry.getInstance().register(IdlingResourceHelper.countingIdlingResource)
    }

    @After
    fun teardown() {
        IdlingRegistry.getInstance().unregister(IdlingResourceHelper.countingIdlingResource)
    }
}