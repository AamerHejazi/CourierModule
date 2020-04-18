# CourierModule

**Note:** In this project I have been used **MAVEN**, **Spring 5** , **Angular JS**, **Jooq** (Object Oriented Querying) and **HikariCP** connection pool.

To Run This program you will need to download **H2 Database Engine** on your macheine and **yarn** tool

### **H2 Database Engine**

- If you did't alredy have **H2** installed, [download H2 from www.h2database.com](https://www.h2database.com/html/main.html).
- After Install the H2 tool, In windows search bar type h2 console the click it, It will open new tab in your default browser.
- Create new folder with name **database** inside **D:/ Driver** because we will create DB Schema inside it in the next step.
- In **Saved Settings:** Choose *Generic H2 (Server), Set **JDBC URL:** (jdbc:h2:file:D:/database/Courier) becaus I used it in my **boom.xml** configuration and in **src\main\resources\application.properties**.
- Leave **User Name:** as it is with **sa** value. 
- Click connect button it will open another page to write your queries
- Find queries for create tavles and data from link [download queries](https://drive.google.com/file/d/1ESn0BlwH8ilXIUh8LZ7CnuM-jGjWrJ6Z/view?usp=sharing).
- Copy all queries and paste it inside the H2 tool the click Run button.
- Now our database is ready.

### **Yarn package manager**
  
- To install yarn tool [Click here](https://yarnpkg.com/getting-started/install#global-install).
- In windows search bar type cmd then click enter, Then and type command:**npm install -g yarn** in your terminal, See the command in there website.
- Make sure it is installed using this command:**yarn --version**.
- Go to the path **/COURIER/src/main/webapp** inside project then run **yarn init** command to starting a new project.
- Add all dependencies and packages using **yarn add [package]** command or **yarn add [package]@[version]** command for specific version.
- Add the following packages:
  - **angular** version **1.7.2** using command **yarn add angular@1.7.2**
  - **@uirouter/angularjs** version **1.0.20** using command **yarn add @uirouter/angularjs@1.0.20**
  - **angular-material** version **1.1.10**
  - **angular-resource** version **1.7.5**
  - **angular-route** version **1.7.2**
  - **bootstrap** version **4.1.3**
  - **bootstrap-toggle** version **2.2.2**
  - **jquery** version **3.3.1**

### Jetty runing
I added jetty server inside bom.xml to run the web application, But we need a command to run this server, So we will configure it inside intellij idea IDE in below steps.
  - From IntelliJ, Clcik on **Run** button > Edit Configuration.
  - Click Add New Configuration (the plus sign).
  - Choose **Maven**.
  - Name it **Jetty run** (or whatever you like).
  - Choose the appropriate working directory it will be filled by default.
  - In Command line, enter **jetty:run**.
  - Click Apply and OK
  - Click the Runners menu then choose your Runner and click **run button**
 

### Finally 
-- Our project is ready to run

**NOTE: Disconnect the H2 from your database because if you don't it will cause an error when you run your application from intellij idea IDE because can't connect to the database from two different places at same time, This happend because we used embedded H2 database**
