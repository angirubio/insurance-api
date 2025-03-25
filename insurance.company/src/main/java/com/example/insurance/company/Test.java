package com.example.insurance.company;

public class Test {

    /**
     * Exercise 1: Basic Java - Palindrome Check
     * Task: Write a Java method to check if a given string is a palindrome.  Solution:
     1. Create a method isPalindrome that takes a String as input.
     2. Convert the string to lowercase to ensure the check is case-insensitive.
     3. Use a loop to compare characters from the beginning and end of the string.
     4. Return true if the string is a palindrome, otherwise return false.
     */
    public static boolean isPalindrome(String input) {
        String normal = input.toLowerCase();
        int beginning = 0;
        int end = normal.length() - 1;

        while (beginning < end) {
            if(normal.charAt(end) != normal.charAt(beginning)) {
                return false;
            }
            beginning++;
            end--;
        }

        return true;
    }

    /*
    public static void main(String[] args) {
        String testString = "Ada";
        boolean result = isPalindrome(testString);
        System.out.println("Is " + testString + " palindrome?: " + result);
    }
     */

    /**
     * Exercise 2: Basic Java - Factorial Calculation
     * Task: Write a Java method to calculate the factorial of a given number.
     1. Create a method factorial that takes an integer n as input.
     2. Use a loop to multiply numbers from 1 to n.
     3. Return the result.
     */
    public static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /*
    public static void main(String[] args) {
        int number = 16;
        int result = factorial(number);
        System.out.println("Factorial of " + number + " is: " + result);
    }
     */

    /* Exercise 3: Refactor - Extract Method
     * Task: Refactor the following code to improve readability by extracting methods.
     1. Extract validation logic into validateCustomer method.
     2. Extract discount calculation into calculateDiscount method.
     3. Extract customer details printing into printCustomerDetails method.

    public void processCustomer(Customer customer) {
        validateCustomer(customer);
        double discount = calculateDiscount(customer);
        printCustomerDetails(customer, discount);
    }

    private void validateCustomer(Customer customer) {
        if (customer == null || customer.getName().isEmpty()) {
            throw new IllegalArgumentException("Invalid customer");
        }
    }

    private double calculateDiscount(Customer customer) {
        return customer.isPremium() ? 0.1 : 0;
    }

    private void printCustomerDetails(Customer customer, double discount) {
        System.out.println("Customer: " + customer.getName());
        System.out.println("Discount: " + discount);
    }
*/

    /* Exercise 4: Spring Boot - Create a REST Controller
     * Task: Create a Spring Boot REST controller to manage Policy entities.

     Policy.java
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

    @Entity
    public class Policy {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String policyNumber;
        private String policyHolder;

        // Getters and setters
    }

 PolicyRepository.java
import org.springframework.data.jpa.repository.JpaRepository;

    public interface PolicyRepository extends JpaRepository<Policy, Long> {
    }

 PolicyController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/policies")
    public class PolicyController {
        @Autowired
        private PolicyRepository policyRepository;

        @GetMapping
        public List<Policy> getAllPolicies() {
            return policyRepository.findAll();
        }

        @GetMapping("/{id}")
        public Policy getPolicyById(@PathVariable Long id) {
            return policyRepository.findById(id).orElse(null);
        }

        @PostMapping
        public Policy createPolicy(@RequestBody Policy policy) {
            return policyRepository.save(policy);
        }

        @PutMapping("/{id}")
        public Policy updatePolicy(@PathVariable Long id, @RequestBody Policy policy) {
            policy.setId(id);
            return policyRepository.save(policy);
        }

        @DeleteMapping("/{id}")
        public void deletePolicy(@PathVariable Long id) {
            policyRepository.deleteById(id);
        }
    }
     */

    /* Exercise 5: Spring Boot - Service Layer
     * Task: Add a service layer to the previous Spring Boot application.
     *
     * // PolicyService.java
import java.util.List;

public interface PolicyService {
    List<Policy> getAllPolicies();
    Policy getPolicyById(Long id);
    Policy createPolicy(Policy policy);
    Policy updatePolicy(Long id, Policy policy);
    void deletePolicy(Long id);
}

// PolicyServiceImpl.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyServiceImpl implements PolicyService {
    @Autowired
    private PolicyRepository policyRepository;

    @Override
    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }

    @Override
    public Policy getPolicyById(Long id) {
        return policyRepository.findById(id).orElse(null);
    }

    @Override
    public Policy createPolicy(Policy policy) {
        return policyRepository.save(policy);
    }

    @Override
    public Policy updatePolicy(Long id, Policy policy) {
        policy.setId(id);
        return policyRepository.save(policy);
    }

    @Override
    public void deletePolicy(Long id) {
        policyRepository.deleteById(id);
    }
}

// PolicyController.java (updated)
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/policies")
public class PolicyController {
    @Autowired
    private PolicyService policyService;

    @GetMapping
    public List<Policy> getAllPolicies() {
        return policyService.getAllPolicies();
    }

    @GetMapping("/{id}")
    public Policy getPolicyById(@PathVariable Long id) {
        return policyService.getPolicyById(id);
    }

    @PostMapping
    public Policy createPolicy(@RequestBody Policy policy) {
        return policyService.createPolicy(policy);
    }

    @PutMapping("/{id}")
    public Policy updatePolicy(@PathVariable Long id, @RequestBody Policy policy) {
        return policyService.updatePolicy(id, policy);
    }

    @DeleteMapping("/{id}")
    public void deletePolicy(@PathVariable Long id) {
        policyService.deletePolicy(id);
    }
}
     */

    /** Exercise 1: Basic Java - Reverse a String
     * Task: Write a Java method to reverse a given string.
     */
    public static String reverseString(String input) {
        char[] chars = input.toCharArray();
        int first = 0;
        int last = input.length() -1;

        while (first < last) {
            char stored = chars[first];
            chars[first] = chars[last];
            chars[last] = stored;
            first++;
            last--;
        }
        return new String(chars);
    }

    /*
    public static void main(String[] args) {
        String original = "Hello";
        String reversed = reverseString(original);
        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);
    }
     */

    /** Exercise 2: Basic Java - Fibonacci Sequence
     * Task: Write a Java method to generate the first n numbers in the Fibonacci sequence.
     */
    public static int[] fibonacci(int n) {
        int[] sequence = new int[n];
        if (n > 0) sequence[0] = 0;
        if (n > 1) sequence[1] = 1;

        for (int i = 2; i < n; i++) {
            sequence[i] = sequence[i - 1] + sequence[i - 2];
        }

        return sequence;
    }

    /*
    public static void main(String[] args) {
        int n = 15;
        int[] seq = fibonacci(n);
        System.out.print("Fibonacci sequence: ");
        for (int num : seq) {
            System.out.print(num + " ");
        }
    }
     */

}
