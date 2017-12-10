package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import parseur.ParsingGrib;

class TestReadParsing {

  @Test
  void test() {
    ParsingGrib pg = new ParsingGrib();
    pg.exportByte();
    assert (true);
  }

}
