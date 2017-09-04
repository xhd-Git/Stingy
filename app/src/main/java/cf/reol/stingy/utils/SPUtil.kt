package cf.reol.stingy.utils

import android.content.Context
import android.content.SharedPreferences
import cf.reol.stingy.conf.Constant

/**
 * Created by reol on 03/09/2017.
 */
class SPUtil{
    companion object {
        fun setData(context: Context, string: String){
            val sp: SharedPreferences = context.getSharedPreferences(Constant.TEST, 0)
            sp.edit().putString(Constant.TEST,string).apply()
        }

        fun getData(context: Context): String{
            val sp: SharedPreferences = context.getSharedPreferences(Constant.TEST, 0)
            return sp.getString(Constant.TEST, "default")
        }

        fun setIndex(context: Context, hashMap: HashMap<Int, String>){
            val sp: SharedPreferences = context.getSharedPreferences(Constant.INDEX, 0)
            val e = sp.edit()
            for (i in hashMap.keys){
                e.putString(i.toString(), hashMap[i])
            }
            e.apply()
        }

        fun getIndex(context: Context): HashMap<Int, String>{
            var i = 0
            val sp: SharedPreferences = context.getSharedPreferences(Constant.INDEX, 0)
            val hashMap: HashMap<Int, String> = HashMap()
            while (true){
                val s = sp.getString(i.toString(), "null")
                if (s == "null"){
                    break
                }else{
                    hashMap.put(i, s)
                }
                i++
            }
            return hashMap
        }
    }
}