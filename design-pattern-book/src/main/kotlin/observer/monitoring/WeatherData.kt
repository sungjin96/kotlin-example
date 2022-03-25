package observer.monitoring

/**
 * Created by marathoner on 2022/03/22
 */
class WeatherData : Subject {

    private var observers: MutableList<Observer> = mutableListOf()
    private var temperature: Float = 0.0f
    private var humidity: Float = 0.0f
    private var pressure: Float = 0.0f

    fun getTemperature(): Float = temperature
    fun getHumidity(): Float = humidity
    fun getPressure(): Float = pressure

    private fun measurementsChanged() {
        notifyObservers()
    }

    fun setMeasurement(temperature: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure
        measurementsChanged()
    }

    override fun registerObserver(o: Observer) {
        observers.add(o)
    }

    override fun removeObserver(o: Observer) {
        observers.remove(o)
    }

    override fun notifyObservers() {
        for (observer in observers) {
            observer.update()
        }
    }

}
