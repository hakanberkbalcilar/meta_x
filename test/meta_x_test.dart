import 'package:flutter_test/flutter_test.dart';
import 'package:meta_x/src/meta_x.dart';
import 'package:meta_x/src/meta_x_method_channel.dart';
import 'package:meta_x/src/meta_x_platform_interface.dart';
import 'package:meta_x/src/model/metadata.dart';
import 'package:plugin_platform_interface/plugin_platform_interface.dart';

class MockMetaXPlatform with MockPlatformInterfaceMixin implements MetaXPlatform {
  @override
  Future<Metadata?> getMetadata() => Future.value(null);
}

void main() {
  final MetaXPlatform initialPlatform = MetaXPlatform.instance;

  test('$MethodChannelMetaX is the default instance', () {
    expect(initialPlatform, isInstanceOf<MethodChannelMetaX>());
  });

  test('getMetadata', () async {
    MockMetaXPlatform fakePlatform = MockMetaXPlatform();
    MetaXPlatform.instance = fakePlatform;

    expect(await MetaX.getMetadata(), null);
  });
}
