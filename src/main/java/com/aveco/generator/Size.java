package com.aveco.generator;

public enum Size {
    SMALL(32, 32, 4, 4, 15),
    MEDIUM(64, 64, 8, 8, 30),
    BIG(128, 128, 12, 15, 60),
    HUGE(256, 256, 20, 15, 80);

    private int column;
    private int row;
    private int enamys;
    private int blocks;
    private int blockSize;

    Size(int column, int row, int enamys, int blocks, int blockSize) {
        this.column = column;
        this.row = row;
        this.enamys = enamys;
        this.blocks = blocks;
        this.blockSize = blockSize;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public int getEnamys() {
        return enamys;
    }

    public int getBlocks() {
        return blocks;
    }

    public int getBlockSize() {
        return blockSize;
    }
}
