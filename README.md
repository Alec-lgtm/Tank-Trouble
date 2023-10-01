# Tank Trouble!

### Team members

- Alec G Chen
- Elisa Avalos
- Sydney Ohr

### Project Description

> One sentence summmary: Tank Trouble is a two player 1v1 game that allows users to control and fire a tank while navigating a maze, and the first user to reach 10 points wins.

> Technical Guide: Our code requires Java 17 to use Kilt Graphics.

> Running the code: To run the program, fork the code from GitHub and open it on VS Code. The main class that sets up and runs the game is TankTroubleGame.

References: 

- Inspiration for our project: https://www.construct.net/en/free-online-games/tank-trouble-82/play

- Java Foundations Introduction to Program Design and Data Structures (5th Edition) (2019).pdf
 
- Tank images from https://lpc.opengameart.org/content/top-down-painted-tanks#comment-form

- Opening screen image from https://www.construct.net/en/free-online-games/tank-trouble-82/play

- Trophy images from https://creazilla.com/nodes/70434-trophy-clipart

### Known Issues
There is a corner glitch in which the user is able to run the tank slightly over the corner of the wall and sometimes the balls go through the corner. There is a possibility that the balls may find their way out of the maze when the canvas resets for the next round. The balls run along the edge of the maze but don’t affect the performance of the game. A rare bug the program has is that player 2 may lose the round the instant they shoot a ball due to spawning location of the ball (instant self-kill). Also, if a tank shoots a ball during the pause between rounds, a ball may be fired as soon as the game runs. If there are too many balls on the screen, on player-ball collision, the program may crash.

### Societal Impact
- Restrictions: There are no restrictions on people who can play Tank Trouble. Though, it may be diffcult for the visually-impaired and people who are physically unable to use a keyboard/computer to play the game.

- Access: Game access is limited to people who have access to a computer. 

- Ethics: It is hard to think of ways our game can be used in a malicious/oppressive way, but we won’t rule out the possibility that it can be used in that kind of manner. 
