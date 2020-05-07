package aut.bme.hu.workplaceapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import aut.bme.hu.workplaceapp.data.DataManager
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.payment_main.*
import kotlinx.android.synthetic.main.payment_monthly.*

class MonthlyPaymentFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(aut.bme.hu.workplaceapp.R.layout.payment_monthly, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        chartPaymentMonthly.layoutMode
        loadMonthlyPayment()
    }

    private fun loadMonthlyPayment() {
        var entries: ArrayList<BarEntry> = ArrayList()
        for (p in 1..12) {
            entries.add(BarEntry(p.toFloat(), DataManager.getCurrentPayment()))
        }
        val dataSet = BarDataSet(entries.toList(), "Payment monthly")
        dataSet.setColors(*ColorTemplate.MATERIAL_COLORS)

        val data = BarData(dataSet)
        chartPaymentMonthly.data = data
        chartPaymentMonthly.invalidate()
    }
}