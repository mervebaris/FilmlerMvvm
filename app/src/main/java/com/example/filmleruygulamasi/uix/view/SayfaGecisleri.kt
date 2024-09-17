package com.example.filmleruygulamasi.uix.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.filmleruygulamasi.data.entity.Filmler
import com.example.filmleruygulamasi.uix.viewmodel.AnaSayfaViewModel
import com.google.gson.Gson

@Composable
fun SayfaGecisleri(anaSayfaViewModel: AnaSayfaViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "anaSayfa") {
        composable("anaSayfa"){
            AnaSayfa(navController = navController, anaSayfaViewModel)
        }
        composable(
            "detaySayfa/{film}",
            arguments = listOf(
                navArgument("film"){type = NavType.StringType}
            )
        ){
            val json = it.arguments?.getString("film") //Stringleştirme işlemi yaptık
            val nesne = Gson().fromJson(json,Filmler::class.java) //json'ı -> Nesneye çevirdik
            DetaySayfa(nesne)
        }
    }
}