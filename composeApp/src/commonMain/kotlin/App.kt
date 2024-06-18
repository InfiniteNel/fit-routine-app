import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.screen.BottomBarScreen
import ui.theme.AppTypography
import ui.theme.darkScheme
import ui.theme.lightScheme

@Composable
@Preview
fun App(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true
) {
    val colorScheme by mutableStateOf(
        if (darkTheme) darkScheme else lightScheme
    )

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography
    ) {
        Navigator(screen = BottomBarScreen()) { navigator ->
            SlideTransition(navigator)
        }
    }
}