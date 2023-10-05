# Tank Trouble

**Team Members:**
- Alec Chen
- Elisa Avalos
- Sydney Ohr

## Project Description
Tank Trouble is an exhilarating two-player 1v1 game where players take control of tanks, navigating a maze, and engage in heated battles to accumulate 10 points and emerge as the victor. This project was developed as part of the COMP 127 Object-Oriented Programming and Abstraction course at Macalester College.

**Gameplay Description:**
In Tank Trouble, players control tanks as they explore a maze, aiming to accumulate 10 points. The game offers [S,E,D,F] and [UP_ARROW, DOWN_ARROW, RIGHT_ARROW, LEFT_ARROW] for movement and keys [Q] and [M] for firing, letting players maneuver their tanks, avoid enemy fire, and aim precisely. It delivers engaging tank combat within a maze environment.

**Objective:**
The objective is to accumulate 10 points before your opponent does. Points are earned by successfully hitting your opponent's tank while avoiding being hit yourself. Tank Trouble is a test of skill and strategy as you aim to outwit your adversary in the maze.

**Technical Requirements:**
Java 17 is required to run this project, which utilizes the Kilt Graphics library.

## Getting Started

Follow these steps to run the game:

1. Clone the project repository from GitHub.

   ```shell
   git clone https://github.com/yourusername/TankTrouble.git
   ```

2. Open the project in your preferred Java development environment, such as VS Code.

3. Locate and run the TankTroubleGame class to set up and start the game.

## References
We drew inspiration from the classic Tank Trouble game, available [here](https://www.construct.net/en/free-online-games/tank-trouble-82/play).

Additional resources used in this project include:

- "Java Foundations Introduction to Program Design and Data Structures (5th Edition) (2019).pdf"
- Tank images from [OpenGameArt](https://lpc.opengameart.org/content/top-down-painted-tanks#comment-form)
- Opening screen image from [Construct.net](https://www.construct.net/en/free-online-games/tank-trouble-82/play)
- Trophy images from [Creazilla](https://creazilla.com/nodes/70434-trophy-clipart)

## Known Issues
While we've done our best to ensure a smooth gaming experience, here are some known issues:

- **Corner Glitch:** Occasionally, players can exploit a corner glitch, allowing tanks to partially overlap walls. Balls may also pass through corners.
- **Ball Escape:** In rare cases, balls may exit the maze when the canvas resets between rounds.
- **Instant Self-Kill:** Player 2 may lose a round instantly if a ball spawns in a specific location.
- **Rapid Ball Fire:** Shooting a ball during the round transition may result in immediate ball firing.
- **Performance Impact:** Excessive balls on-screen may lead to program crashes upon player-ball collisions.

### Societal Impact

- **Accessibility:** Tank Trouble is accessible to users with a computer and basic keyboard skills. However, it may pose challenges for visually-impaired individuals or those with physical disabilities that limit computer usage.

- **Ethical Considerations:** While the game itself is designed for entertainment, we acknowledge the potential for misuse or excessive competitiveness in multiplayer settings. We encourage responsible and fair gameplay.

## Acknowledgement
**Advisor:** Amin G. Alhashim
