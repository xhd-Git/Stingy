package cf.reol.stingy.act.recycler

import android.content.Context
import android.util.Log
import android.view.View
import cf.reol.stingy.R
import cf.reol.stingy.act.recycler.item.AccountingItem
import cf.reol.stingy.act.recycler.item.DividerItem
import cf.reol.stingy.act.recycler.viewholder.AccountingViewHolder
import cf.reol.stingy.act.recycler.viewholder.BaseViewHolder
import cf.reol.stingy.act.recycler.viewholder.DividerViewHolder
import kotlinx.android.synthetic.main.rv_item_divider.view.*

/**
 * Created by reol on 2017/8/29.
 */
class ItemTypeFactory(private val mContext: Context) : TypeFactory {

    override fun type(item: DividerItem): Int = DIVIDER_ITEM_LAYOUT
    override fun type(item: AccountingItem): Int = ACCOUNTING_ITEM_LAYOUT

    override fun createViewHolder(type: Int, itemView: View): BaseViewHolder<Any?>? {
        when(type){
            DIVIDER_ITEM_LAYOUT -> return DividerViewHolder(itemView, mContext) as? BaseViewHolder<Any?>
            ACCOUNTING_ITEM_LAYOUT -> return AccountingViewHolder(itemView, mContext) as? BaseViewHolder<Any?>
            else -> return null
        }
    }

    companion object {
        val DIVIDER_ITEM_LAYOUT: Int = R.layout.rv_item_divider
        val ACCOUNTING_ITEM_LAYOUT: Int = R.layout.rv_item_accounting
    }
}