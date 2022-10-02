package com.hbb.meta_x

import android.media.MediaMetadataRetriever
import android.util.Log

class MetadataProvider(path:String?) : MediaMetadataRetriever() {

    init {
        setDataSource(path)
    }

    val metadata: HashMap<String, Any?>
        get() {
            val metadata = HashMap<String, Any?>()
            metadata["title"] = extractMetadata(METADATA_KEY_TITLE)
            metadata["artists"] = extractMetadata(METADATA_KEY_ARTIST)
            metadata["album"] = extractMetadata(METADATA_KEY_ALBUM)
            metadata["albumArtist"] = extractMetadata(METADATA_KEY_ALBUMARTIST)
            val trackNumber = extractMetadata(METADATA_KEY_CD_TRACK_NUMBER)
            try {
                Log.i("What trackNumber", trackNumber ?: "null")
                if (trackNumber == null) {
                    metadata["trackNumber"] = null
                    metadata["albumLength"] = null
                } else {
                    metadata["trackNumber"] =
                        trackNumber.split("/".toRegex()).toTypedArray()[0].trim { it <= ' ' }

                    metadata["albumLength"] =
                        trackNumber.split("/".toRegex())
                            .toTypedArray()[trackNumber.split("/".toRegex())
                            .toTypedArray().size - 1].trim { it <= ' ' }
                }
            } catch (error: Exception) {
                metadata["trackNumber"] = null
                metadata["albumLength"] = null
            }
            val year = extractMetadata(METADATA_KEY_YEAR)
            val date = extractMetadata(METADATA_KEY_DATE)
            Log.i("What Year", date ?: "null")
            if (year == null)
                if (date == null)
                    metadata["year"] = null
                else
                    metadata["year"] =
                        date.split("-".toRegex()).toTypedArray()[0].trim { it <= ' ' }
            else
                metadata["year"] = year.trim { it <= ' ' }.toInt()

            metadata["genre"] = extractMetadata(METADATA_KEY_GENRE)
            metadata["author"] = extractMetadata(METADATA_KEY_AUTHOR)
            metadata["writer"] = extractMetadata(METADATA_KEY_WRITER)
            metadata["discNumber"] = extractMetadata(METADATA_KEY_DISC_NUMBER)
            metadata["mimeType"] = extractMetadata(METADATA_KEY_MIMETYPE)
            metadata["duration"] = extractMetadata(METADATA_KEY_DURATION)
            metadata["bitrate"] = extractMetadata(METADATA_KEY_BITRATE)
            metadata["cover"] = embeddedPicture
            return metadata
        }
}