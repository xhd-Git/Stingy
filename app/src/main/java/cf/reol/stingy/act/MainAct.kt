package cf.reol.stingy.act

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import cf.reol.stingy.R
import cf.reol.stingy.act.recycler.MultyItemAdapter
import cf.reol.stingy.act.recycler.Visitable
import cf.reol.stingy.act.recycler.item.AccountingItem
import cf.reol.stingy.act.recycler.item.DividerItem
import cf.reol.stingy.act.recycler.item.MemoItem
import cf.reol.stingy.act.recycler.item.TimeStampItem
import cf.reol.stingy.utils.Logger
import kotlinx.android.synthetic.main.act_main.*
import kotlinx.android.synthetic.main.content_act_main.*

class MainAct : AppCompatActivity() {
    val data = ArrayList<Visitable>(10)
    private val adapter = MultyItemAdapter(data, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            data.add(0,DividerItem(Color.RED))
            data.add(0,MemoItem("备忘记录", 1504182660000L))
            adapter.notifyDataSetChanged()
            rvMain.smoothScrollToPosition(0)
        }

        makeList()
    }

    private fun makeList() {

        data.add(AccountingItem(Color.BLACK, Color.RED, "外卖", "南城香满40-20", "22.8"))
        data.add(DividerItem(Color.GRAY))
        data.add(AccountingItem(Color.BLACK, Color.RED, "外卖", "田老师40-20", "21.8"))
        data.add(TimeStampItem(System.currentTimeMillis()))
        data.add(AccountingItem(Color.BLACK, Color.RED, "超市", "啥玩意啊", "28"))
        data.add(MemoItem("备忘记录", 1504182660000L))
        data.add(DividerItem(Color.GRAY))

        rvMain.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvMain.adapter = adapter
        adapter.notifyDataSetChanged()
    }


}
