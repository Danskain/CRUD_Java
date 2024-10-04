primero asegurarse que esta instalado el JDK de java 23 ya que el proyecto esta construido en esa version de java

si queire trabajar en local cambiar las variables de entrno en el archivo aplication.properties

# Conexion a mysql en local
#spring.datasource.url=jdbc:mysql://localhost:3306/pruebas_db?createDatabaseIfNotExist=true
#spring.datasource.username=root
#spring.datasource.password=

la conecion a la base de datos en la nube esta por defecto configurada

spring.datasource.url=jdbc:mysql://junction.proxy.rlwy.net:20421/railway?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=nYDiyNuErMQURcWpqSQMvvffqgtpzcBt
