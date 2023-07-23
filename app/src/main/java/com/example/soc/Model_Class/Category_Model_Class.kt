package com.example.soc.Model_Class

class Category_Model_Class {
    var id = 0
    var cat_id = 0
    lateinit var cat_name: String

    constructor(id:Int,cat_id:Int,cat_name:String) {
        this.id=id
        this.cat_id = cat_id
        this.cat_name = cat_name
    }

    constructor()
}