package com.example.modev4

import androidx.appcompat.app.AppCompatActivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sehir_aciklama.view.*
import kotlinx.android.synthetic.main.sehiradlari.view.*


class MainActivity : AppCompatActivity() {
    var adapter: FoodAdapter? = null
    var foodsList = ArrayList<sehirler>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // load foods
        foodsList.add(sehirler("İstanbul", R.drawable.istanbul, "İstanbul dünyanın en büyük, en önemli ve en güzel şehirlerinden birisidir. Boğazın iki yakasına yayılmış, olağanüstü güzellikteki tepeler, şehrin sakinlerini ve ziyaretçilerini sürekli büyüler. Dünya tarihinin en önemli komutanlarından ve devlet adamlarından biri olan Napolyon, “Eğer dünya tek bir devlet olsaydı, İstanbul başkent olurdu” demiştir. Bu gerçekten de doğrudur. İstanbul’un önemini anlayabilmemiz için tarihe bakmamız gerekir."))
        foodsList.add(sehirler("Malatya", R.drawable.malatya, "Doğal, tarihi ve kültürel bereketi ile yıllar boyunca tarih sayfalarında önemli bir yer edinen Kayısı Diyarı Malatya, Doğu Anadolu Bölgesi'nin Yukarı Fırat Havzası'nda yer almaktadır. Güneydoğu Torosların yüksek batı kısmını oluşturan sıradağlar, ilin güneyinde geniş yer kaplar. Bu dağ sıralarının kuzeyinde Malatya Ovası uzanır. Bu büyük ovayı Tohma Suyu ikiye böler. Fırat, Tohma, Söğütlü, Sultansuyu, Beylerderesi, Derme Suyu, Kuru Çay, Sürgü ve Şiro Çayı Malatya'nın belli başlı akarsularıdır. Malatya sınırlarında plato ve ovalar geniş yer tutar. Başlıca ovalar Malatya, Doğanşehir, İzollu, Akçadağ, Yazıhan, Mandıra, Distrik, Erkenek, Mığdı, Sürgü ve Çaplı Ovalarıdır."))
        foodsList.add(sehirler("Erzurum", R.drawable.erzurum, "Palandöken Dağı'nın bölgede bulunması kış turizminin oldukça gelişmesini sağlamıştır. Yöresel yemekler konusunda da oldukça başarılı olan Erzurum'a kendine ait lezzetleri bulunur. Erzurum Doğu Anadolu Bölgesi'nin en büyük şehirlerinden biridir. Bu sebeple Erzurum şehri bölge için oldukça önemli bir şehirdir. Doğu Anadolu'nun gelişen yapısına göre Erzurum gelişmiş olan bir şehir olarak kendinden söz ettirir."))
        foodsList.add(sehirler("Kars",R.drawable.karrs, "Türkiye'nin en yüksek il merkezlerinden biri olan Kars, köyleri ile birlikte nüfusu 100 bini aşan şehirlerdendir (Şehir merkezi: 102.001, toplam: 129.458). Merkez ilçeye bağlı, yirmi üç mahalle ve yetmiş köy bulunmaktadır. Çeşitli etnisitelerin birlikte yaşadığı il merkezinde kültürel farklılıklardan ve zenginliklerden bahsetmek mümkün olup kozmopolit bir yapı söz konusudur. Kars, Kültür ve Turizm Bakanlığı'nın 2023 yılı için Türkiye Turizm Stratejisi 2023 ve Turizm Stratejisi Eylem Planı kapsamına alınan 15 il merkezinden birisidir. Bu proje ile hedeflenen, il merkezlerini Kültür Turizmi Geliştirilecek Marka Kentler ilan edip gelişmelerini sağlamaktır."))
        foodsList.add(sehirler("Kastamonu", R.drawable.kastamonu, "Kastamonu, Türkiye'nin kuzey kesiminde, Karadeniz Bölgesi'nde yer alan ildir. İlin komşularını Sinop, Çorum, Çankırı, Karabük ve Bartın illeri oluşturmakta olup, ilin ayrıca kuzeyde Karadeniz'e kıyısı bulunmaktadır. İlin merkezi aynı isimli Kastamonu şehridir."))
        foodsList.add(sehirler("Kayseri", R.drawable.kayseri, "Orta Kızılırmak Bölümünde, Erciyes Dağı'nın eteklerinde bir ildir. Kuzey ve kuzeybatıda Yozgat, kuzey ve kuzeydoğuda Sivas, doğuda Kahramanmaraş, güneyde Adana, güneybatıda Niğde, batıda ise Nevşehir illeriyle çevrilidir. Dünyanın en eski şehirlerinden biri olan Kayseri (eski Mazaka, Kaisareia), klasik çağlarda Kapadokya adı verilen bölgededir. Kızılırmak'ın güneyinde bulunan bu bölge, Tuz Gölü'nden Fırat nehrine kadar uzanır. İpek Yolu buradan geçer. Bölge, pek çok uygarlığın beşiği olmuştur."))
        foodsList.add(sehirler("Samsun", R.drawable.samsun, "Samsun, Türkiye'nin büyükşehir statüsündeki otuz ilinden biridir. Karadeniz Bölgesi'ndeki Orta Karadeniz Bölümü'nde, Türkiye coğrafyasının en kuzeyinde merkezî bir noktada yer alır. On yedi ilçesi ve 1.247 mahallesi bulunan Samsun, 1.348.542 kişilik nüfusuyla bölgenin en yüksek, Türkiye'nin ise on altıncı en yüksek nüfuslu ilidir. Doğusunda Ordu, güneyinde Tokat ve Amasya, batısında ise Çorum ve Sinop illeri ile çevrili olup kuzeyinde Karadeniz bulunur. Karadeniz Bölgesi'nin eğitim, sağlık, sanayi, ticaret, ulaşım ve ekonomi açılarından en gelişmiş şehri olan Samsun kalkınmada birinci derecede öncelikli yörelerden biridir."))
        foodsList.add(sehirler("Kahramanmaraş", R.drawable.kahramanmaas, "Kahramanmaraş, eski ve halk arasındaki adıyla Maraş, Türkiye'nin Akdeniz Bölgesinde bulunan bir ili ve en kalabalık on sekizinci kentidir. Kurtuluş Savaşı'nda işgale direnişi nedeniyle TBMM tarafından 5 Nisan 1925'te şehre İstiklal Madalyası verilmiştir. Maraş olan adı, 7 Şubat 1973'te Kahramanmaraş olarak değiştirilmiştir.\n" +
                "\n" +
                "Geç Hitit şehri olan Gurgum’un bulunduğu yerde kurulmuştur. Sistematik bir kazı yapılmamış olmasına rağmen birçok Hitit anıtı bulunmuştur.\n" +
                "\n" +
                "Osmanlı seyyahı Evliya Çelebi, seyahatnamesinde Maraş halkı için, \"kelimatları lisan-ı Türkidir ve ekseriya halkı Türkmendir\" der. Maraş ve çevresi başta Oğuzların Avşar, Bayat ve Beydili boyları çoğunlukta olmakla birlikte hemen hemen 24 Oğuz boyunun tamamı mevcuttur."))
        foodsList.add(sehirler("İzmir", R.drawable.izmir, "İzmir, Türkiye'nin bir ili ve en kalabalık üçüncü şehridir. Nüfusu 2019 itibarıyla 4.367.251 kişidir. Bu nüfus; 30 ilçe ve bu ilçelere bağlı 1.297 mahallede yaşamaktadır. İl genelinde nüfus yoğunluğu 367'dir. Coğrafi olarak Türkiye'nin batısında bulunur ve ilin tamamı Ege Bölgesi'nde yer alır. Yüzölçümü olarak ülkenin yirmi üçüncü büyük ilidir. Etrafı Aydın, Balıkesir, Manisa illeri ve Ege Denizi ve Ege Adaları ile çevrilidir."))
        foodsList.add(sehirler("Van", R.drawable.van, "Van isminin nereden geldiğine dair belli bir kaynak yoktur ancak kabul edilen iki ayrı görüş bulunmaktadır. Bunlardan birincisi şehir kurulduktan sonra Van adında bir valinin gelip şehri bayındır hale getirmesinden dolayı isminin verildiğidir. İkinci görüş ise Urartular'ın şehir için kullandıkları \"Viane\" ve \"Biane\" kelimelerinden türemiş olduğudur. Bölgenin hakim dillerinde yapılan bütün karşılaştırmalarda her iki kelime yakin anlamda görünmektedir. Her iki kelime de sehir ve yerleşime ilişkindir. Dolayisiyla Van yerleşim yeri , şehir, memleket yore benzeri anlamdadır. Bunlardan en yuksek ihtimal ise şehir görünmektedir."))
        adapter = FoodAdapter(this, foodsList)

        gvFoods.adapter = adapter
    }

    class FoodAdapter : BaseAdapter {
        var foodsList = ArrayList<sehirler>()
        var context: Context? = null

        constructor(context: Context, foodsList: ArrayList<sehirler>) : super() {
            this.context = context
            this.foodsList = foodsList
        }

        override fun getCount(): Int {
            return foodsList.size
        }

        override fun getItem(position: Int): Any {
            return foodsList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val food = this.foodsList[position]

            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodView = inflator.inflate(R.layout.sehiradlari, null)
            foodView.imgFood.setImageResource(food.image!!)
            foodView.tvName.text = food.name!!

            foodView.setOnClickListener{
                var intent = Intent(context,sehir_aciklama::class.java)
                intent.putExtra("name",food.name!!)
                intent.putExtra("des",food.des!!)
                intent.putExtra("image",food.image!!)

                context!!.startActivity(intent)
            }

            return foodView
        }
    }
}