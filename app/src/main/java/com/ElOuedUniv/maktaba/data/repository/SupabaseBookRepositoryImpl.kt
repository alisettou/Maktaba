package com.ElOuedUniv.maktaba.data.repository

import com.ElOuedUniv.maktaba.data.model.Book
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SupabaseBookRepositoryImpl @Inject constructor(
    private val supabase: SupabaseClient
) : BookRepository {

    override fun getAllBooks(): Flow<List<Book>> = flow {
        val books = supabase.postgrest["books"]
            .select()
            .decodeList<Book>()
        emit(books)
    }

    override fun getBookByIsbn(isbn: String): Book? = null

    override suspend fun addBook(book: Book) {
        supabase.postgrest["books"].insert(book)
    }
}