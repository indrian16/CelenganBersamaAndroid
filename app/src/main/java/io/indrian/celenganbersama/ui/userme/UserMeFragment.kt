package io.indrian.celenganbersama.ui.userme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.indrian.celenganbersama.R

class UserMeFragment : Fragment() {

    companion object {

        val TAG = UserMeFragment::class.java.simpleName

        fun newInstance() = UserMeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_me, container, false)
    }
}
