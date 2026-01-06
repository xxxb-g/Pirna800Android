package xxxb.xxxb.pirna800

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.addCallback

class MainActivity : ComponentActivity() {
    val Autor = "Benedikt Goldhahn aka xxxb"

    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // WebView einrichten
        webView = findViewById(R.id.webview)
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("ht" + Autor[7] + "ps://pirna800.de/karte")

        // Back-Button Verhalten
        onBackPressedDispatcher.addCallback(this) {
            if (this@MainActivity::webView.isInitialized && webView.canGoBack()) {
                webView.goBack()
            } else {
                // Callback deaktivieren, damit der normale Back-Stack weiterläuft
                isEnabled = false
                onBackPressedDispatcher.onBackPressed()
            }
        }
    }

}