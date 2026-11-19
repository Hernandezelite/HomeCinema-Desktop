# HomeCinema (HomeCinema-Desktop)

Fork de Nuvio enfocado en espaÃ±ol. Mantiene **compatibilidad total con los addons y
plugins de la comunidad** (no se ha cambiado ningÃºn manifest, contrato ni formato
de datos) y prioriza el espaÃ±ol.

## Cambios aplicados

| Ãmbito | Comportamiento por defecto |
| --- | --- |
| Nombre e icono | HomeCinema, con icono de una H sobre una cinta de vÃ­deo (Android, Windows y GitHub). |
| Interfaz | EspaÃ±ol (alues-es) como idioma inicial y como fallback. Se puede cambiar en Ajustes â†’ Apariencia â†’ Idioma. |
| Audio | EspaÃ±ol (es) como idioma preferido. Se puede cambiar en Ajustes â†’ ReproducciÃ³n. |
| SubtÃ­tulos | EspaÃ±ol (es) como idioma preferido. Se puede cambiar en Ajustes â†’ ReproducciÃ³n. |
| CatÃ¡logos / bÃºsqueda | Los resultados con idioma espaÃ±ol aparecen primero (orden estable, nada se filtra). |
| Streams de addons/plugins | Los streams en espaÃ±ol aparecen primero dentro de cada grupo. |
| Scrapers de plugins | Los scrapers que declaran contentLanguage en espaÃ±ol se prueban primero. |
| Actualizador | Apunta a Hernandezelite/HomeCinema-Desktop para que no te instale la versiÃ³n original. |

Archivos nuevos o modificados principales:

- eatures/player/SpanishLanguagePriority.kt (nuevo): lÃ³gica de prioridad, sin tocar APIs de addons.
- eatures/player/PlayerLanguagePreferences.kt y PlayerSettingsRepository.kt: idiomas preferidos.
- eatures/settings/AppLanguage.kt, ThemeSettingsRepository.kt, ThemeSettingsStorage.*.kt: idioma de UI.
- eatures/home/HomeCatalogParser.kt: prioridad en resultados de catÃ¡logo/bÃºsqueda.
- eatures/streams/StreamFetchSupport.kt: prioridad en streams.
- ullCommonMain/.../PluginRepository.kt: prioridad en scrapers.
- eatures/updater/*: repositorio de actualizaciones del fork.

## Antes de distribuir

1. Cambia el pplicationId (ndroidApp/build.gradle.kts) si quieres que conviva con la app oficial.
2. Firma los builds con tu propia clave.
3. Publica los releases en https://github.com/Hernandezelite/HomeCinema-Desktop/releases.

## CompilaciÃ³n

`ash
# Android (APK)
./gradlew :androidApp:assembleDebug

# Windows (MSI)
./gradlew packageMsix
`

Requiere JDK 17+ y Android SDK. El mÃ³dulo composeApp es comÃºn a todas las plataformas.

## Repositorio

- MÃ³vil: https://github.com/Hernandezelite/HomeCinema
- Escritorio / Android / Windows: https://github.com/Hernandezelite/HomeCinema-Desktop
