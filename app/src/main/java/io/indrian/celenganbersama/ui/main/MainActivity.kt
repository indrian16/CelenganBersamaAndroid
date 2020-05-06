package io.indrian.celenganbersama.ui.main

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.github.ajalt.timberkt.Timber
import io.indrian.celenganbersama.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val viewModel: MainViewModel by viewModel()

    private val menuStateObserver = Observer<MainMenuState> { state ->

        when (state) {

            is MainMenuState.Home -> {

                homeButtonState(true)
                meButtonState(false)
            }

            is MainMenuState.Me -> {

                homeButtonState(false)
                meButtonState(true)
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
}
