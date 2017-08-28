package cf.reol.stingy.act

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity



import cf.reol.stingy.R
import kotlinx.android.synthetic.main.act_main.*

class MainAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { Snackbar.make(it,"SnackBar",Snackbar.LENGTH_SHORT).show() }
    }


}
