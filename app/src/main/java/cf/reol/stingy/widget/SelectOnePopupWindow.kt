package cf.reol.stingy.widget

import android.app.Activity
import android.content.Context
import android.opengl.ETC1
import android.view.View
import android.widget.*
import cf.reol.stingy.R
import cf.reol.stingy.act.recycler.item.AccountingItem
import cf.reol.stingy.act.recycler.item.MemoItem
import cf.reol.stingy.act.recycler.item.Visitable
import cf.reol.stingy.utils.DeviceUtil
import cf.reol.stingy.utils.SPUtil

/**
 * Created by reol on 2017/9/1.
 */
class SelectOnePopupWindow(val context: Activity) : PopupWindow(context) {
    lateinit var listener: OnConfirmListener

    init {
        val view = View.inflate(context, R.layout.popup_select, null)
        contentView = view

        this.height = DeviceUtil.height(context) / 2
        this.width = DeviceUtil.width(context) - 100
        this.softInputMode = PopupWindow.INPUT_METHOD_NEEDED
        this.isFocusable = true
        this.setBackgroundDrawable(android.graphics.drawable.ColorDrawable(android.graphics.Color.argb(99,0,0,0)))
        this.elevation = 16f


        val pw_et_title: EditText = view.findViewById(R.id.pw_et_title)
        val pw_et_desp: EditText = view.findViewById(R.id.pw_et_desp)
        val pw_rg: RadioGroup = view.findViewById(R.id.pw_rg)
        val pw_btn_timePicker: TextView = view.findViewById(R.id.pw_btn_timePicker)
        val pw_btn_confirm: TextView = view.findViewById(R.id.pw_confirm)
        val pw_et_money: EditText = view.findViewById(R.id.pw_et_money)

        pw_rg.setOnCheckedChangeListener { _, i -> when(i){
            R.id.pw_rb_money -> {
                pw_btn_timePicker.visibility = View.GONE
                pw_et_money.visibility = View.VISIBLE
            }
            R.id.pw_rb_memo -> {
                pw_btn_timePicker.visibility = View.VISIBLE
                pw_et_money.visibility = View.GONE
            }
        } }

        pw_rg.check(R.id.pw_rb_money)


        pw_btn_timePicker.setOnClickListener { Toast.makeText(context, "showTimePicker", Toast.LENGTH_SHORT).show() }

        pw_btn_confirm.setOnClickListener {
            if (pw_rg.checkedRadioButtonId == R.id.pw_rb_money){
                listener.OnClick(it, AccountingItem(description = pw_et_desp.editableText.toString(),title = pw_et_title.editableText.toString(),
                        money = pw_et_money.editableText.toString()))
                SPUtil.setData(context, pw_et_title.editableText.toString())
            }else{
                listener.OnClick(it,MemoItem(description = pw_et_desp.editableText.toString(),title = pw_et_title.editableText.toString(),
                        timeStamp = System.currentTimeMillis()))//fixme 获取输入时间戳
                SPUtil.setData(context, pw_et_title.editableText.toString())
            }

            this.dismiss()
        }
    }

    fun setOnConfirmListener(listener: OnConfirmListener) {
        this.listener = listener
    }

    override fun showAtLocation(parent: View?, gravity: Int, x: Int, y: Int) {
        super.showAtLocation(parent, gravity, x, y)
        val lp = context.window.attributes
        lp.alpha = 0.5f
        context.window.attributes = lp
    }

    override fun dismiss() {
        super.dismiss()
        val lp = context.window.attributes
        lp.alpha = 1.0f
        context.window.attributes = lp
    }

    interface OnConfirmListener {
        fun OnClick(view: View, item: Visitable)
    }
}