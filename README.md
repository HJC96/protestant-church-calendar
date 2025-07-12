# Protestant Church Calendar (Library)

A simple library for calculating and managing dates in the Protestant church calendar.

## Usage

This project is intended to be used as a library in other Java/Gradle projects.

### Adding to your Gradle project

Add the following to your `build.gradle` file:

```groovy
repositories {
    mavenCentral() // Or your preferred repository if published there
}

dependencies {
    implementation 'com.jc.protestantcalendar:protestant-church-calendar:1.0.0' // Replace with actual group, artifact, version
}
```

### Example Usage (Java)

```java
import com.jc.protestantcalendar.LiturgicalCalculator;
import com.jc.protestantcalendar.LiturgicalDay;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public class MyCalendarApp {
    public static void main(String[] args) {
        LiturgicalCalculator calculator = new LiturgicalCalculator(Locale.ENGLISH);
        List<LiturgicalDay> days = calculator.calculate(2025);

        for (LiturgicalDay day : days) {
            System.out.println(day.getName() + ": " + day.getDate());
        }
    }
}
```

## Building from Source

To build the library from source, navigate to the project root and run:

```bash
./gradlew build
```

This will generate the JAR file in the `build/libs` directory.

## License

This project is licensed under the Apache License 2.0. See the [LICENSE](LICENSE) file for details.
