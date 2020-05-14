# Chrome Dino Game
This is a t-rex game programmed in java. It is similar to the google chrome’s dino game. The project involves use of java.awt package. When the game is started, a game thread is executed which updates the sprite's position and score and draw it on the game window.

### Java Version Used: 
Java SE 13

### IDE Used: 
Eclipse 2019-12

## Code Architecture
![Code_Architecture_Image](/Docs/architecture.jpg)
In the above flow diagram, the rectangles represent the packages that were created in the program and the circles represent the various classes that belong to that particular package.

## Flow of Program
1. GameWindow class is the class containing the main method. It initialises the GameScreen and starts the game thread.
1. Then GameScreen class initialises the various sprites namely land, dino, clouds and cactus.
1. The thread updates and draws the sprite on the game window at certain intervals.
1. In Dino class, for different postures of dino to see him running, Animation class is used which chooses a dino image from an array list.
1. For different types of cacti to appear, an array list is used.
1. Score is also updated by the thread along with sprites.
1. When the game is over and is restarted, a restart method is used to initialise all the objects as their original values.

## Output

### Start Screen
![Start_Screen_Image](/Docs/start_screen.jpg)

### Running Screen
![Running_Screen_Image](/Docs/running_screen.jpg)

### Jumping Screen
![Jumping_Screen_Image](/Docs/jumping_screen.jpg)

### Bending Screen
![Bending_Screen_Image](/Docs/bending_screen.jpg)

### Game Over Screen
![Game_Over_Screen_Image](/Docs/game_over_screen.jpg)
