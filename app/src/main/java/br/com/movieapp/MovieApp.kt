package br.com.movieapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp // esta notação ira informar para o hilt que essa classe Application vai gerar o código necessário pra injeção de independencia durante nosso app
class MovieApp : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}