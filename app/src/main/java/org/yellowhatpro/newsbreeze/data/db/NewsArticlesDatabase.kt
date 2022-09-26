package org.yellowhatpro.newsbreeze.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import org.yellowhatpro.newsbreeze.data.dao.NewsBreezeDao
import org.yellowhatpro.newsbreeze.data.entities.Article

@Database(
    entities = [Article::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(TypeConverter::class)
abstract class NewsArticlesDatabase: RoomDatabase(){
    abstract val newsBreezeDao: NewsBreezeDao

}