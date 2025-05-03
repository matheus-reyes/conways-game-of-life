# conways-game-of-life
Conway's Game of Life implementation in 64-bit signed integer space.

### Each cell's value changes according to the following:
● If an "alive" cell has less than 2 or more than 3 alive neighbors (in any of the 8
surrounding cells), it becomes dead.

![image](https://github.com/user-attachments/assets/c66a99b3-c18b-4c2c-9524-c7aae2b07979)

![image](https://github.com/user-attachments/assets/3635e26d-8731-453b-8c27-38e49251d637)

● If a "dead" cell had *exactly* 3 alive neighbors, it becomes alive.

![image](https://github.com/user-attachments/assets/d83965b6-569d-4365-8c7f-1cf6fc171fa1)

### Explanation
We use a Set to store the live cells. A set is a good data structure because we can access elements in O(1) time and it automatically prevents duplicate cells.
The ```runGameOfLifeIteration``` method is responsible for running a single iteration of the game. We use a HashMap to store the number of neighbors for each cell, and apply the following rules:

If a live cell has exactly 2 or 3 live neighbors, it stays alive;

If a dead cell has exactly 3 live neighbors, it becomes alive.

After each iteration, we update the set with the new live cells.

### How to Test
You can compile with the command: ```javac ConwaysGameOfLife.java```
After compile, you can eddit the file text.txt with the input and run the program with: ```java ConwaysGameOfLife < test.txt```

For example, with the input:
```txt
#Life 1.06
4 5
5 6
6 4
6 5
6 6
```

the expected output is:
```txt
8 8
7 8
9 7
8 6
9 8
```
