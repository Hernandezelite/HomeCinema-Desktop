# HomeCinema Desktop (fork de Nuvio)

Fork de Nuvio enfocado en español para Windows, Android y escritorio. Mantiene
**compatibilidad total con los addons y plugins de la comunidad**: no se ha
cambiado ningún manifest, contrato ni formato de datos. El español es una
preferencia por defecto y un orden estable, nunca un filtro. Todo el contenido
sigue disponible y se puede cambiar el idioma cuando quieras.

## Cambios aplicados

| Ámbito | Comportamiento por defecto |
| --- | --- |
| Nombre e icono | HomeCinema, con una H sobre una cinta de vídeo en Android, Windows y GitHub. |
| Interfaz | Español (`values-es`) como idioma inicial y como fallback. Se cambia en Ajustes → Apariencia → Idioma. |
| Audio | Español (`es`) como idioma preferido. Se cambia en Ajustes → Reproducción. |
| Subtítulos | Español (`es`) como idioma preferido. Se cambia en Ajustes → Reproducción. |
| Catálogos / búsqueda | Los resultados en español aparecen primero, sin eliminar los demás. |
| Streams de addons/plugins | Los streams en español aparecen primero dentro de cada grupo. |
| Scrapers de plugins | Los scrapers que declaran `contentLanguage` en español se prueban primero. |
| Actualizador | Apunta a `Hernandezelite/HomeCinema-Desktop` para no instalar la versión original. |

## Archivos principales

- `features/player/SpanishLanguagePriority.kt`: lógica de prioridad estable, sin tocar APIs de addons.
- `features/player/PlayerLanguagePreferences.kt` y `PlayerSettingsRepository.kt`: idiomas preferidos.
- `features/settings/AppLanguage.kt`, `ThemeSettingsRepository.kt`, `ThemeSettingsStorage.*.kt`: idioma de UI.
- `features/home/HomeCatalogParser.kt`: prioridad en catálogos y búsqueda.
- `features/streams/StreamFetchSupport.kt`: prioridad en streams.
- `fullCommonMain/.../PluginRepository.kt`: prioridad en scrapers.
- `features/updater/*`: repositorio de actualizaciones del fork.
- `composeApp/build.gradle.kts`: nombre de paquete, proveedor y grupo de menú de Windows.

El `applicationId` (`com.nuvio.app`) se mantiene igual a propósito para no romper
addons ni contratos de la comunidad.

El nombre interno de Gradle (`rootProject.name = "Nuvio"`) y el paquete de
recursos Compose (`nuvio.composeapp.generated.resources`) también se conservan:
son identificadores de compilación, no el nombre visible de la app. Cambiarlos
rompería los imports de recursos de todo el proyecto.

## Compilación

Requiere JDK 17+ y Android SDK para los destinos Android.

```bash
# Android (APK)
./gradlew :androidApp:assembleDebug -Pnuvio.android.distribution=full

# Distribución de escritorio para el sistema actual
./gradlew :composeApp:createDistributable
```

En Windows PowerShell:

```powershell
.\gradlew.bat :composeApp:createDistributable
.\gradlew.bat :composeApp:packageReleaseMsi --rerun-tasks
```

## Repositorios

- Móvil: https://github.com/Hernandezelite/HomeCinema
- Escritorio / Android / Windows: https://github.com/Hernandezelite/HomeCinema-Desktop
