# CourierModule

**Note: In this project I have been used **MAVEN**, **Spring 5** , **Angular JS**, **Jooq** (Object Oriented Querying) and **HikariCP** connection pool.

To Run This program you will need to download **H2 Database Engine** on your macheine and **yarn** tool

### **H2 Database Engine**

- If you did't alredy have **H2** installed, [download H2 from www.h2database.com](https://www.h2database.com/html/main.html).
- After Install the H2 tool, In windows search bar type h2 console the click it, It will open new tab in your default browser.
- Create new folder with name **database** inside **D:/ Driver** because we will create DB Schema inside it in the next step.
- In **Saved Settings:** Choose *Generic H2 (Server), Set **JDBC URL:** (jdbc:h2:file:D:/database/Courier) becaus I used it in my **boom.xml** configuration and in **src\main\resources\application.properties**.
- Leave **User Name:** as it is with **sa** value. 
- Click connect Button it will open another page to write your queries
