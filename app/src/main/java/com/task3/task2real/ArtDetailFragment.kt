package com.task3.task2real

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.task3.task2real.databinding.FragmentArtDetailBinding
import java.util.Date
import java.util.UUID

class  ArtDetailFragment: Fragment(){

    private lateinit var binding: FragmentArtDetailBinding

    private lateinit var art: Art

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        art = Art(
            id = UUID.randomUUID(),
            title = "",
            date = Date(),
            isSolved = false
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArtDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            artTitle.doOnTextChanged(){ text, _, _, _ ->
                art = art.copy(title = text.toString())
            }

            artDate.apply {
                text = art.date.toString()
                isEnabled = false
            }

            artSolved.setOnCheckedChangeListener { _, isChecked ->
                art = art.copy(isSolved = isChecked)
            }

            }
        }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    }

