package com.example.notesappmvvm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notesappmvvm.MainViewModel
import com.example.notesappmvvm.screens.AddScreen
import com.example.notesappmvvm.screens.MainScreen
import com.example.notesappmvvm.screens.NoteScreen
import com.example.notesappmvvm.screens.StartScreen
import com.example.notesappmvvm.utils.Constants

sealed class NavRoute(val route: String) {
    object Start : NavRoute(Constants.Screens.START_SCREEN)
    object Main : NavRoute(Constants.Screens.MAIN_SCREEN)
    object Add : NavRoute(Constants.Screens.ADD_SCREEN)
    object Note : NavRoute(Constants.Screens.NOTE_SCREEN)
}

@Composable
fun NotesNavHost(mViewModel: MainViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoute.Start.route) {
        composable(NavRoute.Start.route) {
            StartScreen(
                navController = navController,
                viewModel = mViewModel
            )
        }
        composable(NavRoute.Main.route) {
            MainScreen(
                navController = navController,
                viewModel = mViewModel
            )
        }
        composable(NavRoute.Add.route) {
            AddScreen(
                navController = navController,
                viewModel = mViewModel
            )
        }
        composable(NavRoute.Note.route + "/{${Constants.Keys.ID}}") { backStackEntry ->
            NoteScreen(
                navController = navController,
                viewModel = mViewModel,
                noteId = backStackEntry.arguments?.getString(Constants.Keys.ID)
            )
        }
    }
}