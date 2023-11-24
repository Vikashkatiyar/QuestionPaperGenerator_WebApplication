# QuestionPaperGenerator_WebApplication

# Overview
This backend code is designed to generate questions dynamically based on the specified total marks and difficulty levels. It is implemented using Java with the Spring Boot framework.
# Prerequisites
Make sure you have the following installed:

>Java Development Kit (JDK)

>Spring Boot

# Usage
> Clone the repository: git clone

> Build and run the Spring Boot application: ./mvnw spring-boot:run

#Access the question generation endpoint:

> Endpoint: ```localhost:8080/questions/generate-paper```


> Request Body:

```json
{
    "totalMarks": 100,
    "easy": 30,
    "medium": 50,
    "hard": 20
}
```

# Output
1. Post/Add Questions
 ![image](https://github.com/Vikashkatiyar/QuestionPaperGenerator_WebApplication/assets/89769715/e4817b96-07d9-4d7e-8e30-e1a7d1d77bba)

2.Get/Generate Paper
 ![image](https://github.com/Vikashkatiyar/QuestionPaperGenerator_WebApplication/assets/89769715/1c0cc5b6-11d8-47a7-83a3-66c904222b4b)


# Questions JSON DATA
```
[
    {
        "id": 2,
        "question": "Who wrote Romeo and Juliet?",
        "difficulty": "EASY",
        "subject": "Literature",
        "topic": "Shakespeare",
        "marks": 5
    },
    {
        "id": 4,
        "question": "What is the formula for Oxygen?",
        "difficulty": "EASY",
        "subject": "Chemistry",
        "topic": "Chemical Formulas",
        "marks": 5
    },
    {
        "id": 5,
        "question": "What is the formula for Nitrogen?",
        "difficulty": "EASY",
        "subject": "Chemistry",
        "topic": "Chemical Formulas",
        "marks": 5
    },
    {
        "id": 6,
        "question": "What is the ASCII VALUE of A?",
        "difficulty": "EASY",
        "subject": "CODING",
        "topic": "ASCII VALUES",
        "marks": 5
    },
    {
        "id": 7,
        "question": "What is the ASCII VALUE of B?",
        "difficulty": "EASY",
        "subject": "CODING",
        "topic": "ASCII VALUES",
        "marks": 5
    },
    {
        "id": 8,
        "question": "What is the ASCII VALUE of C?",
        "difficulty": "EASY",
        "subject": "CODING",
        "topic": "ASCII VALUES",
        "marks": 5
    },
    {
        "id": 1,
        "question": "What is the capital of France?",
        "difficulty": "MEDIUM",
        "subject": "Geography",
        "topic": "Countries and Capitals",
        "marks": 10
    },
    {
        "id": 36,
        "question": "What is the formula of Displacement?",
        "difficulty": "MEDIUM",
        "subject": "Physics",
        "topic": "Wave Theory",
        "marks": 10
    },
    {
        "id": 37,
        "question": "What is the formula of Velocity?",
        "difficulty": "MEDIUM",
        "subject": "Physics",
        "topic": "Wave Theory",
        "marks": 10
    },
    {
        "id": 38,
        "question": "What is the formula of a?",
        "difficulty": "MEDIUM",
        "subject": "Physics",
        "topic": "Wave Theory",
        "marks": 10
    },
    {
        "id": 39,
        "question": "What is the formula of Force?",
        "difficulty": "MEDIUM",
        "subject": "Physics",
        "topic": "Wave Theory",
        "marks": 10
    },
    {
        "id": 3,
        "question": "What is the formula for water?",
        "difficulty": "HARD",
        "subject": "Chemistry",
        "topic": "Chemical Formulas",
        "marks": 15
    }
]
```


