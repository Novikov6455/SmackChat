package com.example.smack.Utilities

import android.support.test.espresso.EspressoException
import android.support.test.espresso.FailureHandler
import android.view.View
import org.hamcrest.Matcher
import java.lang.AssertionError

class CustomFailureHandler : FailureHandler {
    override fun handle(error: Throwable, viewMatcher: Matcher<View>) {
        if (error is EspressoException || error is AssertionError) {
            error.stackTrace = Thread.currentThread().stackTrace
                .filter { it.className.startsWith("com.example.smack") }
                .toTypedArray()
        }
        throw error
    }
}