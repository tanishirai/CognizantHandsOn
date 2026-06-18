# Week 1 - Design Patterns and Principles

This repository contains the implementation of two design patterns:

1. Singleton Pattern
2. Factory Method Pattern

---

# Task 1 - Singleton Pattern

**Project Name:** SingletonPatternExample

## Objective

Implement the Singleton Design Pattern to ensure that only one instance of a Logger class exists throughout the application lifecycle.

## Files

- `Logger.java` - Singleton class with private constructor and static `getInstance()` method.
- `SingletonTest.java` - Test class used to verify Singleton behavior.

## How to Run

```bash
cd SingletonPatternExample/src
javac Logger.java SingletonTest.java
java SingletonTest
```

## Output

```text
Log: First log message
Log: Second log message
Log: Third log message

logger1 hashCode: 1450495309
logger2 hashCode: 1450495309
logger3 hashCode: 1450495309

logger1 == logger2 : true
logger2 == logger3 : true
logger1 == logger3 : true

Singleton VERIFIED: all three variables point to the same instance.
```

> Note: The hashCode value may change on different runs, but all three variables should always have the same hashCode because they reference the same Logger instance.


## Screenshot


![Singleton Pattern Output](screenshots/singleton_output.png)

---

# Task 2 - Factory Method Pattern

**Project Name:** FactoryMethodPatternExample

## Objective

Implement the Factory Method Design Pattern to create different types of documents (Word, PDF, and Excel) through factory classes.

## Files

- `WordDocument.java`
- `PdfDocument.java`
- `ExcelDocument.java`
- `ConcreteWordDocument.java`
- `ConcretePdfDocument.java`
- `ConcreteExcelDocument.java`
- `DocumentFactory.java`
- `WordDocumentFactory.java`
- `PdfDocumentFactory.java`
- `ExcelDocumentFactory.java`
- `FactoryMethodTest.java`

## How to Run

```bash
cd FactoryMethodPatternExample/src
javac *.java
java FactoryMethodTest
```

## Output

```text
--- Testing WordDocumentFactory ---
Document type created : Word Document
Correct type created  : true
Opening Word document (.docx)
Saving Word document (.docx)

--- Testing PdfDocumentFactory ---
Document type created : PDF Document
Correct type created  : true
Opening PDF document (.pdf)
Saving PDF document (.pdf)

--- Testing ExcelDocumentFactory ---
Document type created : Excel Document
Correct type created  : true
Opening Excel document (.xlsx)
Saving Excel document (.xlsx)

--- Cross-type verification ---
WordFactory  produces WordDocument  : true
PdfFactory   produces PdfDocument   : true
ExcelFactory produces ExcelDocument : true
```

## Screenshot


![Factory Method Output](screenshots/factory_output.png)

---

# Folder Structure

```text
Week1/
│
├── README.md
│
├── screenshots/
│   ├── singleton_output.png
│   └── factory_output.png
│
├── SingletonPatternExample/
│   └── src/
│       ├── Logger.java
│       └── SingletonTest.java
│
└── FactoryMethodPatternExample/
    └── src/
        ├── WordDocument.java
        ├── PdfDocument.java
        ├── ExcelDocument.java
        ├── ConcreteWordDocument.java
        ├── ConcretePdfDocument.java
        ├── ConcreteExcelDocument.java
        ├── DocumentFactory.java
        ├── WordDocumentFactory.java
        ├── PdfDocumentFactory.java
        ├── ExcelDocumentFactory.java
        └── FactoryMethodTest.java
```

---

# Conclusion

The Singleton Pattern ensures that only one Logger instance is created and shared throughout the application. The Factory Method Pattern provides a flexible way to create different document types without directly instantiating concrete classes. These implementations demonstrate the practical use of design patterns to improve code organization, maintainability, and scalability.