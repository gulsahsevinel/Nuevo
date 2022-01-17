package com.gulsah.nuevocase.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.gulsah.nuevocase.adapter.PhotosAdapter
import com.gulsah.nuevocase.R
import com.gulsah.nuevocase.databinding.FragmentFirstViewBinding
import com.gulsah.nuevocase.viewModel.ViewModel
import com.squareup.picasso.Picasso

class FirstViewFragment : Fragment() {

    private lateinit var binding: FragmentFirstViewBinding
    private lateinit var viewModel : ViewModel
    private lateinit var photosAdapter: PhotosAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first_view, container, false)
        binding.firstViewFragment = this
        viewModel.photoList.observe(viewLifecycleOwner){
            photosAdapter = PhotosAdapter(it)
            binding.photosAdapter = photosAdapter
            Picasso.get().load(it[0].url).into(binding.imageView)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temp : ViewModel by viewModels()
        viewModel = temp
    }
}