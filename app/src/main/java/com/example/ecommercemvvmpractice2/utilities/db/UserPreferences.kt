package com.example.ecommercemvvmpractice2.utilities.db

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.ecommercemvvmpractice2.data.response.LoginData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private val Context.dataStore: DataStore<androidx.datastore.preferences.core.Preferences> by preferencesDataStore(
    name = "user_preferences"
)

class UserPreferences @Inject constructor(private val context: Context) {

    suspend fun saveLoginToken(token: String) {
        context.dataStore.edit { preferences ->
            preferences[TOKEN] = token
        }
    }


    val userToken: Flow<LoginData?> = context.dataStore.data.map {
        val token = it[TOKEN] ?: return@map null
        LoginData(token)

    }

    suspend fun clearData() {
        context.dataStore.edit { prefrences ->

            kotlin.run {
                prefrences.clear()
            }
        }
    }

    companion object {
        val TOKEN = stringPreferencesKey("token")
    }
}