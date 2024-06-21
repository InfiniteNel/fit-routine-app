package ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import domain.models.TrainingRoutineModel

@Composable
fun RoutineListItem (
    routine: TrainingRoutineModel,
    onSelectItem: (TrainingRoutineModel) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                MaterialTheme.colorScheme.secondaryContainer,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(8.dp)
            .clickable {
                onSelectItem(routine)
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = routine.dayOfWeek.getValue(),
            modifier = Modifier.fillMaxWidth().weight(1f),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            textAlign = TextAlign.Center
        )
        
        Text(
            text = "Ejercicios: ${routine.trainingExercises.size}",
            modifier = Modifier.padding(end = 8.dp),
             style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            textAlign = TextAlign.Start
        )
    }
}