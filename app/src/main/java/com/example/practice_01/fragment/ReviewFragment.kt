package com.example.practice_01.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.practice_01.R
import com.example.practice_01.databinding.FragmentReviewBinding

class ReviewFragment : Fragment(R.layout.fragment_review) {

    private var _binding: FragmentReviewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentReviewBinding.inflate(inflater, container, false)
        return binding.root
    }


     fun newInstance(): ReviewFragment {
        val args = Bundle()
        val fragment = ReviewFragment()
        fragment.arguments = args
        return fragment
    }
}