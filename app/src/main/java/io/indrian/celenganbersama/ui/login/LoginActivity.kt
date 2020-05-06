package io.indrian.celenganbersama.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import io.indrian.celenganbersama.R
import io.indrian.celenganbersama.adapter.LoginPagerAdapter
import io.indrian.celenganbersama.ui.dialogs.LoadingDialogFragment
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    companion object {

        private const val TAG_LOADING = "tag_loading"
    }

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

    fun showLoading() {

        val fragmentManager = supportFragmentManager
        val loadingDialogFragment = LoadingDialogFragment()
        loadingDialogFragment.show(fragmentManager, TAG_LOADING)
    }

    fun hideLoading() {

        val prev = supportFragmentManager.findFragmentByTag(TAG_LOADING)
        if (prev != null) {

            val loadingDialogFragment = prev as LoadingDialogFragment
            loadingDialogFragment.dismiss()
        }
    }
}
