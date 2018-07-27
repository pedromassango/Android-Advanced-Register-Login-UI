package com.pedromassango.androidadvancedregisterloginui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnLogin.setOnClickListener(this@MainActivity)
        btnSignup.setOnClickListener(this@MainActivity)

        // default fragment
        btnLogin.callOnClick()
    }

    override fun onClick(clickedView: View?) {

        lateinit var fragment: Fragment
        when (clickedView!!.id) {
            R.id.btnLogin -> {

                fragment = LoginFragment()
                findViewById<View>(R.id.btnSignup).setBackgroundResource(R.drawable.button_background)
            }
            else -> {
                fragment = SignUpFragment()
                findViewById<View>(R.id.btnLogin).setBackgroundResource(R.drawable.button_background)
            }
        }

        supportFragmentManager.beginTransaction()
                .replace(frameLayout.id, fragment)
                .commit()

        clickedView.setBackgroundResource(R.drawable.button_background_selected)
    }

}
