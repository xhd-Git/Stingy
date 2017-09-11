package cf.reol.stingy.utils

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.widget.Toast

/** 神秘特性 ： 扩展函数集合
 * Created by reol on 2017/9/4.
 */

fun Context.toast(string: String){
    Toast.makeText(applicationContext,string, Toast.LENGTH_SHORT).show()
}
