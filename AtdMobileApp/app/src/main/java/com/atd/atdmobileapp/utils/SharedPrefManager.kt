package com.atd.atdmobileapp.utils

import android.content.Context
import com.atd.atdmobileapp.models.homescreenlocations.DCDetails
import com.atd.atdmobileapp.models.myquotes.Retailquote
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SharedPrefManager @Inject constructor(@ApplicationContext context: Context) {

    private var prefs = context.getSharedPreferences(Constants.PREFS, Context.MODE_PRIVATE)

    fun saveOnBoardingStatus(isOnBoardingStatus :String){
        val editor =prefs.edit()
        editor.putString(Constants.IS_ONBOARDING_STATUS,isOnBoardingStatus)
        editor.apply()
    }

    fun getOnBoardingStatus() :String?{
        return prefs.getString(Constants.IS_ONBOARDING_STATUS, null)
    }

    fun removeOnBoardingStatus(){
        prefs.edit().remove(Constants.IS_ONBOARDING_STATUS).apply()
    }

    fun saveLocal(value :String){
        val editor =prefs.edit()
        editor.putString(Constants.LOCAL,value)
        editor.apply()
    }

    fun getLocal() :String?{
        return prefs.getString(Constants.LOCAL, null)
    }

    fun saveLocalTime(value :String){
        val editor =prefs.edit()
        editor.putString(Constants.LOCAL_TIME,value)
        editor.apply()
    }

    fun getLocalTime() :String?{
        return prefs.getString(Constants.LOCAL_TIME, null)
    }

    fun saveLocalPlus(value :String){
        val editor =prefs.edit()
        editor.putString(Constants.LOCALPLUS,value)
        editor.apply()
    }

    fun getLocalPlus() :String?{
        return prefs.getString(Constants.LOCALPLUS, null)
    }

    fun saveLocalPlusTime(value :String){
        val editor =prefs.edit()
        editor.putString(Constants.LOCALPLUS_TIME,value)
        editor.apply()
    }

    fun getLocalPlusTime() :String?{
        return prefs.getString(Constants.LOCALPLUS_TIME, null)
    }



    fun saveToken(token :String){
        val editor =prefs.edit()
        editor.putString(Constants.TOKEN,token)
        editor.apply()
    }

    fun getToken():String?{
        return prefs.getString(Constants.TOKEN, null)
    }

    fun removeToken(){
        prefs.edit().remove(Constants.TOKEN).apply()
    }

    fun saveUserRequest(userRequest :String){
        val editor =prefs.edit()
        editor.putString(Constants.USER_REQUEST,userRequest)
        editor.apply()
    }

    fun removeUserRequest(){
        prefs.edit().remove(Constants.USER_REQUEST).apply()
    }

    fun getUserRequest():String?{
        return prefs.getString(Constants.USER_REQUEST, null)
    }

    fun saveUserName(name: String){
        val editor =prefs.edit()
        editor.putString(Constants.USER_NAME,name)
        editor.apply()
    }

    fun getUserName():String?{
        return prefs.getString(Constants.USER_NAME, null)
    }

    fun removeUserName(){
        prefs.edit().remove(Constants.USER_NAME).apply()
    }

    fun saveProfileSelected(profileSelected:String){
        val editor =prefs.edit()
        editor.putString(Constants.PROFILE_SELECTED,profileSelected)
        editor.apply()
    }

    fun getProfileSelected():String?{
        return prefs.getString(Constants.PROFILE_SELECTED, null)
    }

    fun saveMultipleProfileAccess(multipleProfile: Boolean){
        val editor =prefs.edit()
        editor.putBoolean(Constants.MULTIPLE_PROFILE_AVAILABLE,multipleProfile)
        editor.apply()
    }

    fun getMultipleProfileAccess(): Boolean{
        return prefs.getBoolean(Constants.MULTIPLE_PROFILE_AVAILABLE, false)
    }
    fun removeMultipleProfileAccess() {
        prefs.edit().remove(Constants.MULTIPLE_PROFILE_AVAILABLE).apply()
    }

    //saving location details to be used throughout the App
    fun saveSelectedLocation(dcDetails: DCDetails?){
        val editor =prefs.edit()
        if (dcDetails != null) {
            val dcDetailsJson = Gson().toJson(dcDetails)
            editor.putString(Constants.LOCATION_ADDRESS,dcDetailsJson)
        }
        editor.apply()
    }

    //retrieving saved location
    fun getSelectedLocation():String?{
        return prefs.getString(Constants.LOCATION_ADDRESS, null)
    }

    fun removeSelectedLocation() {
        prefs.edit().remove(Constants.LOCATION_ADDRESS).apply()
    }

    //Saving number of approvals to be used for My Garage Screen
    fun saveApprovalsSize(approvalsNumber : Int){
        val editor =prefs.edit()
        editor.putInt(Constants.APPROVALS_NUMBER,approvalsNumber)
        editor.apply()
    }

    //retrieving number of Approvals
    fun getApprovals(): Int{
       return prefs.getInt(Constants.APPROVALS_NUMBER, 0)
    }

    fun removeApprovals(){
        prefs.edit().remove(Constants.APPROVALS_NUMBER).apply()
    }

    fun saveLocationCount(count :Int){
        val editor =prefs.edit()
        editor.putInt(Constants.LOCATION_COUNT,count)
        editor.apply()
    }

    fun getLocationCount(): Int{
        return prefs.getInt(Constants.LOCATION_COUNT, 0)
    }

    fun removeLocationCount(){
        prefs.edit().remove(Constants.LOCATION_COUNT).apply()
    }

    fun saveLocationNumber(name :String){
        val editor =prefs.edit()
        editor.putString(Constants.LOCATION_NAME,name)
        editor.apply()
    }

    fun getLocationNumber() :String?{
        return prefs.getString(Constants.LOCATION_NAME, null)
    }

    fun removeLocationNumber(){
        prefs.edit().remove(Constants.LOCATION_NAME).apply()
    }

    fun saveBiometricEnabled(value: Boolean){
        val editor =prefs.edit()
        editor.putBoolean(Constants.BIOMETRIC_ENABLED,value)
        editor.apply()
    }

    fun getBiometricEnabled() :Boolean{
        return prefs.getBoolean(Constants.BIOMETRIC_ENABLED, false)
    }

    fun removeBiometric(){
        prefs.edit().remove(Constants.BIOMETRIC_ENABLED).apply()
    }


    fun saveCV(value:Boolean){

        val editor =prefs.edit()
        editor.putBoolean(Constants.CV,value)
        editor.apply()
    }

    fun getCV(): Boolean? {

        return prefs.getBoolean(Constants.CV, false)
    }

    fun saveCVIntro(value: Boolean) {

        val editor = prefs.edit()
        editor.putBoolean(Constants.CVIntro, value)
        editor.apply()
    }

    fun getCVIntro(): Boolean? {

        return prefs.getBoolean(Constants.CVIntro, true)
    }

    fun saveServicingdcNumber(servicingdc: String) {

        val editor = prefs.edit()
        editor.putString(Constants.Srvicindc, servicingdc)
        editor.apply()
    }

    fun getServicingdcNumber(): String? {

        return prefs.getString(Constants.Srvicindc, "")
    }


    fun saveSelectedYear(year: String) {
        val editor = prefs.edit()
        editor.putString(Constants.SELECTED_YEAR, year)
        editor.apply()
    }

    fun getSelectedYear(): String? {
        return prefs.getString(Constants.SELECTED_YEAR, "")
    }

    fun removeSelectedYear() {
        prefs.edit().remove(Constants.SELECTED_YEAR).apply()
    }

    fun saveSelectedMake(year: String) {
        val editor = prefs.edit()
        editor.putString(Constants.SELECTED_MAKE, year)
        editor.apply()
    }

    fun getSelectedMake(): String? {
        return prefs.getString(Constants.SELECTED_MAKE, "")
    }

    fun removeSelectedMake() {
        prefs.edit().remove(Constants.SELECTED_MAKE).apply()
    }

    fun saveSelectedModel(year: String) {
        val editor = prefs.edit()
        editor.putString(Constants.SELECTED_MODEL, year)
        editor.apply()
    }

    fun getSelectedModel(): String? {
        return prefs.getString(Constants.SELECTED_MODEL, "")
    }

    fun removeSelectedModel() {
        prefs.edit().remove(Constants.SELECTED_MODEL).apply()
    }

    fun saveSelectedTrim(year: String) {
        val editor = prefs.edit()
        editor.putString(Constants.SELECTED_TRIM, year)
        editor.apply()
    }

    fun getSelectedTrim(): String? {
        return prefs.getString(Constants.SELECTED_TRIM, "")
    }

    fun removeSelectedTrim() {
        prefs.edit().remove(Constants.SELECTED_TRIM).apply()
    }

    fun saveSelectedOESize(year: String) {
        val editor = prefs.edit()
        editor.putString(Constants.SELECTED_OESIZE, year)
        editor.apply()
    }

    fun getSelectedOESize(): String? {
        return prefs.getString(Constants.SELECTED_OESIZE, "")
    }

    fun removeSelectedOESize() {
        prefs.edit().remove(Constants.SELECTED_OESIZE).apply()
    }

    fun saveSelectedOESizeObj(year: String) {
        val editor = prefs.edit()
        editor.putString(Constants.SELECTED_OESIZE_OBJ, year)
        editor.apply()
    }

    fun getSelectedOESizeObj(): String? {
        return prefs.getString(Constants.SELECTED_OESIZE_OBJ, "")
    }

    fun removeSelectedOESizeObj() {
        prefs.edit().remove(Constants.SELECTED_OESIZE_OBJ).apply()
    }

    fun saveStaggeredFitment(fitment: Boolean) {
        val editor = prefs.edit()
        editor.putBoolean(Constants.STAGGERED_FITMENT, fitment)
        editor.apply()
    }

    fun getStaggeredFitment(): Boolean {
        return prefs.getBoolean(Constants.STAGGERED_FITMENT, false)
    }

    fun removeStaggeredFitment() {
        prefs.edit().remove(Constants.STAGGERED_FITMENT).apply()
    }

    fun saveSavedVehicleObj(vehicle: String) {
        val editor = prefs.edit()
        editor.putString(Constants.SAVED_VEHICLE_OBJ, vehicle)
        editor.apply()
    }

    fun getSavedVehicleObj(): String? {
        return prefs.getString(Constants.SAVED_VEHICLE_OBJ, "")
    }

    fun removeSavedVehicleObj() {
        prefs.edit().remove(Constants.SAVED_VEHICLE_OBJ).apply()
    }


    fun saveUserPreferences(userPref: String) {
        val editor = prefs.edit()
        editor.putString(Constants.USER_PREFERENCES, userPref)
        editor.apply()
    }

    fun getUserPreferences(): String? {
        return prefs.getString(Constants.USER_PREFERENCES, null)
    }

    fun saveOrderApproval(orderApproval: String?) {
        val editor = prefs.edit()
        editor.putString(Constants.orderApproval, orderApproval)
        editor.apply()
    }

    fun getOrderApproval(): String? {
        return prefs.getString(Constants.orderApproval, "")

    }

    fun saveApproveOrdersAtdOnline(approveOrders: String?) {
        val editor = prefs.edit()
        editor.putString(Constants.APPROVE_ORDERS, approveOrders)
        editor.apply()
    }

    fun getApproveOrdersAtdOnline(): String? {
        return prefs.getString(Constants.APPROVE_ORDERS, null)

    }

    fun removeApproveOrdersAtdOnline() {
        prefs.edit().remove(Constants.APPROVE_ORDERS).apply()
    }

    fun saveApproveOrdersTirePros(approveOrders: String?) {
        val editor = prefs.edit()
        editor.putString(Constants.APPROVE_ORDERS_TIRE_PROS, approveOrders)
        editor.apply()
    }

    fun getApproveOrdersTirePros(): String? {
        return prefs.getString(Constants.APPROVE_ORDERS_TIRE_PROS, null)

    }

    fun removeApproveOrdersTirePros() {
        prefs.edit().remove(Constants.APPROVE_ORDERS_TIRE_PROS).apply()
    }


    fun savePORegex(poRegex: String?) {
        val editor = prefs.edit()
        editor.putString(Constants.PORegex, poRegex)
        editor.apply()
    }

    fun getPORegex(): String? {
        return prefs.getString(Constants.PORegex, null)

    }

    fun removePORegex() {
        prefs.edit().remove(Constants.PORegex).apply()
    }

    fun savePoRequired(value: String?) {
        val editor = prefs.edit()
        editor.putString(Constants.PO_Required, value)
        editor.apply()
    }

    fun getPoRequired(): String? {
        return prefs.getString(Constants.PO_Required, null)

    }

    fun removePoRequired() {
        prefs.edit().remove(Constants.PO_Required).apply()
    }

    fun saveDeliveryDefault(value: String?) {
        val editor = prefs.edit()
        editor.putString(Constants.DELIVERY_DEFAULT, value)
        editor.apply()
    }

    fun getDeliveryDefault(): String? {
        return prefs.getString(Constants.DELIVERY_DEFAULT, null)
    }
    fun removeDeliveryDefault() {
        prefs.edit().remove(Constants.DELIVERY_DEFAULT).apply()
    }

    fun saveSelectedDelivery(value: String?) {
        val editor = prefs.edit()
        editor.putString(Constants.SELECTED_DELIVERY, value)
        editor.apply()
    }

    fun getSelectedDelivery(): String? {
        return prefs.getString(Constants.SELECTED_DELIVERY, null)
    }

    fun removeSelectedDelivery() {
        prefs.edit().remove(Constants.SELECTED_DELIVERY).apply()
    }

    fun saveNeedByDate(value: String?) {
        val editor = prefs.edit()
        editor.putString(Constants.NEED_BY_DATE, value)
        editor.apply()
    }

    fun getNeedByDate(): String? {
        return prefs.getString(Constants.NEED_BY_DATE, null)
    }

    fun removeNeedByDate() {
        prefs.edit().remove(Constants.NEED_BY_DATE).apply()
    }





    fun saveBarcode(barcodeText: String) {
        val editor = prefs.edit()
        editor.putString(Constants.barcodeText, barcodeText)
        editor.apply()
    }
    fun getBarcode(): String? {
        return prefs.getString(Constants.barcodeText, "")

    }

    fun saveUserRole(name: String) {
        val editor = prefs.edit()
        editor.putString(Constants.USER_ROLE, name)
        editor.apply()
    }

    fun getUserRole(): String? {
        return prefs.getString(Constants.USER_ROLE, "")
    }

    fun removeUserRole() {
        prefs.edit().remove(Constants.USER_ROLE).apply()
    }

    fun saveWorkingQuote(quote: String, locationNumber: String){
        val editor = prefs.edit()
        editor.putString(Constants.WORKING_QUOTE+locationNumber, quote)
        editor.apply()
    }

    fun getWorkingQuote(locationNumber: String) : String? {
        return prefs.getString(Constants.WORKING_QUOTE+locationNumber, "")
    }

    fun removeWorkingQuote(locationNumber: String) {
        prefs.edit().remove(Constants.WORKING_QUOTE+locationNumber).apply()
    }

}