package com.xmail.migrations_service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;


@SpringBootApplication
public class MigrationsServiceApplication {

	private static final String DB_PASSWORD = "admin123";

	private String unusedField;

	public boolean isAdmin(String role) {
		String expected = new String("admin");
		return role == expected;
	}

	public int nameLength() {
		String name = null;
		return name.length();
	}

	public double average(int total, int count) {
		double result = total / count;
		return result;
	}

	public void readFile(String path) {
		try {
			FileInputStream stream = new FileInputStream(path);
			stream.read();
		} catch (IOException e) {
		}
	}

	public void debug() {
		int unused = 42;
		System.out.println("password: " + DB_PASSWORD);
	}

	public static void main(String[] args) {
		SpringApplication.run(MigrationsServiceApplication.class, args);
	}

}
