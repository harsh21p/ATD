package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes

import android.app.Dialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentDeleteQuoteBinding
import com.atd.atdmobileapp.models.myquotes.Retailquote
import com.atd.atdmobileapp.models.myquotes.UpdateRequestBody
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.utils.*
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DeleteQuoteFragment(private val retailquote: Retailquote, private val onSuccess: () -> Unit) : DialogFragment() {

    private var _binding: FragmentDeleteQuoteBinding?= null
    private val binding get()= _binding!!
    private lateinit var adapter: DeleteQuoteAdapter
    private lateinit var listOfReasons: MutableList<String>
    private lateinit var prevSelection: String
    private var isDeleteEnabled = false
    private var deleteReason = ""
    private val myQuotesViewModel by viewModels<MyQuotesViewModel>()
    @Inject
    lateinit var sharedPrefManager: SharedPrefManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
       _binding = FragmentDeleteQuoteBinding.inflate(inflater, container, false)
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.window?.setBackgroundDrawableResource(R.color.white)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listOfReasons = mutableListOf()
        setupRecyclerView()
        enableDisableDeleteButton(false)
        onEditForReason()
        onClickDelete()
        onClickCancel()
        bindObservers()
        binding.ivCloseTireType.setOnClickListener {
            dialog?.dismiss()
        }
        setUpTheme()
    }

    private fun setUpTheme() {
        binding.ivCloseTireType.imageTintList= ContextCompat.getColorStateList(requireContext(), BottomNavigationScreenFragment.theameColor)
        binding.ivCancel.imageTintList= ContextCompat.getColorStateList(requireContext(), BottomNavigationScreenFragment.theameColor)
        binding.viewDivider9.backgroundTintList= ContextCompat.getColorStateList(requireContext(), BottomNavigationScreenFragment.theameColor)
        binding.etReason.backgroundTintList= ContextCompat.getColorStateList(requireContext(), BottomNavigationScreenFragment.theameColor)

    }


    private fun onClickCancel() {
        binding.ivCancel.setOnClickListener {
            dialog?.dismiss()
        }
    }

    private fun bindObservers() {
        myQuotesViewModel.updateQuoteLiveData.observe(viewLifecycleOwner){
            when(it){
                is NetworkResult.Error -> {
                    toast(it.message)
                }

                is NetworkResult.Loading -> {

                }
                is NetworkResult.Success -> {
                    //show dialogue box
                    showDialog()
                    onSuccess()
                }
            }
        }
    }

    private fun showDialog() {
        val dialogShow = Dialog(requireActivity())
        dialogShow.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogShow.setCancelable(false)
        dialogShow.setContentView(R.layout.custom_quotes_saved)
        dialogShow.window?.setBackgroundDrawableResource(android.R.color.transparent);
        val okText = dialogShow.findViewById(R.id.tvYes) as TextView
        val tvTitle = dialogShow.findViewById(R.id.tvTitle) as TextView
        val descp = dialogShow.findViewById(R.id.tvDescription) as TextView

        tvTitle.text = getString(R.string.delete_quote)
        descp.text = getString(R.string.success_quote_delete)
        okText.setOnClickListener {
            dialogShow.dismiss()
            dialog?.dismiss()

        }
        dialogShow.show()
    }

    private fun onClickDelete() {
        binding.ivDelete.setOnClickListener {
            if (isDeleteEnabled){
                makeDeleteApiCall()
            }else{
                toast("clicked when disabled")

            }
        }
    }

    private fun makeDeleteApiCall() {
        val requestBody = makeRequestBody()
        println("request ->"+Gson().toJson(requestBody))
        myQuotesViewModel.updateRetailQuote(requestBody)
    }

    private fun makeRequestBody(): UpdateRequestBody {

        val requestBody = UpdateRequestBody()

        //setting phone no and area code
        val consumerInfo = retailquote.consumerinfo
        val (areaCode, phoneNumberPart) = extractAreaCodeAndNumber(retailquote.consumerinfo.phone)
        consumerInfo.areacode = areaCode
        consumerInfo.phone = phoneNumberPart
        requestBody.consumerinfo = consumerInfo ///consumer info updated

        requestBody.locationnumber = sharedPrefManager.getLocationNumber().toString()
        requestBody.quoteid = retailquote.retailquoteid
        requestBody.quotestatus = "Deleted"
        requestBody.deletereason = deleteReason
        return requestBody
    }

    private fun extractAreaCodeAndNumber(phoneNumber: String?): Pair<String, String> {
        // Return empty strings if phoneNumber is null
        if (phoneNumber == null) {
            return Pair("", "")
        }

        // Remove non-digit characters from the phone number
        val digitsOnly = phoneNumber.replace(Regex("\\D"), "")

        // Extract the area code (first 3 digits) and phone number (last 7 digits)
        val areaCode = if (digitsOnly.length >= 3) digitsOnly.substring(0, 3) else ""
        val phoneNumberPart = if (digitsOnly.length >= 10) {
            val part = digitsOnly.substring(3, 10)
            "${part.substring(0, 3)}-${part.substring(3, 7)}"
        } else {
            ""
        }

        return Pair(areaCode, phoneNumberPart)
    }

    private fun onEditForReason() {
        binding.etReason.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s.isNullOrBlank()){
                    enableDisableDeleteButton(false)
                }
                else{
                    deleteReason = s.toString()
                    enableDisableDeleteButton(true)
                }
            }

        })
    }

    companion object {
        const val TAG = "deleteQuoteFrag"
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }

    private fun setupRecyclerView() {
        binding.rvYears.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        adapter = DeleteQuoteAdapter(::onClick,requireActivity())
        binding.rvYears.adapter = adapter
        listOfReasons.add("sff")
        listOfReasons.add("fsafa")
        listOfReasons.add(requireActivity().getString(R.string.other_reasons))
        adapter.submitList(listOfReasons)
    }

    private fun onClick(item: String){

        prevSelection = item
        adapter.prevSelection = item
        adapter.notifyItemRangeChanged(0, listOfReasons.size)

        if(item == requireActivity().getString(R.string.other_reasons)){
            binding.reason.visible()
            binding.etReason.visible()
            enableDisableDeleteButton(false)
        }else{
            binding.reason.inVisible()
            binding.etReason.inVisible()
            enableDisableDeleteButton(true)
        }

    }

    private fun enableDisableDeleteButton(shouldEnable: Boolean) {

        isDeleteEnabled = if (shouldEnable){
            if (BottomNavigationScreenFragment.theameColor==R.color.red) {
                binding.ivDelete.setImageResource(R.drawable.delete_quotes_tirepros)
            }else{
                binding.ivDelete.setImageResource(R.drawable.delete_quotes)

            }
            true
        }else{
            binding.ivDelete.setImageResource(R.drawable.disabled_delete_quotes)
            false
        }

    }


}