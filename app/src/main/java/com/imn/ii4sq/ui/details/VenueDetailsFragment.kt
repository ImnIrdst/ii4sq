package com.imn.ii4sq.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.imn.ii4sq.databinding.FragmentVenueDetailsBinding
import com.imn.ii4sq.ui.base.BaseBottomSheetFragment

/**
 * A simple [Fragment] subclass as the venue_details destination in the navigation.
 */
class VenueDetailsFragment : BaseBottomSheetFragment<FragmentVenueDetailsBinding>() {

    private val args: VenueDetailsFragmentArgs by navArgs()

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentVenueDetailsBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textviewVenueDetails.text = args.venue.toString()
    }
}