package com.example.api.api_file_example;

public class WeatherResponse {

    private CurrentWeather current_weather;

    public CurrentWeather getCurrent_weather() {
        return current_weather;
    }

    public void setCurrent_weather(CurrentWeather current_weather) {
        this.current_weather = current_weather;
    }

    public class CurrentWeather {
        private double temperature;
        private double windspeed;
        private double precipitation_probability;

        // Getters
        public double getTemperature() {
            return temperature;
        }

        public double getWindspeed() {
            return windspeed;
        }

        public double getPrecipitationProbability() {
            return precipitation_probability;
        }

        // Setters
        public void setTemperature(double temperature) {
            this.temperature = temperature;
        }

        public void setWindspeed(double windspeed) {
            this.windspeed = windspeed;
        }

        public void setPrecipitationProbability(double precipitation_probability) {
            this.precipitation_probability = precipitation_probability;
        }
    }
}

