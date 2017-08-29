package cf.reol.stingy.act.recycler.item

import android.graphics.Color
import cf.reol.stingy.act.recycler.TypeFactory
import cf.reol.stingy.act.recycler.Visitable

/**
 * Created by reol on 2017/8/29.
 */
class AccountingItem: Visitable {
    var leftColor: Int = Color.CYAN
    var rightColor: Int = Color.GRAY
    var title: String = ""
    var description: String = ""
    var money: String = "0.0"

    constructor(leftColor: Int, rightColor: Int, title: String, description: String, money: String) {
        this.leftColor = leftColor
        this.rightColor = rightColor
        this.title = title
        this.description = description
        this.money = money
    }

    override fun type(typeFactory: TypeFactory): Int = typeFactory.type(this)
}