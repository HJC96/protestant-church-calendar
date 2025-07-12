# Protestant Church Calendar (Library)

A simple library for calculating and managing dates in the Protestant church calendar.

## Usage

This project is intended to be used as a library in other Java projects.

### Adding to your project

#### Gradle

Add the following to your `build.gradle` file:

```groovy
repositories {
    mavenCentral() // Or your preferred repository if published there
}

dependencies {
    implementation 'com.jc.protestantcalendar:protestant-church-calendar:1.0.0' // Replace with actual group, artifact, version
}
```

#### Maven

Add the following to your `pom.xml` file:

```xml
<dependency>
    <groupId>com.jc.protestantcalendar</groupId>
    <artifactId>protestant-church-calendar</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Example Usage (Java - using Interfaces)

```java
// Instantiate services
com.jc.protestantcalendar.LiturgicalCalculator calculator = new com.jc.protestantcalendar.LiturgicalCalculator.LiturgicalCalculator(ResourceBundle.getBundle("messages", Locale.ENGLISH));
com.jc.protestantcalendar.ILiturgicalCalendarService calendarService = new com.jc.protestantcalendar.LiturgicalCalendarService(calculator);

// Get liturgical days for a year
calculator.calculate(2025);

// Get liturgical week for a specific date
calendarService.getLiturgicalWeekFor(LocalDate.now());

// Get upcoming feasts
calendarService.getUpcomingFeasts(LocalDate.now(), 5);
```
## License

This project is licensed under the Apache License 2.0. See the [LICENSE](LICENSE) file for details.
