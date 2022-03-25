package observer.swing

import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.JButton
import javax.swing.JFrame

/**
 * Created by marathoner on 2022/03/25
 */
class SwingObserverExample {
    private lateinit var fram: JFrame


    fun run() {
        val example = SwingObserverExample()
        example.go();
    }

    private fun go() {
        fram = JFrame();

        val button = JButton("할까? 말까?")
        button.addActionListener { println("하지마 !!!") }
        button.addActionListener { println("해!!!") }
    }
}
