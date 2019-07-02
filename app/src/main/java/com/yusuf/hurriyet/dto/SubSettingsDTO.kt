package com.yusuf.hurriyet.dto


data class SubSettingsDTO(val options: String = "",val offmode:String= "" ,val settings:String="") : BaseModel {
    override val type: Int
        get() = BaseModel.TYPE_NAV_SUB_SETTİNGS
}