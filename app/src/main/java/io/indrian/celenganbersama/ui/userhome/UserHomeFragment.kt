package io.indrian.celenganbersama.ui.userhome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.indrian.celenganbersama.R
import io.indrian.celenganbersama.adapter.SavingAdapter
import kotlinx.android.synthetic.main.card_saving_content.*


class UserHomeFragment : Fragment() {

    companion object {

        val TAG = UserHomeFragment::class.java.simpleName

        fun newInstance() = UserHomeFragment()
    }

    private val mAdapter = SavingAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {

        rv_saving.adapter = mAdapter
    }
}
