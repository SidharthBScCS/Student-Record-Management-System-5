# Student Record Management System 5 

## Problem Statement
Design and implement a Student Record Management System using Java
that allows for the management of student records (add, update, delete, search,
and view) with persistent storage. The application must support exception
handling, file handling (to store and retrieve data), multithreading (to
simulate loading), and must leverage the Java Collections Framework. The
system should allow sorting of students by marks, provide the option to search and
delete student records, and display the sorted list of students. Additionally, the
system should use OOP concepts like inheritance, abstraction, and interfaces to
ensure modular and reusable code.

## Packages Used
- model
- service
- utils
- threads
- exception
- main

## Attributes
- **rollNo** : Integer,unique student ID.
- **name** : String,name of the student.
- **email** : String,email of the student.
- **course** : String,course of the student.
- **marks** : double,marks of the student.
- **grade** : String,calculated grade based on the marks.

## System Components

### Package : **model**

#### **Person.java**
- Abstract class
- Fields: name,email
- Contains abstract method **displayInfo()**
- Base class for Student (Inheritance)

#### **Student.java**
- Extends Person
- Additional fields : rollNo,course,marks,grade
- **inputDetails()** : takes input with validation
- **calculateGrade()** : generates grade based on marks
- **displayDetails()** : prints student information
- Overrides **displayInfo()**
- Overrides **toString()** used for file writing

### Package : **service**

#### **RecordActions.java**
- Interface containing required student operations
  - **addStudent()**
  - **deleteStudent()**
  - **updateStudent()**
  - **searchStudent()**
  - **viewAllStudents()**

#### **StudentManager.java**
- Handles all core functionalities
- **ArrayList<Student>** for orderes records
- **HashMap<Integer,Student>** for fast search
- **addStudent()** : with duplicate rollNo check and thread loading
- **deleteStudent()** : using map remove and list sync
- **updateStudent()** : field by field update
- **searchStudent()** : by rollNo or name using streams
- **viewAllStudents()** : **Iterator** traversal
- Sorting ny marks using **Comparator**

### Package : **utils**

#### **FileUtil.java**
- **BufferedReader** : read student records at starting.
- **BufferedWriter** : write updated records at exit
- **fileAttributes()** : shows data
- **randomAccessDemo()** : demonstrates **RandomAccessFile**

### Package : **threads**

#### **Loader.java**
- Implements **Runnable**
- Simulates loading using a loop and **Thread.sleep()**
- Used when adding and saving students.

### Package: **exception**

#### **StudentNotFoundException.java**
- Customized exception
- Throw during search when a student does not exist

### Package : **main**

#### **Main.java**
Menu-Driven program
- 1. Add Student
- 2. View all Students
- 3. Search Student
- 4. Delete Student
- 5. Update Student
- 6. Sort by marks
- 7. Save and Exit

## Code Explanation
This application follows a structured,modular design using Java packages.
It implements **inheritances**,**abstraction**,and **interface** to maintain clean
separation of logic. All student data is encapsulated inside the **Student** class,
enforcing proper access control and data integrity. The system stores records using both
**ArrayList** and **HashMap**,allowing efficient insertion,deletion,traversal,and fast 
lookup.Records are stored using a **Comparator** that arranges students by marks in descending
order,while an **Iterator** ensures safe traversal during display. To preserve data between
executions,the system uses **file handling**,reading existing student records at startup
and writing updated records on exit. **BufferedReader** and **BufferedWriter** ensure fast
file operations. The addition and saving of records simulates a real-world loading experience
using **multithreading** through the **Loader** class. **Exception handling** prevents crashes
due to invalid input. A **customized exception** **StudentNotFoundException** gives precise
error feedback during search operations. Overall, the system integrates **OOP**,**exception handling**,
**multithreading**,**file I/O**,**packages**,**interface**.

## Topics Covered
- Inheritance
- Abstraction
- Method Overriding
- Interfaces
- Encapsulation
- Polymorphism
- ArrayList & HashMap
- Comparator (sorting)
- Iterator
- Exception Handling
- Custom Exceptions
- Multithreading
- File Handling (BufferedReader, BufferedWriter)
- Interfaces
- Packages
- Real-world application development

## Sample Output
<img width="463" height="306" alt="1" src="https://github.com/user-attachments/assets/93e3da00-617d-46fd-a47f-aa95e1494d20" />
<img width="506" height="623" alt="2" src="https://github.com/user-attachments/assets/5cb142a5-0da1-4a53-8d1e-7c6e36676f39" />
<img width="624" height="565" alt="3" src="https://github.com/user-attachments/assets/a98746c7-2fdf-461b-9f06-f151ef143a79" />
<img width="658" height="388" alt="4" src="https://github.com/user-attachments/assets/ba1ce9e2-46c8-471c-bf8a-860911f93cba" />
<img width="651" height="660" alt="5" src="https://github.com/user-attachments/assets/0f87a0fe-287d-421c-bcc6-db73a4b42362" />
<img width="713" height="232" alt="6" src="https://github.com/user-attachments/assets/d889338c-bf33-4363-ac12-6f7f8526cbce" />

## GitHub Links
- src : https://github.com/SidharthBScCS/Student-Record-Management-System-5/tree/main/src
- main : https://github.com/SidharthBScCS/Student-Record-Management-System-5/tree/main/src/main
- model : https://github.com/SidharthBScCS/Student-Record-Management-System-5/tree/main/src/model
- service : https://github.com/SidharthBScCS/Student-Record-Management-System-5/tree/main/src/service
- threads : https://github.com/SidharthBScCS/Student-Record-Management-System-5/tree/main/src/threads
- utils : https://github.com/SidharthBScCS/Student-Record-Management-System-5/tree/main/src/utils
- exception : https://github.com/SidharthBScCS/Student-Record-Management-System-5/tree/main/src/exception
- students.txt : https://github.com/SidharthBScCS/Student-Record-Management-System-5/blob/main/src/students.txt

## Student Details
- **Name** : Sidharth Krishna S
- **Roll No** : 2401720003
- **Course** : BSc Computer Science
- **Semester** : 3rd Semester
- **Assignment** : Java Lab Assignment 5


