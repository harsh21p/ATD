package com.atd.atdmobileapp.ui.onboarding.pages

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentWelcomeBinding
import com.atd.atdmobileapp.utils.Constants
import com.atd.atdmobileapp.utils.SharedPrefManager
import com.atd.atdmobileapp.utils.toast
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class WelcomeToATDFragment : Fragment() {
    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var sharedPrefManager: SharedPrefManager
    var hasNotificationPermissionGranted = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewpager)
        binding.tvNextWelcome.setOnClickListener {
            viewPager?.currentItem = 1
        }
        skipOnBoarding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (Build.VERSION.SDK_INT >= 33) {
            notificationPermissionLauncher.launch(android.Manifest.permission.POST_NOTIFICATIONS)
        } else {
            hasNotificationPermissionGranted = true
        }
    }

    private fun skipOnBoarding() {
        binding.tvSkip.setOnClickListener {
            sharedPrefManager.saveOnBoardingStatus(Constants.ONBOARDING)
            findNavController().navigate(R.id.action_onBoardingFragment_to_loginFragment)
        }
    }

    private val notificationPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                toast("notification permission granted")
            }
        }

    private fun showSettingDialog() {
        MaterialAlertDialogBuilder(requireContext(), com.google.android.material.R.style.MaterialAlertDialog_Material3)
            .setTitle(getString(R.string.notification))
            .setMessage(getString(R.string.notification_permission))
            .setPositiveButton(getString(R.string.okay)) { _, _ ->
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                intent.data = Uri.parse("package:com.atd.atdmobileapp")
                startActivity(intent)
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun showNotificationPermissionRationale() {

        MaterialAlertDialogBuilder(requireContext(), com.google.android.material.R.style.MaterialAlertDialog_Material3)
            .setTitle("Alert")
            .setMessage("Notification permission is required, to show notification")
            .setPositiveButton("Ok") { _, _ ->
                if (Build.VERSION.SDK_INT >= 33) {
                    notificationPermissionLauncher.launch(android.Manifest.permission.POST_NOTIFICATIONS)
                }
            }
            .setNegativeButton("Cancel", null)
            .show()
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding =null
    }



}