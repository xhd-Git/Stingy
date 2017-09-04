package cf.reol.stingy.act.recycler.viewholder

import android.content.Context
import android.util.SparseArray
import android.view.View
import android.widget.TextView
import android.widget.Toast
import cf.reol.stingy.R
import cf.reol.stingy.act.recycler.item.MemoItem
import kotlinx.android.synthetic.main.rv_item_memo.*

/**
 * Created by reol on 2017/8/30.
 */
class MemoViewHolder(itemView: View?, private val mContext: Context) : BaseViewHolder<MemoItem>(itemView) {

    private val title: TextView = itemView!!.findViewById(R.id.rv_memo_title)
    private val status: TextView = itemView!!.findViewById(R.id.rv_memo_status)

    override fun bindViewData(data: MemoItem, position: Int) {
        title.text = data.title
        status.text = data.status

        itemView.setOnClickListener{Toast.makeText(mContext,data.description,Toast.LENGTH_SHORT).show()}
    }
}