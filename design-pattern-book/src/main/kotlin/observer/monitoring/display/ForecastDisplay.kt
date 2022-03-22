package observer.monitoring.display

import observer.monitoring.Observer
import observer.monitoring.WeatherData

/**
 * Created by marathoner on 2022/03/22
 */
class ForecastDisplay(weatherData: WeatherData) : Observer, DisplayElement {
    private var temperature: Float = 0.0f
    private var humidity: Float = 0.0f
    private var pressure: Float = 0.0f

    init {
        weatherData.registerObserver(this)
    }

    override fun display() {
        if (temperature == 80f)
            println("기상 예보: 날씨가 좋아지고 있습니다!")
        else if (temperature < 80f)
            println("기상 예보: 쌀쌀하며 비가 올 것 같습니다.")
        else if (temperature > 80f)
            println("기상 예보: 지금과 비슷할 것 같습니다.")
    }

    override fun update(temp: Float, humidity: Float, pressure: Float) {
        this.temperature = temp
        this.humidity = humidity
        this.pressure = pressure
        display()
    }

}
