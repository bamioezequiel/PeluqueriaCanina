# 🐶 Peluquería Canina - CRUD en Java con JPA y MySQL

## 📌 Descripción
Peluquería Canina es una aplicación de escritorio desarrollada en Java que permite gestionar los datos de las mascotas y sus dueños en una peluquería canina. Utiliza el patrón Modelo-Vista-Controlador (MVC) y la persistencia de datos mediante JPA y MySQL.

## 🚀 Características
- CRUD completo para gestionar clientes y sus mascotas.
- Base de datos en MySQL con JPA para la persistencia de datos.
- Interfaz gráfica amigable para la gestión de registros.
- Implementación del patrón MVC para una estructura modular y escalable.

## 🛠️ Tecnologías utilizadas
- **Lenguaje**: Java
- **Base de Datos**: MySQL
- **Persistencia**: JPA
- **Arquitectura**: Modelo-Vista-Controlador (MVC)
- **IDE recomendado**: NetBeans / IntelliJ IDEA / Eclipse

## 📂 Estructura del Proyecto
```
📂 PeluqueriaCanina
 ├── 📁 com.mycompany.peluqueriacanina
 │   ├── PeluqueriaCanina.java
 │   ├── 📂 igu
 │   │   ├── LoadData.java
 │   │   ├── Main.java
 │   │   ├── ModifyData.java
 │   │   ├── ViewData.java
 │   ├── 📂 logica
 │   │   ├── Controller.java
 │   │   ├── Owner.java
 │   │   ├── Pet.java
 │   ├── 📂 persistencia
 │   │   ├── ControllerPersistence.java
 │   │   ├── OwnerJpaController.java
 │   │   ├── PetJpaController.java
 │   ├── 📂 persistencia.exceptions
 ├── persistence.xml
 ├── README.md
```

## 📦 Instalación y Configuración
1. Clona el repositorio:
   ```sh
   git clone https://github.com/bamioezequiel/PeluqueriaCanina.git
   ```
2. Importa el proyecto en tu IDE.
3. Configura la conexión a la base de datos en `persistence.xml`:
   ```xml
   <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/project_pet?serverTimezone=UTC"/>
   <property name="javax.persistence.jdbc.user" value="root"/>
   <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
   <property name="javax.persistence.jdbc.password" value=""/>
   <property name="javax.persistence.schema-generation.database.action" value="create"/>
   ```
4. Ejecuta los scripts SQL para crear la base de datos.
5. Ejecuta la aplicación desde la clase principal.

## 🖼️ Capturas de Pantalla
![Peluquería Canina](https://imgur.com/SiKiKRu.png)
![Peluquería Canina](https://imgur.com/jm0zpWr.png)
![Peluquería Canina](https://imgur.com/0Wfy2ec.png)
![Peluquería Canina](https://imgur.com/zLa1ebn.png)

## 📄 Enlaces Relacionados
- 🔗 [Repositorio en GitHub](https://github.com/bamioezequiel/PeluqueriaCanina)

## 📝 Autor
- **Ezequiel Bamio** - [GitHub](https://github.com/bamioezequiel)

## 📄 Licencia
Este proyecto está bajo la licencia MIT - consulta el archivo [LICENSE](LICENSE) para más detalles.

---

¡Si te gusta este proyecto, no olvides dejar una ⭐ en GitHub! 😊

