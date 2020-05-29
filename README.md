# library management system

My final project to pass database application labs

## What is it about?

I’ve created an application, which simulates a library management system. There are 3 users that can make use of the application - administrator, librarian and reader. The entire application is fully validated, so any user can’t see the primary and foreign keys. Also, user don’t have to enter them in any place (keys are selected from the drop-down list). Customer can create an account, use the library - see all the books, publishers, categories and authors. Furthermore, user can search these books by data or use searching with additional information such as a description and borrow them (the status changes to -1 and the current date is taken) and have access to all his borrows. After reading he can return the book (each day of lateness after 14 days is 3.50PLN fine). A librarian and an administrator have access to the administrator panel with full CRUD. The librarian can’t create a role or other librarian.

There are screenshots of diagram ERD and application at the bottom.

## To create the project I’ve used:

- JAVA
- MS SQL (T-SQL)
- Hibernate ORM
- Swing

# Requirements:
* application has to allow adding, removing, displaying, modifying records from each table (CRUD)
* any user can’t see the primary and foreign keys and don’t have to enter them in any place
* the script, which creates the database, shouldn’t use cascading deletion
* minimum 3 users with different rights of access (login screen) have to use the application



##
Login Screen\
![Login screen](https://images.tinypic.pl/i/01006/c3sj1drkfhmj.png)\
Main application\
![Main application](https://images.tinypic.pl/i/01006/9iws7oblyv66.png)\
![Main application2](https://images.tinypic.pl/i/01006/i6qmqaobrx5h.png)\
![Main application3](https://images.tinypic.pl/i/01006/o5zpror8r2f2.png)\
Admin panel\
![admin1](https://pics.tinypic.pl/i/01006/0ars064om20l.png)\
One example of CRUD\
![admin2](https://pics.tinypic.pl/i/01006/l26kwqopweyi.png)\
Diagram\
![diagram](https://pics.tinypic.pl/i/01006/ppfogiqf88wj.png)