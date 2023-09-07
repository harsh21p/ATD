package com.atd.atdmobileapp.ui.login


import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.drawable.GradientDrawable
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.FragmentLoginBinding
import com.atd.atdmobileapp.models.Permission
import com.atd.atdmobileapp.models.User
import com.atd.atdmobileapp.roomdatabase.permissions.PermissionEntity
import com.atd.atdmobileapp.utils.*
import com.atd.atdmobileapp.utils.Common.makeFirebaseEventBundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.crashlytics.FirebaseCrashlytics
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val loginViewModel by viewModels<LoginViewModel>()
    private var userName: String = ""
    private var password: String = ""
    private lateinit var firebaseAnalytics: FirebaseAnalytics
    @Inject
    lateinit var sharedPrefManager: SharedPrefManager
    private lateinit var firebaseCrashlytics: FirebaseCrashlytics
    private lateinit var auth:FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        enableLogin()
        enableBiometric()
        firebaseAnalytics = FirebaseAnalyticsManager.getInstance(requireContext())
        firebaseCrashlytics = FirebaseCrashlyticsManager.getInstance()
        setTheme()
        auth = FirebaseAuth.getInstance()
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        landsOnLoginScreenEvent()
        login()
        bindObservers()
        binding.tvResetPassword.setOnClickListener {
            resetPassword(Constants.RESET_PASSWORD_URL)
        }
        validateRememberMe()
    }

    private fun landsOnLoginScreenEvent() {
        val params = makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Login,
            Category.Login,
            Action.Impression,
            "Viewed login screen"
        )

        params.putString(FirebaseAnalytics.Param.SCREEN_NAME, Screen.Login)
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, params)
    }

    private fun login() {
        binding.tvLogin.setOnClickListener {
//            logEvents(binding.tvLogin.id.toString(), binding.tvLogin.text.toString())
            binding.tvPassword.gone()
            binding.tvUsername.gone()
            //logEvents(binding.tvLogin.id.toString(), binding.tvLogin.text.toString())
            val baseAuthToken = getBase64Encoded(userName, password)
            sharedPrefManager.saveToken(baseAuthToken!!)
            rememberUserRequest()
            loginViewModel.loginUser(userName)
        }

    }
    private fun logEvents(buttonId:String, buttonType :String){
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, buttonId)
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, buttonType)
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)
    }

    private fun setTheme(){
        when (sharedPrefManager.getProfileSelected()){
            Constants.TIRE_PROS -> {
                binding.tvResetPasswordRed.visible()
                binding.tvResetPassword.gone()
                binding.textInputPassword.setEndIconTintList(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.red)))
            }
            Constants.ATD_ONLINE -> {
                binding.tvResetPasswordRed.gone()
                binding.tvResetPassword.visible()
                binding.textInputPassword.setEndIconTintList(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.atd_blue)))
            }
            else ->{
                binding.tvResetPasswordRed.gone()
                binding.tvResetPassword.visible()
                binding.textInputPassword.setEndIconTintList(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.atd_blue)))
            }
        }
    }

    private fun enableBiometric(){
        binding.switchEnableFaceId.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                sharedPrefManager.saveBiometricEnabled(true)
            }else {
                sharedPrefManager.removeBiometric()
            }
        }
    }

    private fun enableLogin() {
        val editTexts = listOf(binding.etUserName, binding.etPassword)
        for (editText in editTexts) {
            editText.addTextChangedListener(object : TextWatcher {
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    val et1 = binding.etUserName.text.toString().trim()
                    val et2 = binding.etPassword.text.toString().trim()

                    if (et1.isNotEmpty() && et2.isNotEmpty()) {
                        binding.tvLogin.isClickable = true
                        when (sharedPrefManager.getProfileSelected()){
                            Constants.TIRE_PROS -> {
                                binding.tvLogin.setBackgroundDrawable(resources.getDrawable(R.drawable.nextbuttoncorners_red))
                                binding.tvLogin.setTextColor(resources.getColor(R.color.white))
                            }
                            Constants.ATD_ONLINE -> {
                                binding.tvLogin.setBackgroundDrawable(resources.getDrawable(R.drawable.nextbuttoncorners))
                                binding.tvLogin.setTextColor(resources.getColor(R.color.white))
                            } else -> {
                            binding.tvLogin.setBackgroundDrawable(resources.getDrawable(R.drawable.nextbuttoncorners))
                            binding.tvLogin.setTextColor(resources.getColor(R.color.white))
                            }
                        }

                        userName = et1
                        password = et2
                    } else {
                        binding.tvLogin.isClickable = false
                        binding.tvLogin.setBackgroundDrawable(resources.getDrawable(R.drawable.loginbuttoncorners))
                        binding.tvLogin.setTextColor(resources.getColor(R.color.dim_gray))
                    }

                }

                override fun beforeTextChanged(
                    s: CharSequence, start: Int, count: Int, after: Int
                ) {
                }

                override fun afterTextChanged(
                    s: Editable
                ) {
                }
            })
        }
    }

    private fun rememberUserRequest() {
        if (binding.chkRememberMe.isChecked) {
            sharedPrefManager.saveUserRequest("$userName-$password")
        }else {
            sharedPrefManager.removeUserRequest()
        }
    }

    private fun validateRememberMe() {
        if (sharedPrefManager.getUserRequest() != null) {
            val existingUserName =
                sharedPrefManager.getUserRequest()!!.split("-").first().toString()
            val existingPassword = sharedPrefManager.getUserRequest()!!.split("-").last().toString()
            binding.etUserName.setText(existingUserName)
            binding.etPassword.setText(existingPassword)
            binding.chkRememberMe.isChecked = true
        } else {
            binding.etUserName.setText("")
            binding.etPassword.setText("")
            binding.chkRememberMe.isChecked = false
        }
    }

    private fun bindObservers() {
        loginViewModel.userResponseLiveData.observe(viewLifecycleOwner, Observer {
            binding.progressbar.gone()
            when (it) {
                is NetworkResult.Success -> {
                    binding.tvPassword.gone()
                    binding.tvUsername.gone()
                    CoroutineScope(Dispatchers.IO).launch {
                        println("it>>>>>>"+it.data?.users?.user)
                        it.data?.users?.user?.map {
                            println("permissions Size ${it?.permissions?.permission?.size}")
                            it?.permissions?.permission?.map {permission ->
                                saveApproveOrderWebsite(permission)
                                val permissionEntity= PermissionEntity()
                                permissionEntity.permissionValue=permission.value
                                permissionEntity.website=permission.website
                                loginViewModel.savePermissions(permissionEntity)
                            }
                            //saving user role
                            it?.role?.let { it1 -> saveUserRole(it1) }
                        } }
                    firebaseAuth(it.data?.users?.user)
                    requireActivity().window
                        .clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                    //log the Login Event
                    tapLoginButtonEvent()
                }
                is NetworkResult.Error -> {
                    sharedPrefManager.removeToken()
                    //showErrors(it.message.toString())
                    firebaseCrashlytics.log(it.message.toString())
                    requireActivity().window
                        .clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)

                    binding.tvPassword.visible()
                    binding.tvUsername.visible()

                }
                is NetworkResult.Loading -> {
                    binding.progressbar.visible()
                    requireActivity().window.setFlags(
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                    )
                }
            }
        })
    }

    private fun saveUserRole(role: String) {

        if (role.isNotBlank()){
            sharedPrefManager.saveUserRole(role)
        }
    }

    private fun tapLoginButtonEvent() {

        val params = makeFirebaseEventBundle(
            firebaseAnalytics,
            sharedPrefManager,
            Screen.Login,
            Category.Login,
            Action.Click,
            "User Login"
        )

        firebaseAnalytics.logEvent(FirebaseCustomEvents.Login, params)

    }

    private fun saveApproveOrderWebsite(permission: Permission)
    {
        if(permission.value == Constants.APPROVE_ORDERS && permission.website == Constants.ATD_ONLINE){
            sharedPrefManager.saveApproveOrdersAtdOnline(permission.value)

        } else if (permission.value == Constants.APPROVE_ORDERS && permission.website == Constants.TIRE_PROS){
            sharedPrefManager.saveApproveOrdersTirePros(permission.value)
        }
    }

    private fun firebaseAuth(user :List<User>?) {
        //userName=userName.replace("[^a-zA-Z0-9]".toRegex(),"")
        auth.fetchSignInMethodsForEmail(userName.replace("[^a-zA-Z0-9]".toRegex(),"")+Constants.EMAIL_ID_SUFFIX)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val signInMethods = task.result?.signInMethods
                    if (signInMethods == null || signInMethods.isEmpty()) {
                         createUser(user)
                    } else {
                        signInUser(user)
                    }
                } else {
                    firebaseCrashlytics.log(task.exception?.message.toString())
                }
            }
    }

    private fun createUser(userList: List<User>?) {
        //val cleanedUsername = userName.replace("[^a-zA-Z0-9]".toRegex(), "")
        if (password.length in 2..5) {
            // Append "12345" to the password
            val updatedPassword = password + "12345"
            auth.createUserWithEmailAndPassword(userName.replace("[^a-zA-Z0-9]".toRegex(),"")+Constants.EMAIL_ID_SUFFIX, updatedPassword)
                .addOnCompleteListener(requireActivity()) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        if (userList?.isNotEmpty() == true) {
                            userList.map {
                                if(it.username == userName){
                                    it.websites.website.let { chooseProfile(it) }
                                }
                            }
                        }
                        sharedPrefManager.saveUserName(userName)
                    } else {
                        firebaseCrashlytics.log(task.exception?.message.toString())
                    }
                }
        } else {
            // Use the original password
            auth.createUserWithEmailAndPassword(userName.replace("[^a-zA-Z0-9]".toRegex(),"")+Constants.EMAIL_ID_SUFFIX, password)
                .addOnCompleteListener(requireActivity()) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        if (userList?.isNotEmpty() == true) {
                            userList.map {
                                if(it.username == userName){
                                    it.websites.website.let { chooseProfile(it) }
                                }
                            }
                        }
                        sharedPrefManager.saveUserName(userName)
                    } else {
                        firebaseCrashlytics.log(task.exception?.message.toString())
                    }
                }
        }
    }

    private fun signInUser(userList: List<User>?) {
        //val cleanedUsername = userName.replace("[^a-zA-Z0-9]".toRegex(), "")
        if (password.length in 2..5) {
            // Append "12345" to the password
            val updatedPassword = password + "12345"
            auth.signInWithEmailAndPassword(userName.replace("[^a-zA-Z0-9]".toRegex(),"")+Constants.EMAIL_ID_SUFFIX, updatedPassword)
                .addOnCompleteListener(requireActivity()) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        if (userList?.isNotEmpty() == true) {
                            userList.map {
                                if(it.username == userName){
                                    it.websites.website.let { chooseProfile(it) }
                                }
                            }
                        }
                        sharedPrefManager.saveUserName(userName)
                    } else {
                        firebaseCrashlytics.log(task.exception?.message.toString())
                    }
                }
        } else {
            // Use the original password
            auth.signInWithEmailAndPassword(userName.replace("[^a-zA-Z0-9]".toRegex(),"")+Constants.EMAIL_ID_SUFFIX, password)
                .addOnCompleteListener(requireActivity()) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        if (userList?.isNotEmpty() == true) {
                            userList.map {
                                if(it.username == userName){
                                    it.websites.website.let { chooseProfile(it) }
                                }
                            }
                        }
                        sharedPrefManager.saveUserName(userName)
                    } else {
                        firebaseCrashlytics.log(task.exception?.message.toString())
                    }
                }
        }
    }





    private fun chooseProfile(data:List<String>){
        val atdOnline =data.filter { it ==Constants.ATD_ONLINE }
        val atdTirePros =data.filter { it ==Constants.TIRE_PROS }
        if (atdOnline.isNotEmpty() && atdTirePros.isNotEmpty()){
            findNavController().navigate(R.id.action_loginFragment_to_chooseProfileFragment)
            sharedPrefManager.saveMultipleProfileAccess(true)
        } else if (atdOnline.isEmpty() && atdTirePros.isEmpty()){
            showErrors(getString(R.string.error_msg))
        } else if (atdOnline.isEmpty() && atdTirePros.isNotEmpty()){
               sharedPrefManager.saveProfileSelected(Constants.TIRE_PROS )
            findNavController().navigate(R.id.action_loginFragment_to_selectLocation)
            sharedPrefManager.saveMultipleProfileAccess(false)
        } else if (atdOnline.isNotEmpty() && atdTirePros.isEmpty()){
            sharedPrefManager.saveProfileSelected(Constants.ATD_ONLINE )
            findNavController().navigate(R.id.action_loginFragment_to_selectLocation)
            sharedPrefManager.saveMultipleProfileAccess(false)
        }
    }

    private fun showErrors(error: String) {
        toast(error)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getBase64Encoded(username: String, password: String): String? {
        val userData = "$username:$password"
        val encodedBytes =
            android.util.Base64.encode(userData.toByteArray(), android.util.Base64.NO_WRAP);
        val encodedString = String(encodedBytes)
        return "Basic $encodedString"
    }


    private fun resetPassword(url: String?) {
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        startActivity(intent)

    }







}