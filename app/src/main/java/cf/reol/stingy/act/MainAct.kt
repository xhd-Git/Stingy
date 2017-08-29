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
import kotlinx.android.synthetic.main.act_main.*
import kotlinx.android.synthetic.main.content_act_main.*

class MainAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { Snackbar.make(it,"SnackBar",Snackbar.LENGTH_SHORT).show() }

        makeList()
    }

    private fun makeList() {
        val data = ArrayList<Visitable>(10)
        data.add(AccountingItem(Color.BLACK,Color.RED,"外卖","南城香满40-20","22.8"))
        data.add(DividerItem(Color.GRAY))
        data.add(AccountingItem(Color.BLACK,Color.RED,"外卖","田老师40-20","21.8"))
        data.add(DividerItem(Color.GRAY))
        data.add(AccountingItem(Color.BLACK,Color.RED,"外卖","南城香满40-20","22.8"))
        data.add(DividerItem(Color.GRAY))
        data.add(AccountingItem(Color.BLACK,Color.RED,"超市","啥玩意啊","28"))
        data.add(AccountingItem(Color.BLACK,Color.RED,"超市","啥玩意啊","28"))
        data.add(DividerItem(Color.GRAY))

        Log.d("asdfg", data.toString())
        val adapter = MultyItemAdapter(data, this)
        rvMain.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rvMain.adapter = adapter
    }


}
