package cf.reol.stingy.act.recycler.viewholder

import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.View

/**
 * Created by reol on 2017/8/28.
 */
open abstract class BaseViewHolder<T>(itemView: View?, private val mViews: SparseArray<View> = SparseArray()) : RecyclerView.ViewHolder(itemView) {

    var mItem = itemView

    fun getView(resId: Int): View {
        val view: View
        if (mViews.get(resId) != null){
            view = mViews.get(resId)
        }else{
            view = mItem!!.findViewById(resId)
            mViews.put(resId, view)
        }
        return view
    }

    abstract fun bindViewData(data: T, position: Int)
}