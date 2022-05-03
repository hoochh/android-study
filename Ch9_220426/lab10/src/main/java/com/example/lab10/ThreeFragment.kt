package com.example.lab10

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lab10.databinding.FragmentThreeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [OneFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ThreeFragment : Fragment() {
    lateinit var binding: FragmentThreeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentThreeBinding.inflate(inflater, container, false)
        return binding.root
    }
}