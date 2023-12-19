package ca.six.globalbannerdemo

import android.app.Application

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        self = this

    }


    companion object {
        private lateinit var self: MyApp

        fun app(): MyApp {
            return self
        }
    }
}