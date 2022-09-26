package org.yellowhatpro.newsbreeze.data.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.yellowhatpro.newsbreeze.data.api.NewsApi
import org.yellowhatpro.newsbreeze.data.db.NewsArticlesDatabase
import org.yellowhatpro.newsbreeze.data.repository.NewsBreezeRepository
import org.yellowhatpro.newsbreeze.data.repository.NewsBreezeRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNewsBreezeRepository(newsApi: NewsApi,
                                    db: NewsArticlesDatabase): NewsBreezeRepository =
        NewsBreezeRepositoryImpl(newsApi,db)

    @Provides
    @Singleton
    fun provideNewsArticlesDatabase(app: Application) =
        Room.databaseBuilder(
            app,
            NewsArticlesDatabase::class.java,
            "news_articles_database"
        ).build()
}