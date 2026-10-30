# Student Grade Management System — Java

A console-based Java coursework project using inheritance, interfaces, collections, and file I/O.

## Features
- Read undergraduate and graduate student records from `students.txt`.
- Calculate grade averages, including weighted graduate assessments (40% midterm, 60% final).
- Assign letter grades and write a report to `grades.txt`.

## Files
- `Person.java` — abstract base class.
- `Gradable.java` — grading interface.
- `Student.java` — student grades and report.
- `GraduateStudent.java` — weighted graduate grading.
- `Main.java` — file parsing and output.

## Run
Requires a Java Development Kit and a `students.txt` file in the working directory:

```bash
javac *.java
java Main
```

Example fictional input record:
```text
U,Sample Student,EXAMPLE001,80,85,75,90,88,92
```

The original input data file was not supplied. Do not publish real student records. This educational project has not been independently tested here.
