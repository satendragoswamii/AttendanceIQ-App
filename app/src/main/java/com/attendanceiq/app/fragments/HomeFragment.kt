package com.attendanceiq.app.fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.attendanceiq.app.R
import com.google.android.material.button.MaterialButton

class HomeFragment : Fragment() {

    private lateinit var sharedPrefs: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPrefs = requireActivity().getSharedPreferences("app_prefs", Context.MODE_PRIVATE)

        setupThemeToggle(view)
        setupToolCards(view)
        setupLoginButton(view)
    }

    private fun setupThemeToggle(view: View) {
        val themeToggle = view.findViewById<ImageButton>(R.id.themeToggle)
        val isDarkMode = sharedPrefs.getBoolean("dark_mode", true)

        themeToggle.setImageResource(
            if (isDarkMode) R.drawable.ic_theme else R.drawable.ic_theme
        )

        themeToggle.setOnClickListener {
            val editor = sharedPrefs.edit()
            editor.putBoolean("dark_mode", !isDarkMode)
            editor.apply()
            requireActivity().recreate()
        }
    }

    private fun setupToolCards(view: View) {
        val toolsFragment = parentFragmentManager.findFragmentById(R.id.fragment_container)

        view.findViewById<View>(R.id.cardAttendance)?.setOnClickListener {
            navigateToTool("https://attendanceiq.pythonanywhere.com/")
        }

        view.findViewById<View>(R.id.cardMatcher)?.setOnClickListener {
            navigateToTool("https://attendanceiq.pythonanywhere.com/")
        }

        view.findViewById<View>(R.id.cardReport)?.setOnClickListener {
            navigateToTool("https://attendanceiq.pythonanywhere.com/")
        }
    }

    private fun navigateToTool(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    private fun setupLoginButton(view: View) {
        view.findViewById<MaterialButton>(R.id.btnLogin)?.setOnClickListener {
            navigateToTool("https://attendanceiq.pythonanywhere.com/")
        }
    }
}
