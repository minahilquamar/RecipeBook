package com.example.recipebook

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.recipebook.firebaselogic.CategoryInitializer
import com.example.recipebook.ui.theme.RecipeBookTheme
import com.google.firebase.FirebaseApp
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val categoryInitializer = CategoryInitializer()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {
            RecipeBookTheme {
                FirebaseApp.initializeApp(LocalContext.current)

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                        .background(Color.White),
                    color = Color.White,

                ) {

//                    AuthNavGraph()
                    // Initialize categories when the app starts
                    categoryInitializer.initializeCategories()

                    MainScreen()
                }

            }
        }
    }
}
