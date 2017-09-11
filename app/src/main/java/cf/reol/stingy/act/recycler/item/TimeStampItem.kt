package cf.reol.stingy.act.recycler.item

import cf.reol.stingy.act.recycler.TypeFactory
import java.util.*

/**
 * Created by reol on 2017/8/30.
 */
class TimeStampItem(time: Long = System.currentTimeMillis()): Visitable {
    private val calendar: Calendar = Calendar.getInstance()

    init {
        calendar.timeInMillis = time
    }
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    val minute = calendar.get(Calendar.MINUTE)

    val timeStamp: String = year.toString()+"-"+month.toString()+"-"+day.toString()+" "+hour.toString()+":"+minute.toString()

    override fun type(typeFactory: TypeFactory): Int = typeFactory.type(this)
}