package io.indrian.celenganbersama.ui.userhome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.indrian.celenganbersama.R


class UserHomeFragment : Fragment() {

    companion object {

        val TAG = UserHomeFragment::class.java.simpleName

        fun newInstance() = UserHomeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_home, container, false)
    }
}
