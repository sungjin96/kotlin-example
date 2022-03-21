package strategy.simuduck.duck

import strategy.simuduck.fly.FlyBehavior
import strategy.simuduck.quack.QuackBehavior

/**
 * Created by marathoner on 2022/03/21
 */
abstract class Duck {

    private lateinit var quackBehavior: QuackBehavior
    private lateinit var flyBehavior: FlyBehavior

    fun setQuackBehavior(quackBehavior: QuackBehavior) {
        this.quackBehavior = quackBehavior
    }

    fun setFlyBehavior(flyBehavior: FlyBehavior) {
        this.flyBehavior = flyBehavior
    }

    open fun quack() {
        quackBehavior.quack()
    }

    open fun fly() {
        flyBehavior.fly()
    }

    open fun swim() {
        println("Swim....")
    }

    abstract fun display()
}
