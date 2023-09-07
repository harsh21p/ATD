package com.atd.atdmobileapp.ui.bottomnavigation.account

import android.app.Dialog
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentAccountBinding
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment.Companion.theameColor
import com.atd.atdmobileapp.ui.bottomnavigation.account.preferences.PreferencesFragment
import com.atd.atdmobileapp.ui.login.LoginViewModel
import com.atd.atdmobileapp.utils.*
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class AccountFragment : Fragment(), RecyclerViewClickListener {


    private var _binding: FragmentAccountBinding? = null
    private val binding get() = _binding!!
    private val permissionViewModel by viewModels<LoginViewModel>()

    @Inject
    lateinit var sharedPrefManager: SharedPrefManager
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    private lateinit var adapter: AccountAdapter
    private lateinit var username_local: String
    private var location_number_local: String = ""

    private val accountViewModel by viewModels<AccountViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAccountBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setUpTheme()
        firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext())
        setupUI()
        //setting up location number
        sharedPrefManager?.getLocationNumber()?.let {
            binding.tvLocationNumber.text = getString(R.string.location_number)+it
            location_number_local=it
        }
        accountViewModel.username.observe(viewLifecycleOwner) { username ->
            binding.tvUsername.text = username
            username_local = username
        }

        accountViewModel.locationDetails.observe(viewLifecycleOwner) { locationDetails ->
            binding.tvAddress.text = locationDetails.location
            binding.textView3.text = locationDetails.dc

        }

        sharedPrefManager.getProfileSelected()?.let {
            if (it.equals("tirepros",true)){
                binding.tvCustomerCare.text="${Constants.CUSTOMER_CARE} (866) 263-6283"
            }else if (it.equals("atdonline",true)){
                binding.tvCustomerCare.text="${Constants.CUSTOMER_CARE} (800) 903-0014"
            }
        }

        return root
    }

    private fun setUpTheme() {

        binding.ivHomeIcon.imageTintList= ContextCompat.getColorStateList(requireActivity(), theameColor)
        binding.ivProfileIcon.imageTintList= ContextCompat.getColorStateList(requireActivity(), theameColor)
        binding.imageView7.imageTintList= ContextCompat.getColorStateList(requireActivity(), theameColor)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        firebaseAnalytics = FirebaseAnalyticsManager.getInstance(requireContext())
        getVersionName()
    }

    fun setupUI() {
        visitAccountEvent()
        var title = arrayOf(
            "Preferences",
            "Communication Settings",
            "Change Location",
            "Send Feedback",
            "Privacy Policy",
            "Visit ATD Online",
            "Log Out"
        )

        var icons = arrayOf(
            R.drawable.preferences_account,
            R.drawable.comms_settings_account,
            R.drawable.location_account,
            R.drawable.mail_account,
            R.drawable.lock_account,
            R.drawable.external_link_account,
            R.drawable.logout_icon
        )

        val locationCount = sharedPrefManager.getLocationCount()


        //logic for skipping Change location if user has access to only 1 location
        if (locationCount <=1){
            val filteredTitle =  title.sliceArray(0 until 2) + title.sliceArray(3 until title.size)

            val filteredIcon = icons.sliceArray(0 until 2) + icons.sliceArray(3 until icons.size)

            title = filteredTitle
            icons = filteredIcon
        }

        adapter = AccountAdapter(title, icons,this,requireActivity())
        binding.rcAccount.layoutManager = LinearLayoutManager(requireActivity())
        binding.rcAccount.adapter = adapter
    }

    private fun visitAccountEvent() {
        val params=Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Account,
            Category.Navigation,
            Action.Impression,
            "Accounts screen"
        )

        params.putString(FirebaseAnalytics.Param.SCREEN_NAME, Screen.Account)
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, params)
    }

    override fun onItemClick(view: View, tabName: String) {
        //getting View clicked
        println("Received data as $tabName")

        when (tabName) {
            "Preferences" -> {
                // Code to execute when the title is "Preferences"
//                findNavController().navigate(R.id.preferencesFragment)
                PreferencesFragment().show(requireActivity().supportFragmentManager, PreferencesFragment.TAG)
            }
            "Communication Settings" -> {
                // Code to execute when the title is "Communication Settings"
            }
            "Change Location" -> {
                // Code to execute when the title is "Change Location"
                //adding event
                tapChangesLocationEvent()
                sharedPrefManager.removeSelectedLocation()
                sharedPrefManager.removeLocationNumber()
                if (sharedPrefManager.getMultipleProfileAccess()){
                    findNavController().navigate(R.id.action_boottomNavigation_to_chooseProfileFragment)

                }else{
                    findNavController().navigate(R.id.action_boottomNavigation_to_selectLocation)
                }
            }
            "Send Feedback" -> {
                // Code to execute when the title is "Send Feedback"
                //add event
                tapFeedbackLinkEvent()
                val recipient = "online_support@atd-us.com"
                val subject = "ATDMobile Feedback [$username_local][$location_number_local]"

                val intent = Intent(Intent.ACTION_SEND).apply {
//                    data = Uri.parse("mailto:$recipient")
                    type = "text/plain"
                    putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
                    putExtra(Intent.EXTRA_SUBJECT, subject)
                }

                try {
                    startActivity(Intent.createChooser(intent, "Choose Email Client"))
                } catch (e: Exception) {
                    // Handle the case where no email app is available
                }
            }
            "Privacy Policy" -> {
                // Code to execute when the title is "Privacy Policy"
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://www.atd-us.com/en/privacy-policy")
                startActivity(intent)
            }
            "Visit ATD Online" -> {
                // Code to execute when the title is "Visit ATD Online"
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://www.atd-us.com")
                startActivity(intent)
            }
            "Log Out" -> {
                //adding logout event

                CoroutineScope(Dispatchers.IO).launch {

                    sharedPrefManager.removeToken()
                    sharedPrefManager.removeLocationCount()
                    sharedPrefManager.removeSelectedLocation()
                    sharedPrefManager.removeLocationNumber()
                    sharedPrefManager.removeApprovals()
                    sharedPrefManager.removeBiometric()
                    sharedPrefManager.removeUserName()
                    sharedPrefManager.removeUserRole()
                    sharedPrefManager.removePORegex()
                    sharedPrefManager.removePoRequired()
                    sharedPrefManager.removeDeliveryDefault()
                    sharedPrefManager.removeSelectedDelivery()
                    sharedPrefManager.removeApproveOrdersAtdOnline()
                    sharedPrefManager.removeApproveOrdersTirePros()
                    sharedPrefManager.removeNeedByDate()
                    permissionViewModel.deleteRoomDatabase()
                    sharedPrefManager.removeMultipleProfileAccess()
                }

                findNavController().navigate(R.id.action_boottomNavigation_to_loginFragment)
                logoutEvent()
                showDialog()
            }
            else -> {
                // Code to execute when none of the other cases match
            }
        }
    }

    private fun tapFeedbackLinkEvent() {
        val params = Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Account,
            Category.Account,
            Action.Click,
            "Feedback submitted"
        )
        firebaseAnalytics.logEvent(FirebaseCustomEvents.Submit_Feedback, params)
    }

    private fun tapChangesLocationEvent() {
       val params =Common.makeFirebaseEventBundle(
           firebaseAnalytics,
           sharedPrefManager,
           Screen.Select_Location,
           Category.Account,
           Action.Click,
           "Location changed"
       )

        firebaseAnalytics.logEvent(FirebaseCustomEvents.Change_Location, params)
    }

    private fun logoutEvent() {
        val params = Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Account,
            Category.Login,
            Action.Click,
            "Logout"
        )

        firebaseAnalytics.logEvent(FirebaseCustomEvents.Logout, params)
    }

    private fun taplogOutEvent() {
        val params = Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Account,
            Category.Login,
            Action.Click,
            "Logout"
        )

        firebaseAnalytics.logEvent(FirebaseCustomEvents.Logout, params)
    }



    private fun showDialog() {
        val dialog = Dialog(requireActivity())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.custom_layout)
        dialog.getWindow()?.setBackgroundDrawableResource(android.R.color.transparent);
        val okText = dialog.findViewById(R.id.tvOk) as TextView
        okText.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun getVersionName() {
        val pm: PackageManager = requireContext().packageManager
        val pkgName: String = requireContext().packageName
        var pkgInfo: PackageInfo? = null
        try {
            pkgInfo = pm.getPackageInfo(pkgName, 0)
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        val ver = pkgInfo!!.versionName
        binding.tvVersionNumber.text = ver
    }

}