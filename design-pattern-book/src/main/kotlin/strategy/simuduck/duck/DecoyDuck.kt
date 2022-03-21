package strategy.simuduck.duck

import strategy.simuduck.fly.FlyNoWay
import strategy.simuduck.quack.MuteQuack

/**
 * Created by marathoner on 2022/03/21
 * 1. display
 */
class DecoyDuck() : Duck() {
    init {
        this.setFlyBehavior(FlyNoWay())
        this.setQuackBehavior(MuteQuack())
    }

    override fun display() {
        println("Display: Decoy Duck")
    }
}
