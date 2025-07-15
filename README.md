# 📦 LogiBot — Automated Freight Quoting Assistant (Java)

**LogiBot** is a desktop logistics assistant written in Java. It automates the process of logging into freight platforms, parsing route and contact information, calculating delivery prices based on distance, and sending professional quotes via email.

---

## ✅ Features (Implemented)

- 🔐 **Automated login** using Selenium WebDriver
- 📥 **Route and contact parsing** from logistics requests
- 📏 **Distance-based delivery pricing** using Google Maps API or OpenRouteService
- 📧 **HTML email generation and delivery** via JavaMail
- 🧾 **Email logging system** to prevent duplicate messages
- 🧼 **Auto-cleanup mechanism** based on log tracking

---

## 🔧 In Progress

- More robust error handling during parsing and sending
- Cleaning legacy GUI components (JavaFX) for a headless version
- Refactoring core logic to improve SOLID compliance

---

## 💡 Planned Features

- 🖥 GUI reimplementation (optional) for user-friendly controls
- 🌐 Multi-site parsing and quoting from different freight platforms
- ⚙️ Threaded execution for handling multiple quotes simultaneously
- 🐳 Docker support for deployment
- 🔁 Scheduler for automated batch processing

---

## 🛠 Tech Stack

- **Java 17**
- **Maven**
- **Selenium WebDriver**
- **JavaMail**
- **Google Maps API** / **OpenRouteService**
- **Jsoup**
- **HTML/CSS templates**
- **.env config**

---

## 🚀 How to Run

1. **Clone the repository:**

   ```bash
   git clone https://github.com/your-username/logibot.git
   cd logibot
   ```

2. **Create a `.env` file** in the project root with:

   ```
   EMAIL_USER=your-email@example.com
   EMAIL_PASS=your-email-password
   ```

3. **Build and run the project:**

   ```bash
   mvn clean install
   java -jar target/LogiBot.jar
   ```

---

## 📂 Project Structure

```
com.fedytion
├── calculator         # Distance & price calculation
├── parser             # Route and contact parsers
├── postman            # Email sender and HTML formatter
├── selenium           # Web login via Selenium
├── emaillog           # Email logging and cleanup
├── config             # Constants and .env loader
└── Main.java          # Entry point
```

---

## 📝 Author

Developed by **[Nataliia Fedyshyn](https://github.com/fedytion)**  
Passionate about Java, automation, and elegant backend design.

---

📫 **Open to feedback, ideas, and collaboration!**
