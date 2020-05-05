package io.indrian.celenganbersama.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import io.indrian.celenganbersama.R
import io.indrian.celenganbersama.ui.adapter.LoginPagerAdapter
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setupViewPager()
    }

    private fun setupViewPager() {

        val titleList: List<String> = arrayListOf(
            getString(R.string.sign_in),
            getString(R.string.sign_up)
        )

        val mAdapter = LoginPagerAdapter(this)
        view_pager_login.adapter = mAdapter
        TabLayoutMediator(tab_login, view_pager_login) { tab, position ->

            tab.text = titleList[position]
            view_pager_login.setCurrentItem(tab.position, true)

        }.attach()
    }
}
