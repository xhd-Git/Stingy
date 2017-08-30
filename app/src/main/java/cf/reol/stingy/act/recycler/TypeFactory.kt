package cf.reol.stingy.act.recycler

import android.view.View
import cf.reol.stingy.act.recycler.item.AccountingItem
import cf.reol.stingy.act.recycler.item.DividerItem
import cf.reol.stingy.act.recycler.item.MemoItem
import cf.reol.stingy.act.recycler.item.TimeStampItem
import cf.reol.stingy.act.recycler.viewholder.BaseViewHolder

/**
 * Created by reol on 2017/8/28.
 */
interface TypeFactory {
    fun type(item: DividerItem): Int
    fun type(item: AccountingItem): Int
    fun type(item: MemoItem): Int
    fun type(item: TimeStampItem): Int

    fun createViewHolder(type: Int, itemView: View): BaseViewHolder<Any?>?
}