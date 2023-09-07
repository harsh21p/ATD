package com.atd.atdmobileapp.ui.cart.deliverydayandwindow

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.atd.atdmobileapp.MainViewModel
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentDeliverydayandwindowBinding
import com.atd.atdmobileapp.models.DeliveryDayRequest
import com.atd.atdmobileapp.utils.*
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.DayViewDecorator
import com.prolificinteractive.materialcalendarview.DayViewFacade
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import javax.inject.Inject


@AndroidEntryPoint
class DeliveryDayAndWindowFragment() : DialogFragment() {

    private var _binding: FragmentDeliverydayandwindowBinding? = null
    private val binding get() = _binding!!
    private val deliveryDayAndWindowViewModel by viewModels<DeliveryDayAndWindowViewModel>()
    private lateinit var mainViewModel: MainViewModel
    @Inject
    lateinit var sharedPrefManager: SharedPrefManager
    private val enabledDates = mutableListOf<CalendarDay>()
    private var currentSelectedDate:CalendarDay?=null
    var selectedDates: MutableList<CalendarDay> = mutableListOf()
    var previousSelectedDates: MutableList<CalendarDay> = mutableListOf()
    private lateinit var onApplyClick: (MutableList<CalendarDay>) -> Unit
    private lateinit var onCancel: () -> Unit
    constructor( onApplyClick: (MutableList<CalendarDay>) -> Unit,  onCancel: () -> Unit) : this() {
        this.onApplyClick = onApplyClick
        this.onCancel = onCancel
    }
    companion object {
        const val TAG = "DeliveryDayAndWindowFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.window?.setBackgroundDrawableResource(com.atd.atdmobileapp.R.color.white)
        _binding = FragmentDeliverydayandwindowBinding.inflate(inflater, container, false)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        deliveryDayAndWindowViewModel.getDeliveryDays(DeliveryDayRequest(sharedPrefManager.getLocationNumber().toString()))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backPressed()
        bindObserver()
        onCancelClick()
        onApplyClick()
    }

    private fun bindObserver(){
        deliveryDayAndWindowViewModel.deliveryDaysLiveData.observe(viewLifecycleOwner){
            binding.progressbar.gone()
            when (it) {
                is NetworkResult.Success -> {
                    updateDeliverDaysToCalendar(it.data?.deliverydays?.deliveryday)
                }
                is NetworkResult.Error -> {
                    errorToast(it.message)
                }
                is NetworkResult.Loading -> {
                    binding.progressbar.visible()
                }
            }
        }
    }

    private fun updateDeliverDaysToCalendar(list :List<String>?){
        mainViewModel.selectedCalendarView.observe(viewLifecycleOwner) { viewType ->
            when (viewType) {
                CalendarViewType.FUTURE_DAY -> showCalendarForFutureDay(list)

                CalendarViewType.FUTURE_WINDOW -> showCalendarForFutureWindow(list)
            }
        }
    }

    private fun showCalendarForFutureWindow(deliveryDays: List<String>?) {1
        if (!deliveryDays.isNullOrEmpty()) {
            binding.tvTitle.setText(R.string.delivery_window)
            val calendar = Calendar.getInstance()
            val currentYear = calendar.get(Calendar.YEAR)
            val currentMonth = calendar.get(Calendar.MONTH) + 1
            val currentStartDate = CalendarDay.from(currentYear, currentMonth, 1)
            val currentEndDate = CalendarDay.from(
                currentYear,
                currentMonth,
                calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
            )
            binding.calendarView.state().edit().setMinimumDate(currentStartDate)
                .setMaximumDate(currentEndDate).commit()


            val calendarView = binding.calendarView
            val currentDay = CalendarDay.today()
            calendar.set(currentDay.year, currentDay.month - 1, currentDay.day)
            for (deliveryDay in deliveryDays) {
                val dayOfWeek = when (deliveryDay) {
                    "Sunday" -> Calendar.SUNDAY
                    "Monday" -> Calendar.MONDAY
                    "Tuesday" -> Calendar.TUESDAY
                    "Wednesday" -> Calendar.WEDNESDAY
                    "Thursday" -> Calendar.THURSDAY
                    "Friday" -> Calendar.FRIDAY
                    "Saturday" -> Calendar.SATURDAY
                    else -> -1 // Invalid day
                }

                if (dayOfWeek != -1) {
                    while (calendar.get(Calendar.DAY_OF_WEEK) != dayOfWeek) {
                        calendar.add(Calendar.DAY_OF_WEEK, 1)
                    }
                    val calendarDay = CalendarDay.from(
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH) + 1,
                        calendar.get(Calendar.DAY_OF_MONTH)
                    )
                    enabledDates.add(calendarDay)
                }
            }
            //currentDay background changes
            binding.calendarView.setDateSelected(currentSelectedDate, true)
            binding.calendarView.addDecorator(object : DayViewDecorator {
                private val currentDateDrawable: Drawable? =
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_square)

                override fun shouldDecorate(day: CalendarDay): Boolean {
                    val cal1date = day.date
                    val cal1 = Calendar.getInstance()
                    cal1.set(cal1date.year, cal1date.monthValue - 1, cal1date.dayOfMonth)
                    val cal2 = Calendar.getInstance()
                    return cal1[Calendar.ERA] === cal2[Calendar.ERA] && cal1[Calendar.YEAR] === cal2[Calendar.YEAR] && cal1[Calendar.DAY_OF_YEAR] === cal2[Calendar.DAY_OF_YEAR]
                }

                override fun decorate(view: DayViewFacade) {
                    currentDateDrawable?.let {
                        view.setBackgroundDrawable(it)
                    }
                }
            })

            val decorator = CustomDateDecorator(enabledDates)
            calendarView.addDecorator(decorator)
            calendarView.setOnDateChangedListener { _, selectedDate, isSelected ->
                // Check if the selected date is enabled
                if (enabledDates.contains(CalendarDay.from(selectedDate.date))) {
                    if (isSelected) {
                        selectedDates.clear()
                        currentSelectedDate = selectedDate
                        val selectedIndex =
                            enabledDates.indexOf(CalendarDay.from(selectedDate.date))
                        if (selectedIndex != -1) {
                            val selectedDay = enabledDates[selectedIndex]
                            // val selectedDatesList = mutableListOf<CalendarDay>()
                            selectedDates.add(selectedDay)

                            // Calculate the indices of the previous and next days
                            val previousIndex = selectedIndex - 1
                            val nextIndex = selectedIndex + 1
                            val nextNextIndex = nextIndex + 1
                            // Check if previous and next days are within bounds
                            if (nextNextIndex < enabledDates.size) {
                                val nextNextDay = enabledDates[nextNextIndex]
                                selectedDates.add(nextNextDay)
                            } else {
                                if (previousIndex >= 0) {
                                    val previousDay = enabledDates[previousIndex]
                                    selectedDates.add(previousDay)
                                }
                            }
                            if (nextIndex < enabledDates.size) {
                                val nextDay = enabledDates[nextIndex]
                                selectedDates.add(nextDay)
                            } else {
                                val previousPrevDay = enabledDates[previousIndex - 1]
                                selectedDates.add(previousPrevDay)
                            }
                        }
                        val customSelectedBackgroundDecorator =
                            CustomSelectedBackgroundDecoratorForWindow(
                                requireContext(),
                                selectedDates
                            )
                        binding.calendarView.addDecorator(customSelectedBackgroundDecorator)
                    } else {
                        selectedDates.remove(selectedDate)
                    }
                    binding.calendarView.invalidateDecorators()

                } else {
                    // Notify the user that the selected date is not enabled
                }
            }
            //for the square shape

            // for blue color for enable dates
            val enabledDateDecorator = EnabledDateDecorator(enabledDates, requireContext())
            binding.calendarView.addDecorator(enabledDateDecorator)

            // change selected date text color  from blue to white
            val selectedDateDecorator =
                SelectedDateDecorator(requireContext(), selectedDates, currentSelectedDate)
            binding.calendarView.addDecorator(selectedDateDecorator)

            // unselected date change the text color
            if (previousSelectedDates.isNotEmpty()) {
                val unselectedDecorator =
                    UnselectedDateDecorator(requireContext(), previousSelectedDates.first())
                binding.calendarView.addDecorator(unselectedDecorator)
            }
        }
    }

    private fun showCalendarForFutureDay(deliveryDays: List<String>?) {
        if (!deliveryDays.isNullOrEmpty()) {
            binding.tvTitle.setText(R.string.delivery_day)
            val calendar = Calendar.getInstance()
            val currentYear = calendar.get(Calendar.YEAR)
            val currentMonth = calendar.get(Calendar.MONTH) + 1
            val currentStartDate = CalendarDay.from(currentYear, currentMonth, 1)
            val currentEndDate = CalendarDay.from(
                currentYear,
                currentMonth,
                calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
            )
            binding.calendarView.state().edit().setMinimumDate(currentStartDate)
                .setMaximumDate(currentEndDate).commit()


            val calendarView = binding.calendarView
            val currentDay = CalendarDay.today()
            calendar.set(currentDay.year, currentDay.month - 1, currentDay.day)
            for (deliveryDay in deliveryDays) {
                val dayOfWeek = when (deliveryDay) {
                    "Sunday" -> Calendar.SUNDAY
                    "Monday" -> Calendar.MONDAY
                    "Tuesday" -> Calendar.TUESDAY
                    "Wednesday" -> Calendar.WEDNESDAY
                    "Thursday" -> Calendar.THURSDAY
                    "Friday" -> Calendar.FRIDAY
                    "Saturday" -> Calendar.SATURDAY
                    else -> -1 // Invalid day
                }

                if (dayOfWeek != -1) {
                    while (calendar.get(Calendar.DAY_OF_WEEK) != dayOfWeek) {
                        calendar.add(Calendar.DAY_OF_WEEK, 1)
                    }
                    val calendarDay = CalendarDay.from(
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH) + 1,
                        calendar.get(Calendar.DAY_OF_MONTH)
                    )
                    enabledDates.add(calendarDay)
                }
            }
            binding.calendarView.setDateSelected(currentSelectedDate, true)
            binding.calendarView.addDecorator(object : DayViewDecorator {
                private val currentDateDrawable: Drawable? =
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_square)

                override fun shouldDecorate(day: CalendarDay): Boolean {
                    val cal1date = day.date
                    val cal1 = Calendar.getInstance()
                    cal1.set(cal1date.year, cal1date.monthValue - 1, cal1date.dayOfMonth)
                    val cal2 = Calendar.getInstance()
                    return cal1[Calendar.ERA] === cal2[Calendar.ERA] && cal1[Calendar.YEAR] === cal2[Calendar.YEAR] && cal1[Calendar.DAY_OF_YEAR] === cal2[Calendar.DAY_OF_YEAR]
                }

                override fun decorate(view: DayViewFacade) {
                    currentDateDrawable?.let {
                        view.setBackgroundDrawable(it)
                    }
                }
            })

            val decorator = CustomDateDecorator(enabledDates)
            calendarView.addDecorator(decorator)
            calendarView.setOnDateChangedListener { _, selectedDate, isSelected ->
                // Check if the selected date is enabled
                if (enabledDates.contains(CalendarDay.from(selectedDate.date))) {
                    if (isSelected) {
                        if (selectedDates.size == 1) {
                            if (previousSelectedDates.size == 1) {
                                previousSelectedDates.removeAt(0)
                                previousSelectedDates.add(selectedDates.first())
                            } else {
                                previousSelectedDates.add(selectedDates.first())
                            }
                            selectedDates.removeAt(0)
                        }
                        currentSelectedDate = selectedDate
                        selectedDates.add(selectedDate)
                    } else {
                        selectedDates.remove(selectedDate)
                    }
                    binding.calendarView.invalidateDecorators()

                } else {
                    // Notify the user that the selected date is not enabled
                }
            }
            //for the square shape
            val customSelectedBackgroundDecorator =
                CustomSelectedBackgroundDecorator(requireContext(), enabledDates)
            binding.calendarView.addDecorator(customSelectedBackgroundDecorator)

            // for blue color for enable dates
            val enabledDateDecorator = EnabledDateDecorator(enabledDates, requireContext())
            binding.calendarView.addDecorator(enabledDateDecorator)

            // change selected date text color  from blue to white
            val selectedDateDecorator =
                SelectedDateDecorator(requireContext(), selectedDates, currentSelectedDate)
            binding.calendarView.addDecorator(selectedDateDecorator)

            // unselected date change the text color
            if (previousSelectedDates.isNotEmpty()) {
                val unselectedDecorator =
                    UnselectedDateDecorator(requireContext(), previousSelectedDates.first())
                binding.calendarView.addDecorator(unselectedDecorator)
            }

        }
    }


    private fun CalendarDay.toDate(): Date {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, day)
        return calendar.time
    }

    class CustomSelectedBackgroundDecoratorForWindow(private val context: Context,private val selectedDates: MutableList<CalendarDay>) : DayViewDecorator {
        private val selectedDrawable: Drawable? = ContextCompat.getDrawable(context, R.drawable.ic_selected_square)

        override fun shouldDecorate(day: CalendarDay): Boolean {
            return selectedDates.contains(day)
        }

        override fun decorate(view: DayViewFacade) {
            selectedDrawable?.let {
                view.setBackgroundDrawable(it)
            }
        }
    }

    class CustomSelectedBackgroundDecorator(private val context: Context,private val selectedDates: List<CalendarDay>) : DayViewDecorator {
        private val selectedDrawable: Drawable? = ContextCompat.getDrawable(context, R.drawable.selector_calendar)

        override fun shouldDecorate(day: CalendarDay): Boolean {
            return selectedDates.contains(day)
        }

        override fun decorate(view: DayViewFacade) {
            selectedDrawable?.let {
                view.setBackgroundDrawable(it)
            }

        }
    }

    class CustomDateDecorator(private val enabledDates: List<CalendarDay>) : DayViewDecorator {
        override fun shouldDecorate(day: CalendarDay): Boolean {
            return !enabledDates.contains(day)
        }

        override fun decorate(view: DayViewFacade) {
            view.setDaysDisabled(true)
        }
    }

    class EnabledDateDecorator(
        private val enabledDates: List<CalendarDay>,
        private val context: Context,
    ) : DayViewDecorator {

        override fun shouldDecorate(day: CalendarDay): Boolean {
            return enabledDates.contains(day)
        }

        override fun decorate(view: DayViewFacade) {
            view.addSpan(ForegroundColorSpan(ContextCompat.getColor(context, R.color.atd_blue)))
        }
    }

    class SelectedDateDecorator(
        private val context: Context,
        private val selectedDates: List<CalendarDay>,
        private val selectedDate: CalendarDay?,
    ) : DayViewDecorator {

        override fun shouldDecorate(day: CalendarDay): Boolean {
            return selectedDates.contains(day)
        }

        override fun decorate(view: DayViewFacade) {
            view.addSpan(ForegroundColorSpan(Color.WHITE))

        }
    }

    class UnselectedDateDecorator(
        private val context: Context,
        private val previousDay :CalendarDay,
    ) : DayViewDecorator {
        override fun shouldDecorate(day: CalendarDay): Boolean {
            // Return true for dates that are not selected
            return previousDay == day
        }

        override fun decorate(view: DayViewFacade) {
            // Add span to change text color for unselected dates
            view.addSpan(ForegroundColorSpan(ContextCompat.getColor(context, R.color.atd_blue)))
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }

    private fun onCancelClick(){
        binding.cancelButton.setOnClickListener {
            onCancel()
            dismiss()
        }
    }

    private fun backPressed() {
        binding.ivBack.setOnClickListener {
            dismiss()
        }
    }

    private fun onApplyClick(){
        binding.applyButton.setOnClickListener {
            onApplyClick(selectedDates)
            dismiss()
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}



