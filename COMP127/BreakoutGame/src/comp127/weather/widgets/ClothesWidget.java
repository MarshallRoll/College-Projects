package comp127.weather.widgets;

import comp127.weather.api.CurrentConditions;
import comp127.weather.api.WeatherData;
import edu.macalester.graphics.*;


/**
 * A widget that displays the current temperature and provides an outfit recommendation.
 *
 * @author Marshall Roll
 */
public class ClothesWidget implements WeatherWidget{
    private final double size;
    private GraphicsGroup group;

    private GraphicsText temperature;
    private GraphicsText description;
    private GraphicsText recommendation;
    private GraphicsText headsUp;
    private Image icon;

    /**
     * Creates a temperature widget of dimensions size x size.
     */
    public ClothesWidget(double size) {
        this.size = size;

        group = new GraphicsGroup();

        icon = new Image(0, 0);
        icon.setMaxWidth(size * 0.3);
        icon.setMaxHeight(size * 0.3);
        group.add(icon);

        temperature = new GraphicsText();
        temperature.setFont(FontStyle.BOLD, size * 0.1);
        group.add(temperature);

        description = new GraphicsText();
        description.setFont(FontStyle.BOLD, size * 0.05);
        group.add(description);

        recommendation = new GraphicsText();
        recommendation.setFont(FontStyle.PLAIN, size * 0.05);
        group.add(recommendation);

        headsUp = new GraphicsText();
        headsUp.setFont(FontStyle.PLAIN, size * 0.05);
        group.add(headsUp);

        updateLayout();
    }

    @Override
    public GraphicsObject getGraphics() {
        return group;
    }

    public void update(WeatherData data) {
        CurrentConditions currentConditions = data.getCurrentConditions();

        icon.setImagePath(currentConditions.getWeatherIcon());
        temperature.setText(FormattingHelpers.decimalHelper(currentConditions.getTemperature())+ "\u2109");
        description.setText(currentConditions.getWeatherDescription());
        recommendation.setText(recommendClothes(data));
        if (checkHeadsUp(data) != null) {
            headsUp.setText(checkHeadsUp(data));
            headsUp.setCenter(size * 0.5, size * 0.6);
        }
      
        updateLayout();
    }

    private void updateLayout() {
        icon.setCenter(size * 0.5, size * 0.2);

        temperature.setCenter(size * 0.5, size * 0.4);

        description.setCenter(size * 0.5, size * 0.5);

        recommendation.setCenter(size * 0.5, size * 0.8);


    }

    /**
     * Recommends potential clothing based on temperature
     * @param data
     */
    private String recommendClothes(WeatherData data) {
        CurrentConditions currentConditions = data.getCurrentConditions();
        double temperature = currentConditions.getTemperature(); 
        if (temperature < 0) {
            return ("Get out your parka!");
        }
        if (temperature >= 0 && temperature < 32) {
            return ("Wear a winter coat!");
        }
        if (temperature >= 32 && temperature < 50) {
            return ("You need a jacket!");
        }
        if (temperature >= 50 && temperature < 65) {
            return ("It's long sleeve weather!");
        }
        if (temperature >= 65 && temperature < 78) {
            return ("Wear something a little lighter!");
        }
        if (temperature >= 78 && temperature < 90) {
            return ("Short sleeve time!");
        }
        if (temperature >= 90) {
            return ("Time to wear shorts!");
        }
        else return ("-");
    }

    private String windClothes(WeatherData data) {
        CurrentConditions currentConditions = data.getCurrentConditions();
        double windSpeed = currentConditions.getWindSpeed(); 

        if (windSpeed >= 10) {
            return ("Heads Up: Wear a windbreaker!");
        }
        else return null;
    }

    private String rainClothes(WeatherData data) {
        CurrentConditions currentConditions = data.getCurrentConditions();
        double cloudCoverage = currentConditions.getCloudCoverage(); 

        if (cloudCoverage < 30) {
            return ("Heads Up: Wear sunglasses!");
        }
        if (cloudCoverage >= 60) {
            return ("Heads Up: Wear a rain jacket!");
        }
        else {return null;}
    }

    private String checkHeadsUp(WeatherData data) {
        
        if (windClothes(data) == null) {
            return(rainClothes(data));
        }
        if (rainClothes(data) == null) {
            return(windClothes(data));
        }
        else {
            return (windClothes(data) + "\n" + rainClothes(data));
        }
    }
    
    @Override
    public void onHover(Point position) {
    }
}
