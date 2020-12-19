package ru.task2

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

data class Quote (val type :String?, val value : Value?)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Value(val id : Long?, val quote:String?)
