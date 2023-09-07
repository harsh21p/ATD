package com.atd.atdmobileapp.utils

import android.content.Context
import com.atd.atdmobileapp.R
import dagger.hilt.android.qualifiers.ApplicationContext
import java.security.KeyStore
import java.security.cert.CertificateFactory
import javax.inject.Inject
import javax.net.ssl.TrustManager
import javax.net.ssl.TrustManagerFactory

class CertificateHelper @Inject constructor(@ApplicationContext context: Context) {
    private val applicationContext = context
    fun createTrustManagers(): Array<TrustManager> {
        val certificateInputStream = applicationContext.resources.openRawResource(R.raw.atdconnect)
        val certificateFactory = CertificateFactory.getInstance("X.509")
        val certificate = certificateFactory.generateCertificate(certificateInputStream)
        val trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
        val keyStore = KeyStore.getInstance(KeyStore.getDefaultType())
        keyStore.load(null)
        keyStore.setCertificateEntry("atdconnect", certificate)
        trustManagerFactory.init(keyStore)
        return trustManagerFactory.trustManagers
    }
}