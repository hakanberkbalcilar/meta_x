class FileInfo {
  final String name;
  final String path;
  final String extension;
  final String directory;

  FileInfo({required this.name, required this.path, required this.extension, required this.directory});

  factory FileInfo.fromJson(Map<String, dynamic> json) => FileInfo(
      name: json['name'] as String, path: json['path'] as String, extension: json['extension'] as String, directory: json['directory'] as String);
}
