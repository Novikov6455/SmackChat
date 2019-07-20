package com.example.smack.Tests

import android.support.test.espresso.IdlingRegistry
import android.support.test.rule.ActivityTestRule
import com.example.smack.Tests.Controller.MainActivity
import com.example.smack.Screens.Lev00AppToolbarScreen
import com.example.smack.Screens.Lev02LoginScreen
import com.example.smack.Screens.Lev03MainActivityScreen
import com.example.smack.Services.IdlingResourceHelper
import com.schibsted.spain.barista.rule.cleardata.ClearDatabaseRule
import com.schibsted.spain.barista.rule.cleardata.ClearFilesRule
import com.schibsted.spain.barista.rule.cleardata.ClearPreferencesRule
import org.junit.After
import org.junit.Before
import org.junit.Rule

open class BaseTest {

    @get:Rule
//    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @get:Rule
    var clearPreferencesRule = ClearPreferencesRule()

    @get:Rule
    var clearDatabaseRule = ClearDatabaseRule()

    @get:Rule
    var clearFilesRule = ClearFilesRule()

    val validEmail = "o@o.com"
    val validPassword = "123456"
    val validUserName = "Olga"
    val invalidEmail = "xxxxxx@x.com"
    val invalidPassword = "000000"
    val validChannelName01 = "first forever "
    val validChannelName03 = "Olga news channel"

    @Before
    fun setup() {
        IdlingRegistry.getInstance().register(IdlingResourceHelper.countingIdlingResource)
    }

    @After
    fun teardown() {
        IdlingRegistry.getInstance().unregister(IdlingResourceHelper.countingIdlingResource)
    }

    fun startAppAndGoToLoginScreen(): Lev02LoginScreen {
        val lev00AppToolbarScreen = Lev00AppToolbarScreen()
        val lev01NavHeaderScreen = lev00AppToolbarScreen.tapToolbarBtn()
        return lev01NavHeaderScreen.tapLogInBtn()
    }

    fun loginWithValidCredentials(): Lev03MainActivityScreen {
        val lev02LoginScreen = Lev02LoginScreen()
        lev02LoginScreen.enterLoginEmail(validEmail)
        lev02LoginScreen.enterLoginPassword(validPassword)
        val lev03MainActivityScreen = lev02LoginScreen.tapLoginSubmitBtn()
        return lev03MainActivityScreen
    }
}