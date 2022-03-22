package observer.monitoring.display

import observer.monitoring.Observer
import observer.monitoring.WeatherData

/**
 * Created by marathoner on 2022/03/22
 */
class StatisticsDisplay(weatherData: WeatherData) : Observer, DisplayElement {
    private var temperature: Float = 0.0f

    init {
        weatherData.registerObserver(this)
    }

    override fun display() {
        println("평균/최고/최저 온도 = ${temperature}F")
    }

    override fun update(temp: Float, humidity: Float, pressure: Float) {
        this.temperature = temp
        display()
    }

}
