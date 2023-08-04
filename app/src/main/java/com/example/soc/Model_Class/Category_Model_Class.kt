package com.example.soc.Model_Class

class Category_Model_Class {
    var cat_id = 0
    lateinit var cat_name: String


    constructor(cat_id:Int,cat_name:String) {
        this.cat_id = cat_id
        this.cat_name = cat_name
    }

    constructor()
}