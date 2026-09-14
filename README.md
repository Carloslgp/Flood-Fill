# Flood Fill Algorithm Implementation in Java

This repository contains an implementation of the Flood Fill algorithm, developed as part of the Structured Problem Solving in Computing course. The project demonstrates filling an area of an image starting from a seed point, using Queue and Stack data structures to manage the pixels to be processed.

## Overview

Flood Fill is an algorithm that determines and changes the color of a connected area of pixels in an image. This implementation was designed to fill a PNG image with solid colors, generating an animation of the filling process.

The project includes custom implementations of the Queue and Stack data structures, as required by the coursework.

![Flood Fill animation](animacao.gif)

## How to Run

### Prerequisites

* **Java Development Kit (JDK)** installed.
* **(Optional) FFmpeg** to generate a video animation from the frames.

### Running the Project

1.  **Clone the repository:**
    ```bash
    git clone <REPOSITORY_URL>
    cd <DIRECTORY_NAME>
    ```

2.  **Compile the Java files:**
    From the project root directory, run:
    ```bash
    javac -d . src/Main.java src/FloodFill/*.java src/Queue/*.java src/Stack/*.java
    ```

3.  **Run the program:**
    ```bash
    java Main
    ```
    The program will start processing the image and saving the frames into the `frames/` folder.

### Switching the Algorithm (Queue vs. Stack)

To switch between Queue and Stack, edit `src/Main.java` and change the method call:

* **To use the Queue (default):**
    ```java
    floodFill2.FillQueue();
    ```

* **To use the Stack:**
    ```java
    floodFill2.FillStack();
    ```

### Generating the Animation

After running the program, the `frames/` folder will contain all the generated images.
