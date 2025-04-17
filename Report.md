# News App

A simple Java-based **CLI application** that fetches and displays news articles using the NewsAPI. The app allows users to view a list of news titles and select a specific article to see its full details.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Setup](#setup)
- [Project Structure](#project-structure)
- [Dependencies](#dependencies)
- [Usage](#usage)


## Features

- Fetches news articles from the NewsAPI.
- Displays a list of news titles.
- Allows users to view detailed information about a selected news article.
- Uses `org.json` for JSON parsing and `HttpClient` for making HTTP requests.

## Prerequisites

- Java 11 or higher  
- Gradle  
- A valid NewsAPI key (replace the placeholder in the code with your API key)

## Setup



1. Add your NewsAPI key in the `Infrastructure` class:
   ```java
   String api = "your_api_key_here";
   ```

2. Build the project using Gradle:
   ```bash
   gradle build
   ```

3. Run the application:
   ```bash
   gradle run
   ```

## Project Structure

- `src/main/java/AP/News.java`: Represents a news article with attributes like title, author, description, etc.
- `src/main/java/AP/Infrastructure.java`: Handles fetching and parsing news data from the NewsAPI.
- `src/main/java/AP/Main.java`: Contains the main menu and application logic.
- `build.gradle`: Gradle build file for managing dependencies and configurations.

## Dependencies

The project uses the following dependencies:

- `org.json:json:20211205` – For JSON parsing.
- `org.junit.jupiter:junit-bom:5.9.1` – For testing (if needed).

## Usage

1. Run the application.
2. View the list of news titles.
3. Enter the number corresponding to a news article to view its full details.
