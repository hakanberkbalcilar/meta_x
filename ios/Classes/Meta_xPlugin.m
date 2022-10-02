#import "Meta_xPlugin.h"
#if __has_include(<meta_x/meta_x-Swift.h>)
#import <meta_x/meta_x-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "meta_x-Swift.h"
#endif

@implementation Meta_xPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftMeta_xPlugin registerWithRegistrar:registrar];
}
@end
