## APIs 🔧
- Admin
- Employee

## Admin 👇
These are the main APIs to interact with Employee Database & Performance Database.
- Add/remove/update/view employees
- Add/update/view performance reviews
- Assign employees to participate in another employee's performance review

## Employee 👇
These are the Employee APIs use to interact with Performance Database for adding feedback to other employee (If `employeeParticipation` is set to `true` by **Admin**
- List of performance reviews requiring feedback
- Submit feedback


 - ## Employee Submission
```
{
    "employeeID": 1,
    "employeeName": "David",
    "employeeParticipation": true
}
```

 - ## Performance Submission
```
{
    "key": 1,
    "performance": "David, working in company for last 2 years has really performed well",
    "feedback": ""
}
```

 - ## Feedback Submission
```
{
    "feedbackID": 1,
    "feedbackToBeSubmitted": "I knew David since I start working in the company and he is a really good engineer and a human to be!"
}
```

*Make sure to update and build the *Maven* again before launching the application*
