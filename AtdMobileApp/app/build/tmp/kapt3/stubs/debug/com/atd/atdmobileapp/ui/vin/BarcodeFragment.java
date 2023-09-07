package com.atd.atdmobileapp.ui.vin;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\u0012\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0015H\u0014J-\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00052\u000e\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0!2\u0006\u0010\"\u001a\u00020#H\u0016\u00a2\u0006\u0002\u0010$J\b\u0010%\u001a\u00020\u0015H\u0014J\b\u0010&\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\'"}, d2 = {"Lcom/atd/atdmobileapp/ui/vin/BarcodeFragment;", "Landroidx/appcompat/app/AppCompatActivity;", "Lme/dm7/barcodescanner/zxing/ZXingScannerView$ResultHandler;", "()V", "CAMERA_PERMISSION_REQUEST", "", "scannerView", "Lme/dm7/barcodescanner/zxing/ZXingScannerView;", "sharedPrefManager", "Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "getSharedPrefManager", "()Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "setSharedPrefManager", "(Lcom/atd/atdmobileapp/utils/SharedPrefManager;)V", "sncannedText", "", "getSncannedText", "()Ljava/lang/String;", "setSncannedText", "(Ljava/lang/String;)V", "closeScannerView", "", "handleResult", "result", "Lcom/google/zxing/Result;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "startBarcodeScanner", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class BarcodeFragment extends androidx.appcompat.app.AppCompatActivity implements me.dm7.barcodescanner.zxing.ZXingScannerView.ResultHandler {
    private me.dm7.barcodescanner.zxing.ZXingScannerView scannerView;
    private final int CAMERA_PERMISSION_REQUEST = 123;
    @javax.inject.Inject
    public com.atd.atdmobileapp.utils.SharedPrefManager sharedPrefManager;
    @org.jetbrains.annotations.NotNull
    private java.lang.String sncannedText = "";
    
    public BarcodeFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.utils.SharedPrefManager getSharedPrefManager() {
        return null;
    }
    
    public final void setSharedPrefManager(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.utils.SharedPrefManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSncannedText() {
        return null;
    }
    
    public final void setSncannedText(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    @java.lang.Override
    protected void onPause() {
    }
    
    @java.lang.Override
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull
    int[] grantResults) {
    }
    
    private final void startBarcodeScanner() {
    }
    
    @java.lang.Override
    public void handleResult(@org.jetbrains.annotations.Nullable
    com.google.zxing.Result result) {
    }
    
    private final void closeScannerView() {
    }
    
    @java.lang.Override
    public void onBackPressed() {
    }
}