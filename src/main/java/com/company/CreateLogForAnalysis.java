package com.company;

import wagu.Block;
import wagu.Board;
import wagu.Table;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

class CreateLogForAnalysis {

    static int counter = 0;
    static List<List<String>> rowList = new ArrayList<>();

    private CreateLogForAnalysis() {
    }

    static void addListItem(List<String> listItem) {
        rowList.add(listItem);
    }

    static void createTable(List<List<String>> rowsList) {
        List<String> headerList = asList("SQL Query", "Database", "Execution Time");
        Board board = new Board(150);
        Table table = new Table(board, 150, headerList, rowsList);
        Block tableBlock = table.tableToBlocks();
        board.setInitialBlock(tableBlock);
        board.build();
        String tableString = board.getPreview();
        try {
            File file = new File("test1.txt");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(tableString);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
