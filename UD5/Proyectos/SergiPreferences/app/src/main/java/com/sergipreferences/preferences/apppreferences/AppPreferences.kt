package com.sergipreferences.preferences.apppreferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.sergipreferences.model.UserPreferences
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

class AppPreferences(val context: Context) {
    companion object {
        val USER_NAME = stringPreferencesKey("USER_NAME")
        val PHONE_NUMBER = stringPreferencesKey("PHONE_NUMBER")
    }

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "preferences")

    suspend fun editUserCredentials(userPreferences: UserPreferences) {
        context.dataStore.edit { preferences ->
            preferences[USER_NAME] = userPreferences.userName
            preferences[PHONE_NUMBER] = userPreferences.phoneNumber
        }
    }

    fun loadUserCredentials() = context.dataStore.data.map { preferences ->
        UserPreferences (
            userName = preferences[USER_NAME] ?: "",
            phoneNumber = preferences[PHONE_NUMBER] ?: ""
        )
    }

    suspend fun deleteUserPreferences() {
        context.dataStore.edit { preferences ->
            preferences.remove(USER_NAME)
            preferences.remove(PHONE_NUMBER)
        }
    }
}