package strategy.simuduck.duck

import strategy.simuduck.fly.FlyWithWings
import strategy.simuduck.quack.Quack

/**
 * Created by marathoner on 2022/03/21
 * 1. display
 * 2. fly
 * 3. quack
 */
class RedheadDuck() : Duck() {
    init {
        this.setFlyBehavior(FlyWithWings())
        this.setQuackBehavior(Quack())
    }

    override fun display() {
        println("Display: Redhead Duck")
    }
}
