package com.atd.atdmobileapp.ui.splash

import android.app.Dialog
import android.app.KeyguardManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentSplashBinding
import com.atd.atdmobileapp.utils.SharedPrefManager
import com.atd.atdmobileapp.utils.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import java.util.concurrent.Executor
import javax.inject.Inject

@AndroidEntryPoint
class SplashFragment : Fragment() {
    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!
    private val scope = CoroutineScope(Dispatchers.Main)
    private lateinit var biometricPrompt: BiometricPrompt
    private lateinit var executor: Executor
    private lateinit var callBack: BiometricPrompt.AuthenticationCallback
    private var keyguardManager: KeyguardManager? = null
    @Inject
    lateinit var sharedPrefManager: SharedPrefManager
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        init()
        checkDeviceCanAuthenticateWithBiometrics()
        if(sharedPrefManager.getBiometricEnabled()) {
            authenticateWithBiometrics()
        }else {
            screenDelay()
        }
        return binding.root
    }


    private fun screenDelay() {
        scope.launch {
            delay(2000)
            if (sharedPrefManager.getOnBoardingStatus() == null) {
                findNavController().navigate(R.id.action_splashFragment_to_onBoardingFragment)
            } else {
                if (sharedPrefManager.getToken() == null) {
                    findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
                } else if (sharedPrefManager.getProfileSelected() == null) {
                    findNavController().navigate(R.id.action_splashFragment_to_chooseProfileFragment)
                } else if(sharedPrefManager.getLocationNumber() != null) {
                    findNavController().navigate(R.id.action_splashFragment_to_boottomNavigation)
                } else if (sharedPrefManager.getLocationNumber() == null){
                    findNavController().navigate(R.id.action_splashFragment_to_chooseProfileFragment)
                }
            }
        }
    }

    private fun authenticateWithBiometrics() {
        val promptInfo = BiometricPrompt.PromptInfo.Builder().apply {
            setTitle(getString(R.string.title_biometric_dialog))
            setDescription(getString(R.string.text_description_biometrics_dialog))
            setAllowedAuthenticators(BiometricManager.Authenticators.BIOMETRIC_WEAK or BiometricManager.Authenticators.DEVICE_CREDENTIAL)
        }.build()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            keyguardManager = requireContext().getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
            keyguardManager?.let { manager ->
                if (manager.isKeyguardSecure) {
                    biometricPrompt.authenticate(promptInfo)
                } else {
                    startActivityForResult(
                        setUpDeviceLockInAPIBelow23Intent(),
                        RC_DEVICE_CREDENTIAL_ENROLL
                    )
                }
            }
        } else {
            biometricPrompt.authenticate(promptInfo)
        }
    }
    private fun init() {
        executor = ContextCompat.getMainExecutor(requireActivity().applicationContext)
        callBack = object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                toast(getString(R.string.error_unknown))
            }

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                toast(getString(R.string.message_success))
                screenDelay()
            }

            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                if(errorCode==10){
                    showDialog()
                }else {
                    toast(getErrorMessage(errorCode))
                }
            }
        }
        biometricPrompt = BiometricPrompt(this, executor, callBack)
    }

    private fun showDialog() {
        val dialog = Dialog(requireActivity())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.custom_layout)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent);
        val okText = dialog.findViewById(R.id.tvOk) as TextView
        val tvErrorMessage = dialog.findViewById(R.id.tvErrorMessage) as TextView
        val tvErrorTitle = dialog.findViewById(R.id.tvErrorTitle) as TextView
        tvErrorMessage.text = getString(R.string.error_user_canceled)
        tvErrorTitle.text = getString(R.string.atd_app_locked)
        okText.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun checkDeviceCanAuthenticateWithBiometrics() {
        val biometricManager = BiometricManager.from(requireActivity().applicationContext)
        when (biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_WEAK or BiometricManager.Authenticators.DEVICE_CREDENTIAL)) {
            BiometricManager.BIOMETRIC_SUCCESS -> {
            }
            BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> {

                toast(getString(R.string.message_no_support_biometrics))
            }
            BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE -> {

                toast(getString(R.string.message_no_hardware_available))
            }
            BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> {
               // checkAPILevelAndProceed()
            }
            BiometricManager.BIOMETRIC_ERROR_SECURITY_UPDATE_REQUIRED -> {
                toast(getString(R.string.error_security_update_required))
            }
            BiometricManager.BIOMETRIC_ERROR_UNSUPPORTED -> {
                toast(getString(R.string.error_unknown))
            }
            BiometricManager.BIOMETRIC_STATUS_UNKNOWN -> {
                toast(getString(R.string.error_unknown))
            }
        }
    }

    private fun biometricsEnrollIntent(): Intent {
        return Intent(Settings.ACTION_BIOMETRIC_ENROLL).apply {
            putExtra(
                Settings.EXTRA_BIOMETRIC_AUTHENTICATORS_ALLOWED,
                BiometricManager.Authenticators.BIOMETRIC_WEAK or BiometricManager.Authenticators.DEVICE_CREDENTIAL
            )
        }
    }

    private fun setUpDeviceLockInAPIBelow23Intent(): Intent {
        return Intent(Settings.ACTION_SECURITY_SETTINGS)
    }

    private fun checkAPILevelAndProceed() {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                startActivityForResult(setUpDeviceLockInAPIBelow23Intent(), RC_DEVICE_CREDENTIAL_ENROLL)
            } else {
                startActivityForResult(biometricsEnrollIntent(), RC_BIOMETRICS_ENROLL)
            }
        }catch (e: java.lang.Exception){
            println("biometric api level")
        }
    }

    private fun getErrorMessage(errorCode: Int): String {
        return when (errorCode) {
            BiometricPrompt.ERROR_NEGATIVE_BUTTON -> {
                getString(R.string.message_user_app_authentication)
            }
            BiometricPrompt.ERROR_HW_UNAVAILABLE -> {
                getString(R.string.error_hw_unavailable)
            }
            BiometricPrompt.ERROR_UNABLE_TO_PROCESS -> {
                getString(R.string.error_unable_to_process)
            }
            BiometricPrompt.ERROR_TIMEOUT -> {
                getString(R.string.error_time_out)
            }
            BiometricPrompt.ERROR_NO_SPACE -> {
                getString(R.string.error_no_space)
            }
            BiometricPrompt.ERROR_CANCELED -> {
                getString(R.string.error_canceled)
            }
            BiometricPrompt.ERROR_LOCKOUT -> {
                getString(R.string.error_lockout)
            }
            BiometricPrompt.ERROR_VENDOR -> {
                getString(R.string.error_vendor)
            }
            BiometricPrompt.ERROR_LOCKOUT_PERMANENT -> {
                getString(R.string.error_lockout_permanent)
            }
            BiometricPrompt.ERROR_USER_CANCELED -> {
                getString(R.string.error_user_canceled)
            }
            BiometricPrompt.ERROR_NO_BIOMETRICS -> {
                checkAPILevelAndProceed()
                getString(R.string.error_no_biometrics)
            }
            BiometricPrompt.ERROR_HW_NOT_PRESENT -> {
                getString(R.string.error_hw_not_present)
            }
            BiometricPrompt.ERROR_NO_DEVICE_CREDENTIAL -> {
                startActivityForResult(biometricsEnrollIntent(), RC_BIOMETRICS_ENROLL)
                getString(R.string.error_no_device_credentials)
            }
            BiometricPrompt.ERROR_SECURITY_UPDATE_REQUIRED -> {
                getString(R.string.error_security_update_required)
            }
            else -> {
                getString(R.string.error_unknown)
            }
        }
    }

    companion object {
        const val RC_BIOMETRICS_ENROLL = 10
        const val RC_DEVICE_CREDENTIAL_ENROLL = 18
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onPause() {
        super.onPause()
        scope.cancel()
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }


}