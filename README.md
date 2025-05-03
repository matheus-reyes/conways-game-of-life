# conways-game-of-life
Conway's Game of Life implementation in 64-bit signed integer space.

Each cell's value changes according to the following:
● If an "alive" cell has less than 2 or more than 3 alive neighbors (in any of the 8
surrounding cells), it becomes dead.
![image](https://github.com/user-attachments/assets/c66a99b3-c18b-4c2c-9524-c7aae2b07979)
![image](https://github.com/user-attachments/assets/3635e26d-8731-453b-8c27-38e49251d637)

● If a "dead" cell had *exactly* 3 alive neighbors, it becomes alive.
![image](https://github.com/user-attachments/assets/f0a73029-4dcd-4c3c-ba1d-5acd3e9ea84c)
