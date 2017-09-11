package cf.reol.stingy.act.recycler.item

import android.graphics.Color
import cf.reol.stingy.act.recycler.TypeFactory

/**
 * Created by reol on 2017/8/29.
 */
class AccountingItem(var leftColor: Int= Color.BLACK, var rightColor: Int = Color.RED, var title: String, var description: String, var content: String, var time: Long) : Visitable {

    override fun type(typeFactory: TypeFactory): Int = typeFactory.type(this)
}