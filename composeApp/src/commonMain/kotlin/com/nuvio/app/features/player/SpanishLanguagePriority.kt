package com.nuvio.app.features.player

/**
 * Fork Nuvio Español: da prioridad al contenido en español sin filtrar el resto.
 *
 * No toca los contratos de addons ni de plugins de la comunidad: solo reordena
 * resultados (catálogos, streams y scrapers) de forma estable.
 */
object SpanishLanguagePriority {
    private val spanishWords = listOf("spanish", "espanol", "español", "castellano")

    fun isSpanish(value: String?): Boolean {
        if (value.isNullOrBlank()) return false
        when (normalizeLanguageCode(value)) {
            "es", "es-419" -> return true
        }
        val text = value.lowercase().replace('_', '-')
        if (spanishWords.any { text.contains(it) }) return true
        return text
            .replace(Regex("\\s+"), " ")
            .split(' ')
            .any { token ->
                token == "es" || token == "spa" ||
                    token == "es-419" || token == "es-la" || token == "es-lat"
            }
    }

    fun isSpanishAny(vararg values: String?): Boolean = values.any(::isSpanish)

    /** Orden estable: los elementos en español primero, el resto conserva su orden. */
    fun <T> prioritize(items: List<T>, languageOf: (T) -> String?): List<T> =
        items.sortedWith(compareByDescending<T> { item ->
            if (isSpanish(languageOf(item))) 1 else 0
        })
}