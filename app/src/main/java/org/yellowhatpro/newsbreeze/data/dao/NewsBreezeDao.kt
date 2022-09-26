package org.yellowhatpro.newsbreeze.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import org.yellowhatpro.newsbreeze.data.entities.Article

@Dao
interface NewsBreezeDao {

    @Query("SELECT * FROM newsArticles")
    fun getAllArticles(): Flow<List<Article>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticles(article: List<Article>)

    @Query("DELETE FROM newsArticles WHERE isSaved = 0")
    suspend fun deleteAllArticles()

    @Query("UPDATE newsArticles SET isSaved =:isSaved WHERE id =:id")
    suspend fun toggleSavedState(isSaved: Boolean, id: Int)
}