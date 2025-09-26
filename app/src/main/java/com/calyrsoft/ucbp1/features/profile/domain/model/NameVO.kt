package com.calyrsoft.ucbp1.features.profile.domain.model

data class NameVO(val value: String) {
    init {
        require(value.isNotBlank() && value.length >= 3) {
            "El nombre debe tener al menos 3 caracteres."
        }
    }
}