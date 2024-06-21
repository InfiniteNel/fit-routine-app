package core.utils

enum class DaysOfWeek {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
    
    fun getValue(): String {
        return when (this) {
            MONDAY -> "Lunes"
            TUESDAY -> "Martes"
            WEDNESDAY -> "Miercoles"
            THURSDAY -> "Jueves"
            FRIDAY -> "Viernes"
            SATURDAY -> "Sabado"
            SUNDAY -> "Domingo"
        }
    }
}