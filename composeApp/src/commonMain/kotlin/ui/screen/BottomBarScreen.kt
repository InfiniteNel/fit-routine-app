package ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.*
import ui.screen.myday.MyDayScreen
import ui.screen.weeklyroutine.WeeklyRoutineScreen

class BottomBarScreen : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        TabNavigator(
            MyDayScreen,
            tabDisposable = {
                TabDisposable(
                    it,
                    listOf(MyDayScreen, WeeklyRoutineScreen)
                )
            }
        ) {
            Scaffold(
                bottomBar = {
                    BottomAppBar (
                        content = {
                            NavigationBar {
                                TabNavigationItem(MyDayScreen)
                                TabNavigationItem(WeeklyRoutineScreen)
                            }
                        }
                    )
                },
                content = {
                    CurrentTab()
                }
            )
        }
    }

    @Composable
    private fun RowScope.TabNavigationItem(tab: Tab) {
        val tabNavigator: TabNavigator = LocalTabNavigator.current

        NavigationBarItem(
            selected = tabNavigator.current == tab,
            onClick = { tabNavigator.current = tab },
            icon = {
                tab.options.icon?.let { icon ->
                    Icon(
                        painter = icon,
                        contentDescription =
                        tab.options.title
                    )
                }
            },
            label = {
                Text(
                    text = tab.options.title
                )
            },
            colors = NavigationBarItemColors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                selectedIndicatorColor = Color.Transparent,
                selectedTextColor = MaterialTheme.colorScheme.primary,
                unselectedIconColor = MaterialTheme.colorScheme.secondary.copy(alpha = 0.5f),
                unselectedTextColor = MaterialTheme.colorScheme.secondary.copy(alpha = 0.5f),
                disabledIconColor = Color.Transparent,
                disabledTextColor = Color.Transparent
            )
        )
    }
}