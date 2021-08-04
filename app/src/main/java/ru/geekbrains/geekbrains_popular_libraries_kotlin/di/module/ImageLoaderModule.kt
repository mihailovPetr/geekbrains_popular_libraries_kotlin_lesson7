package ru.geekbrains.geekbrains_popular_libraries_kotlin.di.module

import android.widget.ImageView
import dagger.Module
import dagger.Provides
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.cache.IImageCache
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.cache.room.RoomImageCache
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.room.db.Database
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.image.IImageLoader
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.network.INetworkStatus
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.App
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.image.GlideImageLoader
import javax.inject.Singleton

@Module
class ImageLoaderModule {

    @Singleton
    @Provides
    fun imageLoader(
        imageCache: IImageCache,
        networkStatus: INetworkStatus
    ): IImageLoader<ImageView> = GlideImageLoader(imageCache, networkStatus)

    @Singleton
    @Provides
    fun imageCache(database: Database, app: App): IImageCache = RoomImageCache(database, app.cacheDir)
}