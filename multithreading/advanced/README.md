# Java Multithreading – Intermediate Level

This module covers **intermediate concurrency concepts in Java**, focusing on thread management, thread pools, and lock mechanisms.

Instead of manually managing threads, modern Java applications rely on the **Executor Framework and advanced synchronization mechanisms** to build scalable concurrent systems.

---

# 1. Executor Framework

The Executor Framework (introduced in Java 5) provides a **high-level API for managing and executing threads**.

Before Executor Framework:

```java
Thread t = new Thread(task);
t.start();
