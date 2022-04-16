package comp127.weather.widgets;

import comp127.weather.api.ForecastConditions;
import comp127.weather.api.WeatherData;
import edu.macalester.graphics.*;

import java.util.ArrayList;
import java.util.List;

public class ForecastWidget implements WeatherWidget {

    private final double size;
    private GraphicsGroup group;

    private GraphicsText temp;
    private GraphicsText date;
    private GraphicsText time;
    private GraphicsText tempRange;
    private GraphicsText description;
    private Image icon;

    private GraphicsGroup boxGroup;  

    private List<ForecastBox> boxes = new ArrayList<>();

    /**
     * Creates a forecast widget of dimensions size x size.
     */
    public ForecastWidget(double size) {
        this.size = size;

        group = new GraphicsGroup();

        temp = new GraphicsText();
        temp.setFont(FontStyle.BOLD, size * 0.05);
        group.add(temp);

        date = new GraphicsText();
        date.setFont(FontStyle.PLAIN, size * 0.05);
        group.add(date);

        time = new GraphicsText();
        time.setFont(FontStyle.PLAIN, size * 0.05);
        group.add(time);

        tempRange = new GraphicsText();
        tempRange.setFont(FontStyle.PLAIN, size * 0.05);
        group.add(tempRange);

        description = new GraphicsText();
        description.setFont(FontStyle.PLAIN, size * 0.05);
        group.add(description);

        icon = new Image(0, 0);
        icon.setMaxWidth(size * 0.3);
        icon.setMaxHeight(size * 0.3);
        group.add(icon);

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
        temp.setText(FormattingHelpers.decimalHelper(forecastConditions.getTemperature())+ "\u2109");
        tempRange.setText(FormattingHelpers.decimalHelper(forecastConditions.getMinTemperature()) + " \u2109 " + "| " +
        FormattingHelpers.decimalHelper(forecastConditions.getMaxTemperature()) + " \u2109 ");
        description.setText(forecastConditions.getWeatherDescription());
        icon.setImagePath(forecastConditions.getWeatherIcon());

        updateLayout();
    }

    private void updateLayout() {
       date.setCenter(date.getWidth()/2 + size * 0.03, date.getHeight()/2 + size * 0.025);
       time.setCenter(size * 0.97 - time.getWidth()/2, time.getHeight()/2 + size * 0.025);
       temp.setCenter(size * 0.5, size * 0.5);
       icon.setCenter(size * 0.5, size * 0.3);
       tempRange.setCenter(size * 0.5, size * 0.6);
       description.setCenter(size * 0.5, size * 0.7);
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
