package comp127.weather.widgets;

import comp127.weather.api.ForecastConditions;
import comp127.weather.api.WeatherData;
import edu.macalester.graphics.*;

import java.util.ArrayList;
import java.util.List;

public class AdvancedForecastWidget implements WeatherWidget {

    private final double size;
    private GraphicsGroup group;

    private GraphicsText date;
    private GraphicsText time;
    private GraphicsText humidity;
    private GraphicsText pressure;
    private GraphicsText cloudCoverage;
    private GraphicsText wind;

    private GraphicsGroup boxGroup;  

    private List<ForecastBox> boxes = new ArrayList<>();

    public AdvancedForecastWidget(double size) {
        this.size = size;

        group = new GraphicsGroup();
        
        time = new GraphicsText();
        time.setFont(FontStyle.BOLD, size * 0.05);
        group.add(time);

        pressure = new GraphicsText();
        pressure.setFont(FontStyle.PLAIN, size * 0.05);
        group.add(pressure);

        humidity = new GraphicsText();
        humidity.setFont(FontStyle.PLAIN, size * 0.05);
        group.add(humidity);

        date = new GraphicsText();
        date.setFont(FontStyle.BOLD, size * 0.05);
        group.add(date);

        cloudCoverage = new GraphicsText();
        cloudCoverage.setFont(FontStyle.PLAIN, size * 0.05);
        group.add(cloudCoverage);

        wind = new GraphicsText();
        wind.setFont(FontStyle.PLAIN, size * 0.05);
        group.add(wind);

        boxGroup = new GraphicsGroup();
        group.add(boxGroup);

        updateLayout();
    }

    @Override
    public GraphicsObject getGraphics() {
        return group;
    }

    public void update(WeatherData data) {

        boxes.clear();  
        boxGroup.removeAll();

        double x = size * 0.2, y = size * 0.85, width = size * 0.025, length = size * 0.05; 
        double spacing = size * 0.005;
        for (ForecastConditions condition : data.getForecasts()) {
            ForecastBox box = new ForecastBox(condition, x, y, width, length);
            x += width + spacing;
            if (x > size * 0.8) {
                y += length + spacing;
                x = size * 0.2;
            }
            boxGroup.add(box);
            boxes.add(box);
            selectForecast(box);
        } 

    }

    private void selectForecast(ForecastBox box) {
        for (ForecastBox eachBox: boxes) {
            eachBox.setActive(false);
        }
        box.setActive(true);

        ForecastConditions forecastConditions = box.getForecast();
        date.setText(FormattingHelpers.dateHelper(forecastConditions.getPredictionTime()));
        time.setText(FormattingHelpers.timeHelper(forecastConditions.getPredictionTime()));
        humidity.setText("Humidity: " + (FormattingHelpers.decimalHelper(forecastConditions.getHumidity()).toString()) + "%");
        pressure.setText("Pressure: " + (FormattingHelpers.decimalHelper(forecastConditions.getPressure()).toString()) + " hPa");
        cloudCoverage.setText("Cloud Coverage: " + (FormattingHelpers.decimalHelper(forecastConditions.getCloudCoverage()).toString())+ "%");
        wind.setText("Wind: " + FormattingHelpers.decimalHelper(forecastConditions.getWindSpeed()) + " mph, " +
        forecastConditions.getWindDirectionAsString());


        updateLayout();
    }

    private void updateLayout() {
       date.setCenter(date.getWidth()/2 + size * 0.03, date.getHeight()/2 + size * 0.025);
       time.setCenter(size * 0.97 - time.getWidth()/2, time.getHeight()/2 + size * 0.025);
       humidity.setCenter(size * 0.5, size * 0.5);
       pressure.setCenter(size * 0.5, size * 0.6);
       cloudCoverage.setCenter(size * 0.5, size * 0.4);
       wind.setCenter(size * 0.5, size * 0.7);
       boxGroup.setCenter(size * 0.5, size * 0.9);

    }

    /**
     * Given a position in the widget, this returns the ForecastBox at that position if one exists
     *
     * @param location pos to check
     * @return null if not over a forecast box
     */
    private ForecastBox getBoxAt(Point location) {
        GraphicsObject obj = group.getElementAt(location);
        if (obj instanceof ForecastBox) {
            return (ForecastBox) obj;
        }
        return null;
    }

    /**
     * Updates the currently displayed forecast information as the mouse moves over the widget.
     * If there is not a ForecastBox at that position, the display does not change.
     */
    @Override
    public void onHover(Point position) {
        ForecastBox boxAtPosition = getBoxAt(position);
        if (boxAtPosition != null) {
            selectForecast(boxAtPosition);
        }
    }
}
