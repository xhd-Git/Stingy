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
    }
}