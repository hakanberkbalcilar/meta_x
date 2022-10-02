package com.hbb.meta_x

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.annotation.NonNull
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import java.util.ArrayList

class MetaXPlugin: FlutterPlugin, MethodCallHandler {
  private lateinit var channel: MethodChannel


  override fun onAttachedToEngine(flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    channel = MethodChannel(flutterPluginBinding.binaryMessenger, "meta_x")
    channel.setMethodCallHandler(this)
  }

  override fun onMethodCall(call: MethodCall, result: MethodChannel.Result) {
    if (call.method == "getFromFile") {
      val provider = MetadataProvider()
      provider.setPath(call.argument("path")!!)

      val meta = provider.metadata

      provider.release()
      Handler(Looper.getMainLooper())
        .post {
            result.success(meta)
        }
    }
    if (call.method == "getFromFiles") {
      val pathList : List<String> = call.argument("paths")!!
      val metaList : ArrayList<Any> = ArrayList()
      val provider = MetadataProvider()

      pathList.forEach {
        try{
          provider.setPath(it)

          val meta = provider.metadata
          if(meta != null)
            metaList.add(meta)
        }catch(e:Exception){
          Log.e("MetaXError", e.message ?: "Unknown")
        }
      }

      provider.release()
      Handler(Looper.getMainLooper())
        .post {
          result.success(pathList)
        }
    } else {
      result.notImplemented()
    }
  }

  override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
    channel.setMethodCallHandler(null)
  }

}
