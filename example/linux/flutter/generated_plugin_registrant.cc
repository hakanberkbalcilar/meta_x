//
//  Generated file. Do not edit.
//

// clang-format off

#include "generated_plugin_registrant.h"

#include <meta_x/meta_x_plugin.h>

void fl_register_plugins(FlPluginRegistry* registry) {
  g_autoptr(FlPluginRegistrar) meta_x_registrar =
      fl_plugin_registry_get_registrar_for_plugin(registry, "MetaXPlugin");
  meta_x_plugin_register_with_registrar(meta_x_registrar);
}
