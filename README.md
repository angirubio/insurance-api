# API de Seguros - Spring Boot

Este proyecto implementa una API REST para gestionar pólizas de seguros utilizando **Spring Boot** y **Spring Data JPA**. La API permite realizar operaciones CRUD sobre las pólizas de seguros, así como realizar búsquedas y paginación de pólizas por nombre de cliente.

## Requerimientos

- **Java 17** o superior
- **Maven** o **Gradle** para gestionar las dependencias
- **H2 Database** en memoria (configurada para pruebas rápidas)
  
## Características

- Obtener todas las pólizas de seguros.
- Obtener una póliza de seguros por su ID.
- Crear una nueva póliza de seguros.
- Actualizar una póliza existente.
- Eliminar una póliza de seguros.
- Búsqueda de pólizas por nombre de cliente con paginación.

## Endpoints

### 1. Obtener todas las pólizas
- **Método:** `GET`
- **Ruta:** `/api/policies`
- **Descripción:** Obtiene todas las pólizas de seguros almacenadas.
- **Respuesta de ejemplo:**
  ```json
  [
    {
      "id": 1,
      "policyNumber": "POL12345",
      "customerName": "Juan Pérez",
      "startDate": "2023-01-01",
      "endDate": "2024-01-01",
      "premiumAmount": 1200.50
    },
    {
      "id": 2,
      "policyNumber": "POL12346",
      "customerName": "Ana García",
      "startDate": "2023-02-01",
      "endDate": "2024-02-01",
      "premiumAmount": 950.00
    }
  ]
