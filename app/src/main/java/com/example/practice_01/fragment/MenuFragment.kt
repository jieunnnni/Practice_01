package com.example.practice_01.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.practice_01.R
import com.example.practice_01.databinding.FragmentMenuBinding

class MenuFragment: Fragment(R.layout.fragment_menu) {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }


     fun newInstance(): MenuFragment {
        val args = Bundle()
        val fragment = MenuFragment()
        fragment.arguments = args
        return fragment
    }
}