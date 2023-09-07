package com.atd.atdmobileapp.ui.licenceplate

import android.content.pm.ActivityInfo
import android.graphics.*
import android.os.Bundle
import android.os.PersistableBundle
import android.util.DisplayMetrics
import android.util.Log
import android.util.Size
import android.view.*
import android.widget.ImageButton
import android.widget.StackView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.OcrLicencePlateBinding
import com.atd.atdmobileapp.utils.SharedPrefManager
import com.google.common.util.concurrent.ListenableFuture
import com.google.firebase.FirebaseApp
import com.google.firebase.ml.vision.FirebaseVision
import com.google.firebase.ml.vision.common.FirebaseVisionImage
import com.google.firebase.ml.vision.common.FirebaseVisionImageMetadata
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import java.util.concurrent.ExecutionException
import java.util.concurrent.Executors
import javax.inject.Inject

@AndroidEntryPoint
class OCRLicencePlate : AppCompatActivity(), SurfaceHolder.Callback {

    lateinit var mCameraView: PreviewView
    lateinit var holder: SurfaceHolder
    lateinit var surfaceView: SurfaceView
    lateinit var canvas: Canvas
    lateinit var paint: Paint
    var xOffset = 0
    var yOffset = 0
    var boxWidth = 0
    var boxHeight = 0
    lateinit var tvOcr :TextView
    private var cameraProviderFuture: ListenableFuture<ProcessCameraProvider>? = null
    private val executor = Executors.newSingleThreadExecutor()


    @Inject
    lateinit var sharedPrefManager: SharedPrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ocr_licence_plate)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        FirebaseApp.initializeApp(this)
        //Create the bounding box
        surfaceView = findViewById(R.id.overlay)
        tvOcr = findViewById(R.id.tvOcr)
        mCameraView = findViewById(R.id.previewView)

        surfaceView.setZOrderOnTop(true)
        holder = surfaceView.getHolder()
        holder.setFormat(PixelFormat.TRANSPARENT)
        holder.addCallback(this)

        startCamera()

    }


    /**
     * Responsible for converting the rotation degrees from CameraX into the one compatible with Firebase ML
     */
    private fun degreesToFirebaseRotation(degrees: Int): Int {
        return when (degrees) {
            0 -> FirebaseVisionImageMetadata.ROTATION_0
            90 -> FirebaseVisionImageMetadata.ROTATION_90
            180 -> FirebaseVisionImageMetadata.ROTATION_180
            270 -> FirebaseVisionImageMetadata.ROTATION_270
            else -> throw IllegalArgumentException(
                "Rotation must be 0, 90, 180, or 270."
            )
        }
    }

    /**
     * Starting Camera
     */
    fun startCamera() {
        cameraProviderFuture = ProcessCameraProvider.getInstance(this)
        cameraProviderFuture!!.addListener({
            try {
                val cameraProvider = cameraProviderFuture!!.get()
                bindPreview(cameraProvider)
            } catch (e: ExecutionException) {
                // No errors need to be handled for this Future.
                // This should never be reached.
            } catch (e: InterruptedException) {
            }
        }, ContextCompat.getMainExecutor(this))
    }

    /**
     *
     * Binding to camera
     */
    private fun bindPreview(cameraProvider: ProcessCameraProvider) {
        val preview = Preview.Builder()
            .build()
        preview.setSurfaceProvider(mCameraView!!.createSurfaceProvider())
        val cameraSelector = CameraSelector.Builder()
            .requireLensFacing(CameraSelector.LENS_FACING_BACK)
            .build()

        //Image Analysis Function
        //Set static size according to your device or write a dynamic function for it
        val imageAnalysis = ImageAnalysis.Builder()
            .setTargetResolution(Size(720, 1488))
            .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
            .build()
        imageAnalysis.setAnalyzer(executor, ImageAnalysis.Analyzer { image ->
            //changing normal degrees into Firebase rotation
            val rotationDegrees = degreesToFirebaseRotation(image.imageInfo.rotationDegrees)
            if (image == null || image.image == null) {
                return@Analyzer
            }
            //Getting a FirebaseVisionImage object using the Image object and rotationDegrees
            val mediaImage = image.image
            val images = FirebaseVisionImage.fromMediaImage(mediaImage!!, rotationDegrees)
            //Getting bitmap from FirebaseVisionImage Object
            val bmp = images.bitmap
            //Getting the values for cropping
            val displaymetrics = DisplayMetrics()
            this.windowManager.defaultDisplay.getMetrics(displaymetrics)
            val height = bmp.height
            val width = bmp.width
            val left: Int
            val right: Int
            val top: Int
            val bottom: Int
            var diameter: Int
            diameter = width
            if (height < width) {
                diameter = height
            }
            val offset = (0.05 * diameter).toInt()
            diameter -= offset
            left = width/2- diameter/2
            top = height / 2 - diameter / 6
            right = width /2+ diameter/2
            bottom = height / 2 - diameter / 5
            xOffset = left
            yOffset = top

            //Creating new cropped bitmap
            val bitmap = Bitmap.createBitmap(bmp, left, top, right, bottom)
            //initializing FirebaseVisionTextRecognizer object
            val detector = FirebaseVision.getInstance()
                .onDeviceTextRecognizer
            //Passing FirebaseVisionImage Object created from the cropped bitmap
            val result = detector.processImage(FirebaseVisionImage.fromBitmap(bitmap))
                .addOnSuccessListener { firebaseVisionText -> // Task completed successfully
                    // ...
                    //getting decoded text
                    var text = firebaseVisionText.text
                    //Setting the decoded text in the texttview

                    surfaceView!!.setOnClickListener {
                        if (!text.trim { it <= ' ' }.isEmpty()) {
                           // Toast.makeText(this,text,Toast.LENGTH_SHORT).show()
                            sharedPrefManager.saveBarcode(text)
                           onBackPressed()
                        }

                        //ocrImage.setText(text);
                    }
                    //for getting blocks and line elements
                    for (block in firebaseVisionText.textBlocks) {
                        val blockText = block.text
                        for (line in block.lines) {
                            val lineText = line.text
                            for (element in line.elements) {
                                val elementText = element.text
                            }
                        }
                    }
                    image.close()
                }
                .addOnFailureListener { e -> // Task failed with an exception
                    // ...
                    Log.e("Error", e.toString())
                    image.close()
                }
        })
        val camera = cameraProvider.bindToLifecycle(
            (this as LifecycleOwner),
            cameraSelector,
            imageAnalysis,
            preview
        )
    }
    

    /**
     *
     * For drawing the rectangular box
     */
    private fun DrawFocusRect(color: Int) {
        val displaymetrics = DisplayMetrics()
        this.windowManager.defaultDisplay.getMetrics(displaymetrics)
        val height = mCameraView!!.height
        val width = mCameraView!!.width

        //cameraHeight = height;
        //cameraWidth = width;
        val left: Int
        val right: Int
        val top: Int
        val bottom: Int
        var diameter: Int
        diameter = width
        if (height < width) {
            diameter = height
        }
        val offset = (0.05 * diameter).toInt()
        diameter -= offset
        canvas = holder!!.lockCanvas()
        canvas.drawColor(0, PorterDuff.Mode.CLEAR)
        //border's properties
        paint = Paint()
        paint!!.style = Paint.Style.STROKE
        paint!!.color = color
        paint!!.strokeWidth = 5f
        left = width / 3 - diameter / 2
        top = height / 2 - diameter / 4
        right = (width / 3 + diameter / 1)+120
        bottom = height / 2 + diameter / 4
        xOffset = left
        yOffset = top
        boxHeight = bottom - top
        boxWidth = right - left
        //Changing the value of x in diameter/x will change the size of the box ; inversely proportionate to x
        canvas.drawRect(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat(), paint!!)
        holder!!.unlockCanvasAndPost(canvas)
    }

    /**
     * Callback functions for the surface Holder
     */
    override fun surfaceCreated(holder: SurfaceHolder) {}
    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        //Drawing rectangle
        DrawFocusRect(ContextCompat.getColor(this, R.color.atd_blue))
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {}
}