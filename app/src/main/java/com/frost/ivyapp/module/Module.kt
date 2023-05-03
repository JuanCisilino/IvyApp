package com.frost.ivyapp.module

import com.frost.ivyapp.BuildConfig
import com.frost.ivyapp.network.OpenAIService
import com.frost.ivyapp.repository.TextRepository
import com.frost.ivyapp.usecases.GenerateTextUC
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Module {


    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS) // Tiempo límite de conexión de 60 segundos
            .readTimeout(60, TimeUnit.SECONDS) // Tiempo límite de lectura de 60 segundos
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Authorization", "Bearer API_KEY")
                    .build()
                chain.proceed(request)
            }
            .build()
    }

    @Provides
    @Singleton
    fun provideOpenAIService(okHttpClient: OkHttpClient): OpenAIService {
        return Retrofit.Builder()
            .baseUrl("https://api.openai.com/v1/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OpenAIService::class.java)
    }

    @Provides
    fun provideOpenAIRepository(api: OpenAIService) = TextRepository(api = api)

    @Provides
    fun provideGenerateTextUseCase(repository: TextRepository) = GenerateTextUC(repository = repository)

}