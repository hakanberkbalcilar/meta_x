#include "include/meta_x/meta_x_plugin_c_api.h"

#include <flutter/plugin_registrar_windows.h>

#include "meta_x_plugin.h"

void Meta_xPluginCApiRegisterWithRegistrar(
    FlutterDesktopPluginRegistrarRef registrar) {
  meta_x::Meta_xPlugin::RegisterWithRegistrar(
      flutter::PluginRegistrarManager::GetInstance()
          ->GetRegistrar<flutter::PluginRegistrarWindows>(registrar));
}
