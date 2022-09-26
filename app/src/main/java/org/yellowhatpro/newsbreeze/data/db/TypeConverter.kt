package org.yellowhatpro.newsbreeze.data.db

import androidx.room.TypeConverter
import org.yellowhatpro.newsbreeze.data.entities.Source

object TypeConverter {

    @TypeConverter
    fun fromSource(source: Source) = source.name

    @TypeConverter
    fun toSource(sourceName: String) = Source(sourceName, sourceName)
}