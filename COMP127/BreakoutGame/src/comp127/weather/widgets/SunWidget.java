package comp127.weather.widgets;

import comp127.weather.api.WeatherData;
import edu.macalester.graphics.*;

import java.awt.Color;

/**
 * A widget that displays the current temperature, and the current conditions as an icon and a string.
 *
 * @author Original version created by by Daniel Kluver on 10/6/17.
 */
public class SunWidget implements WeatherWidget {
    private final double size;
    private GraphicsGroup group;

    private GraphicsText sunrise;
    private GraphicsText sunset;
    private GraphicsText city;
    private Ellipse sun;
    private Ellipse darkSun;
    private GraphicsText sunriseLabel;
    private GraphicsText sunsetLabel;
    

    /**
     * Creates a temperature widget of dimensions size x size displaying sunrise and sunset times.
     */
    public SunWidget(double size) {
        this.size = size;

        group = new GraphicsGroup();

        sun = new Ellipse(size * 0.25, size * 0.4, size * 0.1, size * 0.1);
        sun.setFillColor(Color.YELLOW);
        group.add(sun);

        sunriseLabel = new GraphicsText();
        sunriseLabel.setFont(FontStyle.PLAIN, size * 0.1);
        group.add(sunriseLabel);

        sunrise = new GraphicsText();
        sunrise.setFont(FontStyle.BOLD, size * 0.1);
        group.add(sunrise);

        sunsetLabel = new GraphicsText();
        sunsetLabel.setFont(FontStyle.PLAIN, size * 0.1);
        group.add(sunsetLabel);

        sunset = new GraphicsText();
        sunset.setFont(FontStyle.BOLD, size * 0.1);
        group.add(sunset);

        darkSun = new Ellipse(size * 0.25, size * 0.4, size * 0.1, size * 0.1);
        darkSun.setFillColor(Color.BLACK);
        darkSun.setStrokeColor(Color.RED);
        group.add(darkSun);

        city = new GraphicsText();
        city.setFont(FontStyle.PLAIN, size * 0.05);
        group.add(city);

        updateLayout();
    }

    @Override
    public GraphicsObject getGraphics() {
        return group;
    }

    public void update(WeatherData data) {
               
        sunriseLabel.setText("Sunrise:");
        sunrise.setText(FormattingHelpers.TIME_OF_DAY.format(data.getCurrentConditions().getSunriseTime()));
        sunsetLabel.setText("Sunset:");
        sunset.setText(FormattingHelpers.TIME_OF_DAY.format(data.getCurrentConditions().getSunsetTime()));
        city.setText(data.getCityName());

        updateLayout();
    }

    private void updateLayout() {
        sun.setCenter(size * 0.3, size * 0.24);

        sunriseLabel.setCenter(size * 0.56, size * 0.25);
       
        sunrise.setCenter(size * 0.5, size * 0.4);

        darkSun.setCenter(size * 0.3, size * 0.6);

        sunsetLabel.setCenter(size * 0.56, size * 0.6);

        sunset.setCenter(size * 0.5, size * 0.75);

        city.setCenter(size * 0.5, size * 0.95);
    }

    @Override
    public void onHover(Point position) {
    }
}