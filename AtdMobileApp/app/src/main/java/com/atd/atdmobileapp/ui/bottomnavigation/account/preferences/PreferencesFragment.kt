package com.atd.atdmobileapp.ui.bottomnavigation.account.preferences

import android.app.AlarmManager
import android.app.Dialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Context.ALARM_SERVICE
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.*
import android.widget.CompoundButton
import android.widget.FrameLayout
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.atd.atdmobileapp.MainActivity
import com.atd.atdmobileapp.MainViewModel
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentPreferencesBinding
import com.atd.atdmobileapp.models.preferences.Item
import com.atd.atdmobileapp.models.preferences.PreferencesConfiguration
import com.atd.atdmobileapp.models.preferences.ProductItems
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment.Companion.theameColor
import com.atd.atdmobileapp.utils.*
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import kotlin.math.cos


@AndroidEntryPoint
class PreferencesFragment() : DialogFragment() {

    private var _binding: FragmentPreferencesBinding ?= null
    private val binding get() = _binding!!
    @Inject
    lateinit var sharedPrefManager: SharedPrefManager
    private lateinit var storedUserPreferences: PreferencesConfiguration
    private var somethingChanged: Boolean = false
    private var costChanged: Boolean = false
    private var isResetPressed: Boolean = false
    private lateinit var mainViewModel: MainViewModel
    private lateinit var firebaseAnalytics: FirebaseAnalytics
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentPreferencesBinding.inflate(inflater, container, false)
        setupHeader()
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.window?.setBackgroundDrawableResource(R.color.white)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext())
        return binding.root
    }

    private fun setUpTheme() {
        
        binding.ivCloseTireType.imageTintList= ContextCompat.getColorStateList(requireActivity(),theameColor)
        binding.arrow1.imageTintList= ContextCompat.getColorStateList(requireActivity(),theameColor)
        binding.arrow2.imageTintList= ContextCompat.getColorStateList(requireActivity(),theameColor)
        binding.arrow3.imageTintList= ContextCompat.getColorStateList(requireActivity(),theameColor)
        binding.arrow4.imageTintList= ContextCompat.getColorStateList(requireActivity(),theameColor)
        binding.arrow5.imageTintList= ContextCompat.getColorStateList(requireActivity(),theameColor)
        binding.tvSave.setTextColor(ContextCompat.getColorStateList(requireActivity(),theameColor))
        binding.resetAll.setTextColor(ContextCompat.getColorStateList(requireActivity(),theameColor))
        binding.businessDaysChart.tSun.setTextColor(ContextCompat.getColorStateList(requireActivity(),theameColor))
        binding.businessDaysChart.tvMon.setTextColor(ContextCompat.getColorStateList(requireActivity(),theameColor))
        binding.businessDaysChart.tvTue.setTextColor(ContextCompat.getColorStateList(requireActivity(),theameColor))
        binding.businessDaysChart.tvWed.setTextColor(ContextCompat.getColorStateList(requireActivity(),theameColor))
        binding.businessDaysChart.tvThu.setTextColor(ContextCompat.getColorStateList(requireActivity(),theameColor))
        binding.businessDaysChart.tvFri.setTextColor(ContextCompat.getColorStateList(requireActivity(),theameColor))
        binding.businessDaysChart.tvSat.setTextColor(ContextCompat.getColorStateList(requireActivity(),theameColor))

        if ( binding.switch1.isChecked) {
            binding.switch1.buttonTintList =
                ContextCompat.getColorStateList(requireActivity(), theameColor)
        }
        if ( binding.swOrderCutOff.isChecked) {
            binding.swOrderCutOff.buttonTintList =
                ContextCompat.getColorStateList(requireActivity(), theameColor)
        }
        if ( binding.swStartOfBusinessDay.isChecked) {
            binding.swStartOfBusinessDay.buttonTintList =
                ContextCompat.getColorStateList(requireActivity(), theameColor)
        }
        if ( binding.swEndOfBusinessDay.isChecked) {
            binding.swEndOfBusinessDay.buttonTintList =
                ContextCompat.getColorStateList(requireActivity(), theameColor)
        }
    }


    companion object {
        const val TAG = "PrefsFrag"
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        visitPreferenceEvent()
        checkUserPreferences()
        onClickTimePicker()
        onTimePickerSelect()
        onClickTimePickerEndTime()
        onTimePickerSelectEndTime()
        onClickBack()
        onClickFitment()
        onClickMyBrands()
        onClickAvailabilityFilter()
        onClickSortOrder()
        onClickAddToCart()
        onClickSave()
        onClickReset()
        onStateChangedForSwitches()
        setUpTheme()
        onclickWeekDay()


    }

    private fun visitPreferenceEvent() {
        val params = Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Preferences,
            Category.Account,
            Action.Impression,
            "User preferences screen"
        )

        params.putString(FirebaseAnalytics.Param.SCREEN_NAME, Screen.Preferences)
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, params)
    }

    private fun onClickReset() {
        binding.resetAll.setOnClickListener {
            somethingChanged = true
            setDefault()
        }
    }

    private fun onClickSave() {
        binding.tvSave.setOnClickListener {
            if (somethingChanged){
                //aading pref change event
                updatePeferenceEvent()
                //logic to show green notification text box
                showConfirmationSnackBar("☑ Account Preferences Saved Successfully")
                somethingChanged = false
                //to save show cost changes in sharedPrefs
                if (costChanged){
                    if(storedUserPreferences.showProductCost == true){
                        sharedPrefManager.saveCV(false)
                    }else{
                        sharedPrefManager.saveCV(true)
                    }
                    costChanged = false
                }
                sharedPrefManager.saveUserPreferences(Gson().toJson(storedUserPreferences))
                mainViewModel.notifyPreferenceChanged()
            }
        }
    }

    private fun updatePeferenceEvent() {
        val params =Common.makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Preferences,
            Category.Account,
            Action.Click,
            "Preferences updated"
        )

        firebaseAnalytics.logEvent(FirebaseCustomEvents.Update_Preferences, params)
    }

    private fun showConfirmationSnackBar(message: String) {
        val coordinatorLayout: ConstraintLayout = binding.root
        val snackBar = Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_LONG)
        val snackBarView = snackBar.view
        snackBarView.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.green))
        val anchorView = binding.tireTypesHeader
        val params = snackBarView.layoutParams as FrameLayout.LayoutParams
        params.gravity = Gravity.TOP or Gravity.FILL_HORIZONTAL
        params.topMargin = anchorView.height
        snackBarView.layoutParams = params
        snackBar.show()
    }

    private fun onClickAddToCart() {
        binding.tvAddToCart.setOnClickListener {
            //open Add To Cart dialogue frag
            OptionFragment(
                Constants.PREFERENCES_ADD_TO_CART,
                storedUserPreferences,
                ::getUserSelection,
                ::getUpdatedQty
            ).show(requireActivity().supportFragmentManager, OptionFragment.TAG)
        }
    }

    private fun onStateChangedForSwitches() {
        binding.switch1.setOnCheckedChangeListener { _: CompoundButton, b: Boolean ->
            somethingChanged = true
            //changing CV value for search result frag
            costChanged = true
            storedUserPreferences.showProductCost = b
            if ( binding.switch1.isChecked) {
                binding.switch1.buttonTintList =
                    ContextCompat.getColorStateList(requireActivity(), theameColor)
            }else{
                binding.switch1.buttonTintList =
                    ContextCompat.getColorStateList(requireActivity(), R.color.dusty_gray)
            }

        }

        binding.swOrderCutOff.setOnCheckedChangeListener { _: CompoundButton, b: Boolean ->
            somethingChanged = true
            storedUserPreferences.orderCutOff = b

            if ( binding.swOrderCutOff.isChecked) {
                binding.swOrderCutOff.buttonTintList =
                    ContextCompat.getColorStateList(requireActivity(), theameColor)
            }else{
                binding.swOrderCutOff.buttonTintList =
                    ContextCompat.getColorStateList(requireActivity(), R.color.dusty_gray)
            }

        }

        binding.swStartOfBusinessDay.setOnCheckedChangeListener { _: CompoundButton, b: Boolean ->
            somethingChanged = true
            storedUserPreferences.startOfBusiness = b
            if ( binding.swStartOfBusinessDay.isChecked) {
                binding.swStartOfBusinessDay.buttonTintList =
                    ContextCompat.getColorStateList(requireActivity(), theameColor)
            }else{
                binding.swStartOfBusinessDay.buttonTintList =
                    ContextCompat.getColorStateList(requireActivity(), R.color.dusty_gray)
            }

        }

        binding.swEndOfBusinessDay.setOnCheckedChangeListener { _: CompoundButton, b: Boolean ->
            somethingChanged = true
            storedUserPreferences.endOfBusiness = b

            if ( binding.swEndOfBusinessDay.isChecked) {
                binding.swEndOfBusinessDay.buttonTintList =
                    ContextCompat.getColorStateList(requireActivity(), theameColor)
            }else{
                binding.swEndOfBusinessDay.buttonTintList =
                    ContextCompat.getColorStateList(requireActivity(), R.color.dusty_gray)
            }
        }
    }

    private fun onClickSortOrder() {
        binding.tvSortOrder.setOnClickListener {
            //open Fitment dialogue frag
            OptionFragment(
                Constants.PREFERENCES_SORT_ORDER,
                storedUserPreferences,
                ::getUserSelection,
                ::getUpdatedQty
            ).show(requireActivity().supportFragmentManager, OptionFragment.TAG)
        }
    }

    private fun onClickAvailabilityFilter() {
        binding.tvAvailabilityFilter.setOnClickListener {
            //open Fitment dialogue frag
            OptionFragment(
                Constants.PREFERENCES_AVAILABILITY_FILTER,
                storedUserPreferences,
                ::getUserSelection,
                ::getUpdatedQty
            ).show(requireActivity().supportFragmentManager, OptionFragment.TAG)
        }

    }

    private fun onClickMyBrands() {
        binding.tvMyBrands.setOnClickListener {
            //open Fitment dialogue frag
            OptionFragment(
                Constants.PREFERENCES_MY_BRANDS,
                storedUserPreferences,
                ::getUserSelection,
                ::getUpdatedQty
            ).show(requireActivity().supportFragmentManager, OptionFragment.TAG)
        }
    }

    private fun getUpdatedQty(item: List<Item>){
        somethingChanged = true
        //got updated qty
        storedUserPreferences.productItems?.items = item
    }

    private fun getUserSelection(item: String, type: String){
        somethingChanged = true
        //got item for type
        when(type){
            Constants.PREFERENCES_FITMENT ->{
                //update fitment results preference
                binding.tvFitmentResultValue.text = item
                storedUserPreferences.fitmentResults = item
            }

            Constants.PREFERENCES_MY_BRANDS ->{
                //update My Brand preference
                binding.tvMyBrandsValue.text = item
                storedUserPreferences.myBrands = item
            }

            Constants.PREFERENCES_AVAILABILITY_FILTER ->{
                //update availability preference
                binding.tvAvailabilityFilterValue.text = item
                storedUserPreferences.availabilityFilter = item
            }

            Constants.PREFERENCES_SORT_ORDER ->{
                //update sort order preference
                binding.tvSortOrderValue.text = item
                storedUserPreferences.sortOrder = item
            }
        }
    }

    private fun onClickFitment() {
        binding.tvFitmentResult.setOnClickListener {
            //open Fitment dialogue frag
            OptionFragment(Constants.PREFERENCES_FITMENT, storedUserPreferences, ::getUserSelection, ::getUpdatedQty).show(requireActivity().supportFragmentManager, OptionFragment.TAG)
        }
    }

    private fun onClickBack() {
        binding.ivCloseTireType.setOnClickListener {
            if (somethingChanged){
                //logic to show save cnfrm dialogue box
                showDialog()
            }else{
                dialog?.dismiss()
            }
        }
    }

    private fun setupWeekDays(){
        val businessDays = storedUserPreferences.businessDays
        businessDays?.forEach { day ->
            when(day){

                "sun" -> {
                    binding.businessDaysChart.tSun.tag = "selected"
                    binding.businessDaysChart.tSun.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
                    binding.businessDaysChart.tSun.background = ContextCompat.getDrawable(requireContext(), theameColor)
                }

                "mon" -> {
                    binding.businessDaysChart.tvMon.tag = "selected"
                    binding.businessDaysChart.tvMon.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
                    binding.businessDaysChart.tvMon.background = ContextCompat.getDrawable(requireContext(), theameColor)
                }

                "tue" -> {
                    binding.businessDaysChart.tvTue.tag = "selected"
                    binding.businessDaysChart.tvTue.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
                    binding.businessDaysChart.tvTue.background = ContextCompat.getDrawable(requireContext(), theameColor)
                }

                "wed" -> {
                    binding.businessDaysChart.tvWed.tag = "selected"
                    binding.businessDaysChart.tvWed.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
                    binding.businessDaysChart.tvWed.background = ContextCompat.getDrawable(requireContext(), theameColor)
                }

                "thu" -> {
                    binding.businessDaysChart.tvThu.tag = "selected"
                    binding.businessDaysChart.tvThu.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
                    binding.businessDaysChart.tvThu.background = ContextCompat.getDrawable(requireContext(), theameColor)
                }

                "fri" -> {
                    binding.businessDaysChart.tvFri.tag = "selected"
                    binding.businessDaysChart.tvFri.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
                    binding.businessDaysChart.tvFri.background = ContextCompat.getDrawable(requireContext(), theameColor)
                }

                "sat" -> {
                    binding.businessDaysChart.tvSat.tag = "selected"
                    binding.businessDaysChart.tvSat.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
                    binding.businessDaysChart.tvSat.background = ContextCompat.getDrawable(requireContext(), theameColor)
                }
            }
        }
    }



    private fun onclickWeekDay() {
        binding.businessDaysChart.tSun.setOnClickListener {
            somethingChanged = true
            if (binding.businessDaysChart.tSun.tag.equals("selected")){
                binding.businessDaysChart.tSun.tag = "unselected"
                binding.businessDaysChart.tSun.setTextColor(ContextCompat.getColor(requireContext(),theameColor))
                binding.businessDaysChart.tSun.background = ContextCompat.getDrawable(requireContext(), R.drawable.border_for_textview)
                storedUserPreferences.businessDays?.remove("sun")
            }else{
                binding.businessDaysChart.tSun.tag = "selected"
                binding.businessDaysChart.tSun.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
                binding.businessDaysChart.tSun.background = ContextCompat.getDrawable(requireContext(), theameColor)
                storedUserPreferences.businessDays?.add("sun")
            }
        }

        binding.businessDaysChart.tvMon.setOnClickListener {
            somethingChanged = true
            if (binding.businessDaysChart.tvMon.tag.equals("selected")){
                binding.businessDaysChart.tvMon.tag = "unselected"
                binding.businessDaysChart.tvMon.setTextColor(ContextCompat.getColor(requireContext(),
                    theameColor))
                binding.businessDaysChart.tvMon.background = ContextCompat.getDrawable(requireContext(), R.drawable.border_for_textview)
                storedUserPreferences.businessDays?.remove("mon")
            }else{
                binding.businessDaysChart.tvMon.tag = "selected"
                binding.businessDaysChart.tvMon.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
                binding.businessDaysChart.tvMon.background = ContextCompat.getDrawable(requireContext(), theameColor)
                storedUserPreferences.businessDays?.add("mon")
            }
        }

        binding.businessDaysChart.tvTue.setOnClickListener {
            somethingChanged = true
            if (binding.businessDaysChart.tvTue.tag.equals("selected")){
                binding.businessDaysChart.tvTue.tag = "unselected"
                binding.businessDaysChart.tvTue.setTextColor(ContextCompat.getColor(requireContext(),theameColor))
                binding.businessDaysChart.tvTue.background = ContextCompat.getDrawable(requireContext(), R.drawable.border_for_textview)
                storedUserPreferences.businessDays?.remove("tue")
            }else{
                binding.businessDaysChart.tvTue.tag = "selected"
                binding.businessDaysChart.tvTue.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
                binding.businessDaysChart.tvTue.background = ContextCompat.getDrawable(requireContext(), theameColor)
                storedUserPreferences.businessDays?.add("tue")
            }
        }

        binding.businessDaysChart.tvWed.setOnClickListener {
            somethingChanged = true
            if (binding.businessDaysChart.tvWed.tag.equals("selected")){
                binding.businessDaysChart.tvWed.tag = "unselected"
                binding.businessDaysChart.tvWed.setTextColor(ContextCompat.getColor(requireContext(),theameColor))
                binding.businessDaysChart.tvWed.background = ContextCompat.getDrawable(requireContext(), R.drawable.border_for_textview)
                storedUserPreferences.businessDays?.remove("wed")
            }else{
                binding.businessDaysChart.tvWed.tag = "selected"
                binding.businessDaysChart.tvWed.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
                binding.businessDaysChart.tvWed.background = ContextCompat.getDrawable(requireContext(), theameColor)
                storedUserPreferences.businessDays?.add("wed")
            }
        }

        binding.businessDaysChart.tvThu.setOnClickListener {
            somethingChanged = true
            if (binding.businessDaysChart.tvThu.tag.equals("selected")){
                binding.businessDaysChart.tvThu.tag = "unselected"
                binding.businessDaysChart.tvThu.setTextColor(ContextCompat.getColor(requireContext(),theameColor))
                binding.businessDaysChart.tvThu.background = ContextCompat.getDrawable(requireContext(), R.drawable.border_for_textview)
                storedUserPreferences.businessDays?.remove("thu")
            }else{
                binding.businessDaysChart.tvThu.tag = "selected"
                binding.businessDaysChart.tvThu.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
                binding.businessDaysChart.tvThu.background = ContextCompat.getDrawable(requireContext(), theameColor)
                storedUserPreferences.businessDays?.add("thu")
            }
        }

        binding.businessDaysChart.tvFri.setOnClickListener {
            somethingChanged = true
            if (binding.businessDaysChart.tvFri.tag.equals("selected")){
                binding.businessDaysChart.tvFri.tag = "unselected"
                binding.businessDaysChart.tvFri.setTextColor(ContextCompat.getColor(requireContext(),theameColor))
                binding.businessDaysChart.tvFri.background = ContextCompat.getDrawable(requireContext(), R.drawable.border_for_textview)
                storedUserPreferences.businessDays?.remove("fri")
            }else{
                binding.businessDaysChart.tvFri.tag = "selected"
                binding.businessDaysChart.tvFri.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
                binding.businessDaysChart.tvFri.background = ContextCompat.getDrawable(requireContext(), theameColor)
                storedUserPreferences.businessDays?.add("fri")
            }
        }

        binding.businessDaysChart.tvSat.setOnClickListener {
            somethingChanged = true
            if (binding.businessDaysChart.tvSat.tag.equals("selected")){
                binding.businessDaysChart.tvSat.tag = "unselected"
                binding.businessDaysChart.tvSat.setTextColor(ContextCompat.getColor(requireContext(),theameColor))
                binding.businessDaysChart.tvSat.background = ContextCompat.getDrawable(requireContext(), R.drawable.border_for_textview)
                storedUserPreferences.businessDays?.remove("sat")
            }else{
                binding.businessDaysChart.tvSat.tag = "selected"
                binding.businessDaysChart.tvSat.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
                binding.businessDaysChart.tvSat.background = ContextCompat.getDrawable(requireContext(), theameColor)
                storedUserPreferences.businessDays?.add("sat")
            }
        }
        setupWeekDays()
    }

    private fun onTimePickerSelectEndTime() {
        binding.timePickerEndTime.setOnTimeChangedListener { view, hourOfDay, minute ->
            val calendar = Calendar.getInstance()
            calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
            calendar.set(Calendar.MINUTE, minute)

            val dateFormat = SimpleDateFormat("h:mm a", Locale.getDefault())
            val formattedTime = dateFormat.format(calendar.time)
            binding.tvEndTimeValue.text = formattedTime
            storedUserPreferences.endTime = formattedTime
            somethingChanged = true
            //val notificationHelper = NotificationHelperClass(requireActivity().applicationContext)
            //notificationHelper.setupNotification(getString(R.string.local_cut_off), getString(R.string.order_now), Gson().fromJson(sharedPrefManager.getUserPreferences(), PreferencesConfiguration()::class.java))
        }
    }



    private fun onClickTimePickerEndTime() {
        val viewList = listOf<View>(binding.tvEndTime, binding.tvEndTimeValue)
        viewList.forEach { view ->
            view.setOnClickListener {
                if(binding.timePickerEndTime.visibility == View.VISIBLE){
                    binding.timePickerEndTime.gone()
                }else{
                    binding.timePickerEndTime.visible()
                }
            }
        }
    }

    private fun onTimePickerSelect() {
        binding.timePicker.setOnTimeChangedListener { view, hourOfDay, minute ->
            val calendar = Calendar.getInstance()
            calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
            calendar.set(Calendar.MINUTE, minute)

            val dateFormat = SimpleDateFormat("h:mm a", Locale.getDefault())
            val formattedTime = dateFormat.format(calendar.time)
            binding.tvStartTimeValue.text = formattedTime
            storedUserPreferences.startTime = formattedTime
            somethingChanged = true
        }
    }

    private fun onClickTimePicker() {
        val viewList = listOf<View>(binding.tvStartTime, binding.tvStartTimeValue)
        viewList.forEach { view ->
            view.setOnClickListener {
                if(binding.timePicker.visibility == View.VISIBLE){
                    binding.timePicker.gone()
                }else{
                    binding.timePicker.visible()
                }
            }
        }
    }

    private fun checkUserPreferences() {
        if (sharedPrefManager.getUserPreferences().isNullOrEmpty()){
            //generate default prefs and assign
            setDefault()
        }else{
            //prev stored prefs found populate the UI with existing data
            storedUserPreferences = Gson().fromJson(sharedPrefManager.getUserPreferences(), PreferencesConfiguration()::class.java)
            setOnPrevSavedPrefs()
        }
    }

    private fun setOnPrevSavedPrefs() {
        binding.switch1.isChecked = storedUserPreferences.showProductCost == true
        binding.swOrderCutOff.isChecked = storedUserPreferences.orderCutOff == true
        binding.swStartOfBusinessDay.isChecked = storedUserPreferences.startOfBusiness == true
        binding.swEndOfBusinessDay.isChecked = storedUserPreferences.endOfBusiness == true
        binding.tvStartTimeValue.text = storedUserPreferences.startTime
        binding.tvEndTimeValue.text = storedUserPreferences.endTime
        binding.tvFitmentResultValue.text = storedUserPreferences.fitmentResults
        binding.tvMyBrandsValue.text = storedUserPreferences.myBrands
        binding.tvAvailabilityFilterValue.text = storedUserPreferences.availabilityFilter
        binding.tvSortOrderValue.text = storedUserPreferences.sortOrder
        //logic to setup bussiness days
        setupWeekDays()
    }

    private fun setDefault() {
        val preferencesConfiguration = PreferencesConfiguration()
        preferencesConfiguration.showProductCost = true
        binding.switch1.isChecked = true
        preferencesConfiguration.orderCutOff = true
        binding.swOrderCutOff.isChecked = true
        preferencesConfiguration.startOfBusiness = true
        binding.swStartOfBusinessDay.isChecked = true
        preferencesConfiguration.startTime = "8:00 AM"
        binding.tvStartTimeValue.text = "8:00 AM"
        preferencesConfiguration.endOfBusiness = true
        binding.swEndOfBusinessDay.isChecked = true
        preferencesConfiguration.endTime = "17:00 PM"
        binding.tvEndTimeValue.text = "17:00 PM"
        preferencesConfiguration.businessDays = mutableListOf("mon","tue","wed","thu", "fri")
        preferencesConfiguration.fitmentResults = "Tires"
        binding.tvFitmentResultValue.text = "Tires"
        preferencesConfiguration.myBrands = "Show All Brands"
        binding.tvMyBrandsValue.text = "Show All Brands"
        preferencesConfiguration.availabilityFilter = "Local+"
        binding.tvAvailabilityFilterValue.text = "Local+"
        preferencesConfiguration.sortOrder = "Brand"
        binding.tvSortOrderValue.text = "Brand"

        val itemsDefault: List<Item> = listOf(
            Item("Passenger Tire", "passenger tires", 4),
            Item("Light Truck Tire", "light truck tires", 4),
            Item("Medium Truck Tire", "medium truck tires", 4),
            Item("Small Tire", "small tires", 2),
            Item("Trailer Tire", "trailer tires", 2),
            Item("Farm Tire", "farm tires", 2),
            Item("Industrial Tire", "industrial tires", 2),
            Item("OTR, Grader, EM Tires", "otr,grader,em tires", 2),
            Item("Tubes and Flaps", "tubes and flaps", 1),
            Item("AG Wheels", "ag wheels", 4),
            Item("Steel Wheels", "steel wheels", 4),
            Item("Custom Wheels", "custom wheels", 4),
            Item("Tire Repair", "tire repair", 1),
            Item("Wheel Accessories", "wheel accessories", 1),
            Item("Supplies", "supplies", 1),
            Item("Tools", "tools", 1)
        )

        preferencesConfiguration.productItems = ProductItems("add to cart/retail quote", itemsDefault)
        if (!isResetPressed){
            //saving default
            sharedPrefManager.saveUserPreferences(Gson().toJson(preferencesConfiguration))
        }
        storedUserPreferences = preferencesConfiguration
        setupWeekDays()

    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return object : Dialog(requireActivity(), theme){
            override fun onBackPressed() {
                showDialog()
            }
        }
    }

    private fun setupHeader() {

        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                backPressed()
            }
        }
        requireActivity()
            .onBackPressedDispatcher
            .addCallback(requireActivity(), onBackPressedCallback)
    }
    private fun backPressed() {
        BottomNavigationScreenFragment.atdLogo?.setOnClickListener(null)
        BottomNavigationScreenFragment.tvHeaderText?.text=""
        BottomNavigationScreenFragment.atdLogo?.setCompoundDrawablesWithIntrinsicBounds(R.drawable.atdheader, 0, 0, 0)

        if (somethingChanged){
            showDialog()
        }else{
            dialog?.dismiss()
        }

    }


    private fun showDialog() {
        val dialogBox = Dialog(requireActivity())
        dialogBox.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogBox.setCancelable(false)
        dialogBox.setContentView(R.layout.custom_preference_delete_layout)
        val title = dialogBox.findViewById(R.id.title) as TextView
        title.text = getString(R.string.save_changes)
        val description = dialogBox.findViewById(R.id.description) as TextView
        description.text = getString(R.string.preferences_dis)
        dialogBox.getWindow()?.setBackgroundDrawableResource(android.R.color.transparent);
        val okText = dialogBox.findViewById(R.id.tvYes) as TextView
        okText.text = getString(R.string.save)
        val cancel = dialogBox.findViewById(R.id.tvCancel) as TextView
        okText.setOnClickListener {
            //saving the update user prefs
            dialogBox.dismiss()
            //save the prefs in shared preferences
            sharedPrefManager.saveUserPreferences(Gson().toJson(storedUserPreferences))
            dialog?.dismiss()
        }
        cancel.setOnClickListener {
            dialogBox.dismiss()
        }
        dialogBox.show()
    }


}