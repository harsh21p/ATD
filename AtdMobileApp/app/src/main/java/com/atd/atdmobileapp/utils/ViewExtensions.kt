package com.atd.atdmobileapp.utils

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.Group
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.room.Database
import com.atd.atdmobileapp.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


fun View.visible(): View {
    this.visibility = View.VISIBLE
    if (this is Group) {
        this.requestLayout()
    }
    return this
}

fun View.inVisible(): View {
    this.visibility = View.INVISIBLE
    if (this is Group) {
        this.requestLayout()
    }
    return this
}

fun View.gone(): View {
    this.visibility = View.GONE
    if (this is Group) {
        this.requestLayout()
    }
    return this
}

fun Fragment.toast(message: String?) {
    try {
        val mToastLength: Long = 40 * 1000
        Toast.makeText(requireContext(), message, mToastLength.toInt()).show()
    } catch (ex: Exception) {

    }
}

fun Fragment.errorToast(message: String?){

    try {
        val toast = Toast(context)
        toast.duration = Toast.LENGTH_LONG
        val inflater =
            requireActivity()!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = inflater.inflate(R.layout.toast, null)
        val errorMessage : TextView= view.findViewById(R.id.toastMessage)
        errorMessage.text= message
        toast.setView(view)
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
        toast.show()
    }catch (ex:Exception){

    }
}

fun Fragment.successToast(message: String?){

    try {
        val context= context
        val toast = Toast(context)
        toast.duration = Toast.LENGTH_SHORT
        val inflater =
            requireActivity()!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = inflater.inflate(R.layout.toast, null)

        val errorMessage : TextView= view.findViewById(R.id.toastMessage)
        errorMessage.setCompoundDrawablesWithIntrinsicBounds(R.drawable.check,0,0,0)
        errorMessage.text= message
        context?.let { ContextCompat.getColor(it,R.color.green) }
            ?.let { errorMessage.setBackgroundColor(it) }
        context?.let { ContextCompat.getColor(it,R.color.white) }
            ?.let { errorMessage.setTextColor(it) }
        toast.setView(view)
        toast.setGravity(Gravity.TOP, 0, 0)
        toast.show()
    }catch (ex:Exception){

    }
}

fun Fragment.waitToast(message: String?){

    try {
        val context= context
        val toast = Toast(context)
        toast.duration = Toast.LENGTH_SHORT
        val inflater =
            requireActivity()!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = inflater.inflate(R.layout.toast, null)

        val errorMessage : TextView= view.findViewById(R.id.toastMessage)
        errorMessage.setCompoundDrawablesWithIntrinsicBounds(R.drawable.alert,0,0,0)
        errorMessage.compoundDrawablePadding=10
        errorMessage.compoundDrawableTintList= context?.let { ContextCompat.getColorStateList(it,R.color.white) }
        errorMessage.text= message
        context?.let { ContextCompat.getColor(it,R.color.red) }
            ?.let { errorMessage.setBackgroundColor(it) }
        context?.let { ContextCompat.getColor(it,R.color.white) }
            ?.let { errorMessage.setTextColor(it) }
        toast.setView(view)
        toast.setGravity(Gravity.TOP, 0, 0)
        toast.show()
    }catch (ex:Exception){

    }
}
fun View.hideSoftInput() {
    val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
}

/*
fun Fragment.emptyDatabase() {
    viewLifecycleOwner.lifecycleScope.launchWhenCreated {
        withContext(Dispatchers.IO) {
            Database.getInstance(requireActivity()).clearAllTables()
        }
    }
}
*/

