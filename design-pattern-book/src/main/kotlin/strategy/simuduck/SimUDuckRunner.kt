package strategy.simuduck

import strategy.simuduck.duck.Duck
import strategy.simuduck.duck.MallardDuck
import strategy.simuduck.fly.FlyLocatePowered

/**
 * Created by marathoner on 2022/03/21
 */
class SimUDuckRunner {
    fun run() {
        val mallardDuck: Duck = MallardDuck()
        mallardDuck.display()
        mallardDuck.quack()
        mallardDuck.fly()
        mallardDuck.setFlyBehavior(FlyLocatePowered())
        mallardDuck.fly()
    }
}
