package observer.monitoring

import observer.monitoring.display.CurrentConditionsDisplay
import observer.monitoring.display.ForecastDisplay
import observer.monitoring.display.HeatIndexDisplay
import observer.monitoring.display.StatisticsDisplay

/**
 * Created by marathoner on 2022/03/22
 */
class MonitoringRunner {
    fun run() {
        val weatherData = WeatherData()

        val currentConditionsDisplay = CurrentConditionsDisplay(weatherData)
        val statisticsDisplay = StatisticsDisplay(weatherData)
        val forecastDisplay = ForecastDisplay(weatherData)
        val heatIndexDisplay = HeatIndexDisplay(weatherData)

        weatherData.setMeasurement(80f, 65f, 30.4f)
        weatherData.setMeasurement(82f, 70f, 29.2f)
        weatherData.setMeasurement(78f, 90f, 29.5f)
    }
}
