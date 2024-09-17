package com.example.filmleruygulamasi.data.repo

import com.example.filmleruygulamasi.data.datasource.FilmlerDataSource
import com.example.filmleruygulamasi.data.entity.Filmler

class FilmlerRepository {
    val fds = FilmlerDataSource()

    suspend fun filmleriYukle(): List<Filmler> = fds.filmleriYukle()
}