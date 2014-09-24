package com.minesweeper.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.minesweeper.board.test.BoardConsoleTest;
import com.minesweeper.game.test.GameConsoleTest;

@RunWith(Suite.class)
@SuiteClasses({ BoardConsoleTest.class,GameConsoleTest.class })
public class AllTests {

}
