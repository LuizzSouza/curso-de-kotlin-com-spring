package com.mercadolivro.enums

enum class Errors(
    val code: String,
    val message: String
) {
    ML000("ML-000", "Access Denied"),
    ML001("ML-001", "Invalid Request"),
    ML101("ML-101", "Book [%s] not exists"),
    ML102("ML-102", "Cannot update book with status [%s]"),
    ML103("ML-103", "Cannot buy book with not available stock"),
    ML201("ML-201", "Customer [%s] not exists")
}