package observer.monitoring.display

import observer.monitoring.Observer
import observer.monitoring.WeatherData

/**
 * Created by marathoner on 2022/03/22
 */
class CurrentConditionsDisplay(private val weatherData: WeatherData) : Observer, DisplayElement {
    private var temperature: Float = 0.0f
    private var humidity: Float = 0.0f

    init {
        weatherData.registerObserver(this)
    }

    override fun display() {
        println("현재 상태: 온도 ${temperature}F, 습도 ${humidity}%")
    }

    override fun update() {
        this.temperature = weatherData.getTemperature()
        this.humidity = weatherData.getHumidity()
        display()
    }

}

