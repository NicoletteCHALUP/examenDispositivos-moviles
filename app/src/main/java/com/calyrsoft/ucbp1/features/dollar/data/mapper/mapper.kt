package com.calyrsoft.ucbp1.features.dollar.data.mapper

import com.calyrsoft.ucbp1.features.dollar.data.database.entity.DollarEntity
import com.calyrsoft.ucbp1.features.dollar.domain.model.DollarModel

fun DollarEntity.toModel() : DollarModel {
    return DollarModel(
        dollarOfficial = dollarOfficial,
        dollarParallel = dollarParallel,
        // Nuevos campos mapeados de la Entity al Model
        dollarUsdt = dollarUsdt,
        dollarUsdc = dollarUsdc,
        updatedAt = timestamp
    )
}


fun DollarModel.toEntity() : DollarEntity {
    return DollarEntity(
        dollarOfficial = dollarOfficial,
        dollarParallel = dollarParallel,
        // Nuevos campos mapeados del Model a la Entity
        dollarUsdt = dollarUsdt,
        dollarUsdc = dollarUsdc,
        timestamp = updatedAt // Usamos 'updatedAt' del Model como 'timestamp' en la Entity
    )
}