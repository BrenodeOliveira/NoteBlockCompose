package br.com.breno.blocknotescompose

import android.app.Application
import br.com.breno.blocknotescompose.di.databaseModule
import br.com.breno.blocknotescompose.di.domainModule
import br.com.breno.blocknotescompose.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(databaseModule, domainModule, presentationModule)
        }
    }
}