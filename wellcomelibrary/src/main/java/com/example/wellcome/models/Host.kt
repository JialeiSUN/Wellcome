package com.example.wellcome.models

class Hosts(title: String, description: String, address: String, phone: String, tags: List<String>, val nombrePersonne: String, val nombrePiece:String) : Service(title, description,
    address,phone, tags)
{

}