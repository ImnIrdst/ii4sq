package com.imn.ii4sq.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.imn.ii4sq.R
import com.imn.ii4sq.databinding.FragmentVenueDetailsBinding

/**
 * A simple [Fragment] subclass as the venue_details destination in the navigation.
 */
class VenueDetailsFragment : Fragment() {

    private var _binding: FragmentVenueDetailsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentVenueDetailsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonVenueDetails.setOnClickListener {
            findNavController().navigate(R.id.action_VenueDetailsFragment_to_MapFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}