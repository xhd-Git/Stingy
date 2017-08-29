package cf.reol.stingy.act.recycler.viewholder

import android.content.Context
import android.util.Log
import android.util.SparseArray
import android.view.View
import cf.reol.stingy.R
import cf.reol.stingy.act.recycler.item.DividerItem
import kotlinx.android.synthetic.main.rv_item_divider.view.*

/**
 * Created by reol on 2017/8/28.
 */
class DividerViewHolder(itemView: View?, val mContext: Context) : BaseViewHolder<DividerItem>(itemView) {

    override fun bindViewData(data: DividerItem, position: Int) {
        itemView.findViewById<View>(R.id.rv_divider).setBackgroundColor(data.color)
    }

}