package aut.bme.hu.workplaceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import androidx.appcompat.app.AlertDialog
import aut.bme.hu.workplaceapp.data.DataManager
import aut.bme.hu.workplaceapp.fragments.DatePickerDialogFragment
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.activity_holiday.*
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList

class HolidayActivity : AppCompatActivity(), DatePickerDialogFragment.OnDateSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_holiday)

        btnTakeHoliday.setOnClickListener {
            DatePickerDialogFragment().show(supportFragmentManager, "DATE_TAG")
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

    override fun onDateSelected(year: Int, month: Int, dayOfMonth: Int) {
        var numHolidays = DataManager.holidays

        if (DataManager.getRemainingHolidays() > 0 && dateValidation(year, month, dayOfMonth)) {
            DataManager.holidays = numHolidays + 1
        } else {
            createErrorMessage()
        }

        loadHolidays()
    }

    fun createErrorMessage() {
        val builder = AlertDialog.Builder(this@HolidayActivity)
        builder.setTitle("Error")
        builder.setMessage("You cannot take holiday in the past!")
        builder.setPositiveButton("OK") {dialog, which -> }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    fun dateValidation(year: Int, month: Int, dayOfMonth: Int) : Boolean {
        val current = Calendar.getInstance()
        var currentYear = current.get(Calendar.YEAR)
        var currentMonth = current.get(Calendar.MONTH)
        var currentDay = current.get(Calendar.DAY_OF_MONTH)

        if (year >= currentYear && month > currentMonth) {
            return true
        } else return year >= currentYear && month == currentMonth && dayOfMonth >= currentDay
    }


}
