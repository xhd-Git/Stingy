package cf.reol.stingy.act.recycler

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import cf.reol.stingy.act.recycler.viewholder.BaseViewHolder

/**
 * Created by reol on 2017/8/29.
 */
class MultyItemAdapter(private val mData: List<Visitable>, context: Context): RecyclerView.Adapter<BaseViewHolder<Any?>?>() {
    private val typeFactory: TypeFactory
    init {
        typeFactory = ItemTypeFactory(context)
    }

    override fun getItemCount(): Int = mData.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder<Any?>? {
        Log.d("asdfg", viewType.toString())
        val view = LayoutInflater.from(parent?.context).inflate(viewType, parent, false)
        return typeFactory.createViewHolder(viewType, view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Any?>?, position: Int) {
        holder?.bindViewData(mData[position], position)
        Log.d("asdfg", holder.toString())
    }

    override fun getItemViewType(position: Int): Int = mData[position].type(typeFactory)

}