package aut.bme.hu.workplaceapp.fragments

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.lang.ClassCastException
import java.lang.RuntimeException
import java.util.*

class DatePickerDialogFragment : DialogFragment(), DatePickerDialog.OnDateSetListener{

    private lateinit var onDateSelectedListener: OnDateSelectedListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            onDateSelectedListener = if(targetFragment != null) {
                targetFragment as OnDateSelectedListener
            } else {
                activity as OnDateSelectedListener
            }
        } catch (e: ClassCastException) {
            throw RuntimeException(e)
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var c = Calendar.getInstance()
        var year = c.get(Calendar.YEAR)
        var month = c.get(Calendar.MONTH)
        var day = c.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(
            activity!!, this, year, month, day
        )
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        onDateSelectedListener.onDateSelected(year, month, dayOfMonth)
    }
    interface OnDateSelectedListener {
        fun onDateSelected(year: Int, month: Int, dayOfMonth: Int)
    }
}