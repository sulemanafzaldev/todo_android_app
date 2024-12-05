package com.example.todoapp

import com.example.todoapp.model.CardInfo

object DataObject {
    var listdata = mutableListOf<CardInfo>()

    fun setData(title: String, perority: String) {
        listdata.add(CardInfo(title, perority))
    }

    fun getData(pos: Int): CardInfo {
        return listdata[pos]
    }

    fun getAllData(): List<CardInfo> {
        return listdata
    }

    fun deleteItem(pos: Int) {
        listdata.removeAt(pos)
    }

    fun updateItem(pos: Int, title: String, perority: String){
        listdata[pos].title =title
        listdata[pos].periorty = perority
    }

    fun deleteAllData() {
        listdata.clear()
    }
}