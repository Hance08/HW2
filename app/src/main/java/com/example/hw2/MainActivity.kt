package com.example.hw2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.hw2.screens.DetailScreen
import com.example.hw2.screens.MainScreen
import com.example.hw2.ui.theme.HW2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HW2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val imageId = arrayOf(
                        R.drawable.image1,
                        R.drawable.image2,
                        R.drawable.image3,
                        R.drawable.image4,
                        R.drawable.image5,
                        R.drawable.image6
                    )

                    val names = arrayOf(
                        "台北101",
                        "野柳女王頭",
                        "阿里山小火車",
                        "六福村遊樂園",
                        "九份老街",
                        "正濱漁港"
                    )

                    val ingredientsMain = arrayOf(
                        "台北市 信義區",
                        "新北市 萬里區",
                        "南投",
                        "桃園市 龍潭區",
                        "新北市 瑞芳區",
                        "基隆市 中正區",
                    )

                    val ingredientsDetail = arrayOf(
                        "台北101位於台北市中心，是台灣著名的地標，高聳的樣貌讓人在遠方就能清楚的看見。",
                        "野柳女王頭是屬於蕈狀岩，因形狀貌似英國伊莉莎白女王頭像，因而得名。",
                        "阿里山林業鐵路是位於臺灣南部的高山森林鐵路系統，該鐵路乃是日治時代為了將阿里山林場產出之林木向外輸送而建設；林場砍伐業務結束後，客運與觀光成為該鐵路的主要功能。",
                        "六福村主題遊樂園，目前遊樂園內共分為六大主題區域，分別是「中央魔術噴泉」、「美國大西部」、「南太平洋」、「阿拉伯皇宮」、「非洲部落」（野生動物園）、「六福水樂園」",
                        "九份是臺灣新北市瑞芳區的一個地區，與基隆山遙望；整個小鎮座落於山坡地上，也因此形成了獨特的山坡和階梯式建築景觀。早期因金礦而興盛，礦坑挖掘殆盡後一度沒落。1990年代後，因電影《悲情城市》在此取景，其獨特的舊式建築、坡地及風情透過該片吸引國內外的注目，也為此地區重新帶來生機，成為觀光景點。",
                        "正濱漁港，舊稱基隆漁港，位於基隆市中正區正濱里與和平島南方，屬於第一類漁港；可停泊1,000頓以上的遠洋漁船，為近海拖網與遠洋漁業基地。",
                    )

                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "MainScreen") {
                        composable(route = "MainScreen") {
                            MainScreen(imageId, names, ingredientsMain, navController)
                        }
                        composable(route = "DetailScreen/{index}",
                            arguments = listOf(
                                navArgument(name = "index") {
                                    type = NavType.IntType
                                }
                            )
                        ) { index ->
                            DetailScreen(
                                photos = imageId,
                                names = names,
                                ingredients = ingredientsDetail,
                                itemIndex = index.arguments?.getInt("index")
                            )
                        }
                    }

                }
            }
        }
    }
}