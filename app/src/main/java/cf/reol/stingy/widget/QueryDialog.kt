package cf.reol.stingy.widget

import android.app.Dialog
import android.content.Context
import android.view.View
import cf.reol.stingy.R
import kotlinx.android.synthetic.main.dialog_query.*

/**
 * Created by reol on 2017/9/1.
 */
class QueryDialog(context: Context?) : Dialog(context) {
    init {
        this.requestWindowFeature(android.view.Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_query)
        dialog_2btn_tv2.visibility = View.GONE
        dialog_2btn_btn1.setOnClickListener{this.dismiss()}
    }

    fun setOkBtnText(text: String):QueryDialog{
        dialog_2btn_btn2.text = text
        return this
    }

    fun setCancelBtnText(text: String):QueryDialog{
        dialog_2btn_btn1.text = text
        return this
    }

    fun setMainText(text: String): QueryDialog{
        dialog_2btn_tv1.text = text
        return this
    }

    fun setSecondaryText(text: String): QueryDialog{
        dialog_2btn_tv2.visibility = View.VISIBLE
        dialog_2btn_tv2.text = text
        return this
    }

    fun setOkBtnListener(listener:View.OnClickListener):QueryDialog{
        dialog_2btn_btn2.setOnClickListener(listener)
        return this
    }

    fun setCancelBtnListener(listener: View.OnClickListener):QueryDialog{
        dialog_2btn_btn1.setOnClickListener(listener)
        return this
    }

}