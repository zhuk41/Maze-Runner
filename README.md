[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/8jM7fhXE)
# Assignment A3 - Maze Runner

  * **Student**: [Kevin Zhu](zhuk41@mcmaster.ca)
  * **Program**: B. Eng. In Software Engineering
  * **Course code**: SFWRENG 2AA4
  * **Course Title**: Software Design I - Introduction to Software Development 
  * Term: *Level II - Winter 2024*

## Business Logic Specification

This program explores a maze, finding a path from an entry point to an exit one.

- The maze is stored in a text file, with `#` representing walls and `␣` (_empty space_) representing passages.
- You’ll find examples of such mazes in the [`examples`](./examples) directory. 
    - You can also use the [Maze Generator](https://github.com/ace-lectures/maze-gen) to generate others.
- The Maze is surrounded by walls on its four borders, except for its entry/exit points.
    - Entry and exit points are always located on the East and West border.
    - The maze is not directed. As such, exit and entry can be interchanged.
- At the beginning of the exploration, we're located on the entry tile, facing the opposite side (e.g., if entering by the eastern entry, you're facing West).
- The program generates a sequence of instructions to reach the opposite exit (i.e., a "path"):
    - `F` means 'move forward' according to your current direction
    - `R` means 'turn right' (does not move, just change direction), and `L` means ‘turn left’. 
- A canonical path contains only `F`, `R` and `L` symbols
- A factorized path squashes together similar instructions (i.e., `FFF` = `3F`, `LL` = `2L`).
- Spaces are ignored in the instruction sequence (only for readability: `FFLFF` = `FF L FF`)
- The program takes as input a maze and print the path on the standard output.


## How to run this software?

To build the program, simply package it with Maven:

```
% mvn -q clean package 
%
```

When called on a non-existing file, it stops and ends.

```
% java -jar target/mazerunner.jar -i ./examples/medium.maz.txtd
[INFO ] Main ** Starting Maze Runner
[INFO ] Controller **** Reading the maze from file medium.maz.txtd
[ERROR] Controller /!\ An error has happened /!\
[INFO ] Controller Invalid Maze file
[INFO ] Controller **** No Maze Found
[INFO ] Main ** End of MazeRunner
%
```


### Command line arguments

The program uses the following flags:

- `-i MAZE_FILE`: specifies the filename to be used.
- `-p PATH_SEQUENCE`: activates the path verification mode to validate that PATH_SEQUENCE is correct for the maze
- `-method {bfs, righthand}`: specifies which path computation method to use.
- `-baseline {bfs, righthand}`: if provided with -method will return time taken to run both methods and speedup based on number of path steps reduced.
#### Examples

When no logs are activated, the programs only print the computed path on the standard output.

```
% java -jar target/mazerunner.jar -i ./examples/straight.maz.txt -method bfs
** Path: FFFF
** Factorized Path: "4F"
%
```

If a given path is correct, the program prints the message `*** Path is Correct` on the standard output.

```
% java -jar target/mazerunner.jar -i ./examples/straight.maz.txt -p 4F
** Path is Correct
%
```

If a given path is incorrect, the program prints the message `*** Path is Incorrect` on the standard output.

```
% java -jar target/mazerunner.jar -i ./examples/straight.maz.txt -p 3F
*** Path is Incorrect
%
```
If given both a method and baseline it will return runtimes and compare path length(Speedup).

```
% java -jar target/mazerunner.jar -i ./examples/medium.maz.txt -method bfs -baseline righthand
Time taken to create maze: 8.04ms
Time taken to solve maze with bfs: 1.98ms
Time taken to solve maze with righthand: 4.60ms
Speedup: 7.23
%
```