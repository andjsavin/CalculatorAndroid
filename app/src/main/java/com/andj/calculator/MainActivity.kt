package com.andj.calculator

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.andj.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.buttonZero.setOnClickListener {
            binding.editText.text = binding.editText.text.append("0")
            if (binding.infoTextView.text != "") {
                binding.editText.setText("")
                binding.infoTextView.text = ""
            }
        }
        binding.buttonOpen.setOnClickListener {
            binding.editText.text = binding.editText.text.append("(")
            if (binding.infoTextView.text != "") {
                binding.editText.setText("")
                binding.infoTextView.text = ""
            }
        }
        binding.buttonClose.setOnClickListener {
            binding.editText.text = binding.editText.text.append(")")
            if (binding.infoTextView.text != "") {
                binding.editText.setText("")
                binding.infoTextView.text = ""
            }
        }
        binding.buttonDot.setOnClickListener {
            binding.editText.text = binding.editText.text.append(".")
            if (binding.infoTextView.text != "") {
                binding.editText.setText(".")
                binding.infoTextView.text = ""
            }
        }
        binding.buttonOne.setOnClickListener {
            binding.editText.text = binding.editText.text.append("1")
            if (binding.infoTextView.text != "") {
                binding.editText.setText("1")
                binding.infoTextView.text = ""
            }
        }
        binding.buttonTwo.setOnClickListener {
            binding.editText.text = binding.editText.text.append("2")
            if (binding.infoTextView.text != "") {
                binding.editText.setText("2")
                binding.infoTextView.text = ""
            }
        }
        binding.buttonThree.setOnClickListener {
            binding.editText.text = binding.editText.text.append("3")
            if (binding.infoTextView.text != "") {
                binding.editText.setText("3")
                binding.infoTextView.text = ""
            }
        }
        binding.buttonFour.setOnClickListener {
            binding.editText.text = binding.editText.text.append("4")
            if (binding.infoTextView.text != "") {
                binding.editText.setText("4")
                binding.infoTextView.text = ""
            }
        }
        binding.buttonFive.setOnClickListener {
            binding.editText.text = binding.editText.text.append("5")
            if (binding.infoTextView.text != "") {
                binding.editText.setText("5")
                binding.infoTextView.text = ""
            }
        }
        binding.buttonSix.setOnClickListener {
            binding.editText.text = binding.editText.text.append("6")
            if (binding.infoTextView.text != "") {
                binding.editText.setText("6")
                binding.infoTextView.text = ""
            }
        }
        binding.buttonSeven.setOnClickListener {
            binding.editText.text = binding.editText.text.append("7")
            if (binding.infoTextView.text != "") {
                binding.editText.setText("7")
                binding.infoTextView.text = ""
            }
        }
        binding.buttonEight.setOnClickListener {
            binding.editText.text = binding.editText.text.append("8")
            if (binding.infoTextView.text != "") {
                binding.editText.setText("8")
                binding.infoTextView.text = ""
            }
        }
        binding.buttonNine.setOnClickListener {
            binding.editText.text = binding.editText.text.append("9")
            if (binding.infoTextView.text != "") {
                binding.editText.setText("9")
                binding.infoTextView.text = ""
            }
        }
        binding.buttonC.setOnClickListener { binding.editText.setText("") }
        binding.buttonPlus.setOnClickListener {
            binding.editText.text = binding.editText.text.append("+")
            if (binding.infoTextView.text != "") {
                binding.editText.setText("+")
                binding.infoTextView.text = ""
            }
        }
        binding.buttonMinus.setOnClickListener {
            binding.editText.text = binding.editText.text.append("-")
            if (binding.infoTextView.text != "") {
                binding.editText.setText("-")
                binding.infoTextView.text = ""
            }
        }
        binding.buttonMul.setOnClickListener {
            binding.editText.text = binding.editText.text.append("*")
            if (binding.infoTextView.text != "") {
                binding.editText.setText("*")
                binding.infoTextView.text = ""
            }
        }
        binding.buttonDiv.setOnClickListener {
            binding.editText.text = binding.editText.text.append("/")
            if (binding.infoTextView.text != "") {
                binding.editText.setText("/")
                binding.infoTextView.text = ""
            }
        }
        binding.buttonR.setOnClickListener {
            if (binding.editText.text.toString() != "") {
                binding.editText.setText(binding.editText.text.removeSuffix(binding.editText.text[binding.editText.text.length - 1].toString()))
            }
        }
        binding.buttonCalc.setOnClickListener {
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
                    if (expression[i-1] in listOf('-', '+', '/', '*', '(')) {
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
        }

    }
}
