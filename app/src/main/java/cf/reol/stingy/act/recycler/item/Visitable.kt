package cf.reol.stingy.act.recycler.item

import cf.reol.stingy.act.recycler.TypeFactory

/** recyclerView 的 item 都要实现
 * Created by reol on 2017/8/28.
 */
interface Visitable {
    fun type(typeFactory: TypeFactory): Int
}