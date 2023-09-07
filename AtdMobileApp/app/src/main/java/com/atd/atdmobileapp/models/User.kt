package com.atd.atdmobileapp.models

data class User(
    val active: Boolean,
    val configurations: Configurations,
    val customers: Customers,
    val email: String,
    val fax: String,
    val locations: Locations,
    val logindisabled: Boolean,
    val name: String,
    val permissions: Permissions,
    val phone: String,
    val role: String,
    val switchstores: Boolean,
    val username: String,
    val websites: Websites
)