package com.example.perritosapk.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.perritosapk.DogViewModel
import com.example.perritosapk.R
import com.example.perritosapk.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
private lateinit var binding: FragmentSecondBinding
private val viewModel : DogViewModel by activityViewModels()
    lateinit var breed :String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            breed= it.getString("breed","")
        }
    }
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = DogAdapter()
        //asignar raza a edtext desde firsfragment
        binding.breed2.text = breed
        viewModel.allDogBreed.observe(viewLifecycleOwner,{
             it.let {

        adapter.update(it)
            }
}
        )

    }
}