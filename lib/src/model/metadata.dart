import 'package:flutter/services.dart';
import 'package:meta_x/src/model/file_info.dart';

class Metadata {
  final String? title;
  final List<String>? artists;
  final String? album;
  final String? albumArtist;
  final String? genre;
  final String? author;
  final String? writer;
  final String? mimeType;
  final int? trackNumber;
  final int? albumLength;
  final int? year;
  final int? discNumber;
  final int? duration;
  final int? bitrate;
  final Uint8List? cover;
  final FileInfo fileInfo;

  Metadata({
    this.title,
    this.artists,
    this.album,
    this.albumArtist,
    this.trackNumber,
    this.albumLength,
    this.year,
    this.genre,
    this.author,
    this.writer,
    this.discNumber,
    this.mimeType,
    this.duration,
    this.bitrate,
    this.cover,
    required this.fileInfo,
  });

  factory Metadata.fromJson(Map<dynamic, dynamic> json) => Metadata(
        title: json['title'] as String?,
        artists: [],
        album: json['album'] as String?,
        albumArtist: json['albumArtist'] as String?,
        genre: json['genre'] as String?,
        author: json['author'] as String?,
        writer: json['writer'] as String?,
        fileInfo: FileInfo.fromJson(json['fileInfo']),
        mimeType: json['mimeType'] as String?,
        trackNumber: int.tryParse(json['trackNumber'] as String? ?? ''),
        albumLength: int.tryParse(json['albumLength'] as String? ?? ''),
        year: int.tryParse(json['year'] as String? ?? ''),
        discNumber: int.tryParse(json['discNumber'] as String? ?? ''),
        duration: int.tryParse(json['duration'] as String? ?? ''),
        bitrate: int.tryParse(json['bitrate'] as String? ?? ''),
        cover: json['cover'] as Uint8List?,
      );
}
