package com.wizion.androidarchitecturecomponentsandjetpack.dagger_hilt.models.post

data class Links(
    val about: List<About>,
    val author: List<Author>,
    val collection: List<Collection>,
    val curies: List<Cury>,
    val replies: List<Reply>,
    val self: List<Self>
)