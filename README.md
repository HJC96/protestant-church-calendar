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
import com.jc.protestantcalendar.ILiturgicalCalculator;
import com.jc.protestantcalendar.ILiturgicalCalendarService;
import com.jc.protestantcalendar.LiturgicalCalculator;
import com.jc.protestantcalendar.LiturgicalCalendarService;

import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;

// Instantiate services
ResourceBundle messages = ResourceBundle.getBundle("messages", Locale.ENGLISH);
ILiturgicalCalculator calculator = new LiturgicalCalculator(messages);
ILiturgicalCalendarService calendarService = new LiturgicalCalendarService(Locale.ENGLISH, calculator);

// Get liturgical days for a year
calculator.calculate(2025);

// Get liturgical week for a specific date
calendarService.getLiturgicalWeekFor(LocalDate.now());

// Get upcoming feasts
calendarService.getUpcomingFeasts(LocalDate.now(), 5);
```

## Building from Source

To build the library from source, navigate to the project root and run:

```bash
./gradlew build
```

This will generate the JAR file in the `build/libs` directory.

## License

This project is licensed under the Apache License 2.0. See the [LICENSE](LICENSE) file for details.
