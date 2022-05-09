package com.example.ch15_220509

import android.os.Bundle
import android.text.TextUtils
import androidx.preference.EditTextPreference
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat

class MySettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings, rootKey)
        val idPreference:EditTextPreference?=findPreference("id")
        val colorPreference:ListPreference?=findPreference("color")

        colorPreference?.summaryProvider=ListPreference.SimpleSummaryProvider.getInstance()
        //summary는 선택한 결과가 나오는 위치
        idPreference?.summaryProvider=
            Preference.SummaryProvider<EditTextPreference>{ preference ->
            val text=preference.text
                if(TextUtils.isEmpty(text)){
                    "설정이 되지 않았음"
                }else{
                    "설정된 id 값은 $text 입니다."
                }
        }
    }
}