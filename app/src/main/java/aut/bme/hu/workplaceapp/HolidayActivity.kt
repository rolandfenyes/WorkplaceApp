package aut.bme.hu.workplaceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import aut.bme.hu.workplaceapp.data.DataManager
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.activity_holiday.*
import kotlinx.android.synthetic.main.activity_menu.*

class HolidayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_holiday)

        btnTakeHoliday.setOnClickListener {
            //TODO
        }

        loadHolidays()

    }

    private fun loadHolidays() {
        var entries: ArrayList<PieEntry> = ArrayList()

        entries.add(PieEntry(DataManager.holidays.toFloat(), "Taken"))
        entries.add(PieEntry(DataManager.getRemainingHolidays().toFloat(), "Remaining"))

        val dataSet = PieDataSet(entries, "Holidays")
        dataSet.setColors(*ColorTemplate.MATERIAL_COLORS)

        val data = PieData(dataSet)
        chartHoliday.data = data
        chartHoliday.invalidate()
    }


}
