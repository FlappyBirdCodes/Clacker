# Clacker
This is a dice rolling simulation written for my computer science class which is done in Java. The program utilizes fundamental programming concepts such as variables, if statements, loops, input, ArrayLists and functions. 

# How to play the game
-The initial board will be an ArrayList of integers between 1 and 12. 
-The user will first be asked to input how many simulations they want to attempt. For each simulation, two dices will be rolled.
-If the results of the rolls are 3 and 5, the ArrayList will replace those numbers with a -1, symbolizing that they've been removed. 
-If any particular number is already covered, nothing will happen. However, if BOTH numbers are covered and the sum of the numbers is greater than 6, the sum is then used to replace numbers from 7 to 12 in the ArrayList. 
-The game will terminate if the entire board has been filled up. The user will then be asked if they would like to play again.
-If all simulation attempts have been used up, the game will prompt the user

