# Java Multithreading – Basic Concepts

This module covers the **fundamental concepts of Java multithreading** required to understand concurrent programming.

Multithreading allows a program to execute **multiple threads simultaneously**, improving performance and CPU utilization.

---

## Topics Covered

### 1. Thread vs Process
Process:
- Independent program execution
- Has its own memory space

Thread:
- Lightweight unit of execution
- Shares memory within the same process

Example:
Browser → Process  
Tabs inside browser → Threads

---

### 2. Thread Creation

Two main ways:

#### 1. Extending Thread Class
```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running");
    }
}
