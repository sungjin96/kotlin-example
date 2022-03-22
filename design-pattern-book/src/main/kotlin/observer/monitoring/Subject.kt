package observer.monitoring

/**
 * Created by marathoner on 2022/03/22
 */
interface Subject {
    fun registerObserver(o: Observer)
    fun removeObserver(o: Observer)
    fun notifyObservers()
}
