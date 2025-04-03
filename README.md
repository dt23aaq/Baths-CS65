# Battles and the High Seas (BATH):Naval Warfare Java Game

## Project Overview

BATHS is a naval warfare simulation game set during the Napoleonic era, where players take on the role of the Admiral of the Blue. The game challenges players to strategically manage a naval squadron, fight encounters, and maintain their war chest.

## Features

- Single-player naval warfare simulation
- Strategic ship management
- Encounter-based gameplay
- Dynamic war chest management
- Multiple ship types (Man-O-War, Frigate, Sloop)

## Prerequisites

- Java Development Kit (JDK) 11 or higher
- NetBeans IDE (recommended)
- Git

## Installation

1. Clone the repository:
```bash
git clone https://github.com/your-username/BATHS-Naval-Game.git
```

2. Open the project in NetBeans:
- File > Open Project
- Navigate to the cloned repository
- Select the project

## Game Mechanics

### Ship Management
- Commission ships from reserve fleet
- Decommission ships to recover funds
- Manage squadron composition

### Encounters
- Fight various encounter types (Blockade, Battle, Skirmish)
- Win prize money
- Risk losing ships

### War Chest
- Start with 1000 pounds
- Earn/lose money through encounters
- Manage financial resources strategically

## How to Play

1. Start the game
2. Select encounters by number
3. Choose ships for encounters
4. Manage your squadron and war chest
5. Aim to complete all encounters with money remaining

## Project Structure

```
BATHS-Naval-Game/
│
├── src/
│   ├── main/java/
│   │   └── baths/
│   │       ├── Ship.java
│   │       ├── ManOWar.java
│   │       ├── Frigate.java
│   │       ├── Sloop.java
│   │       ├── Encounter.java
│   │       └── BATHSGame.java
│   │
│   └── test/java/
│       └── baths/
│           └── BATHSGameTest.java
│
├── README.md
└── LICENSE
```

## Testing

Run unit tests using NetBeans' built-in testing framework or via command line:

```bash
mvn test
```

## Contributors

- Samson Fabiyi
- Darrel Toledo
- Mihai Lucian Stoica


## Future Enhancements

- Multiplayer functionality
- More ship types
- Random encounter generation
- Advanced battle mechanics
- User interface improvements

## Acknowledgements

- University of Hertfordshire
- Course CS65 Project Team
```

Key aspects of this README:

1. Comprehensive project description
2. Installation instructions
3. Game mechanics overview
4. Project structure
5. How to play
6. Contributors
7. Future plans

Would you like me to modify anything to better suit your specific project?
