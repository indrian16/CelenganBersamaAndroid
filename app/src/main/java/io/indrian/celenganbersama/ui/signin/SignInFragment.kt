package io.indrian.celenganbersama.ui.signin


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.indrian.celenganbersama.R
import io.indrian.celenganbersama.ui.login.LoginActivity
import io.indrian.celenganbersama.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_sign_in.*

class SignInFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListener()
    }

    private fun initListener() {

        btn_login.setOnClickListener(this)
        btn_login_facebook.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when (v?.id) {

            R.id.btn_login -> {

                (activity as LoginActivity).showLoading()
            }

            R.id.btn_login_facebook -> {

                val intent = Intent(activity, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
