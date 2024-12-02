
# My Uni Society App

**My Uni Society** is a mobile application designed to help college societies manage their events, members, and activities. It allows admins to create and manage events, while students can join the society, register for the app, and stay updated on upcoming activities.

## Overview
My Uni Society uses **Jetpack Compose** for the user interface and **Firebase** for authentication and data storage along with **Firestore**.

## Features
- **User Registration & Login**: Users can register and log in with their email and password.
- **Event Management**: Admins can create and manage events, while students can view event details.
- **Snackbar Notifications**: Alerts are shown for success or error messages, such as successful event creation.
- **User InterfaceI**: Clean and responsive design using Jetpack Compose.
- **Firebase Integration**: Firebase Authentication for user login and Firestore for storing data.

## Technologies Used
- **Frontend**: 
  - Jetpack Compose (UI)
  - Kotlin
- **Backend**: 
  - Firebase (Authentication & Firestore)
- **Libraries**:
  - Material3 (UI components)
  - Kotlin Coroutines
  - Navigation Component 

##Firebase

[Firebase](https://firebase.google.com/) is a platform from Google. It gives you many tools to help build apps. Firebase works on Android, iOS, and web. It is built on Google Cloud. It makes it easy to store data and use different services for your app.

### Types of Firebase Authentication:
Firebase helps you sign in users on your app.

1. **FirebaseUI Authentication**
   - Ready-to-use UI to log users in with email/password, phone, or social logins (Google, Facebook, etc.).

2. **Firebase SDK Authentication**
   - **Email/Password**: Basic sign-in with email and password, with reset email support.
   - **Social logins**: Google, Facebook, Twitter, GitHub sign-in.
   - **Phone number**: Sends SMS for phone verification.
   - **Custom Authentication**: Use your own sign-in system.

### Steps to Set Up Firebase in Your Project

#### 1. Create Firebase Project
- Go to [Firebase Console](https://firebase.google.com/), click on **Go to Console**, then **Create Project**.
- Choose a name and turn off **Google Analytics**.

#### 2. Enable Firebase Authentication
- In Firebase Console, go to **Authentication** under **Build** and click **Get Started**.
- Turn on **Email/Password** sign-in method.

#### 3. Connect Your Android App to Firebase
- In Firebase, click **Project Settings**.
- Under **Your Apps**, click the **Android** logo to add your app.
- Register your app by entering the **Application ID** from your `build.gradle` file.
- Download `google-services.json` file and put it in the `app/` folder.

#### 4. Add Firebase Dependencies
-Firebase will provide dependencies to implement into your Project

### How to Open My App in Emulator or Device from Android Studio

1. **Clone the Repository**
   - Open **Git** on your computer.
   - In terminal or command prompt, type the command to clone:
     ```bash
     git clone https://github.com/K00288365/MyUniApp.git
     ```

3. **Install Android Studio**
   - If you don’t have **Android Studio**, download and install it from [Android Studio website](https://developer.android.com/studio).

4. **Open the Project in Android Studio**
   - Open **Android Studio**.
   - Select **Open an existing project** and open the folder where you cloned or downloaded the project.

6. **Run the App**
   - In Android Studio, click the **Run** button.
   - Choose your **device** or **emulator** from the list.
   - Android Studio will **install** and **open** the app on your device or emulator.
