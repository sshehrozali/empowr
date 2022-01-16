# Employee Performance Feedback App 😎

This is a Complete MVC Architecture Spring Boot RESTful Application with CRUD APIs for Admin and Employee Controller and Service Classes and Entities. Uses Apache Derby for Rapid production prototype in-memory Database for testing Controller classes and Service Layer i.e. Business Logic and Data Access (Repository) Layer to Entity classes.

## Installation 📲
Clone or Download the Repository to your Local machine.
Spring Boot, OpenJDK, Java and other dependencies are required.
Just reload Maven project (pom.xml) file from source folder and it will automatically
reload and install all the dependencies required.

```bash
git clone https://github.com/sshehrozali/Employee-FeedBack_RESTful-Application-Spring-Boot-Apache-Derby.git
```

## APIs 🔧
- Admin APIs
- Employee APIs

## Admin APIs 👇
These are the main APIs to interact with Employee Database & Performance Database.
- Add/remove/update/view employees
- Add/update/view performance reviews
- Assign employees to participate in another employee's performance review

## Employee APIs 👇
These are the Employee APIs use to interact with Performance Database for adding feedback to other employee (If `employeeParticipation` is set to `true` by **Admin**
- List of performance reviews requiring feedback
- Submit feedback


*Make sure to update and build the *Maven* again before launching the application*

## License 🚩
[MIT](https://choosealicense.com/licenses/mit/)

### Made with ❤ and 💤 by Shehroz Ali.
