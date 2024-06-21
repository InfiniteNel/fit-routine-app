package domain.models

data class TrainingExerciseModel (
    val id: Long,
    val order: Int,
    val name: String,
    val description: String?,
    val series: Int,
    val repeats: Int,
    val position: String,
    val currentWeight: Float
)