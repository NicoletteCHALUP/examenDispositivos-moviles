package com.calyrsoft.ucbp1.features.profile.domain.model

data class EmailVO(val value: String) {
    init {
        require(value.matches(Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\$"))) {
        }
    }
}