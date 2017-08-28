package cf.reol.stingy.act.recycler

import android.view.View
import cf.reol.stingy.act.recycler.item.DividerItem
import cf.reol.stingy.act.recycler.viewholder.BaseViewHolder

/**
 * Created by reol on 2017/8/28.
 */
interface TypeFactory {
    fun type(item: DividerItem): Int

    fun createViewHolder(type: Int, itemView: View)
}