package cf.reol.stingy.act.recycler.item

import android.graphics.Color
import cf.reol.stingy.act.recycler.TypeFactory

/**
 * Created by reol on 2017/8/28.
 */
class DividerItem(var color: Int = Color.BLACK) : Visitable {

    override fun type(typeFactory: TypeFactory): Int = typeFactory.type(this)
}