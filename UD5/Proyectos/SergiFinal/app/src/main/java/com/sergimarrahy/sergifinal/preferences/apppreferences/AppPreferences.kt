package com.sergimarrahy.sergifinal.preferences.apppreferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.sergimarrahy.sergifinal.model.User
import kotlinx.coroutines.flow.map

class AppPreferences(val context: Context) {
    companion object {
        val USER_ID = intPreferencesKey("USER_ID")
        val USER_NAME = stringPreferencesKey("USER_NAME")
    }

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "preferences")

    suspend fun saveUser(userPreferences: User) {
        context.dataStore.edit { preferences ->
            preferences[USER_ID] = userPreferences.userId
            preferences[USER_NAME] = userPreferences.userName
        }
    }

    fun loadUser() = context.dataStore.data.map { preferences ->
        User (
            userId = preferences[USER_ID] ?: 0,
            userName = preferences[USER_NAME] ?: ""
        )
    }

    suspend fun deleteUserPreferences() {
        context.dataStore.edit { preferences ->
            preferences.remove(USER_ID)
            preferences.remove(USER_NAME)
        }
    }
}