package cf.reol.stingy.act.recycler.viewholder

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.TextView
import cf.reol.stingy.R
import cf.reol.stingy.act.recycler.item.AccountingItem

/**
 * Created by reol on 2017/8/29.
 */
class AccountingViewHolder(itemView: View?, val mContext: Context) : BaseViewHolder<AccountingItem>(itemView) {

    private val leftIcon: View = itemView!!.findViewById(R.id.rv_memo_icon_left)
    private val rightIcon: View = itemView!!.findViewById(R.id.rv_memo_icon_right)
    private val tvMain: TextView = itemView!!.findViewById(R.id.rv_acc_tv_main)
    private val tvDesp: TextView = itemView!!.findViewById(R.id.rv_acc_tv_description)
    private val tvMoney: TextView = itemView!!.findViewById(R.id.rv_acc_tv_money)

    override fun bindViewData(data: AccountingItem, position: Int) {
        leftIcon.setBackgroundColor(data.leftColor)
        rightIcon.setBackgroundColor(data.rightColor)
        tvMain.text = data.title
        tvDesp.text = data.description
        tvMoney.text = data.money
    }

}