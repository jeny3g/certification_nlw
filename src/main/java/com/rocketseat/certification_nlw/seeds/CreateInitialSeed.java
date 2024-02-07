package com.rocketseat.certification_nlw.seeds;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class CreateInitialSeed {

  private final JdbcTemplate jdbcTemplate;

  public CreateInitialSeed(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }

  public static void main(String[] args) {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.postgresql.Driver");
    dataSource.setUrl("jdbc:postgresql://localhost:5434/pg_nlw");
    dataSource.setUsername("admin");
    dataSource.setPassword("admin");

    CreateInitialSeed createInitialSeed = new CreateInitialSeed(dataSource);

    createInitialSeed.run();
  }

  public void run(String ...args) {
    executeSqlFile("src/main/resources/create.sql");
  }

  private void executeSqlFile(String filePath) {
    try {
      String sqlScript = new String(Files.readAllBytes(Paths.get(filePath)));

      jdbcTemplate.execute(sqlScript);

      System.out.println("File " + filePath + " executed successfully");
    } catch (IOException e) {
      System.out.println("Error reading file: " + filePath);
      e.printStackTrace();
    }
  }
}
