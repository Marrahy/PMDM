package com.sergipreferences.preferences.apppreferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

class AppPreferences(val context: Context) {
    companion object {
        val USER_NAME = stringPreferencesKey("USER_NAME")
        val PHONE_NUMBER = stringPreferencesKey("PHONE_NUMBER")
    }

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "preferences")

    suspend fun saveUserCredentials(userName: String, phoneNumber: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_NAME] = userName
            preferences[PHONE_NUMBER] = phoneNumber
        }
    }

    fun loadUserCredentials() = context.dataStore.data.map { preferences ->
        preferences[USER_NAME] ?: ""
        preferences[PHONE_NUMBER] ?: ""
    }

//    suspend fun deleteAllData(userName: String, phoneNumber: String) {
//        context.dataStore.edit { preferences ->
//            preferences[USER_NAME] = userName
//            preferences[PHONE_NUMBER] = phoneNumber
//        }
//    }
}