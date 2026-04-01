# 🪣 Deposito — Simulación de Depósito con Hilos

Proyecto Java que simula el llenado y vaciado de un depósito de agua usando **multithreading** (dos hilos concurrentes sincronizados).

---

## 📋 Descripción

El programa crea un depósito con capacidad de **1000 litros** y lanza dos hilos en paralelo:

- 💧 **HiloLlenado** — llena el depósito continuamente
- 🔄 **HiloVaciado** — vacía el depósito cuando se activa

Los hilos se comunican y sincronizan usando `synchronized`, `wait()` y `notifyAll()`, evitando condiciones de carrera.

---

## ⚙️ Lógica de estados

| Nivel de agua | Evento |
|---------------|--------|
| Llega a **900 L** | Se activa el vaciado a 5 L/s |
| Llega a **1000 L** | Se para el llenado, vaciado sube a 10 L/s |
| Baja a **100 L** | Se reactiva el llenado a 5 L/s |
| Llega a **0 L** | Se para el vaciado, llenado vuelve a 10 L/s |

---

## 🗂️ Estructura del proyecto
```
src/main/java/
├── Deposito.java       # Lógica del depósito (synchronized, wait/notifyAll)
├── HiloLlenado.java    # Hilo que llama a deposito.llenar()
├── HiloVaciado.java    # Hilo que llama a deposito.vaciar()
└── Main.java           # Punto de entrada — lanza los dos hilos
```

---

## 🧵 Conceptos aplicados

- **Multithreading** — dos hilos corriendo en paralelo
- **Sincronización** — método `synchronized` para acceso exclusivo
- **Comunicación entre hilos** — `wait()` y `notifyAll()`

---

## 🛠️ Tecnologías

![Java](https://img.shields.io/badge/Java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)

---

## 👩‍💻 Autora

**Nataliia Sokhatska** — [@SoNataLiia](https://github.com/SoNataLiia)
