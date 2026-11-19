> 🧩 HomeCinema: fork enfocado en español. Consulta [SPANISH_FORK.md](SPANISH_FORK.md).

<div align="center">

  <img src="homecinema-icon.png" alt="HomeCinema" width="320" />

  <p>
    Una app de cine en casa libre y de código abierto para Windows, Android
    y escritorio. Español por defecto, sin filtrar contenido.
  </p>

  [Sitio web](https://nuvio.tv) · [Releases](https://github.com/Hernandezelite/HomeCinema-Desktop/releases/latest) · [Apoyar](https://nuvio.tv/support)

</div>

## ⚠️ Software alfa

Esta rama sigue en fase alfa y está pensada para pruebas. Puede haber cambios
rupturistas en cada versión; no la uses como app principal todavía.

## Descargar HomeCinema Desktop

Descarga la última compilación desde [GitHub Releases](https://github.com/Hernandezelite/HomeCinema-Desktop/releases/latest).

- Windows: instalador MSI
- Android: APK
- macOS / Linux: consulta los releases del proyecto original si necesitas esos destinos

## Compilar desde el código

```bash
git clone https://github.com/Hernandezelite/HomeCinema-Desktop.git
cd HomeCinema-Desktop
```

### Ejecutar la app

```bash
./gradlew :composeApp:run
```

En Windows PowerShell:

```powershell
.\gradlew.bat :composeApp:run
```

### Empaquetar la app

Paquete de escritorio para el sistema actual:

```bash
./gradlew :composeApp:createDistributable
```

En Windows también puedes generar el MSI:

```powershell
.\gradlew.bat :composeApp:packageReleaseMsi --rerun-tasks
```

La app compartida está construida con Kotlin Multiplatform y Compose Multiplatform.

## Licencia

[GNU General Public License v3.0](./LICENSE)
