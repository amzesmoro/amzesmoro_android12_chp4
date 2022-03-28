package com.amzesmoro.cc_chp4

enum class PlayerShape(val shape: Int) {
    IDLE(-1),
    ROCK(0),
    PAPER(1),
    SCISSOR(2);

    companion object {
        fun fromInt(shape: Int): PlayerShape {
            val values = PlayerShape.values()
            val result = values.find {
                return@find it.shape == shape
            }
            return result ?: IDLE
        }
    }
}