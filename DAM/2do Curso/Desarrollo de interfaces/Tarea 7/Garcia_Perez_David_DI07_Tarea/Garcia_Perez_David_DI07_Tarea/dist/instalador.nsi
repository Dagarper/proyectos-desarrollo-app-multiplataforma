; -------------------------------
; Configuración básica
; -------------------------------
!include "MUI2.nsh"

; Constantes configurables
!define APP_NAME "Buscador de texto"
!define APP_VERSION "1.0"
!define JAR_FILE "Garcia_Perez_David_DI07_Tarea.jar"
!define INSTALL_DIR "$PROGRAMFILES\${APP_NAME}"

; Configuración general
Name "${APP_NAME} ${APP_VERSION}"
OutFile "MiAplicacion_Setup.exe"
InstallDir "${INSTALL_DIR}"
InstallDirRegKey HKCU "Software\${APP_NAME}" ""
RequestExecutionLevel admin

; -------------------------------
; Interfaz Modern UI
; -------------------------------
!insertmacro MUI_PAGE_DIRECTORY
!insertmacro MUI_PAGE_INSTFILES
!insertmacro MUI_UNPAGE_CONFIRM
!insertmacro MUI_UNPAGE_INSTFILES
!insertmacro MUI_LANGUAGE "Spanish"

; -------------------------------
; SECCIÓN DE INSTALACIÓN
; -------------------------------

Section "Instalar"
    ; Copiar archivos
    SetOutPath "$INSTDIR"
    File "Garcia_Perez_David_DI07_Tarea.jar"
    File "README.TXT"
    
    ; Accesos directos
    CreateShortCut "$DESKTOP\${APP_NAME}.lnk" "javaw.exe" "-jar $\"$INSTDIR\Garcia_Perez_David_DI07_Tarea.jar$\"" "$INSTDIR\Garcia_Perez_David_DI07_Tarea.jar" 0
    CreateShortCut "$SMPROGRAMS\${APP_NAME}.lnk" "javaw.exe" "-jar $\"$INSTDIR\Garcia_Perez_David_DI07_Tarea.jar$\"" "$INSTDIR\Garcia_Perez_David_DI07_Tarea.jar" 0
    
    ; Crear desinstalador
    WriteUninstaller "$INSTDIR\Uninstall.exe"
SectionEnd

; -------------------------------
; SECCIÓN DE DESINSTALACIÓN 
; -------------------------------
Section "Uninstall"
    ; Eliminar archivos
    Delete "$INSTDIR\Garcia_Perez_David_DI07_Tarea.jar"
    Delete "$INSTDIR\README.TXT"
    Delete "$INSTDIR\Uninstall.exe"
    
    ; Eliminar accesos directos
    Delete "$DESKTOP\${APP_NAME}.lnk"
    Delete "$SMPROGRAMS\${APP_NAME}.lnk"
    
    ; Eliminar carpeta
    RMDir "$INSTDIR"
SectionEnd