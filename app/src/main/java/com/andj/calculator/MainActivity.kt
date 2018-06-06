package com.andj.calculator

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.andj.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var counter: Int = 0
    private var prev: String = ""

    private fun isBlocked(button: String, expression: String): Boolean {
        if (expression == "") return false
        if (button in listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "0")) {
            if (expression[expression.length - 1] in listOf(')')) return true
        }
        if (button == "(") {
            if (expression[expression.length - 1] in listOf('1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '.', ')')) return true
        }
        if (button == ")") {
            if (counter == 0) return true
            if (expression[expression.length - 1] in listOf('+', '-', '/', '*', '.', '(')) return true
        }
        if (button == ".") {
            if (expression[expression.length - 1] in listOf('+', '-', '/', '*', '.', '(', ')')) return true
            var i:Int = expression.length -1
            while (i >= 0) {
                if (expression[i] in listOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0')) {
                    i -= 1
                    continue
                }
                if (expression[i] == '.') return true
                return false
            }
        }
        if (button in listOf("+", "-", "*", "/")) {
            if (expression[expression.length - 1] in listOf('+', '-', '/', '*', '.', '(')) return true
        }
        if (button == "calc") {
            if (expression[expression.length - 1] in listOf('+', '-', '/', '*', '.', '(')) return true
            if (counter > 0) return true
        }
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.buttonZero.setOnClickListener {
            if (!isBlocked("0", binding.editText.text.toString())) {
                binding.editText.text = binding.editText.text.append("0")
                if (binding.infoTextView.text != "") {
                    binding.editText.setText("0")
                    binding.infoTextView.text = ""
                }
            }
        }
        binding.buttonOpen.setOnClickListener {
            if (!isBlocked("(", binding.editText.text.toString())) {
                binding.editText.text = binding.editText.text.append("(")
                counter += 1
                if (binding.infoTextView.text != "") {
                    binding.editText.setText("(")
                    binding.infoTextView.text = ""
                }
            }
        }
        binding.buttonClose.setOnClickListener {
            if (!isBlocked(")", binding.editText.text.toString())) {
                binding.editText.text = binding.editText.text.append(")")
                counter -= 1
                if (binding.infoTextView.text != "") {
                    binding.editText.setText(")")
                    binding.infoTextView.text = ""
                }
            }
        }
        binding.buttonDot.setOnClickListener {
            if (!isBlocked(".", binding.editText.text.toString())) {
                binding.editText.text = binding.editText.text.append(".")
                if (binding.infoTextView.text != "") {
                    binding.editText.setText(".")
                    binding.infoTextView.text = ""
                }
            }
        }
        binding.buttonOne.setOnClickListener {
            if (!isBlocked("1", binding.editText.text.toString())) {
                binding.editText.text = binding.editText.text.append("1")
                if (binding.infoTextView.text != "") {
                    binding.editText.setText("1")
                    binding.infoTextView.text = ""
                }
            }
        }
        binding.buttonTwo.setOnClickListener {
            if (!isBlocked("2", binding.editText.text.toString())) {
                binding.editText.text = binding.editText.text.append("2")
                if (binding.infoTextView.text != "") {
                    binding.editText.setText("2")
                    binding.infoTextView.text = ""
                }
            }
        }
        binding.buttonThree.setOnClickListener {
            if (!isBlocked("3", binding.editText.text.toString())) {
                binding.editText.text = binding.editText.text.append("3")
                if (binding.infoTextView.text != "") {
                    binding.editText.setText("3")
                    binding.infoTextView.text = ""
                }
            }
        }
        binding.buttonFour.setOnClickListener {
            if (!isBlocked("4", binding.editText.text.toString())) {
                binding.editText.text = binding.editText.text.append("4")
                if (binding.infoTextView.text != "") {
                    binding.editText.setText("4")
                    binding.infoTextView.text = ""
                }
            }
        }
        binding.buttonFive.setOnClickListener {
            if (!isBlocked("5", binding.editText.text.toString())) {
                binding.editText.text = binding.editText.text.append("5")
                if (binding.infoTextView.text != "") {
                    binding.editText.setText("5")
                    binding.infoTextView.text = ""
                }
            }
        }
        binding.buttonSix.setOnClickListener {
            if (!isBlocked("6", binding.editText.text.toString())) {
                binding.editText.text = binding.editText.text.append("6")
                if (binding.infoTextView.text != "") {
                    binding.editText.setText("6")
                    binding.infoTextView.text = ""
                }
            }
        }
        binding.buttonSeven.setOnClickListener {
            if (!isBlocked("7", binding.editText.text.toString())) {
                binding.editText.text = binding.editText.text.append("7")
                if (binding.infoTextView.text != "") {
                    binding.editText.setText("7")
                    binding.infoTextView.text = ""
                }
            }
        }
        binding.buttonEight.setOnClickListener {
            if (!isBlocked("8", binding.editText.text.toString())) {
                binding.editText.text = binding.editText.text.append("8")
                if (binding.infoTextView.text != "") {
                    binding.editText.setText("8")
                    binding.infoTextView.text = ""
                }
            }
        }
        binding.buttonNine.setOnClickListener {
            if (!isBlocked("9", binding.editText.text.toString())) {
                binding.editText.text = binding.editText.text.append("9")
                if (binding.infoTextView.text != "") {
                    binding.editText.setText("9")
                    binding.infoTextView.text = ""
                }
            }
        }
        binding.buttonC.setOnClickListener { binding.editText.setText("") }
        binding.buttonPlus.setOnClickListener {
            if (!isBlocked("+", binding.editText.text.toString())) {
                binding.editText.text = binding.editText.text.append("+")
                if (binding.infoTextView.text != "") {
                    binding.editText.setText("+")
                    binding.infoTextView.text = ""
                }
            }
        }
        binding.buttonMinus.setOnClickListener {
            if (!isBlocked("-", binding.editText.text.toString())) {
                binding.editText.text = binding.editText.text.append("-")
                if (binding.infoTextView.text != "") {
                    binding.editText.setText("-")
                    binding.infoTextView.text = ""
                }
            }
        }
        binding.buttonMul.setOnClickListener {
            if (!isBlocked("*", binding.editText.text.toString())) {
                binding.editText.text = binding.editText.text.append("*")
                if (binding.infoTextView.text != "") {
                    binding.editText.setText("*")
                    binding.infoTextView.text = ""
                }
            }
        }
        binding.buttonDiv.setOnClickListener {
            if (!isBlocked("/", binding.editText.text.toString())) {
                binding.editText.text = binding.editText.text.append("/")
                if (binding.infoTextView.text != "") {
                    binding.editText.setText("/")
                    binding.infoTextView.text = ""
                }
            }
        }
        binding.buttonR.setOnClickListener {
            if (binding.editText.text.toString() != "") {
                if (binding.editText.text[binding.editText.text.length -1] == '(') {
                    counter -= 1
                } else if (binding.editText.text[binding.editText.text.length -1] == ')') {
                    counter += 1
                }
                binding.editText.setText(binding.editText.text.removeSuffix(binding.editText.text[binding.editText.text.length - 1].toString()))
            } else {
                binding.editText.setText(prev)
                binding.infoTextView.text = ""
            }
        }
        binding.buttonCalc.setOnClickListener {
            if (!isBlocked("calc", binding.editText.text.toString())) {
                val expression = binding.editText.text
                var answer = ""
                var suf = ""
                var i = 0
                while (i < expression.length) {
                    if (i == 0) {
                        if (expression[i] == '-') {
                            answer += "(0-"
                            i += 1
                            while (expression[i] !in listOf('+', '-', '*', '/')) {
                                answer += expression[i]
                                if (i == expression.length - 1) break
                                i += 1
                            }
                            if (i == expression.length - 1) {
                                answer += ")"
                                i += 1
                            } else {
                                answer = answer + ")" + expression[i]
                                i += 1
                            }
                            continue
                        }
                    }
                    if (expression[i] == '-') {
                        if (expression[i - 1] in listOf('-', '+', '/', '*', '(')) {
                            answer += "(0-"
                            i += 1
                            while (expression[i] !in listOf('+', '-', '*', '/')) {
                                answer += expression[i]
                                if (i == expression.length - 1) break
                                i += 1
                            }
                            if (i == expression.length - 1) {
                                answer += ")"
                                i += 1
                            } else {
                                answer = answer + ")" + expression[i]
                                i += 1
                            }
                            continue
                        } else {
                            answer += expression[i]
                            i += 1
                        }
                        continue
                    }
                    answer += expression[i]
                    i += 1
                }
                answer = ExpressionUtils.calculateExpression(answer).toString()
                if ('.' in answer) {
                    i = answer.length - 1
                    while (true) {
                        if (answer[i] == '0') {
                            suf += "0"
                            i -= 1
                            continue
                        }
                        if (answer[i] == '.') {
                            suf = ".$suf"
                            answer = answer.removeSuffix(suf)
                            break
                        }
                        break
                    }
                }
                binding.infoTextView.text = answer
                prev = answer
                counter = 0
            }
        }
    }
}
