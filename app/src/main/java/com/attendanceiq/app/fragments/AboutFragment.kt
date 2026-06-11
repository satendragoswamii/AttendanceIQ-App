package com.attendanceiq.app.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.attendanceiq.app.R
import com.google.android.material.switchmaterial.SwitchMaterial

class AboutFragment : Fragment() {

    private lateinit var sharedPrefs: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPrefs = requireActivity().getSharedPreferences("app_prefs", Context.MODE_PRIVATE)

        setupThemeSwitch(view)
    }

    private fun setupThemeSwitch(view: View) {
        val themeSwitch = view.findViewById<SwitchMaterial>(R.id.themeSwitch)
        val isDarkMode = sharedPrefs.getBoolean("dark_mode", true)

        themeSwitch.isChecked = isDarkMode

        themeSwitch.setOnCheckedChangeListener { _, isChecked ->
            val editor = sharedPrefs.edit()
            editor.putBoolean("dark_mode", isChecked)
            editor.apply()
            requireActivity().recreate()
        }
    }
}
