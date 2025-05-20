# Kotlin + Spring Boot Example Project

## Overview
A sample backend application demonstrating a full CRUD stack using Kotlin, Spring Boot, and Spring Data JPA. The goal is to showcase how to map database tables to Kotlin `@Entity` classes, expose RESTful endpoints, validate inputs, handle exceptions globally, and perform automated persistence without writing any SQL by hand.

---

## Database Schema  
This project uses four main tables:

- **student**  
  Stores basic student information (e.g. `student_id`, `name`, `phonenumber`, …).

- **class**  
  Stores class information (e.g. `class_id`, `title`, `description`, …).
  Stores teacher/employee data (e.g. `employee_id`, `name`, `department`, …).

- **class_registration**  
  A join table to associate students with classes (composite key: `class_id`, `student_id`), plus metadata like enrollment date (`enrol_dt`) and abandonment date (`abnd_dt`).



