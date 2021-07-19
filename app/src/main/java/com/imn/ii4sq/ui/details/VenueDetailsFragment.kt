package com.imn.ii4sq.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import com.imn.ii4sq.R
import com.imn.ii4sq.databinding.FragmentVenueDetailsBinding
import com.imn.ii4sq.domain.entities.State
import com.imn.ii4sq.domain.entities.VenueDetails
import com.imn.ii4sq.domain.entities.humanReadable
import com.imn.ii4sq.ui.base.BaseBottomSheetFragment
import com.imn.ii4sq.utils.showSnackbar
import org.koin.androidx.viewmodel.ext.android.viewModel


class VenueDetailsFragment : BaseBottomSheetFragment<FragmentVenueDetailsBinding>() {

    private val args: VenueDetailsFragmentArgs by navArgs()

    private val detailsViewModel: VenueDetailsViewModel by viewModel()

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentVenueDetailsBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
        initViewModels()
    }

    private fun initUI() = with(binding) {
        titleTextView.text = args.venue.name
    }


    private fun initViewModels() {
        detailsViewModel.venueDetails.observe(viewLifecycleOwner) {
            handleVenueDetailsState(it)
        }
        detailsViewModel.loadVenueDetails(args.venue.id)
    }

    private fun handleVenueDetailsState(it: State<VenueDetails>) = with(binding) {
        when(it) {
            is State.Failure -> {
                coordinatorLayout.showSnackbar(
                    it.error.humanReadable(requireContext()),
                    Snackbar.LENGTH_INDEFINITE,
                    R.string.retry
                ) {
                    detailsViewModel.loadVenueDetails(args.venue.id)
                }
                loadingView.isVisible = false
            }
            is State.Loading -> {
                loadingView.isVisible = true
            }
            is State.Success -> {
                loadingView.isVisible = false
                populateUI(it.value)
            }
        }
    }


    private fun populateUI(details: VenueDetails) = with(binding) {
        addressTextView.text = details.location.address

        phoneTextView.text = details.contact.formattedPhone
        phoneFlow.isVisible = details.contact.formattedPhone != null

        descriptionTextView.text = details.description
        descriptionFlow.isVisible = details.description != null

        binding.root.viewTreeObserver.addOnGlobalLayoutListener {
            (dialog as BottomSheetDialog).behavior.peekHeight = binding.root.height
        }
    }
}