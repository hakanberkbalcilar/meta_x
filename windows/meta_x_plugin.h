#ifndef FLUTTER_PLUGIN_META_X_PLUGIN_H_
#define FLUTTER_PLUGIN_META_X_PLUGIN_H_

#include <flutter/method_channel.h>
#include <flutter/plugin_registrar_windows.h>

#include <memory>

namespace meta_x {

class Meta_xPlugin : public flutter::Plugin {
 public:
  static void RegisterWithRegistrar(flutter::PluginRegistrarWindows *registrar);

  Meta_xPlugin();

  virtual ~Meta_xPlugin();

  // Disallow copy and assign.
  Meta_xPlugin(const Meta_xPlugin&) = delete;
  Meta_xPlugin& operator=(const Meta_xPlugin&) = delete;

 private:
  // Called when a method is called on this plugin's channel from Dart.
  void HandleMethodCall(
      const flutter::MethodCall<flutter::EncodableValue> &method_call,
      std::unique_ptr<flutter::MethodResult<flutter::EncodableValue>> result);
};

}  // namespace meta_x

#endif  // FLUTTER_PLUGIN_META_X_PLUGIN_H_
