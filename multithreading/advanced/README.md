
# Java Multithreading – Advanced Concepts

This module explores **advanced concurrency mechanisms** used in high-performance and large-scale applications.

These concepts help developers build **non-blocking, scalable, and highly concurrent systems**.

---

# 1. ForkJoinPool

ForkJoinPool is designed for **parallel processing of large tasks**.

It follows the **Divide and Conquer** algorithm.

A large task is divided into smaller subtasks which are executed in parallel.

Example structure:

Task
 ├── Subtask 1
 ├── Subtask 2
 └── Subtask 3

Each subtask can again split into smaller tasks.

---

## Example

```java
class SumTask extends RecursiveTask<Integer> {

    int start, end;

    SumTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    protected Integer compute() {

        if (end - start <= 10) {
            int sum = 0;
            for (int i = start; i <= end; i++)
                sum += i;
            return sum;
        }

        int mid = (start + end) / 2;

        SumTask left = new SumTask(start, mid);
        SumTask right = new SumTask(mid + 1, end);

        left.fork();

        return right.compute() + left.join();
    }
}
