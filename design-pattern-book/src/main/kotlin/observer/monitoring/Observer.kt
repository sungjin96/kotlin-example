package observer.monitoring

/**
 * Created by marathoner on 2022/03/22
 */
interface Observer {
    fun update(temp: Float, humidity: Float, pressure: Float)
}
