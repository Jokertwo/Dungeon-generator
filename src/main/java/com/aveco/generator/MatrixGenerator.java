package com.aveco.generator;

public interface MatrixGenerator {

    /**
     * String which represent the wall
     */
    String WALL = "#";
    /**
     * String which represent the barricade
     */
    String BARRICADE = "B";
    /**
     * String which represent the player
     */
    String PLAYER = "P";
    /**
     * String which represent the enemy
     */
    String ENEMY = "X";
    /**
     * String which represent the empty place
     */
    String EMPTY = " ";

    /**
     * Generate new matrix based on the size. Matrix has wall on the borders and contains barricades, one player and few enemies
     *
     * @param size size of matrix
     * @return return randomly created matrix
     */
    String[][] generateMatrix(Size size);
}
