package ui.screen.weeklyroutine

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.VectorPainter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import core.utils.DaysOfWeek
import domain.models.TrainingRoutineModel
import ui.components.RoutineListItem

object WeeklyRoutineScreen: Tab {
    
    private val itemsTraining = listOf(
        TrainingRoutineModel(DaysOfWeek.MONDAY, emptyList()),
        TrainingRoutineModel( DaysOfWeek.TUESDAY, emptyList()),
        TrainingRoutineModel(DaysOfWeek.WEDNESDAY, emptyList()),
        TrainingRoutineModel(DaysOfWeek.THURSDAY, emptyList()),
        TrainingRoutineModel(DaysOfWeek.FRIDAY, emptyList()),
        TrainingRoutineModel(DaysOfWeek.SATURDAY, emptyList()),
        TrainingRoutineModel(DaysOfWeek.SUNDAY, emptyList()),
    )

    private const val TITLE_SCREEN = "Rutina Semanal"

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = TITLE_SCREEN,
                            style = MaterialTheme.typography.headlineMedium
                        )
                            },
                    colors = TopAppBarColors(
                        MaterialTheme.colorScheme.secondaryContainer,
                        MaterialTheme.colorScheme.secondaryContainer,
                        MaterialTheme.colorScheme.secondaryContainer,
                        MaterialTheme.colorScheme.onSecondaryContainer,
                        MaterialTheme.colorScheme.secondaryContainer
                    )
                )
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { /* FAB click */ },
                    modifier = Modifier.padding(4.dp)
                ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null)
                }
            },
            bottomBar = {
                BottomAppBar {  }
            },
            content = {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    if (itemsTraining.isEmpty()) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                            text = "¡Ups! Parece que no hay rutinas disponibles en este momento. No te preocupes, crea tu propia rutina personalizada pulsando en el botón \"+\". ¡Tú puedes hacerlo!"
                        )
                    } else {
                        LazyColumn(
                            modifier = Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            items(itemsTraining) { item ->
                                RoutineListItem(
                                    routine = item,
                                    onSelectItem = { /* Item click */ }
                                )
                            }
                        }
                    }
                }
            }
        )
    }

    override val options: TabOptions
        @Composable
        get(){
            val icon: VectorPainter = rememberVectorPainter(Icons.Default.DateRange)
            val title = TITLE_SCREEN
            val index: UShort = 0u
            
            return remember {
                TabOptions(
                    index, title, icon
                )
            }
        }
}