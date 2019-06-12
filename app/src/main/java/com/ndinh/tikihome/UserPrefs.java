package com.ndinh.tikihome;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created by hnam on 14/10/2016.
 */
public class UserPrefs {
    private static final String PREF_AUTHENTICATION = "userprefs";
    public static final String PREF_CACHE = "cache";
    private static SharedPreferences sPrefs;

    public static void initUserPrefs(Context context) {
        sPrefs = context.getSharedPreferences(PREF_AUTHENTICATION, Context.MODE_PRIVATE);
    }

    public static SharedPreferences getPrefs(){
        return sPrefs;
    }

    public static SharedPreferences.Editor getPrefsEditor() {
        return sPrefs.edit();
    }

    public static String get(String key){
        return sPrefs.getString(key,"");
    }

    public static String get(String key, String defValues){
        return sPrefs.getString(key, defValues);
    }

    public static void set(String key, String value) {
        getPrefsEditor().putString(key,value).commit();
    }

    public static void setLong(String key, long value) {
        getPrefsEditor().putLong(key, value).commit();
    }

    public static void setBoolean(String key, boolean value){
        getPrefsEditor().putBoolean(key, value).commit();
    }

    public static boolean getBoolean(String key, boolean value){
        return sPrefs.getBoolean(key, value);
    }



}
