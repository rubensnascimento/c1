package com.br.bandtec.avaliacao

data class Cliente (val nome:String, val renda:Int){

    //---------------

    val classeSocial:String = when(renda){
        in 0..2900 ->"Pobre"
        in 2900..12000 ->"Classe média"
        else -> "Rico"
    }

}