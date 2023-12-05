package com.sergimarrahy.sergilist.Model

data class WowCharacter (
    val characterClass: String = "",
    val specialization: String = "",
    var favorite: Boolean = false
) {
    companion object {
        fun getData() : List<WowCharacter> {
            return listOf(
                WowCharacter("Guerrero", "Armas", false),
                WowCharacter("Guerrero", "Furia", false),
                WowCharacter("Guerrero", "Protección", false),
                WowCharacter("Paladín", "Sagrado", false),
                WowCharacter("Paladín", "Protección", false),
                WowCharacter("Paladín", "Reprensión", false),
                WowCharacter("Cazador", "Bestias", false),
                WowCharacter("Cazador", "Puntería", false),
                WowCharacter("Cazador", "Supervivencia", false),
                WowCharacter("Pícaro", "Asesinato", false),
                WowCharacter("Pícaro", "Forajido", false),
                WowCharacter("Pícaro", "Sutileza", false),
                WowCharacter("Sacerdote", "Disciplina", false),
                WowCharacter("Sacerdote", "Sagrado", false),
                WowCharacter("Sacerdote", "Sombras", false),
                WowCharacter("Caballero de la Muerte", "Sangre", false),
                WowCharacter("Caballero de la Muerte", "Escarcha", false),
                WowCharacter("Caballero de la Muerte", "Profano", false),
                WowCharacter("Chamán", "Elemental", false),
                WowCharacter("Chamán", "Mejora", false),
                WowCharacter("Chamán", "Restauración", false),
                WowCharacter("Mago", "Arcano", false),
                WowCharacter("Mago", "Fuego", false),
                WowCharacter("Mago", "Escarcha", false),
                WowCharacter("Brujo", "Aflicción", false),
                WowCharacter("Brujo", "Demonología", false),
                WowCharacter("Brujo", "Destrucción", false),
                WowCharacter("Monje", "Brewmaster", false),
                WowCharacter("Monje", "Windwalker", false),
                WowCharacter("Monje", "Mistweaver", false),
                WowCharacter("Cazador de demonios", "Devastación", false),
                WowCharacter("Cazador de demonios", "Venganza", false)
            )
        }
    }
}