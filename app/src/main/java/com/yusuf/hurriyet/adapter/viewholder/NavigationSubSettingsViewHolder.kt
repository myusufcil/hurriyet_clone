package com.yusuf.hurriyet.adapter.viewholder

import android.view.View
import android.widget.Switch
import android.widget.TextView
import com.yusuf.hurriyet.R
import com.yusuf.hurriyet.adapter.BaseViewHolder
import com.yusuf.hurriyet.dto.BaseModel
import com.yusuf.hurriyet.dto.SubSettingsDTO


class NavigationSubSettingsViewHolder (view: View): BaseViewHolder(view){
    var navSettings=view.findViewById<TextView>(R.id.item_navigation_sub_settings_settings_text)
    var offlineMode=view.findViewById<TextView>(R.id.item_navigation_sub_settings_off_mode)
    var switcher = view.findViewById<Switch>(R.id.salt_text_mode)
    override fun bindView(items: BaseModel, position: Int) {
        var item = items as SubSettingsDTO
        switcher .text = item.options
        offlineMode.text=item.offmode
        navSettings.text=item.settings
    }
}