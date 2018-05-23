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
        binding.buttonZero.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View) {
                binding.editText.text = binding.editText.text.append("0")
                if (binding.infoTextView.text != "") {
                    binding.editText.setText("")
                    binding.infoTextView.text = ""
                }
            }
        })
        binding.buttonOpen.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View) {
                binding.editText.text = binding.editText.text.append("(")
                if (binding.infoTextView.text != "") {
                    binding.editText.setText("")
                    binding.infoTextView.text = ""
                }
            }
        })
        binding.buttonClose.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View) {
                binding.editText.text = binding.editText.text.append(")")
                if (binding.infoTextView.text != "") {
                    binding.editText.setText("")
                    binding.infoTextView.text = ""
                }
            }
        })
        binding.buttonDot.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View) {
                binding.editText.text = binding.editText.text.append(".")
                if (binding.infoTextView.text != "") {
                    binding.editText.setText(".")
                    binding.infoTextView.text = ""
                }
            }
        })
        binding.buttonOne.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View) {
                binding.editText.text = binding.editText.text.append("1")
                if (binding.infoTextView.text != "") {
                    binding.editText.setText("1")
                    binding.infoTextView.text = ""
                }
            }
        })
        binding.buttonTwo.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View) {
                binding.editText.text = binding.editText.text.append("2")
                if (binding.infoTextView.text != "") {
                    binding.editText.setText("2")
                    binding.infoTextView.text = ""
                }
            }
        })
        binding.buttonThree.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View) {
                binding.editText.text = binding.editText.text.append("3")
                if (binding.infoTextView.text != "") {
                    binding.editText.setText("3")
                    binding.infoTextView.text = ""
                }
            }
        })
        binding.buttonFour.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View) {
                binding.editText.text = binding.editText.text.append("4")
                if (binding.infoTextView.text != "") {
                    binding.editText.setText("4")
                    binding.infoTextView.text = ""
                }
            }
        })
        binding.buttonFive.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View) {
                binding.editText.text = binding.editText.text.append("5")
                if (binding.infoTextView.text != "") {
                    binding.editText.setText("5")
                    binding.infoTextView.text = ""
                }
            }
        })
        binding.buttonSix.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View) {
                binding.editText.text = binding.editText.text.append("6")
                if (binding.infoTextView.text != "") {
                    binding.editText.setText("6")
                    binding.infoTextView.text = ""
                }
            }
        })
        binding.buttonSeven.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View) {
                binding.editText.text = binding.editText.text.append("7")
                if (binding.infoTextView.text != "") {
                    binding.editText.setText("7")
                    binding.infoTextView.text = ""
                }
            }
        })
        binding.buttonEight.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View) {
                binding.editText.text = binding.editText.text.append("8")
                if (binding.infoTextView.text != "") {
                    binding.editText.setText("8")
                    binding.infoTextView.text = ""
                }
            }
        })
        binding.buttonNine.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View) {
                binding.editText.text = binding.editText.text.append("9")
                if (binding.infoTextView.text != "") {
                    binding.editText.setText("9")
                    binding.infoTextView.text = ""
                }
            }
        })
        binding.buttonC.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View) {
                binding.editText.setText("")
            }
        })
        binding.buttonPlus.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View) {
                binding.editText.text = binding.editText.text.append("+")
                if (binding.infoTextView.text != "") {
                    binding.editText.setText("+")
                    binding.infoTextView.text = ""
                }
            }
        })
        binding.buttonMinus.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View) {
                binding.editText.text = binding.editText.text.append("-")
                if (binding.infoTextView.text != "") {
                    binding.editText.setText("-")
                    binding.infoTextView.text = ""
                }
            }
        })
        binding.buttonMul.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View) {
                binding.editText.text = binding.editText.text.append("*")
                if (binding.infoTextView.text != "") {
                    binding.editText.setText("*")
                    binding.infoTextView.text = ""
                }
            }
        })
        binding.buttonDiv.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View) {
                binding.editText.text = binding.editText.text.append("/")
                if (binding.infoTextView.text != "") {
                    binding.editText.setText("/")
                    binding.infoTextView.text = ""
                }
            }
        })
        binding.buttonR.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View) {
                if (binding.editText.text.toString() != "") {
                    binding.editText.setText(binding.editText.text.removeSuffix(binding.editText.text[binding.editText.text.length - 1].toString()))
                }
            }
        })
        binding.buttonCalc.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View) {
                val expression = binding.editText.text
                var answer: String = ""
                var suf: String = ""
                var i: Int = 0
                while (i < expression.length) {
                    if (i == 0) {
                        if (expression[i] == '-') {
                            answer = answer + "(0-" + expression[i + 1] + ")"
                            i += 2
                            continue
                        }
                    }
                    if (expression[i] == '-') {
                        if (expression[i-1] in listOf('-', '+', '/', '*', '(')) {
                            answer = answer + "(0-" + expression[i + 1] + ")"
                            i += 2
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
        })

    }
}
