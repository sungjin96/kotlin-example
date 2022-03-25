package observer.monitoring.display

import observer.monitoring.Observer
import observer.monitoring.WeatherData

/**
 * Created by marathoner on 2022/03/22
 */
class HeatIndexDisplay(val weatherData: WeatherData) : Observer, DisplayElement {
    private var temperature: Float = 0.0f
    private var humidity: Float = 0.0f

    init {
        weatherData.registerObserver(this)
    }

    override fun display() {
        println("체감 온도: ${computeHeatIndex(temperature, humidity)}")
    }

    override fun update() {
        this.temperature = weatherData.getTemperature()
        this.humidity = weatherData.getHumidity()
        display()
    }

    private fun computeHeatIndex(t: Float, rh: Float): Float {
        return (16.923 + 0.185212 * t + 5.37941 * rh - 0.100254 * t * rh +
                0.00941695 * (t * t) + 0.00728898 * (rh * rh) +
                0.000345372 * (t * t * rh) - 0.000814971 * (t * rh * rh) +
                0.0000102102 * (t * t * rh * rh) - 0.000038646 * (t * t * t) + 0.0000291583 *
                (rh * rh * rh) + 0.00000142721 * (t * t * t * rh) +
                0.000000197483 * (t * rh * rh * rh) - 0.0000000218429 * (t * t * t * rh * rh) +
                0.000000000843296 * (t * t * rh * rh * rh) -
                0.0000000000481975 * (t * t * t * rh * rh * rh)).toFloat()
    }
}
