package com.berin.restup.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.berin.restup.entity.Urunler
import com.berin.restup.repo.UrunlerdaoRepos

class AnasayfaFragmentViewModel : ViewModel(){

    private val udaor = UrunlerdaoRepos()
    var urunListesi = MutableLiveData<List<Urunler>>()

    init {
        urunleriAl()
        urunListesi = udaor.urunList()
    }

    fun urunleriAl(){
        udaor.tumUrunleriAl()
    }
    fun AnasayfaSepetiGuncelle(id:Int,sepet_durum:Int){
        udaor.sepetDurumGuncelle(id,sepet_durum)
    }

    fun urunlerYukle(){
//        val urunAdiListe = arrayListOf<String>("pijama","battaniye","yastık","carsaf takımı","tv koltugu","tabu","monopoly","scrabble","jenga","satranç&tavla&dama",
//            "masa","sandalye","laptop standı","termos bardak","defter&kalem")
//        val urunFiyatListe = arrayListOf<String>("79,99","179,99","199,99","379,99","679,99","219,99","179,99","99,99","39,99","59,99","379,99","155,99","69,99","99,99","379,99")
//        val urunAciklamaListe = arrayListOf<String>("Pamuklu rahat pijama takımı","Pamuklu sıcacık","boyun konforlu yastık","pamuklu nevresim takımı", "saatler geçirmek isteyeceğiniz bir koltuk",
//            "yasak kelimeler,çizim,kukla,en az kelimeyle anlatma","hayallerindeki servete kavuşmak için mülk satın al,emlak ticaret oyunu", "tek başına bulmaca çözmekten sıkıldın mı?"," 54 Parça Ahşap Denge Zeka ve Strateji Oyunu","Tek bir kutuda üç klasik oyun",
//            "artık kendine ait çalışma masan olmalı", "sırtını ağrıtmayacak bir sandalye","laptobunu göz hizanda tutman sağlık için önemli","artık çalışmaya dalsan bile kahven soğumayacak","çalışmalarını not alabileceğin defter kalem seti")
//        val urunGorselUrlListe = arrayListOf<String>("https://lh3.googleusercontent.com/ZIv1bQ35RFLgVQcgJ8XaNTksumCYTRO-Y0qDRTQWDDXPwOSL4J_zeFznSSxt5yg3-ShODagsu8yhf5tL6Ls9KGcr_42BoOdlDZ7fAMaeWIUHRj5KPSOx9hIbDrXNcGEE96YeRwWADlk=w2400",
//            "https://lh3.googleusercontent.com/zcFluytw1t0YLNQ0wYOo8j2fVldNgdOTpLZmCBhhQGyhW4fassIC4yocB_dKILKVPrfCXl9owPjmP55X6dXvhtqMCTW4OEtXe6QJydvOUpk6D--35uN4FMFLc5h_5wvcLnE0-eXfiRw=w2400",
//            "https://lh3.googleusercontent.com/zcFluytw1t0YLNQ0wYOo8j2fVldNgdOTpLZmCBhhQGyhW4fassIC4yocB_dKILKVPrfCXl9owPjmP55X6dXvhtqMCTW4OEtXe6QJydvOUpk6D--35uN4FMFLc5h_5wvcLnE0-eXfiRw=w2400",
//            "https://lh3.googleusercontent.com/OQ_-OcxJjA0_CYwmLD88zKyq9yP1sl3h8hBDgwwjo32IAql2aw2CRA9whcUXUUIQDP7U6B93Z7Hmg8s0wnx730hs9aeGIzxCYKH6I8o4uEDAOfuAomM0dQxMgmP6rnqXXGdE2uulCOA=w2400",
//            "https://lh3.googleusercontent.com/PtY4ZNGtyjTSFxiSv7U7ouUhoYdeRWGJrw4HR9Bc4bqbJEjYljqg3nQwmHX6WBi7kKRS7OXINt1zTujcFIXXu9KqoiZLRemNV2XKyk7HcvozxjB1sSF87uej_PXLlqWer24Rq5i5mmU=w2400",
//            "https://lh3.googleusercontent.com/kZL7UFFbK4m8gkeX_EFHCUG5DSL1M3Y089Lo7QlL2-QzlqEDDcsFeYaSFJ0CsymCxC98tnSWWGm_dcPTOW1lFresfxmC3yfoLTEFM4xhuT0Qd7_no_bsG3M98pkJP1t7ULpNO8OpwVY=w2400",
//            "https://lh3.googleusercontent.com/FkWB2nGn9mM3aUmrlj_-QO5mQjvlwWhst2H8JIAEr_rbE3qcUu0p6tQaFHDlnoYwk8kcAQHNCMqKJK1ErVQ0HibP8dyHbaafJ3sZ1eM5cV5nztSSR6mv3s1Oi5aZy6grFyQNU-uYgoY=w2400",
//            "https://lh3.googleusercontent.com/IU0Vu5q5dzB3m0notFePitBZdtLul5k7KPgXSkad_82L_tnzCenJoa70XFO2kRyM0urDGO00Gh4C7kLCTfEazPQw8Hxlk6ls4cVefCvTCHan9DqD91dxaXPsfOYDpYj0jFjbvzHycIU=w2400",
//            "https://lh3.googleusercontent.com/_F0COnp0i0umKnU6KuzWxKC8JZ34YeVpF7YN0Q11X5XUMJAFUfG6sfAOfatWG34gX19eNNFNDtho76q7EZbFVFvOgpy0pUrodFR9T0swnNK8MEOyDY4aA4A8lPn_nH-bgY4IYMeIDhg=w2400",
//            "https://lh3.googleusercontent.com/WarzgDE9bdLDmIolu-m0dwshnGwrUSf-LrKRVDWD4DWn-YEB90iMFW2_Ej0kA9NTgLV9CuGCa74rVUr6qhqLotfOyJFDs2rxGunpt7y9cIaMMk-iEWR-jsumb-oWdFUoZBgS4R0Ljas=w2400",
//            "https://lh3.googleusercontent.com/tqQ1-kNVZAs2XGPhv3pJ2RcGVw3y1mAAn2Ir3D2LqBiUH8VBOItrkzYrDwRW1KPCKJFdkdk7POP8WUhNEOedvkecub3XJa8s4x1ZJjJWX_45N_ZmVeLqC1iZf-eF-EdGBsSY6mHV4QM=w2400",
//            "https://lh3.googleusercontent.com/WBPeXCKOxWG0HALeny7nqwNJdp9oHxFZDvr7As0RSj_NC5CmehLCQm_-nyyz_mLEIgFPSo3h2DJKWxUXXiKp8vb5g9qR4ZUOWGcgzxH4SLDfWojSvbvnvahJyuCMd6DF5BLQY_-edD0=w2400",
//            "https://lh3.googleusercontent.com/6WaCf7fIBqiX97OuC_UmCdzhgP35P6CzDb1UTOJd4HPa-K3ZCBc-D_4611Q7fH52dHVcFkkQHwUbapIwYa4VMo0MOkxfZ3vP1rm6EOv2bsHyWraUZCfLUQcbNjaJ6rZ8hEgzZuvS0j0=w2400",
//            "https://lh3.googleusercontent.com/SDUb3KTjJKJSujY44XAUBDj7-V-ku5TGISSGOLPg8kzjqZAyrC4eF0rEPM8PKmk1FCEz3HX8h39IJwnGTRhUZwInXYDtnbrihfR3hUb4WeJlnpTzH9D4-56ijFp_mC2DLfkM7qiQ600=w2400",
//            "https://lh3.googleusercontent.com/o7g7KtXnHvVrpE3ld8mG8QC3FkIDqNx1__B1atfoA31jZweXoIomsXpJXYUSzo1HrJsTWIMw0SSZ_CX1DTcAJi9F5KYYUlku4ucf8eznvt7CRSs-KA8dwKX0dGCnzSjkThEJnQqRUuo=w2400"
//        )
//
//        val kampanyaliUrunAdListe = arrayListOf<String>("Uyku Paketi","Aileyle Eğlence Paketi","Çalışma Paketi")
//        val kampanyaliUrunFiyatListe = arrayListOf<String>("1000","400","800")
//        val kampanyaliUrunAciklamaListe = arrayListOf<String>("Eve kapanma döneminde yataktan çıkmaz mı oldunuz? Bu paket tam sizlik.. Konforunuz için her şey düşünülmüş",
//            "Evde telefonlara dalıp ailemizi unutmaya son! Ailenizle sosyalleşmek için oynayabileceğiniz eğlence seti",
//            "Uzaktan çalışma döneminde hem rahat çalışma hem de şirket ortamını size sunmak için bu set tam sizlik")
//        val kampanyaliUrunGorselListe = arrayListOf<String>("https://lh3.googleusercontent.com/QKkP2ySKy4Mg2BIz1dC-trBig7iP0n2iAhrdad1ElUyEN5ASiw0eTWplyEwZYFM7PILVZXk1lWMgtKCJ9eGt3xOIqSUovX6aSaEHcaWRkTNorFK3B4JrEWoTroPDpJvjZa9mUqBv7us=w2400",
//            "https://lh3.googleusercontent.com/dSD_Zt7ed-OSgUVPkNZ3CVkLF-8MyqIipxW3AolywNIOzSF3RNlF4_2HysI0ViXBMJEn1Dz3_cX92siJJngdF8zHWOQmr_6NJTfEbgdCiSN4q5sFCGvEGO8E9n4zywPrU_B4mPssIWk=w2400",
//            "https://lh3.googleusercontent.com/QM49k9uv2B4do47g_m5pl2Eh9FIekryUCkvR6GzFQkPPAnBI8Mh3YovODdOBwzTCF3prIC1JlV8UtbTRTCgk2W3p4mMs44TCnLGuoWuVajjxQLn0e3k8ryvQZ1nO4c1VL3EGEYEcIIQ=w2400")
//
//        for (i in 0 until kampanyaliUrunAdListe.size){
//            udaor.urunYukle("nurberinteker",kampanyaliUrunAdListe[i],kampanyaliUrunFiyatListe[i],kampanyaliUrunAciklamaListe[i],kampanyaliUrunGorselListe[i],0,1)
//        }
//
//        for(i in 0 until urunAdiListe.size){
//            udaor.urunYukle("nurberinteker",urunAdiListe[i],urunFiyatListe[i],urunAciklamaListe[i],urunGorselUrlListe[i],0,0)
//        }

    }

}