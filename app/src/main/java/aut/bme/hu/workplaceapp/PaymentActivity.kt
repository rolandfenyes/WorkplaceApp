package aut.bme.hu.workplaceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import aut.bme.hu.workplaceapp.adapter.PaymentPagerAdapter
import aut.bme.hu.workplaceapp.adapter.ProfilePagerAdapter
import kotlinx.android.synthetic.main.activity_payment.*
import kotlinx.android.synthetic.main.activity_profile.*

class PaymentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        vpPayment.adapter = PaymentPagerAdapter(this)

    }
}
