import 'dart:html' as html show window;

import 'package:flutter_web_plugins/flutter_web_plugins.dart';
import 'package:meta_x/src/meta_x_platform_interface.dart';
import 'package:meta_x/src/model/metadata.dart';

/// A web implementation of the Meta_xPlatform of the Meta_x plugin.
class MetaXWeb extends MetaXPlatform {
  /// Constructs a Meta_xWeb
  MetaXWeb();

  static void registerWith(Registrar registrar) {
    MetaXPlatform.instance = MetaXWeb();
  }

  /// Returns a [String] containing the version of the platform.
  @override
  Future<Metadata?> file(String path) async {
    // final metadata = html.window.navigator.userAgent;
    // return metadata;
    return null;
  }
}
