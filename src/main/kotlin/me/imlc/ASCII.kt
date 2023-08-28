package me.imlc


public val ASCII_NULL = (0).toChar()
public val ASCII_RETURN = (13).toChar()
public val ASCII_ESC = (27).toChar()
public val ASCII_LEFT_SQUARE_BRACKET = (91).toChar()
public val ASCII_A = (65).toChar()
public val ASCII_B = (66).toChar()

val CONTROL_CODE_ARROW_UP = charArrayOf(ASCII_ESC, ASCII_LEFT_SQUARE_BRACKET, ASCII_A)
val CONTROL_CODE_ARROW_DOWN = charArrayOf(ASCII_ESC, ASCII_LEFT_SQUARE_BRACKET, ASCII_B)
//val CONTROL_CODE_ARROW_DOWN = charArrayOf(ASCII_ESC, ASCII_LEFT_SQUARE_BRACKET, )

class ASCII {

}