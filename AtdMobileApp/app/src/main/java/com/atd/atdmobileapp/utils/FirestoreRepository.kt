package com.atd.atdmobileapp.utils

import com.atd.atdmobileapp.models.Cart
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FirestoreRepository @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val sharedPrefManager: SharedPrefManager,
) {

    private val usersCollection = firestore.collection("carts")


    suspend fun createCart(cart: Cart) {
        if(!sharedPrefManager.getUserName().isNullOrBlank() && !sharedPrefManager.getLocationNumber().isNullOrBlank() ) {
            val documentName =
                sharedPrefManager.getUserName() + "-" + sharedPrefManager.getLocationNumber()
            val documentReference =
                usersCollection.document(documentName + "-" + cart.atdProductNumber)
            val documentSnapshot = documentReference.get().await()
            if (documentSnapshot.exists()) {
                updateCart(cart, documentSnapshot.getLong("quantity")?.toInt())
            } else {
                documentReference.set(cart).await()
            }
        } else {

        }
    }

    private suspend fun updateCart(cart: Cart, currentQuantity :Int?) {
        if(!sharedPrefManager.getUserName().isNullOrBlank() && !sharedPrefManager.getLocationNumber().isNullOrBlank()) {
            val documentName =
                sharedPrefManager.getUserName() + "-" + sharedPrefManager.getLocationNumber()
            val documentReference =
                usersCollection.document(documentName + "-" + cart.atdProductNumber)
            val updateQuantity = cart.quantity + (currentQuantity ?: 0)

            val fieldUpdates = mapOf<String, Any>(
                "brand" to cart.brand,
                "style" to cart.style,
                "description" to cart.description,
                "quantity" to updateQuantity,
                "productImage" to cart.productImage,
                "supplier" to cart.supplier,
                "atdProductNumber" to cart.atdProductNumber,
                "userName" to sharedPrefManager.getUserName().toString(),
                "locationNumber" to sharedPrefManager.getLocationNumber().toString(),
                "createdDate" to cart.createdDate,
                "modifiedDate" to Common.currentDateTime()
            )
            documentReference.set(fieldUpdates).await()
        }else {

        }
    }

     suspend fun updateCartQuantity(cart: Cart, currentQuantity :Int?) {
         if(!sharedPrefManager.getUserName().isNullOrBlank() && !sharedPrefManager.getLocationNumber().isNullOrBlank()) {
             val documentName =
                 sharedPrefManager.getUserName() + "-" + sharedPrefManager.getLocationNumber()
             val documentReference =
                 usersCollection.document(documentName + "-" + cart.atdProductNumber)
             val updateQuantity = currentQuantity ?: 0
             val fieldUpdates = mapOf<String, Any>(
                 "brand" to cart.brand,
                 "style" to cart.style,
                 "description" to cart.description,
                 "quantity" to updateQuantity,
                 "productImage" to cart.productImage,
                 "supplier" to cart.supplier,
                 "atdProductNumber" to cart.atdProductNumber,
                 "userName" to sharedPrefManager.getUserName().toString(),
                 "locationNumber" to sharedPrefManager.getLocationNumber().toString(),
                 "createdDate" to cart.createdDate,
                 "modifiedDate" to Common.currentDateTime()
             )
             documentReference.set(fieldUpdates).await()
         }
    }
    suspend fun getRecordsBaseOnUserDetails(username: String, locationNumber: String): List<Cart> {
        val querySnapshot = usersCollection
            .whereEqualTo("userName", username)
            .whereEqualTo("locationNumber", locationNumber)
            .get()
            .await()

        val cartList = mutableListOf<Cart>()
        for (document in querySnapshot.documents) {
            val cart = document.toObject(Cart::class.java)
            cart?.let {
                cartList.add(it)
            }
        }
        return cartList
    }

    suspend fun getRecords(): List<Cart> {
        val querySnapshot = usersCollection.get().await()
        val cartList = mutableListOf<Cart>()

        for (document in querySnapshot.documents) {
            val cart = document.toObject(Cart::class.java)
            cart?.let {
                cartList.add(it)
            }
        }
        return cartList
    }

    suspend fun deleteRecord(documentId: String) :Boolean{
        val documentReference = usersCollection.document(documentId)
        return try {
            documentReference.delete().await()
            true
        } catch (e: Exception) {
            false
        }
    }

}
