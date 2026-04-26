package com.ElOuedUniv.maktaba.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.storage.Storage
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SupabaseModule {

    @Provides
    @Singleton
    fun provideSupabaseClient(): SupabaseClient {
        return createSupabaseClient(
            supabaseUrl = "https://trdnfzyjjfmhhzcrbfwp.supabase.co",       // ← ضع رابطك هنا
            supabaseKey = "sb_publishable_HRvO2Ing8LGCldhYZzd7dA_2p_fIQ6p"   // ← ضع مفتاحك هنا
        ) {
            install(Postgrest)
            install(Storage)
        }
    }
}