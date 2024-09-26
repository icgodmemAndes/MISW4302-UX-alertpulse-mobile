# MISW4302-UX-alertpulse-mobile

# AlertPulse_Movil_UX
Repositorio para la entrega final del Proyecto MISW-4302-2024 Version Movil

## Integrantes:

|   Nombre                         |   Correo                      |
|----------------------------------|-------------------------------|
| Jhon Edinson Muñoz | je.munozr1@uniandes.edu.co    |
| Juan Carlos Torres  | jc.torresm1@uniandes.edu.co    |


## Tabla de contenido
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Diferencias con MockUps](#diferencias-con-mockups)
- [Pasos para hacer Build](#pasos-para-hacer-build)
- [Pasos para Generar APK](#pasos-para-generar-apk)
- [Pasos para Ejecutar en Dispositvo Fisico de Pruebas](#pasos-para-ejecutar-en-dispositivo-fisico-de-pruebas)
- [Pasos para Ejecutar en Dispositivo Emulado de Pruebas](#pasos-para-ejecutar-en-dispositivo-emulado-de-pruebas)



### Estructura del Proyecto
![image](https://github.com/user-attachments/assets/b15599ae-1549-4ece-999a-d14f63adf544)


### Diferencias con MockUps

| Diferencia  | Imagen del Mockup | Imagen del Maquetado | Justificacion del Cambio |
|-------------|-------------------|----------------------|--------------------------|
| Menu de navegación inferior |![image](https://github.com/user-attachments/assets/52d9c428-d39f-4e99-934e-8f792b93587d)| ![image](https://github.com/user-attachments/assets/beb88ab9-94a4-48cb-aba6-393114adda03) | Por componentes de material design, se tiene un tamaño reducido de los iconos inferiores de navegación, se usa color de contraste para diferencia el fondo, queda en negrita cada texto del menú y ligeramente sombreado al estar en una u otra pantalla. Por recomendación del tutor se adiciona texto a cada icono, el botón de crear recordatorio deja de ser menú y ahora es un icono plus en la parte inferior derecha|
| Lista de recordatorios |![image](https://github.com/user-attachments/assets/3b0207c4-01b6-4fe6-8b00-7fad32c942d8) |![image](https://github.com/user-attachments/assets/05ccd5c3-bcd5-4fe4-bd2f-d2f1487f08d7) | En el diseño original se tenia cada opción dibujada sobre el fondo. Por recomendación del tutor se adiciona fondo de contraste a cada opción |
| Pantalla de grabación | ![image](https://github.com/user-attachments/assets/ac38095b-d126-4206-95eb-eb2dc029c441) | ![image](https://github.com/user-attachments/assets/9e102dce-cd1e-4d99-9c0e-3eb6502c9e02) | Por recomendación del tutor, se adiciona botón de aceptar y cancelar una vez el usuario ha terminado alguna grabación de voz. |


### Pasos para hacer Build
1. En Android Studio con el proyecto abierto, hacer click en el boton del martillo, que aparecera en la parte superior derecha:
![image](https://github.com/user-attachments/assets/06efec96-dca6-42d4-89e9-e2dbe2e849d9)


2. Esperar una salida de la consola similar a la siguiente imagen:
![image](https://github.com/user-attachments/assets/40139f73-8e2f-4b1f-b145-734f9a7bee63)


### Pasos para Generar APK
1. En Android Studio con el proyecto abierto, hacer click en Build -> Build Bundle(s)/APK(s) -> Build APK(s)

2. Esperar hasta que Android Studio avise que termine la generacion y hacer click en "Locate":

3. Te dirigirá a la ubicacion donde se genero al APK:
"Ruta Local proyecto"\app\build\outputs\apk\debug

### Pasos para Ejecutar en Dispositivo Fisico de Pruebas
1. Conecte un dispositivo Android mediante cable USB

2. En Android Studio con el proyecto abierto y el dispositvo a usar conectado (con la opcion de desarrollador activada):

3. Hacer click en la flecha verde(icono play verde) del menu superior derecho:

4. Esperar a que en la terminal aparezca el siguiente mensaje:
install successfully finished en la barra inferior de Run.

### Pasos para Ejecutar en Dispositivo Emulado de Pruebas
#### Crear Dispositivo Virual
1. Ir al menu Tool seleccione la opción Device Manager del menu lateral derecho

2. Seleccione la Opción Virtual y luego dar click en el botón "Create Device"

3. Seleccione el Tipo de dispositivo, Modelo y tamaño de pantalla, luego dar click en Next.

4. Seleccione la imagen del sistema Operativo a usar en el dispositivo virtual y dar click en Next.

5. Seleccione la orientación del dispositivo y dar click en Finish.

6. En la pantalla se muestran los dispositivos virtuales creados.

7. En la Barra de herramientas seleccione el proyecto, seleccione el dispositivo a usar y dar click en el boton compilar.


8. Iniciara el despliegue de la aplicación en el dispositivo seleccionado y estara listo para la prueba.
