🚀 Java Production Tasks - Beginner Level (1 Year Experience)
Week 1: Basic Bug Fixes & Code Quality
Task 1: NullPointerException Fix
// BROKEN CODE - Fix the NPE
public class UserService {
public String getUserName(User user) {
return user.getName().toUpperCase(); // NPE risk!
}

    public int getUserAge(User user) {
        return user.getAge(); // NPE risk!
    }
}
Your Job: Add null checks and return meaningful defaults
Expected Time: 30 minutes
Skills Learned: Defensive programming, null safety
Task 2: Fix String Concatenation Performance
// SLOW CODE - Fix performance issue
public String buildReport(List<String> items) {
String result = "";
for (String item : items) {
result = result + item + ", "; // Performance problem!
}
return result;
}
Your Job: Replace with StringBuilder
Expected Time: 15 minutes
Skills Learned: String performance optimization
Task 3: Fix Resource Leak
// RESOURCE LEAK - Files not closed properly
public String readFile(String filename) {
try {
FileReader file = new FileReader(filename);
BufferedReader reader = new BufferedReader(file);
return reader.readLine();
} catch (IOException e) {
return "Error reading file";
}
// Resources never closed!
}
Your Job: Use try-with-resources
Expected Time: 20 minutes
Skills Learned: Resource management
Week 2: Collections & Data Handling
Task 4: Fix Concurrent Modification
// CRASHES WITH ConcurrentModificationException
public void removeInactiveUsers(List<User> users) {
for (User user : users) {
if (!user.isActive()) {
users.remove(user); // Exception here!
}
}
}
Your Job: Fix the concurrent modification
Expected Time: 25 minutes
Skills Learned: Iterator usage, collection modification
Task 5: Optimize Database Queries
// N+1 QUERY PROBLEM - Very slow!
public List<OrderDTO> getOrdersWithCustomers() {
List<Order> orders = orderRepository.findAll();
List<OrderDTO> result = new ArrayList<>();

    for (Order order : orders) {
        // This hits database for EACH order!
        Customer customer = customerRepository.findById(order.getCustomerId());
        result.add(new OrderDTO(order, customer));
    }
    return result;
}
Your Job: Fetch customers in batch to avoid N+1 queries
Expected Time: 45 minutes
Skills Learned: Database optimization basics
Task 6: Fix Memory Usage with Large Lists
// MEMORY INTENSIVE - Loads everything into memory
public List<Product> searchProducts(String keyword) {
List<Product> allProducts = productRepository.findAll(); // Loads 1M+ records!
return allProducts.stream()
.filter(p -> p.getName().contains(keyword))
.collect(Collectors.toList());
}
Your Job: Use pagination or database filtering
Expected Time: 40 minutes
Skills Learned: Memory-efficient data processing
Week 3: Basic Threading & Synchronization
Task 7: Fix Thread Safety Issue
// NOT THREAD-SAFE - Counter gets wrong values
public class CounterService {
private int counter = 0;

    public void increment() {
        counter++; // Race condition!
    }
    
    public int getCount() {
        return counter;
    }
}
Your Job: Make it thread-safe using synchronized or AtomicInteger
Expected Time: 30 minutes
Skills Learned: Basic thread safety
Task 8: Fix Deadlock Risk
// POTENTIAL DEADLOCK - Two methods lock in different order
public class AccountService {
public void transfer(Account from, Account to, double amount) {
synchronized(from) {
synchronized(to) {
from.withdraw(amount);
to.deposit(amount);
}
}
}

    public void reverseTransfer(Account from, Account to, double amount) {
        synchronized(to) {      // Different lock order!
            synchronized(from) { // Deadlock risk!
                to.withdraw(amount);
                from.deposit(amount);
            }
        }
    }
}
Your Job: Fix the lock ordering
Expected Time: 35 minutes
Skills Learned: Deadlock prevention
Week 4: Error Handling & Validation
Task 9: Improve Exception Handling
// BAD EXCEPTION HANDLING - Swallows errors
public User createUser(String email, String password) {
try {
if (email == null) throw new Exception("Email required");
if (password.length() < 6) throw new Exception("Password too short");

        return userRepository.save(new User(email, password));
    } catch (Exception e) {
        e.printStackTrace(); // Bad! Just prints and continues
        return null;         // Caller doesn't know what went wrong
    }
}
Your Job: Create proper custom exceptions and don't swallow errors
Expected Time: 40 minutes
Skills Learned: Proper exception handling
Task 10: Add Input Validation
// NO VALIDATION - Accepts dangerous input
@RestController
public class UserController {
@PostMapping("/users")
public ResponseEntity<User> createUser(@RequestBody CreateUserRequest request) {
// No validation! Accepts any input
User user = new User();
user.setEmail(request.getEmail());        // Could be null/invalid
user.setAge(request.getAge());            // Could be negative
user.setPassword(request.getPassword());   // Could be empty

        return ResponseEntity.ok(userService.save(user));
    }
}
Your Job: Add proper validation using annotations or manual checks
Expected Time: 50 minutes
Skills Learned: Input validation, security basics
Bonus Tasks (When Ready)
Task 11: Simple Cache Implementation
// NO CACHING - Hits database every time
public Product getProduct(Long productId) {
return productRepository.findById(productId); // Always hits DB
}
Your Job: Add simple in-memory caching
Expected Time: 1 hour
Skills Learned: Caching concepts
Task 12: Add Logging
// NO LOGGING - Hard to debug issues
public void processOrder(Order order) {
validateOrder(order);
calculateTotal(order);
saveOrder(order);
sendConfirmationEmail(order);
// No logging - can't track what happened!
}
Your Job: Add appropriate logging at different levels
Expected Time: 45 minutes
Skills Learned: Logging best practices
📚 How to Approach Each Task
Step-by-Step Process:
Read the code and understand what it's supposed to do
Identify the problem (I've marked them in comments)
Think of a simple solution first
Write the fix
Test your solution with simple test cases
Ask yourself: "Is this better than before?"
Learning Resources:
Google: "Java [specific topic]" (like "Java StringBuilder vs String")
Stack Overflow: For specific error messages
Oracle Java Docs: For API references
Ask me: If you get stuck on any task!
🎯 Start Here
Pick Task 1 (NullPointerException Fix) - it's the easiest and most common issue you'll face.
Time commitment: 15-30 minutes per task
Goal: Learn one new concept per task
Difficulty: Gradually increases from very easy to moderate
Would you like me to:
Give you the solution code for Task 1 to see the pattern?
Provide hints for how to approach it?
Start with an even simpler warm-up task?
Remember: Every senior developer started exactly where you are now! 🚀
 