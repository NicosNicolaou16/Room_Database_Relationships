# Room Database Relationships

[![Linktree](https://img.shields.io/badge/linktree-1de9b6?style=for-the-badge&logo=linktree&logoColor=white)](https://linktr.ee/nicos_nicolaou)
[![Static Badge](https://img.shields.io/badge/Site-blue?style=for-the-badge&label=Web)](https://nicosnicolaou16.github.io/)
[![X](https://img.shields.io/badge/X-%23000000.svg?style=for-the-badge&logo=X&logoColor=white)](https://twitter.com/nicolaou_nicos)
[![LinkedIn](https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin&logoColor=white)](https://linkedin.com/in/nicos-nicolaou-a16720aa)
[![Medium](https://img.shields.io/badge/Medium-12100E?style=for-the-badge&logo=medium&logoColor=white)](https://medium.com/@nicosnicolaou)
[![Mastodon](https://img.shields.io/badge/-MASTODON-%232B90D9?style=for-the-badge&logo=mastodon&logoColor=white)](https://androiddev.social/@nicolaou_nicos)
[![Bluesky](https://img.shields.io/badge/Bluesky-0285FF?style=for-the-badge&logo=Bluesky&logoColor=white)](https://bsky.app/profile/nicolaounicos.bsky.social)
[![Dev.to blog](https://img.shields.io/badge/dev.to-0A0A0A?style=for-the-badge&logo=dev.to&logoColor=white)](https://dev.to/nicosnicolaou16)
[![YouTube](https://img.shields.io/badge/YouTube-%23FF0000.svg?style=for-the-badge&logo=YouTube&logoColor=white)](https://www.youtube.com/@nicosnicolaou16)
[![Static Badge](https://img.shields.io/badge/Developer_Profile-blue?style=for-the-badge&label=Google)](https://g.dev/nicolaou_nicos)

---

# 📦 Room Database Relationships in Android

This repository demonstrates how to implement **Room Database relationships** in Android
applications with a full real-world example.
It covers:

* 🔗 **One-to-One**
* 🔗 **One-to-Many**
* 🔗 **Many-to-Many**

The project also integrates with a **real API endpoint** using **Retrofit**, parses responses with *
*DTOs (Data Transfer Objects)**, and saves the data into the local Room database.
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
 ├─ entities/dto/         # Data Transfer Objects from API
 ├─ entities/rockets      # Room database entities
 ├─ entities/dao/         # Data Access Objects (Room queries)
 ├─ domain/repository/    # Repository pattern implementation
 
di/                       # Hilt modules for dependency injection

ui/                       # ViewModels and UI (Jetpack Compose / XML)

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

* A **Rockets** has one **Height**

### 🔹 One-to-Many

* A **Rockets** has many **PayloadWeights**

### 🔹 Many-to-Many

* A **Rockets** can enroll in many **PayloadWeights**
* A **PayloadWeights** can have many **Rockets**

---

# Versioning

Target SDK version: 36 <br />
Minimum SDK version: 29 <br />
Kotlin version: 2.2.10 <br />
Gradle version: 8.12.2 <br />

---

## 📜 License

This project is licensed under the **MIT License** – see the [LICENSE](LICENSE) file for details.

---

Do you want me to also **add sample code snippets** (like a `RocketsEntity`, `RocketsDao`,
`DTO → Entity`, and a Retrofit interface) inside the README so devs instantly understand how it
works?

# Feeds/Urls/End point (References)

https://github.com/r-spacex/SpaceX-API (GitHub) <br />
https://docs.spacexdata.com/?version=latest (Postman) <br />
