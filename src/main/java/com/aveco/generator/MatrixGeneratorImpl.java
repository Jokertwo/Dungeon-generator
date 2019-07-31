package com.aveco.generator;

import java.util.Random;

public class MatrixGeneratorImpl implements MatrixGenerator {

    private Random random = new Random();
    private Size size;


    @Override
    public String[][] generateMatrix(Size size) {
        this.size = size;
        String[][] place = new String[size.getColumn()][size.getRow()];
        //create walls
        place = createWalls(place);

        // create barricade
        for (int i = 0; i < size.getBlocks(); i++) {
            int startX = random.nextInt(size.getColumn() - size.getBlockSize()) + 1;
            int startY = random.nextInt(size.getRow() - size.getBlockSize()) + 1;
            int endX = startX + random.nextInt(size.getBlockSize());
            int endY = startY + random.nextInt(size.getBlockSize());
            place = createBarricade(place, startX, endX, startY, endY);
        }

        // put player
        putPerson(PLAYER, place);

        for (int i = 0; i < size.getEnamys(); i++) {
            putPerson(ENEMY, place);
        }


        return place;
    }

    /**
     * Put person randomly into the matrix
     *
     * @param person inserted person
     * @param place  matrix
     * @return return matrix with person
     */
    private String[][] putPerson(String person, String[][] place) {
        boolean isOk = false;
        while (!isOk) {
            int x = random.nextInt(size.getRow() - 2) + 1;
            int y = random.nextInt(size.getColumn() - 2) + 1;
            if (!place[x][y].equals(BARRICADE)
                    && !place[x + 1][y].equals(BARRICADE)
                    && !place[x][y + 1].equals(BARRICADE)
                    && !place[x - 1][y].equals(BARRICADE)
                    && !place[x][y - 1].equals(BARRICADE)) {
                place[x][y] = person;
                isOk = true;
            }
        }
        return place;
    }

    /**
     * Create wall on the boarder of matrix
     *
     * @param place matrix where should be created the walls
     * @return matrix with walls
     */
    private String[][] createWalls(String[][] place) {
        for (int i = 0; i < place.length; i++) {
            for (int j = 0; j < place[i].length; j++) {
                if (i == 0 || i == place.length - 1 || j == 0 || j == place.length - 1) {
                    place[i][j] = WALL;
                } else {
                    place[i][j] = EMPTY;
                }
            }
        }
        return place;
    }

    /**
     * Create barricade inside the matrix
     *
     * @param place  matrix where should be the barricade created
     * @param startX where the barricade starts (X axis)
     * @param endX   where the barricade ends (X axis)
     * @param startY where the barricade starts (Y axis)
     * @param endY   where the barricade ends (Y axis)
     * @return return matrix with created barricade
     */
    private String[][] createBarricade(String[][] place, int startX, int endX, int startY, int endY) {
        for (int i = startX; i < endX; i++) {
            for (int j = startY; j < endY; j++) {
                place[i][j] = BARRICADE;
            }
        }
        return place;
    }


    public static void main(String[] args) {
        MatrixGenerator generator = new MatrixGeneratorImpl();
        String[][] map = generator.generateMatrix(Size.MEDIUM);

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
