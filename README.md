# Tugas_PAPB

This Repositories is created for PAPB Final Project, The programming language used in this project is 100% Kotlin Native
Reason for using Kotlin rather than Java is that Kotlin offers more usability and generally shorter and easier to understand

The project created is an imaginary Gas Station Membership Application for SPBU Vivo. 

When Developing the Backend of this project, We initially intended to implement database and authentication. However, due to several errors when attempting to implement firebase real-time database,
we opted to just use the firebase authentication. The authentication works perfectly, both login and signup, and even checked if user has logged in before. To counter the need of database to store
all the data, we make use of intent to send data between activities. However, once user has closed the application, the intent is no longer in the system so some text may appear different.
