# Tic-Tac-Toe
Terminal based Tic-Tac-Toe game with a 3x3 gameboard.

When first starting the game, the board should be empty and the program should ask the first player for input.

```swift
                [   ] [   ] [   ]
                [   ] [   ] [   ]
                [   ] [   ] [   ]

> Player 1, enter a position (1-9):
```

The position inputed should be between 1 and 9 and represents the tile the user wants to mark. The tiles should be positioned as:

```swift

                  [ 1 ] [ 2 ] [ 3 ]
                  [ 4 ] [ 5 ] [ 6 ]
                  [ 7 ] [ 8 ] [ 9 ]
```

When a player has chosen a tile, that tile should be marked. For example:

```swift
                [   ] [   ] [   ]
                [   ] [   ] [   ]
                [   ] [   ] [   ]

> Player 1, enter a position (1-9): 1

                [ x ] [   ] [   ]
                [   ] [   ] [   ]
                [   ] [   ] [   ]

> Player 2, enter a position (1-9):
```

A user should not be able to place a mark on an already marked tile.
```swift
                [ x ] [   ] [   ]
                [   ] [   ] [   ]
                [   ] [   ] [   ]

> Player 2, enter a position (1-9): 1
> Sorry, that tile is taken. Try again:
```

The first player who successfully places three marks on horizontal, vertical, or diagonal row wins the game.


Let player 1 have the mark ``x`` and player two be ``o``.

**Voluntary extensions**:
* An initial main screen where the user can either start a new game or quit the game.
* When the game is over, the user should be prompted to start a new game, or quit (perhaps even go back to the main screen described above).
* 3D graphics & sound effects.
* Multiplayer over the internet.
* AI.
