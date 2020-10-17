# Clacker
This is a dice rolling simulation written for my computer science class which is done in Java. The program utilizes fundamental programming concepts such as variables, if statements, loops, input, ArrayLists and functions. 

# How to play the game
-The initial board will be an ArrayList of integers between 1 and 12. <br>
-The user will first be asked to input their name and how many simulations they want to attempt. For each simulation, two dices will be rolled. <br>
-If the results of the rolls are 3 and 5, the ArrayList will replace those numbers with a -1, symbolizing that they've been removed. <br>
-If any particular number is already covered, nothing will happen. However, if BOTH numbers are covered and the sum of the numbers is greater than 6, the sum is then used to replace numbers from 7 to 12 in the ArrayList. <br>
-The game will terminate if the entire board has been filled up. The user will then be asked if they would like to play again. <br>
-If all simulation attempts have been used up, the game will ask the user to input how many more attempts they would like to try. The game does not terminate until the entire board has been filled up. 

# Scoring system
For every simulation, the program will print out the score and the number of rolls left in this format.

Score: <score> <br>
"Rolls left: " + <rolls_left>

