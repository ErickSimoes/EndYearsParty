package br.com.ericksimoes.endyearsparty.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by erick on 17/08/2017.
 */

public class SecurityPreferences {
    private final SharedPreferences mSharedPreferences;

    public SecurityPreferences(Context context) {
        this.mSharedPreferences = context.getSharedPreferences("EndYears", Context.MODE_PRIVATE);
    }

    public void storeString(String key, String value) {
        this.mSharedPreferences.edit().putString(key, value).apply();
    }

    public String getStoredString(String key) {
        return this.mSharedPreferences.getString(key, "");
    }
}
