package com.hbb.meta_x

import android.media.MediaMetadataRetriever
import android.util.Log

class MetadataProvider : MediaMetadataRetriever() {

    private var path: String = ""

    fun setPath(path:String) {
        this.path = path
        setDataSource(path)
    }

    val metadata: HashMap<String, Any?>?
        get() {
            val metadata = HashMap<String, Any?>()
            try {
                metadata["title"] = extractMetadata(METADATA_KEY_TITLE)
                metadata["artists"] = extractMetadata(METADATA_KEY_ARTIST)
                metadata["album"] = extractMetadata(METADATA_KEY_ALBUM)
                metadata["albumArtist"] = extractMetadata(METADATA_KEY_ALBUMARTIST)
                metadata["genre"] = extractMetadata(METADATA_KEY_GENRE)
                metadata["author"] = extractMetadata(METADATA_KEY_AUTHOR)
                metadata["writer"] = extractMetadata(METADATA_KEY_WRITER)
                metadata["discNumber"] = extractMetadata(METADATA_KEY_DISC_NUMBER)
                metadata["mimeType"] = extractMetadata(METADATA_KEY_MIMETYPE)
                metadata["duration"] = extractMetadata(METADATA_KEY_DURATION)
                metadata["bitrate"] = extractMetadata(METADATA_KEY_BITRATE)
                metadata["albumArt"] = embeddedPicture

                val trackNumber = extractMetadata(METADATA_KEY_CD_TRACK_NUMBER)
                try {

                    if (trackNumber == null) {
                        metadata["trackNumber"] = null
                        metadata["albumLength"] = null
                    } else {
                        val splitTrackNumber = trackNumber.split("/".toRegex()).toTypedArray()
                        metadata["trackNumber"] = splitTrackNumber[0].trim { it <= ' ' }
                        metadata["albumLength"] = splitTrackNumber[splitTrackNumber.size - 1].trim { it <= ' ' }
                    }
                } catch (error: Exception) {
                    metadata["trackNumber"] = null
                    metadata["albumLength"] = null
                }
                val year = extractMetadata(METADATA_KEY_YEAR)
                val date = extractMetadata(METADATA_KEY_DATE)

                if (year == null)
                    if (date == null)
                        metadata["year"] = null
                    else
                        metadata["year"] =
                            date.split("-".toRegex()).toTypedArray()[0].trim { it <= ' ' }
                else
                    metadata["year"] = year.trim { it <= ' ' }.toInt()

                val fileInfo = HashMap<String, Any?>()
                val splitPath = path.split("/")
                val splitFileName = splitPath.last().split(".")

                fileInfo["name"] =
                    splitFileName.subList(0, splitFileName.size - 2).joinToString(".")
                fileInfo["path"] = path
                fileInfo["extension"] = splitFileName.last()
                fileInfo["directory"] = splitPath[splitPath.size - 2]

                metadata["fileInfo"] = fileInfo

                return metadata
            }
            catch (e:IllegalStateException){
                Log.e("MetaXError", e.message ?: "Unknown")
                return null
            }
        }
}