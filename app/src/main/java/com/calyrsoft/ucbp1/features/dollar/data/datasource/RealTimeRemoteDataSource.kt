package com.calyrsoft.ucbp1.features.dollar.data.datasource

import com.calyrsoft.ucbp1.features.dollar.domain.model.DollarModel
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class RealTimeRemoteDataSource {

    suspend fun getDollarUpdates(): Flow<DollarModel> = callbackFlow {
        val callback = object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                // Se reemplaza el TODO por una implementación real.
                close(p0.toException())
            }
            override fun onDataChange(p0: DataSnapshot) {

                val value = p0.getValue(DollarModel::class.java)

                if (value != null) {
                    // Tarea: Agregar un texto que muestre la fecha de actualización (1 punto)
                    val updatedAt = p0.child("updatedAt").value as? Long ?: System.currentTimeMillis()
                    value.updatedAt = updatedAt

                    trySend(value)
                }
            }
        }

//         Write a message to the database
        val database = Firebase.database
        val myRef = database.getReference("dollar")
        myRef.addValueEventListener(callback)

        awaitClose {
            myRef.removeEventListener(callback)
        }
    }
}