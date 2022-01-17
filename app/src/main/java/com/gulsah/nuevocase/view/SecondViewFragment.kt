package com.gulsah.nuevocase.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.gulsah.nuevocase.adapter.CommentsAdapter
import com.gulsah.nuevocase.R
import com.gulsah.nuevocase.databinding.FragmentSecondViewBinding
import com.gulsah.nuevocase.viewModel.ViewModel
import com.squareup.picasso.Picasso

class SecondViewFragment : Fragment() {

    private lateinit var binding : FragmentSecondViewBinding
    private lateinit var viewModel : ViewModel
    private lateinit var commentsAdapter : CommentsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second_view, container, false)
        binding.secondViewFragment = this

        val bundle : SecondViewFragmentArgs by navArgs()
        val photo = bundle.photosObject

        viewModel.comments(photo.photosId)
        Picasso.get().load(photo.url).into(binding.ivAlbumPhoto)
        binding.tvAlbumTitle.text = photo.title

        viewModel.commentsList.observe(viewLifecycleOwner){
            commentsAdapter = CommentsAdapter(it)
            binding.commentsAdapter = commentsAdapter
        }

        binding.ivBack.setOnClickListener {
            val transition = SecondViewFragmentDirections.secondViewFragmentToFirstViewFragment()
            Navigation.findNavController(it).navigate(transition)
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temp : ViewModel by viewModels()
        viewModel = temp
    }
}