import 'package:meta_x/src/meta_x_platform_interface.dart';
import 'package:meta_x/src/model/metadata.dart';

class MetaX {
  static Future<Metadata?> getMetadata() => MetaXPlatform.instance.getMetadata();
}
