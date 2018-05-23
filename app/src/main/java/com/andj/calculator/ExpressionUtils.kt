package com.andj.calculator

import java.math.BigDecimal
import java.util.*

object ExpressionUtils {
    val MAIN_MATH_OPERATIONS: MutableMap<String, Int>

    init {
        MAIN_MATH_OPERATIONS = HashMap()
        MAIN_MATH_OPERATIONS["*"] = 1
        MAIN_MATH_OPERATIONS["/"] = 1
        MAIN_MATH_OPERATIONS["+"] = 2
        MAIN_MATH_OPERATIONS["-"] = 2
    }

    @JvmOverloads
    fun sortingStation(expression: String?, operations: Map<String, Int>?, leftBracket: String = "(",
                       rightBracket: String = ")"): String {
        var expression = expression
        if (expression == null || expression.length == 0)
            throw IllegalStateException("Expression isn't specified.")
        if (operations == null || operations.isEmpty())
            throw IllegalStateException("Operations aren't specified.")
        val out = ArrayList<String>()
        val stack = Stack<String>()

        expression = expression.replace(" ", "")

        val operationSymbols = HashSet(operations.keys)
        operationSymbols.add(leftBracket)
        operationSymbols.add(rightBracket)

        var index = 0
        var findNext = true
        while (findNext) {
            var nextOperationIndex = expression.length
            var nextOperation = ""
            for (operation in operationSymbols) {
                val i = expression.indexOf(operation, index)
                if (i >= 0 && i < nextOperationIndex) {
                    nextOperation = operation
                    nextOperationIndex = i
                }
            }
            if (nextOperationIndex == expression.length) {
                findNext = false
            } else {
                if (index != nextOperationIndex) {
                    out.add(expression.substring(index, nextOperationIndex))
                }
                if (nextOperation == leftBracket) {
                    stack.push(nextOperation)
                } else if (nextOperation == rightBracket) {
                    while (stack.peek() != leftBracket) {
                        out.add(stack.pop())
                        if (stack.empty()) {
                            throw IllegalArgumentException("Unmatched brackets")
                        }
                    }
                    stack.pop()
                } else {
                    while (!stack.empty() && stack.peek() != leftBracket &&
                            operations[nextOperation]!! >= operations[stack.peek()]!!) {
                        out.add(stack.pop())
                    }
                    stack.push(nextOperation)
                }
                index = nextOperationIndex + nextOperation.length
            }
        }

        if (index != expression.length) {
            out.add(expression.substring(index))
        }

        while (!stack.empty()) {
            out.add(stack.pop())
        }
        val result = StringBuffer()
        if (!out.isEmpty())
            result.append(out.removeAt(0))
        while (!out.isEmpty())
            result.append(" ").append(out.removeAt(0))

        return result.toString()
    }

    fun calculateExpression(expression: String): BigDecimal {
        val rpn = sortingStation(expression, MAIN_MATH_OPERATIONS)
        val tokenizer = StringTokenizer(rpn, " ")
        val stack = Stack<BigDecimal>()
        while (tokenizer.hasMoreTokens()) {
            val token = tokenizer.nextToken()
            // Операнд.
            if (!MAIN_MATH_OPERATIONS.keys.contains(token)) {
                stack.push(BigDecimal(token))
            } else {
                val operand2 = stack.pop()
                val operand1 = if (stack.empty()) BigDecimal.ZERO else stack.pop()
                if (token == "*") {
                    stack.push(operand1.multiply(operand2))
                } else if (token == "/") {
                    stack.push(operand1.divide(operand2))
                } else if (token == "+") {
                    stack.push(operand1.add(operand2))
                } else if (token == "-") {
                    stack.push(operand1.subtract(operand2))
                }
            }
        }
        if (stack.size != 1)
            throw IllegalArgumentException("Expression syntax error.")
        return stack.pop()
    }
}