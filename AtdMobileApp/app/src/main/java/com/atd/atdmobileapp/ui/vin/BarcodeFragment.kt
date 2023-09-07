package com.atd.atdmobileapp.ui.vin

import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.atd.atdmobileapp.MainViewModel
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment.Companion.atdFooter
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment.Companion.atdHeader
import com.atd.atdmobileapp.utils.SharedPrefManager
import com.atd.atdmobileapp.utils.gone
import com.atd.atdmobileapp.utils.visible
import com.google.zxing.Result
import dagger.hilt.android.AndroidEntryPoint
import me.dm7.barcodescanner.zxing.ZXingScannerView
import javax.inject.Inject


@AndroidEntryPoint
class BarcodeFragment : AppCompatActivity(), ZXingScannerView.ResultHandler {


    private lateinit var scannerView: ZXingScannerView
    private val CAMERA_PERMISSION_REQUEST: Int=123
    @Inject
    lateinit var sharedPrefManager: SharedPrefManager
    var sncannedText : String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       setContentView(R.layout.fragment_barcode)

        atdHeader?.gone()
        atdFooter?.gone()
        scannerView =findViewById(R.id.scannerView)

        scannerView.startCamera()
        scannerView.setOnClickListener {
            if (sncannedText.isNotEmpty()) {
                closeScannerView()
            }
        }
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


    }

    override fun onResume() {
        super.onResume()
        scannerView.setResultHandler(this)
    }

    override fun onPause() {
        super.onPause()
        scannerView.stopCamera()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray,
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_REQUEST) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startBarcodeScanner()
            } else {
                Toast.makeText(
                    this,
                    "Camera permission denied",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun startBarcodeScanner() {
       setContentView(scannerView)
        scannerView.startCamera()
    }
    override fun handleResult(result: Result?) {
        // Process the scanned barcode result
        val barcodeResult = result?.text
        //Toast.makeText(this, "Scanned Barcode: $barcodeResult", Toast.LENGTH_SHORT).show()

        sncannedText=barcodeResult.toString()

        scannerView.resumeCameraPreview(this)

    }
    private fun closeScannerView() {
        scannerView.stopCamera()
        atdHeader?.visible()
        atdFooter?.visible()
        sharedPrefManager.saveBarcode(sncannedText)
        onBackPressed()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        scannerView.stopCamera()

    }


}