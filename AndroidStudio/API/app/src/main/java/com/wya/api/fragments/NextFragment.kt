package com.wya.api.fragments

import android.os.Bundle
import android.telecom.Call
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wya.api.R
import kotlinx.android.synthetic.main.fragment_next.view.*

class NextFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_next, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var url = arguments.let {
            NextFragmentArgs.fromBundle(it)
        }
        var url : String = urlBundle?.articleUrl.webView.loadUrl(url)}


}