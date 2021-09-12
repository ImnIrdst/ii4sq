package com.imn.ii4sq.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.imn.ii4sq.utils.ViewLifecycleDelegateMutable

abstract class BaseFragment<T : ViewBinding> : Fragment() {

    protected var binding: T by ViewLifecycleDelegateMutable()

    abstract fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = inflateBinding(inflater, container).also { binding = it; }.root
}
