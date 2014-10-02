package com.minesweeper.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.minesweeper.board.Box;
import com.minesweeper.board.test.BoardConsoleTest;
import com.minesweeper.board.test.BoxTest;
import com.minesweeper.game.test.GameConsoleTest;


@RunWith(Suite.class)
@SuiteClasses({ FactoryGameTest.class,BoardConsoleTest.class,GameConsoleTest.class,BoxTest.class})
public class AllTests {

}
