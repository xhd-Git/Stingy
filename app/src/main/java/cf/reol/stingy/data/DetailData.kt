package cf.reol.stingy.data

import io.realm.RealmObject

/**
 * Created by reol on 04/09/2017.
 */
open class DetailData(var title:String, var description: String,
                      var type: Int, var content: Long, var time: Long, var status: String): RealmObject(){

    constructor() : this("事件","描述",0,0,0," ")
}