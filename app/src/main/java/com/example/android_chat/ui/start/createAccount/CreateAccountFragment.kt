package com.example.android_chat.ui.start.createAccount

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.android_chat.data.EventObserver
import com.example.android_chat.R
import com.example.android_chat.databinding.FragmentCreateAccountBinding
import com.example.android_chat.ui.main.MainActivity
import com.example.android_chat.util.SharedPreferencesUtil
import com.example.android_chat.util.forceHideKeyboard
import com.example.android_chat.util.showSnackBar

class CreateAccountFragment : Fragment() {

    private val viewModel by viewModels<CreateAccountViewModel>()
    private lateinit var viewDataBinding: FragmentCreateAccountBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = FragmentCreateAccountBinding.inflate(inflater, container, false)
            .apply { viewmodel = viewModel }
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner
        setHasOptionsMenu(true)
        return viewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupObservers()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                findNavController().popBackStack()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupObservers() {
        viewModel.dataLoading.observe(viewLifecycleOwner,
            EventObserver { (activity as MainActivity).showGlobalProgressBar(it) })

        viewModel.snackBarText.observe(viewLifecycleOwner,
            EventObserver { text ->
                view?.showSnackBar(text)
                view?.forceHideKeyboard()
            })

        viewModel.isCreatedEvent.observe(viewLifecycleOwner, EventObserver {
            SharedPreferencesUtil.saveUserID(requireContext(), it.uid)
            navigateToChats()
        })
    }

    private fun navigateToChats() {
        findNavController().navigate(R.id.action_createAccountFragment_to_navigation_chats)
    }
}