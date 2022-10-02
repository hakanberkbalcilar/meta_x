import 'package:meta_x/src/meta_x_method_channel.dart';
import 'package:meta_x/src/model/metadata.dart';
import 'package:plugin_platform_interface/plugin_platform_interface.dart';

abstract class MetaXPlatform extends PlatformInterface {
  MetaXPlatform() : super(token: _token);

  static final Object _token = Object();

  static MetaXPlatform _instance = MethodChannelMetaX();

  static MetaXPlatform get instance => _instance;

  static set instance(MetaXPlatform instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }

  Future<Metadata?> getMetadata() {
    throw UnimplementedError('platformVersion() has not been implemented.');
  }
}
