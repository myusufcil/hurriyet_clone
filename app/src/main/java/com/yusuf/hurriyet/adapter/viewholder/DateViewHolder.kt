package com.yusuf.hurriyet.adapter.viewholder

import android.view.View
import android.widget.TextView
import com.yusuf.hurriyet.adapter.BaseViewHolder
import com.yusuf.hurriyet.R
import com.yusuf.hurriyet.dto.BaseModel
import com.yusuf.hurriyet.dto.DateDTO
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class DateViewHolder (view: View): BaseViewHolder(view){

    private val item_date_textview_date=view.findViewById(R.id.item_date_textview_date) as TextView
    override fun bindView(items: BaseModel, position: Int) {

        var item = items as DateDTO
        item_date_textview_date.text =convertISOTimeToDate(item.date)

    }
    private fun convertISOTimeToDate(isoTime: String): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS")
        var convertedDate: Date? = null
        var formattedDate = ""
        try {
            convertedDate = sdf.parse(isoTime)
            formattedDate = SimpleDateFormat("EEE, d MMM yyyy , HH:mm:ss").format(convertedDate)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return formattedDate
    }
}