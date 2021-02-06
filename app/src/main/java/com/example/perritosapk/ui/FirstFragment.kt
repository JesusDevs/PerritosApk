package com.example.perritosapk.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.perritosapk.DogViewModel
import com.example.perritosapk.R
import com.example.perritosapk.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
private lateinit var binding: FragmentFirstBinding
private val viewModel : DogViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentFirstBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = DogAdapter()
        binding.rvView.adapter= adapter
        binding.rvView.layoutManager = LinearLayoutManager(context)

            viewModel.allDogBreed.observe(viewLifecycleOwner, Observer {
            it?.let {
                Log.d("baseDeDatos","$it")
                adapter.update(it)
            }
            })
        adapter.selectedDogItem().observe(viewLifecycleOwner,{
            it?.let{
                viewModel.selectedDog(it)
                val bundle =Bundle()
                bundle.putString("breed",it.breed)
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            }
        })
        }
    }
