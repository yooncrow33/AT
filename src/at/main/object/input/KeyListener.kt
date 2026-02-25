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
    //tab
   /* override fun onKey1Press() {
        main.getTab().setTabState(Tab.State.store)
    }
    override fun onKey2Press() {
        main.getTab().setTabState(Tab.State.aircraft)
    }
    override fun onKey3Press() {
        main.getTab().setTabState(Tab.State.setting)
    }

    */


    //move
    override fun onKeyWPress() {
        main.view.moveTrueW()
    }
    override fun onKeyAPress() {
        main.view.moveTrueA()
    }
    override fun onKeySPress() {
        main.view.moveTrueS()
    }
    override fun onKeyDPress() {
        main.view.moveTrueD()
    }

    override fun onKeyWRelease() {
        main.view.moveFalseW()
    }
    override fun onKeyARelease() {
        main.view.moveFalseA()
    }
    override fun onKeySRelease() {
        main.view.moveFalseS()
    }
    override fun onKeyDRelease() {
        main.view.moveFalseD()
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