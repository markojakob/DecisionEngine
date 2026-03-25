# Decision Engine Project

This project implements a simple **loan decision engine** for Inbank. It calculates the **maximum approved loan amount** and period based on a user's personal code and a primitive credit scoring algorithm. The frontend allows users to submit loan requests and see the decision in real time.

---

## Features

- REST API endpoint: `POST /decision`  
- Frontend React form for submitting loan requests  
- Validates loan amount (2000–10000€) and period (12–60 months)  
- Handles debt and three credit segments:
  - `49002010965` → debt → always rejected  
  - `49002010976` → segment 1 → creditModifier = 100  
  - `49002010987` → segment 2 → creditModifier = 300  
  - `49002010998` → segment 3 → creditModifier = 1000  
- Determines maximum approved loan amount based on credit score  
- Returns requested loan amount, approved amount, and approved period  

---

## Backend (Spring Boot)

1. Navigate to the backend folder:


- cd Backend


2. Run the backend:


- ./mvnw spring-boot:run


Backend runs at: http://localhost:8080  
Endpoint: `POST /decision`  

**Request body example:**


{
"personalCode": "49002010987",
"loanAmount": 2000,
"period": 14
}


**Response example:**


{
"approved": true,
"approvedAmount": 4200,
"loanAmount": 2000,
"period": 14,
"personalCode": "49002010987"
}


---

## Frontend (React)

1. Navigate to the frontend folder:


- cd frontend


2. Install dependencies:


- npm install


3. Run the frontend:


- npm start


Frontend runs at: http://localhost:3000  
Fill in personal code, loan amount, and period, then click **Check Loan**  

**Validation ensures:**

- Loan amount: 2000–10000€  
- Loan period: 12–60 months  

---

## Notes / Improvements

- Currently, the credit scoring algorithm is simple and fixed for the assignment; could be replaced with a real scoring system  
- Step size in backend is fixed at 50€; could be made configurable  
- Frontend alerts could be replaced with inline validation messages for better UX
