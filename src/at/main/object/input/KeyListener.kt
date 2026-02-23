package ie.main.input.at.main.`object`.input

import at.main.Main
import scope.KeyBindingBase
import java.awt.KeyEventDispatcher
import java.awt.KeyboardFocusManager
import java.awt.event.KeyEvent
import javax.swing.JComponent

class KetListener(comp: JComponent, var main: Main) : KeyBindingBase(comp) {

    init {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(KeyEventDispatcher { e: KeyEvent? ->
            if (e!!.getID() == KeyEvent.KEY_TYPED && main.console.isOpen) {
                val c = e.getKeyChar()
                if (c != '\n' && c != '\b' && c.code != 27) {
                    main.console.inputKey(c, 0)
                }
            }
            false
        })
    }
    //move
    override fun onKeyWPress() {
        super.onKeyWPress()
    }
    override fun onKeyAPress() {
        super.onKeyWPress()
    }
    override fun onKeySPress() {
        super.onKeyWPress()
    }
    override fun onKeyDPress() {
        super.onKeyWPress()
    }

    //console
    override fun onKeyEnterPress() {
        if (main.console.isOpen) {
            main.console.inputKey('\n', 10) // 강제로 코드 10 넣어줌
            return
        }
    }
    override fun onKeyF12Press() {
        main.console.toggle()
        println("Console toggle")
    }
    override fun onKeyBackspacePress() {
        if (main.console.isOpen) {
            main.console.inputKey('\b', 8)
        }
    }

}