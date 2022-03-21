package strategy.simuduck.duck

import strategy.simuduck.fly.FlyNoWay
import strategy.simuduck.quack.Quack

/**
 * Created by marathoner on 2022/03/21
 * 1. display
 * 2. quack
 */
class RubberDuck() : Duck() {
    init {
        this.setFlyBehavior(FlyNoWay())
        this.setQuackBehavior(Quack())
    }

    override fun display() {
        println("Display: Rubber Duck")
    }
}
