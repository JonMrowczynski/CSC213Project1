# 🃏 CSC213 Project 1

**Author**: Justin Del Vecchio

**Edited by**: Jon Mrowczynski

---

*Allot at least 3 weeks to complete this project to be safe!*

This project is all about probabilities! You'll be implementing a Java program that simulates drawing hands from a
deck and tracking how long it takes to see every possible unique hand! This project will challenge your
understanding of Java collections, probability, file handling, and real-world software development practices.

There are many things that you will do in this project, including, but not limited to:

- Write code to iterate through different deck and hand sizes.
- Utilize a testing framework to run tests on methods, classes, and your entire codebase.
- Running multiple trials to measure the number of attempts needed to achieve full coverage.
- Output real-time progress updates and save the results to a CSV file for analysis.
- Setting up a private GitHub repo to manage your code.
- Compiling your project into a .jar file.

The skeleton code for this project is found in this repo. **You will be responsible for *cloning* the project and
completing it.**

---

## 📂 Package Structure

This project follows a **Maven/Gradle-style structure**:

```
src/
 ├── main/java/edu/canisius/csc213/project1/Deck.java
 ├── test/java/edu/canisius/csc213/project1/DeckTest.java
```

It's usually a good idea to stick with this default structure. Otherwise, you have to manually change settings.

---

## Part 1. Defining the Card and the Deck Classes

Implement a `Card` class that represents a standard playing card. Each card has:

- A **suit** (♠ **Spades**, ♥ **Hearts**, ♦ **Diamonds**, ♣ **Clubs**)
- A **rank** (**2–10, Jack, Queen, King, Ace**)

Your task is to define the class and ensure that it passes the provided **JUnit tests**.

---

### 🔧 **Step 1: Define the `Card` Record**

Your `Card.java` should be placed in the `edu.canisius.csc213.project1` package and should contain a `Card` record
that has:

- **Two enums**: `Suit` and `Rank` (already provided below).
- Two private final fields for `Suit` and `Rank` (in that order).
    - These fields should be named `suit` and `rank`, respectively.
- An **override of `toString()`** to display cards in `"RANK of SUIT"` format.

Remember a `record` is a special kind of `class` often called a "data class" that helps prevent us from having to write
a bunch of boilerplate code. Said differently, since we are using a `record`, all getter methods, `equals()`,
`hascode()`, and even the constructor are automatically created for us!

```java
public enum Suit {HEARTS, DIAMONDS, CLUBS, SPADES}

public enum Rank {TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE}
```

---

### 🧪 **Step 2: Make Sure Your `Card` `record` Passes All Tests!**

- A **JUnit test file** (`CardTest.java`) is provided to verify your implementation.
- You can determine what each of them test by looking at their corresponding Javadocs and testing code.
- It is not guaranteed that your `Card` `record` functions completely correctly if it passes all the tests, but it is a
  very good check!
---

### 🔧 **Step 3: Implement the `Deck` Class**

The `class Deck` in `Deck.java` represents a **custom-sized deck of playing cards**, that supports shuffling and
drawing.

#### **Deck Rules:**

1. The deck **size** must be a **multiple of 4**, up to a maximum of **52**.
2. If an invalid size is provided, the constructor **throws an `IllegalArgumentException`**.
3. The deck is built in the following order:
    - **4 cards → 4 Aces**
    - **8 cards → 4 Aces + 4 Kings**
    - **12 cards → 4 Aces + 4 Kings + 4 Queens**
    - … continues until **52 cards (full deck)**
4. The deck must have:
    - **A method to shuffle the cards**.
    - **A method to draw a card (removing it from the deck)**.
    - **A method to get the number of remaining cards**.

---

### 🧪 **Step 4: Make Sure Your `Deck` `class` Passes All Tests!**

- A **JUnit test file** (`DeckTest.java`) is provided to verify your implementation.
- You can determine what each of them test by looking at their corresponding Javadocs and testing code.
- It is not guaranteed that your `Deck` `class` functions entirely correctly if all tests pass, but it is a very good
  check!

---

## Part 2: Dealing Some Cards!

---

### 📂 **Final Project Structure**

Your project should now have this structure:

```
src/
 ├── main/java/edu/canisius/csc213/project1/
 │   ├── Card.java
 │   ├── Deck.java
 │   ├── UniqueHands.java  <-- (You will implement this!)
 ├── test/java/edu/canisius/csc213/project1/
 │   ├── CardTest.java
 │   ├── DeckTest.java
 │   ├── UniqueHandsTest.java  <-- (Unit tests are provided!)
```

---

### 🔧 **Step 1: Implement `UniqueHands.java`**

You will now implement the `UniqueHands` `class`, which simulates drawing random hands from a deck and measures how
long it takes to see every possible hand. This class must:

1. Runs 5 **trials** for different combinations of **deck sizes (24, 28)** and **hand sizes (6, 7)**.
2. Measure the number of attempts and time taken to see **every unique hand** for the given deck and hand sizes.
3. Compute and print the average results over all trials for each combination.

---

### 🧪 **Step 2a: Run the Unit Tests for `UniqueHands`**

- A **JUnit test file** (`UniqueHandsTest.java`) is provided to verify your implementation.
- You can determine what each of them test by looking at their corresponding Javadocs and testing code.
- It is not guaranteed that your `UniqueHands` `class` functions completely correctly if it passes all the tests, 
  but it 
  is a
  very good check!

---

### 📌 **Step 2b: Expected Output**

Once you implement `UniqueHands.java`, your program should produce output **similar to this**:

```
🃏 Deck Simulation: How long to see every possible hand?
----------------------------------------------------------------------------------------------------
Deck Size: 24 | Hand Size: 6 | Trial 1 | Attempts: 1,659,552 | Time: 6.558s
Deck Size: 24 | Hand Size: 6 | Trial 2 | Attempts: 1,391,488 | Time: 4.914s
Deck Size: 24 | Hand Size: 6 | Trial 3 | Attempts: 1,645,210 | Time: 5.422s
Deck Size: 24 | Hand Size: 6 | Trial 4 | Attempts: 1,644,965 | Time: 5.797s
Deck Size: 24 | Hand Size: 6 | Trial 5 | Attempts: 1,623,150 | Time: 5.902s
✅ Deck Size: 24 | Hand Size: 6 | Avg Attempts: 1,592,873 | Avg Time: 5.719s
----------------------------------------------------------------------------------------------------
Deck Size: 24 | Hand Size: 7 | Trial 1 | Attempts: 4,324,562 | Time: 24.049s
Deck Size: 24 | Hand Size: 7 | Trial 2 | Attempts: 4,895,201 | Time: 27.399s
Deck Size: 24 | Hand Size: 7 | Trial 3 | Attempts: 4,180,101 | Time: 23.052s
Deck Size: 24 | Hand Size: 7 | Trial 4 | Attempts: 4,216,866 | Time: 24.173s
Deck Size: 24 | Hand Size: 7 | Trial 5 | Attempts: 4,913,785 | Time: 27.352s
✅ Deck Size: 24 | Hand Size: 7 | Avg Attempts: 4,506,103 | Avg Time: 25.205s
----------------------------------------------------------------------------------------------------
Deck Size: 28 | Hand Size: 6 | Trial 1 | Attempts: 5,021,739 | Time: 22.837s
Deck Size: 28 | Hand Size: 6 | Trial 2 | Attempts: 4,489,967 | Time: 20.060s
Deck Size: 28 | Hand Size: 6 | Trial 3 | Attempts: 5,204,598 | Time: 22.903s
Deck Size: 28 | Hand Size: 6 | Trial 4 | Attempts: 5,265,020 | Time: 24.315s
Deck Size: 28 | Hand Size: 6 | Trial 5 | Attempts: 5,003,764 | Time: 22.811s
✅ Deck Size: 28 | Hand Size: 6 | Avg Attempts: 4,997,017 | Avg Time: 22.585s
----------------------------------------------------------------------------------------------------
```

To produce output like the sample, your `main()` method must:

### **✅ 1. Set Up Deck & Hand Size Loops**

- They need to **loop through different deck sizes** (`24, 28`).
- Inside that, **loop through hand sizes** (`6, 7`).
- Inside that, **run multiple trials** (5 trials per deck-hand size pair).

---

### **✅ 2. Track and Print Progress During `countAttemptsToSeeAllHands()`**

- Every **100,000 attempts**, print:
    - **Percentage coverage**
    - **Total unique hands seen**
    - **Total unique hands possible**
    - **How many unique hands are still needed**
- Stop printing progress when 100% is reached.

---

### **✅ 3. Track Total Attempts & Execution Time for Each Trial**

- Record **how many attempts** it took to see every hand.
- Use `System.nanoTime()` at **start** and **end** to calculate execution time.
- Print the final summary:

  ```
  ✅ 100.00% coverage reached after 1,576,221 attempts (Unique Hands: 134,596 / 134,596 | Needed: 0)
  Deck Size: 24 | Hand Size: 6 | Trial 1 | Attempts: 1,576,221 | Time: 6.176s
  ```

---

### **✅ 4. Save Results to CSV**

- Write a CSV file with **deck size, hand size, trial #, attempts, and time.**
- Example:

  ```
  Deck Size,Hand Size,Trial,Attempts,Time (s)
  24,6,1,1576221,6.176
  24,6,2,1593462,5.268
  ```

---

## Submission

You must create a **private** GitHub repo and share it with the professor so they can download and run your project.

## Grading Rubric

**Total: 100 Points**

| **Category**                                 | **Criteria**                                                                                               | **Points** |
|----------------------------------------------|------------------------------------------------------------------------------------------------------------|------------|
| **GitHub Repository** (10 pts)               | Repository is correctly set up, private, and contains only the necessary source and test files.            | **5**      |
|                                              | Repository is properly structured with the correct package layout.                                         | **5**      |
| **Card Class Implementation** (10 pts)       | `Card` `record` correctly defines `Suit` and `Rank` enums, and fields for suit and rank.                   | **5**      |
|                                              | Implements proper `toString()`.                                                                            | **5**      |
| **Deck Class Implementation** (20 pts)       | Validates deck size (must be multiple of 4 and at most 52).                                                | **5**      |
|                                              | Implements shuffle, draw, and size methods correctly.                                                      | **15**     |
| **Unique Hands Simulation** (30 pts)         | Implements `UniqueHands.java` with correct looping structure (deck sizes, hand sizes, trials).             | **10**     |
|                                              | `countAttemptsToSeeAllHands()` correctly tracks unique hands, prints progress, and stops at 100% coverage. | **10**     |
|                                              | Outputs correct format with `coverage%, unique hands seen, total unique hands, remaining hands needed`.    | **10**     |
| **Unit Testing & Code Reliability** (15 pts) | All provided JUnit tests pass (`CardTest.java`, `DeckTest.java`, `UniqueHandsTest.java`).                  | **10**     |
|                                              | Student writes additional tests or includes thoughtful edge cases (optional extra credit).                 | **5**      |
| **Compile Script & JAR Packaging** (10 pts)  | Correctly compiles and generates a runnable `.jar` that runs correctly with `java -jar UniqueHands.jar`.   | **5**      |
|                                              | Uploaded `.jar` to D2L                                                                                     | **5**      |
| **CSV File Output** (10 pts)                 | Outputs correctly formatted CSV file with `Deck Size, Hand Size, Trial, Attempts, Time (s)`.               | **10**     |
