import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:meta_x/src/meta_x_method_channel.dart';

void main() {
  MethodChannelMetaX platform = MethodChannelMetaX();
  const MethodChannel channel = MethodChannel('meta_x');

  TestWidgetsFlutterBinding.ensureInitialized();

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return null;
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getMetadata', () async {
    expect(await platform.getMetadata(), null);
  });
}
