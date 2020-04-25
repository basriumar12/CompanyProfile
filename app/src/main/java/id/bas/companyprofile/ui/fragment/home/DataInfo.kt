package id.bas.companyprofile.ui.fragment.home

import id.bas.companyprofile.ui.fragment.home.model.ModelInfo

object DataInfo {

    val nameInfo =  arrayOf(
        "Pembuatan Aplikasi Ojek Online",
        "Pembuatan Aplikasi Akuntansi",
        "Pembuatan Ojek Online Sistem"
    )

    val imageInfo = arrayOf(
        "https://assets.jalantikus.com/assets/cache/500/284/userfiles/2019/02/04/aplikasi-ojek-online-3-a8d5d.jpg",
        "https://ecs7.tokopedia.net/img/cache/700/product-1/2016/7/26/9410026/9410026_bbde85d5-694c-4a27-a3b3-db2159a48ae7.jpg",
        "https://ecs7.tokopedia.net/img/cache/700/product-1/2016/7/26/9410026/9410026_bbde85d5-694c-4a27-a3b3-db2159a48ae7.jpg"

    )

    val detailInfo = arrayOf(
        "http:///google",
        "http:///google",
        "http:///google"

    )


    val listData : ArrayList<ModelInfo>
    get() {
        val list = ArrayList<ModelInfo>()
        for (posisi in nameInfo.indices){
            val modelInfo = ModelInfo()
            modelInfo.nameInfo = nameInfo[posisi]
            modelInfo.imageInfo = imageInfo[posisi]
            modelInfo.detailInfo = detailInfo[posisi]

            list.add(modelInfo)

        }

        return list

    }
}