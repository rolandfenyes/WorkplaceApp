package aut.bme.hu.workplaceapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import aut.bme.hu.workplaceapp.data.DataManager
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.payment_main.*

class PaymentTaxesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(aut.bme.hu.workplaceapp.R.layout.payment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadPaymentTaxes()
        tvPayment.text = DataManager.getCurrentPayment().toString()+" Ft"
    }

    private fun loadPaymentTaxes() {
        var entries: ArrayList<PieEntry> = ArrayList()
        entries.add(PieEntry(DataManager.getCurrentNetPayment(), "Net payment"))
        entries.add(PieEntry(DataManager.getSZJA(), "SzJA"))
        entries.add(PieEntry(DataManager.getNYA(), "NyA"))
        entries.add(PieEntry(DataManager.getEBTH(), "EBTH"))
        entries.add(PieEntry(DataManager.getEBHK(), "EBHK"))
        entries.add(PieEntry(DataManager.getMNAJ(), "MNAH"))

        val dataSet = PieDataSet(entries, "Payment")
        dataSet.setColors(*ColorTemplate.MATERIAL_COLORS)

        val data = PieData(dataSet)
        chartPaymentTaxes.data = data
        chartPaymentTaxes.invalidate()
    }


}