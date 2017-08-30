package cf.reol.stingy.act.recycler

import android.content.Context
import android.util.Log
import android.view.View
import cf.reol.stingy.R
import cf.reol.stingy.act.recycler.item.AccountingItem
import cf.reol.stingy.act.recycler.item.DividerItem
import cf.reol.stingy.act.recycler.item.MemoItem
import cf.reol.stingy.act.recycler.item.TimeStampItem
import cf.reol.stingy.act.recycler.viewholder.*
import kotlinx.android.synthetic.main.rv_item_divider.view.*

/**
 * Created by reol on 2017/8/29.
 */
class ItemTypeFactory(private val mContext: Context) : TypeFactory {

    override fun type(item: DividerItem): Int = DIVIDER_ITEM_LAYOUT
    override fun type(item: AccountingItem): Int = ACCOUNTING_ITEM_LAYOUT
    override fun type(item: MemoItem): Int = MEMO_ITEM_LAYOUT
    override fun type(item: TimeStampItem): Int = TIME_STAMP_LAYOUT

    override fun createViewHolder(type: Int, itemView: View): BaseViewHolder<Any?>? = when(type){
        DIVIDER_ITEM_LAYOUT -> DividerViewHolder(itemView, mContext) as? BaseViewHolder<Any?>
        ACCOUNTING_ITEM_LAYOUT -> AccountingViewHolder(itemView, mContext) as? BaseViewHolder<Any?>
        MEMO_ITEM_LAYOUT -> MemoViewHolder(itemView, mContext) as? BaseViewHolder<Any?>
        TIME_STAMP_LAYOUT -> TimeStampViewHolder(itemView, mContext) as? BaseViewHolder<Any?>
        else -> null
    }

    companion object {
        val DIVIDER_ITEM_LAYOUT: Int = R.layout.rv_item_divider
        val ACCOUNTING_ITEM_LAYOUT: Int = R.layout.rv_item_accounting
        val MEMO_ITEM_LAYOUT: Int = R.layout.rv_item_memo
        val TIME_STAMP_LAYOUT: Int = R.layout.rv_item_time_stamp
    }
}