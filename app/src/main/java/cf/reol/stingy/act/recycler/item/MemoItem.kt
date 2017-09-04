package cf.reol.stingy.act.recycler.item

import cf.reol.stingy.act.recycler.TypeFactory

/** 备忘事件记录
 * Created by reol on 2017/8/30.
 */
class MemoItem(val title: String, timeStamp: Long, val description: String) : Visitable {
    var status: String = ""
    init {
        val seconds: Int = ((timeStamp - System.currentTimeMillis()) / 1000).toInt()
        status = if (seconds < 0) {
            "已结束"
        } else {
            if (seconds > 86400) {
                "剩余" + (seconds / 86400).toString() + "天"
            } else {
                "剩余" + (seconds / 3600).toString() + "时"
            }
        }

    }

    override fun type(typeFactory: TypeFactory): Int = typeFactory.type(this)
}