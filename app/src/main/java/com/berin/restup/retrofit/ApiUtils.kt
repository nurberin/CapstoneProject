package com.berin.restup.retrofit


class ApiUtils {
    companion object{
        val BASE_URL="http://upschool.canerture.com"

        fun getUrunlerDaoInterface():UrunlerDaoInterface{
            return RetrofitClient.getClient(BASE_URL)
                .create(UrunlerDaoInterface::class.java)
        }

        fun getKullaniciDaoInterface():KullaniciDaoInterface{
            return RetrofitClient.getClient(BASE_URL)
                .create(KullaniciDaoInterface::class.java)
        }
    }
}