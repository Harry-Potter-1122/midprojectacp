# ⚡ Electricity Tracker

A simple **Java console-based application** built in **IntelliJ IDEA** to manage and track electricity usage at home.  
This project demonstrates **object-oriented programming (OOP)** concepts, class design, and file-based data persistence.

---

## 🧩 Features

✅ Manage multiple **Homes**  
✅ Add, edit, or remove **Devices** within each home  
✅ Track electricity consumption and monthly bill estimates  
✅ Change electricity **rate settings** dynamically  
✅ Data is **saved to a file** (`data.txt`) so nothing is lost when restarting the app  

---

## 🏗️ Project Structure

ElectricityTracker/
└── src/
├── MainApp.java # Entry point – main() method, program flow control
├── Home.java # Home class: contains list of devices and billing logic
├── Device.java # Device class: represents an electrical appliance
└── Screen.java # Handles all UI logic (home, device, and settings screens)

yaml
Copy code

---

## ⚙️ How to Run (in IntelliJ IDEA)

1. Open **IntelliJ IDEA** → click **New Project → Java**  
2. Copy the `src` folder into your project  
3. Open `MainApp.java`  
4. Run the program:  
   - Press **Shift + F10**, or  
   - Click the **green ▶ button** next to `public static void main(String[] args)`  

The app will start in your console and automatically create a `data.txt` file to store all home/device information.

---

## 💾 Data Persistence

- All homes, devices, and settings are saved in **`data.txt`** (in the project root directory).  
- The file is reloaded each time the program starts.  
- Example structure:
Home: MyHouse
Device: Fan, 75W, 6h/day
Device: AC, 1500W, 3h/day
Rate: 20 PKR/kWh

yaml
Copy code

---

## 🧠 Concepts Demonstrated

- Object-Oriented Programming (OOP)
- Classes, objects, and encapsulation  
- File handling (`BufferedReader`, `BufferedWriter`)  
- Exception handling  
- Data persistence  
- Console-based menu-driven UI  

---

## 📘 Example Output

============================
ELECTRICITY TRACKER
Manage Homes

Manage Devices

Settings

Exit
Choose an option: 1

yaml
Copy code

---

## 👨‍💻 Developed With

- **Language:** Java  
- **IDE:** IntelliJ IDEA  
- **Version Control:** Git & GitHub  

---
