package io.indrian.celenganbersama.ui.dialogs

import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import io.indrian.celenganbersama.R


class LoadingDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.dialog_loading, container, false)
    }

    override fun onResume() {
        super.onResume()

        val window = dialog?.window
        if (window != null) {

            val params = window.attributes
            params.width = resources.getDimensionPixelSize(R.dimen.popup_loading)
            params.height = resources.getDimensionPixelSize(R.dimen.popup_loading)

            window.attributes = params
            window.setGravity(Gravity.CENTER)
            window.setBackgroundDrawableResource(android.R.color.transparent)
        }
    }
}