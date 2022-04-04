package com.example.standforukraine.data

import java.text.SimpleDateFormat

fun Long.toDateString(): String {
    return SimpleDateFormat("dd.MM HH:mm").format(this*1000)
}