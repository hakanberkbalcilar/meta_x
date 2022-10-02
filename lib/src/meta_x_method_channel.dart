import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:meta_x/src/meta_x_platform_interface.dart';
import 'package:meta_x/src/model/metadata.dart';

class MethodChannelMetaX extends MetaXPlatform {
  @visibleForTesting
  final methodChannel = const MethodChannel('meta_x');

  @override
  Future<Metadata?> getMetadata() async {
    final metadata = await methodChannel.invokeMethod<Map<String, dynamic>>('getMetadata');
    return metadata == null ? null : Metadata.fromJson(metadata);
  }
}
