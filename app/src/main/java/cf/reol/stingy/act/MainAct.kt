package cf.reol.stingy.act

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Gravity
import android.view.View
import android.widget.PopupWindow
import android.widget.Toast
import cf.reol.stingy.R
import cf.reol.stingy.act.recycler.MultyItemAdapter
import cf.reol.stingy.act.recycler.item.Visitable
import cf.reol.stingy.act.recycler.item.AccountingItem
import cf.reol.stingy.act.recycler.item.DividerItem
import cf.reol.stingy.act.recycler.item.MemoItem
import cf.reol.stingy.act.recycler.item.TimeStampItem
import cf.reol.stingy.utils.SPUtil
import cf.reol.stingy.utils.toast
import cf.reol.stingy.widget.SelectOnePopupWindow
import kotlinx.android.synthetic.main.act_main.*
import kotlinx.android.synthetic.main.content_act_main.*

class MainAct : AppCompatActivity() {
    val data = ArrayList<Visitable>(10)
    private val adapter = MultyItemAdapter(data, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_main)
        setSupportActionBar(toolbar)

        setupData()

        fab.setOnClickListener {
            val pw = SelectOnePopupWindow(this)
            pw.setOnConfirmListener(object : SelectOnePopupWindow.OnConfirmListener{
                override fun OnClick(view: View, item: Visitable) {
//                    data.add(0, DividerItem())
//                    data.add(0, item)
//                    data.add(0,TimeStampItem())
//                    adapter.notifyDataSetChanged()
//                    rvMain.smoothScrollToPosition(0)
                    addItem(item)
                }
            })

            pw.showAtLocation(fab,Gravity.CENTER,0,0)

        }

        swipe_refresh.setOnRefreshListener { swipe_refresh.postDelayed({ swipe_refresh.isRefreshing = false },2000) }

        makeList()
    }

    private fun setupData() {
        val title = SPUtil.getData(this)
        if (title != "default"){
            addItem(MemoItem(title, System.currentTimeMillis(),""))
        }
    }

    private fun addItem(item: Visitable){
        data.add(0, DividerItem())
        data.add(0, item)
        data.add(0,TimeStampItem())
        adapter.notifyDataSetChanged()
        rvMain.smoothScrollToPosition(0)
    }

    private fun makeList() {
        rvMain.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvMain.adapter = adapter
        adapter.notifyDataSetChanged()
    }

}