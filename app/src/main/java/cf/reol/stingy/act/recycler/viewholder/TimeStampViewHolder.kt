package cf.reol.stingy.act.recycler.viewholder

import android.content.Context
import android.view.View
import android.widget.TextView
import cf.reol.stingy.R
import cf.reol.stingy.act.recycler.item.TimeStampItem

/**
 * Created by reol on 2017/8/30.
 */
class TimeStampViewHolder(itemView: View?, val mContext: Context) : BaseViewHolder<TimeStampItem>(itemView){

    val timeStamp: TextView = itemView!!.findViewById(R.id.rv_timestamp)

    override fun bindViewData(data: TimeStampItem, position: Int) {
        timeStamp.text = data.timeStamp
    }

}