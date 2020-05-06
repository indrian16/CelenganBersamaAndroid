package io.indrian.celenganbersama.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import io.indrian.celenganbersama.ui.signin.SignInFragment
import io.indrian.celenganbersama.ui.signup.SignUpFragment

class LoginPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {

        return when (position) {

            0 -> SignInFragment()
            1 -> SignUpFragment()
            else -> SignInFragment()
        }
    }
}