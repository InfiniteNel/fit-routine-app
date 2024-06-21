package domain.models

import core.utils.DaysOfWeek

data class TrainingRoutineModel (
    val dayOfWeek: DaysOfWeek,
    val trainingExercises: List<TrainingExerciseModel>
)