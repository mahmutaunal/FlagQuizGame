package com.mahmutalperenunal.flagquiz.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mahmutalperenunal.flagquiz.databinding.FragmentHomeBinding
import com.mahmutalperenunal.flagquiz.database.DatabaseCopyHelper

class FragmentHome : Fragment() {

    private lateinit var fragmentHomeBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)

        createAndOpenDatabase()

        fragmentHomeBinding.buttonStart.setOnClickListener {

            val direction = FragmentHomeDirections.actionFragmentHomeToFragmentQuiz()
            this.findNavController().navigate(direction)

        }

        // Inflate the layout for this fragment
        return fragmentHomeBinding.root
    }

    private fun createAndOpenDatabase() {

        //try-catch
        try {

            val helper = DatabaseCopyHelper(requireActivity())
            helper.createDataBase()
            helper.openDataBase()

        } catch (e: Exception) {

            e.printStackTrace()

        }

    }
}