# Room Database Relationships

---

# 📦 Room Database Relationships in Android

This repository demonstrates how to implement **Room Database relationships** in Android applications with a full real-world example.
It covers:

* 🔗 **One-to-One**
* 🔗 **One-to-Many**
* 🔗 **Many-to-Many**

The project also integrates with a **real API endpoint** using **Retrofit**, parses responses with **DTOs (Data Transfer Objects)**, and saves the data into the local Room database.
Built with **Hilt (Dependency Injection)** for clean architecture and testability.

---

## ✨ Features

* ✅ Room Database with entity relationships (1:1, 1\:N, N\:M)
* ✅ Retrofit for API calls
* ✅ DTOs for parsing and mapping API responses
* ✅ Repository pattern for data flow management
* ✅ Hilt for dependency injection
* ✅ Clean architecture principles
* ✅ Example use cases for real-world scenarios

---

## 🛠️ Tech Stack

* **Kotlin**
* **Room (Persistence Library)**
* **Retrofit (Networking)**
* **Hilt (Dependency Injection)**
* **Coroutines & Flow (Asynchronous programming)**
* **MVVM Architecture**

---

## 🏗️ Architecture

This project follows **Clean Architecture + MVVM**, organized into layers:

```
data/
 ├─ dto/         # Data Transfer Objects from API
 ├─ entities/    # Room database entities
 ├─ dao/         # Data Access Objects (Room queries)
 ├─ repository/  # Repository pattern implementation
 └─ mapper/      # DTO ↔ Entity mappers

di/              # Hilt modules for dependency injection

ui/              # ViewModels and UI (Jetpack Compose / XML)

```

---

## ⚡ Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/room-relationships-demo.git
   cd room-relationships-demo
   ```
2. Open in **Android Studio**
3. Sync Gradle dependencies
4. Run on emulator/device

---

## 📊 Example Relationships

### 🔹 One-to-One

* A **User** has one **Profile**

### 🔹 One-to-Many

* A **Category** has many **Products**

### 🔹 Many-to-Many

* A **Student** can enroll in many **Courses**
* A **Course** can have many **Students**

---

## 📸 Screenshots

(Add app screenshots here)

---

## 🚀 Future Improvements

* Add unit tests with JUnit & Mockito
* Implement paging with **Paging 3**
* Add offline-first caching strategies

---

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!
Feel free to open a PR 🙌

---

## 📜 License

This project is licensed under the **MIT License** – see the [LICENSE](LICENSE) file for details.

---

Do you want me to also **add sample code snippets** (like a `UserEntity`, `UserDao`, `DTO → Entity mapper`, and a Retrofit interface) inside the README so devs instantly understand how it works?
