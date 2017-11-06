package com.nanobi.calcite;


import org.apache.calcite.jdbc.CalciteConnection; 
import org.apache.calcite.linq4j.tree.Types; 
import org.apache.calcite.schema.SchemaPlus; 
import org.apache.calcite.schema.TableFunction; 
import org.apache.calcite.schema.impl.AbstractSchema; 
import org.apache.calcite.schema.impl.TableFunctionImpl; 
import org.junit.Test;

import java.lang.reflect.Method; 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 

import static org.hamcrest.CoreMatchers.is; 

 
/**
 * Unit tests for example user-defined functions. 
 */ 
public class ExampleFunctionTest { 
  public static final Method MAZE_METHOD = 
      Types.lookupMethod(MazeTable.class, "generate", int.class, int.class, 
          int.class); 
  public static final Method SOLVE_METHOD = 
      Types.lookupMethod(MazeTable.class, "solve", int.class, int.class, 
          int.class); 
 
  /** Unit test for {@link MazeTable}. */ 
  @Test public void testMazeTableFunction() 
      throws SQLException, ClassNotFoundException { 
    final String maze = "" 
        + "+--+--+--+--+--+\n" 
        + "|        |     |\n" 
        + "+--+  +--+--+  +\n" 
        + "|     |  |     |\n" 
        + "+  +--+  +--+  +\n" 
        + "|              |\n" 
        + "+--+--+--+--+--+\n"; 
    checkMazeTableFunction(false, maze); 
  } 
 
  /** Unit test for {@link MazeTable}. */ 
  @Test public void testMazeTableFunctionWithSolution() 
      throws SQLException, ClassNotFoundException { 
    final String maze = "" 
        + "+--+--+--+--+--+\n" 
        + "|*  *    |     |\n" 
        + "+--+  +--+--+  +\n" 
        + "|*  * |  |     |\n" 
        + "+  +--+  +--+  +\n" 
        + "|*  *  *  *  * |\n" 
        + "+--+--+--+--+--+\n"; 
    checkMazeTableFunction(true, maze); 
  } 
 
  public void checkMazeTableFunction(Boolean solution, String maze) 
      throws SQLException, ClassNotFoundException { 
    Connection connection = DriverManager.getConnection("jdbc:calcite:"); 
    CalciteConnection calciteConnection = 
        connection.unwrap(CalciteConnection.class); 
    SchemaPlus rootSchema = calciteConnection.getRootSchema(); 
    SchemaPlus schema = rootSchema.add("s", new AbstractSchema()); 
    final TableFunction table = TableFunctionImpl.create(MAZE_METHOD); 
    schema.add("Maze", table); 
    final TableFunction table2 = TableFunctionImpl.create(SOLVE_METHOD); 
    schema.add("Solve", table2); 
    final String sql; 
    if (solution) { 
      sql = "select *\n" 
          + "from table(\"s\".\"Solve\"(5, 3, 1)) as t(s)"; 
    } else { 
      sql = "select *\n" 
          + "from table(\"s\".\"Maze\"(5, 3, 1)) as t(s)"; 
    } 
    ResultSet resultSet = connection.createStatement().executeQuery(sql); 
    final StringBuilder b = new StringBuilder(); 
    while (resultSet.next()) { 
      b.append(resultSet.getString(1)).append("\n"); 
    } 
    System.out.println(b.toString());
   // assertThat(b.toString(), is(maze)); 
  } 
} 
 
// End ExampleFunctionTest.java


 