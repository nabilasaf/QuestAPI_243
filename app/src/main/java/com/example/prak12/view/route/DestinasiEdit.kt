package com.example.prak12.view.route

import com.example.prak12.R

object DestinasiEdit : DestinasiNavigasi {
    override val route = "item_edit"
    override val titleRes = R.string.edit_siswa
    val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}