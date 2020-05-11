package io.indrian.celenganbersama.ui.main

import android.content.res.ColorStateList
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import io.indrian.celenganbersama.R
import io.indrian.celenganbersama.ui.userhome.UserHomeFragment
import io.indrian.celenganbersama.ui.userme.UserMeFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val viewModel: MainViewModel by viewModel()

    private val menuStateObserver = Observer<MainMenuState> { state ->

        when (state) {

            is MainMenuState.Home -> {

                homeButtonState(true)
                meButtonState(false)
                changeFragment(UserHomeFragment.newInstance(), UserHomeFragment.TAG)
                changeStatusBarColor(R.color.primaryColor)
            }

            is MainMenuState.Me -> {

                homeButtonState(false)
                meButtonState(true)
                changeFragment(UserMeFragment.newInstance(), UserMeFragment.TAG)
                changeStatusBarColor(R.color.primaryTextColor)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.mainMenuState.observe(this, menuStateObserver)
        initListener()
    }

    private fun initListener() {

        btn_home.setOnClickListener(this)
        btn_me.setOnClickListener(this)
    }

    override fun onDestroy() {
        viewModel.mainMenuState.removeObserver(menuStateObserver)
        super.onDestroy()
    }

    override fun onClick(v: View?) {

        when (v?.id) {

            R.id.btn_home -> viewModel.changeMenu(MainMenuState.Home)
            R.id.btn_me -> viewModel.changeMenu(MainMenuState.Me)
        }
    }

    private fun homeButtonState(filled: Boolean) {

        if (filled) {

            btn_home.setColorFilter(resources.getColor(R.color.primaryTextColor))
            btn_home.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.primaryColor))

        } else {

            btn_home.setColorFilter(resources.getColor(R.color.primaryColor))
            btn_home.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.primaryTextColor))
        }
    }

    private fun meButtonState(filled: Boolean) {

        if (filled) {

            btn_me.setColorFilter(resources.getColor(R.color.primaryTextColor))
            btn_me.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.primaryColor))

        } else {

            btn_me.setColorFilter(resources.getColor(R.color.primaryColor))
            btn_me.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.primaryTextColor))
        }
    }

    private fun changeFragment(fragment: Fragment, tag: String) {

        val transaction = supportFragmentManager.apply {

            popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }.beginTransaction().also {

            it.replace(R.id.user_frame, fragment, tag)
        }

        transaction.commit()
    }

    private fun changeStatusBarColor(color: Int) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, color);
        }
    }
}
