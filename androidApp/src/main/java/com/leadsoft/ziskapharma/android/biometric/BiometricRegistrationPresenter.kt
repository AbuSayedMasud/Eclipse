package com.leadsoft.ziskapharma.android.biometric


import android.content.Context
import com.leadsoft.ziskapharma.android.sharePreference.PreferencesManager

class BiometricRegistrationPresenter(context: Context) {
    private val preferencesManager = PreferencesManager(context)

    fun registration(username: String, password: String): String {
//        val identityService = SecurityFactory.getIdentityService("LEADS")
//        val identityResponse = identityService.biometricRegistered(username, password)
//        preferencesManager.saveKey("RegistrationKey", identityResponse)
//        return identityResponse
        val identityResponse="okay";
        preferencesManager.saveKey("RegistrationKey", identityResponse)
        return identityResponse

    }
}
