package cf.reol.stingy.act.recycler

/**
 * Created by reol on 2017/8/28.
 */
interface Visitable {
    fun type(typeFactory: TypeFactory): Int
}