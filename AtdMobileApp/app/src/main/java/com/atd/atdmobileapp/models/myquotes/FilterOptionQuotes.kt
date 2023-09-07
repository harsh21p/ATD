package com.atd.atdmobileapp.models.myquotes

import com.atd.atdmobileapp.models.productsearch.FilterItem


data class FilterOptionQuotes(
    var Status: List<FilterItem> ?= null,
    var LastModified: List<FilterItem> ?= null,
    var CreatedBy: List<FilterItem> ?= null,
    var ModifiedBy: List<FilterItem> ?= null
)

