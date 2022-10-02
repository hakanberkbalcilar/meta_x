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
            val fileInfo = HashMap<String, Any?>()
            metadata["fileInfo"] = fileInfo

            val splitPath = path.split("/")
            val splitFileName = splitPath.last().split(".")

            fileInfo["extension"] = splitFileName.last()
            fileInfo["name"] = splitFileName.subList(0, splitFileName.size - 1).joinToString(".")
            fileInfo["path"] = path
            fileInfo["directory"] = splitPath[splitPath.size - 2]

            metadata["title"] = getMetaData(METADATA_KEY_TITLE)
            metadata["artists"] = getMetaData(METADATA_KEY_ARTIST)
            metadata["album"] = getMetaData(METADATA_KEY_ALBUM)
            metadata["albumArtist"] = getMetaData(METADATA_KEY_ALBUMARTIST)
            metadata["genre"] = getMetaData(METADATA_KEY_GENRE)
            metadata["author"] = getMetaData(METADATA_KEY_AUTHOR)
            metadata["writer"] = getMetaData(METADATA_KEY_WRITER)
            metadata["discNumber"] = getMetaData(METADATA_KEY_DISC_NUMBER)
            metadata["mimeType"] = getMetaData(METADATA_KEY_MIMETYPE)
            metadata["duration"] = getMetaData(METADATA_KEY_DURATION)
            metadata["bitrate"] = getMetaData(METADATA_KEY_BITRATE)
            metadata["trackNumber"] = getMetaData(METADATA_KEY_CD_TRACK_NUMBER)
            metadata["year"] = getMetaData(METADATA_KEY_YEAR)

            try {
                metadata["albumArt"] = embeddedPicture
            }
            catch (e:IllegalStateException){
                Log.e("MetaXError", e.message ?: "Unknown")
            }
            return metadata

        }

        private fun getMetaData(i:Int): String?{
            try{
                val result = extractMetadata(i)
                return result
            }
            catch(e:Exception){
                 return null   
            }
        }
}