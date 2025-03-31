## https://app.diagrams.net/
## to create er diagram

# Smart Contact Manager

## 📌 Project Description

Smart Contact Manager is a **Spring Boot & Thymeleaf** web application that allows users to manage their contact details efficiently. Users can create, update, delete, and view their contacts securely. The project follows a **user-based authentication system**, ensuring each user has access only to their own contacts.

## 🛠️ Tech Stack

- **Backend:** Spring Boot, Spring MVC, Spring Data JPA, Hibernate
- **Frontend:** Thymeleaf, Bootstrap, HTML, CSS
- **Database:** MySQL
- **Security:** Spring Security (for authentication & authorization)

---

## 📂 Project Structure

```
Smart_Contact_Manager/
│── src/
│   ├── main/
│   │   ├── java/com/example/contactmanager/
│   │   │   ├── controllers/
│   │   │   ├── entities/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   ├── resources/
│   │   │   ├── static/
│   │   │   ├── templates/
│   │   │   │   ├── home.html
│   │   │   │   ├── login.html
│   │   │   │   ├── dashboard.html
│   │   │   ├── application.properties
│── pom.xml
│── README.md
```

---

## 📖 Features

- **User Authentication:** Secure login and signup using Spring Security.
- **Contact Management:** Create, edit, view, and delete contacts.
- **User Dashboard:** Personalized dashboard with user-specific contacts.
- **Search Contacts:** Find saved contacts easily using search functionality.
- **Responsive UI:** Mobile-friendly design with Bootstrap.
- **Profile Photo Upload:** Users can upload profile pictures.

---

## 🗃️ Database Schema

### **User Entity**

| Field      | Type    | Description               |
| ---------- | ------- | ------------------------- |
| `id`       | Long    | Primary Key               |
| `name`     | String  | User Full Name            |
| `email`    | String  | Unique Email ID           |
| `password` | String  | Encrypted Password        |
| `enabled`  | Boolean | Account Activation Status |
| `photo`    | String  | Profile Photo Path        |
| `role`     | String  | Role (USER/ADMIN)         |
| `desc`     | String  | User Bio Description      |

### **Contact Entity**

| Field      | Type   | Description              |
| ---------- | ------ | ------------------------ |
| `c_id`     | Long   | Primary Key              |
| `name`     | String | Contact Full Name        |
| `photo`    | String | Contact Photo Path       |
| `nickname` | String | Nickname of Contact      |
| `work`     | String | Work/Company Name        |
| `desc`     | String | Additional Description   |
| `phone`    | String | Phone Number             |
| `user`     | User   | Foreign Key (User Owner) |

---

## 🚀 Installation & Setup

### **1. Clone the Repository**

```sh
git clone https://github.com/your-username/Smart_Contact_Manager.git
cd Smart_Contact_Manager
```

### **2. Configure Database**

Modify `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/contact_manager
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

### **3. Build & Run the Project**

```sh
mvn clean install
mvn spring-boot:run
```

### **4. Access the Application**

Open [http://localhost:8080](http://localhost:8080) in your browser.

---

## 📸 Screenshots

(Include relevant UI screenshots here)
![image](https://github.com/user-attachments/assets/d531c9fc-3eb6-435c-9c43-5f32b7eaf0f5)
![image](https://github.com/user-attachments/assets/c2100918-cdfe-474d-930a-77586fc185cc)



 ## E-R diaram
![erdiagram](https://github.com/user-attachments/assets/5dbd4fa8-d4c4-4378-a59b-c44a3fecc6d8)

## 🤝 Contributing

Feel free to submit issues or pull requests. Contributions are always welcome!

---

## 📜 License

This project is licensed under the 

" Smart_Contact_1.0.1
