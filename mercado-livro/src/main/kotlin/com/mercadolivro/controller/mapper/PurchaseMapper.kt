package com.mercadolivro.controller.mapper

import com.mercadolivro.controller.request.PostPurchaseRequest
import com.mercadolivro.controller.response.PurchaseResponse
import com.mercadolivro.extension.toResponse
import com.mercadolivro.model.PurchaseModel
import com.mercadolivro.service.BookService
import com.mercadolivro.service.CustomerService
import org.springframework.stereotype.Component

@Component
class PurchaseMapper(
    private val bookService: BookService,
    private val customerService: CustomerService
) {

    fun toModel(request: PostPurchaseRequest): PurchaseModel {
        val customer = customerService.findById(request.customerId)
        val books = bookService.findAllById(request.bookIds)

        return PurchaseModel(
            customer = customer,
            books = books.toMutableList(),
            price = books.sumOf { it.price }
        )
    }

    fun fromModel(model: PurchaseModel): PurchaseResponse {
        return PurchaseResponse(
            id = model.id,
            customerId = model.customer.id,
            customerName = model.customer.name,
            books = model.books.map { it.toResponse() },
            nfe = model.nfe,
            price = model.price,
            createdAt = model.createdAt
        )

    }
}