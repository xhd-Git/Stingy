package cf.reol.stingy.act

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Gravity
import android.view.View
import cf.reol.stingy.R
import cf.reol.stingy.act.recycler.MultyItemAdapter
import cf.reol.stingy.act.recycler.item.*
import cf.reol.stingy.data.DetailData
import cf.reol.stingy.utils.Logger
import cf.reol.stingy.utils.SPUtil
import cf.reol.stingy.utils.toast
import cf.reol.stingy.widget.SelectOnePopupWindow
import io.realm.Realm
import io.realm.RealmResults

import kotlinx.android.synthetic.main.act_main.*
import kotlinx.android.synthetic.main.content_act_main.*

class MainAct : AppCompatActivity() {

    val data = ArrayList<Visitable>(10)
    private val adapter = MultyItemAdapter(data, this)

    private val realm: Realm = Realm.getDefaultInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_main)
        setSupportActionBar(toolbar)

        setupData()

        fab.setOnClickListener {
            val pw = SelectOnePopupWindow(this)
            pw.setOnConfirmListener(object : SelectOnePopupWindow.OnConfirmListener {
                override fun OnClick(view: View, item: Visitable) {
                    addItem(item, System.currentTimeMillis())
                }
            })

            pw.showAtLocation(fab, Gravity.CENTER, 0, 0)

        }

        swipe_refresh.setOnRefreshListener { swipe_refresh.postDelayed({ swipe_refresh.isRefreshing = false }, 2000) }

        makeList()
    }

    private fun setupData() {
        val result: RealmResults<DetailData> = realm.where(DetailData::class.java).findAll()
        if (result.size > 0) {
            for (i in result){
                val item: Visitable = when (i.type) {
                    0 -> AccountingItem(title = i.title, description = i.description, content = i.content.toString(), time = i.time)
                    1 -> MemoItem(i.title, i.time, i.description, i.time)
                    else -> DividerItem()
                }
                addItem(item, i.time)
            }
        }
    }

    private fun addItem(item: Visitable, timeStamp: Long) {
        data.add(0, DividerItem())
        data.add(0, item)
        data.add(0, TimeStampItem(timeStamp))
        adapter.notifyDataSetChanged()
        rvMain.smoothScrollToPosition(0)
    }

    private fun makeList() {
        rvMain.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvMain.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

}