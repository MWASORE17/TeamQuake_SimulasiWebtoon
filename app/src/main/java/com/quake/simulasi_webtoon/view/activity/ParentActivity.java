package com.quake.simulasi_webtoon.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.quake.simulasi_webtoon.model.entity.Comic;
import com.quake.simulasi_webtoon.model.entity.ComicCategory;
import com.quake.simulasi_webtoon.model.entity.ComicComment;
import com.quake.simulasi_webtoon.model.entity.ComicEpisode;
import com.quake.simulasi_webtoon.model.entity.ComicLike;
import com.quake.simulasi_webtoon.model.entity.Daily;
import com.quake.simulasi_webtoon.model.entity.User;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Created by edwin on 08/05/17.
 */

public class ParentActivity extends AppCompatActivity {
    /*
    * TO-DO
    * move one Activity to another Activity inside the Application
    */
    public static void doChangeActivity (Context context, Class destination) {
        Intent _intent = new Intent(context, destination);
        _intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(_intent);
    }

    public void isiLike(){
        if(ComicLike.like_data == null){
            ComicLike.like_data = new ArrayList<>();
            ComicLike.like_data.add(new ComicLike(User.users.get(0).getId(), Comic.comic_data.get(0).getId(), ComicEpisode.comic_episode_data.get(0).getId()));
        }
    }

    public void isiDaily(){
        if(Daily.release_day == null){
            Daily.release_day = new ArrayList<>();
            Daily.release_day.add(new Daily("SEN"));
            Daily.release_day.add(new Daily("SEL"));
            Daily.release_day.add(new Daily("RAB"));
            Daily.release_day.add(new Daily("KAM"));
            Daily.release_day.add(new Daily("JUM"));
            Daily.release_day.add(new Daily("SAB"));
            Daily.release_day.add(new Daily("MIN"));
        }

    }
    public void isiUser(){
        if(User.users == null){
            User.users = new ArrayList<>();
            User.users.add(new User("Afie", "afie@yahoo.com", "afie"));
            User.users.add(new User("Dendeng", "dendeng@yahoo.com", "dendeng"));
        }
    }

    public void isiComic(){
        if(Comic.comic_data == null){
            Comic.comic_data = new ArrayList<>();
            Comic.comic_data.add(new Comic(
                //Cover COMIC
                "http://swebtoon.phinf.naver.net/20160805_258/1470360905863yYdMl_JPEG/EC8DB8EB84A4EC9DBC_mobile.jpg?type=q70",
                //Author Comic
                "NURFADLI MURSYID",
                    //JUDUL COMIC
                "Tahilalats",
                    //DESKRIPSI COMIC
                "Cerita random kehidupan masyarakat kekinian",
                    //COMIC CATEGORY
                ComicCategory.category_data.get(1).getId(),
                    //HARI COMIC RELEASE
                Daily.release_day.get(0),
                    //URL WEBSITE yang menampilkan episode2 nya
                "http://www.webtoons.com/id/comedy/tahilalats/list?title_no=542",
                    //BACKGROUND URL
                "http://swebtoon.phinf.naver.net/20160805_123/1470360922841AfSAT_JPEG/EC9E91ED9288EC8381EC84B8_mobile.jpg?type=q70"));

            Comic.comic_data.add(new Comic(
                    //Cover COMIC
                    "http://swebtoon.phinf.naver.net/20161121_78/1479704830562xz8I4_JPEG/EC8DB8EB84A4EC9DBC_mobile.jpg?type=q70",
                    //Author Comic
                    "Ben",
                    //JUDUL COMIC
                    "Cinema of Darkness",
                    //DESKRIPSI COMIC
                    "Gelapnya kehidupan, dibalik cerita-cerita suram",
                    //COMIC CATEGORY
                    ComicCategory.category_data.get(2).getId(),
                    //HARI COMIC RELEASE
                    Daily.release_day.get(1),
                    //URL WEBSITE yang menampilkan episode2 nya
                    "http://www.webtoons.com/id/horror/heisefangyingji/list?title_no=873",
                    //BACKGROUND URL
                    "http://swebtoon.phinf.naver.net/20161121_59/1479704855005663Nt_JPEG/EC9E91ED9288EC8381EC84B8_mobile.jpg?type=q70"));

            Comic.comic_data.add(new Comic(
                    //Cover COMIC
                    "http://swebtoon.phinf.naver.net/20161227_98/1482806025153LeIz3_JPEG/EC8DB8EB84A4EC9DBC_mobile.jpg?type=q70",
                    //Author Comic
                    "Bang Gaber",
                    //JUDUL COMIC
                    "Lucunya Hidup Ini",
                    //DESKRIPSI COMIC
                    "Tentang hidup yang dilihat dari sudut pandang berbeda hingga kita bisa menyeringai melihatnya",
                    //COMIC CATEGORY
                    ComicCategory.category_data.get(5).getId(),
                    //HARI COMIC RELEASE
                    Daily.release_day.get(2),
                    //URL WEBSITE yang menampilkan episode2 nya
                    "http://www.webtoons.com/id/slice-of-life/lucunya-hidup-ini/list?title_no=910",
                    //BACKGROUND URL
                    "http://swebtoon.phinf.naver.net/20161227_19/1482806043536R3ByX_JPEG/m_EC9E91ED9288EC8381EC84B8_ECA084EB8BAC.jpg?type=q70"));


            Comic.comic_data.add(new Comic(
                    //Cover COMIC
                    "http://swebtoon.phinf.naver.net/20160622_274/1466577123375lrLlL_JPEG/thumb_mobile.jpg?type=q70",
                    //Author Comic
                    "Si Ona / Remaja Shoujo",
                    //JUDUL COMIC
                    "#Moments",
                    //DESKRIPSI COMIC
                    "Kumpulan cerita manis dari curhatan orang-orang disekitarmu -- teman, keluarga, kecengan, atau mantan",
                    //COMIC CATEGORY
                    ComicCategory.category_data.get(0).getId(),
                    //HARI COMIC RELEASE
                    Daily.release_day.get(3),
                    //URL WEBSITE yang menampilkan episode2 nya
                    "http://www.webtoons.com/id/romance/moments/list?title_no=698",
                    //BACKGROUND URL
                    "http://swebtoon.phinf.naver.net/20160622_109/14665771331353PtPo_JPEG/M_details.jpg?type=q70"));


            Comic.comic_data.add(new Comic(
                    //Cover COMIC
                    "http://swebtoon.phinf.naver.net/20160212_211/1455264457655Qk42s_JPEG/thumb_mobile.jpg?type=q70",
                    //Author Comic
                    "Felicia Huang",
                    //JUDUL COMIC
                    "304th Study Room",
                    //DESKRIPSI COMIC
                    "Selama 40 Hari, Desyca, Siswi pemalas tapi super hoki,menjalani karantina",
                    //COMIC CATEGORY
                    ComicCategory.category_data.get(3).getId(),
                    //HARI COMIC RELEASE
                    Daily.release_day.get(4),
                    //URL WEBSITE yang menampilkan episode2 nya
                    "http://www.webtoons.com/id/drama/304th-study-room/list?title_no=617",
                    //BACKGROUND URL
                    "http://swebtoon.phinf.naver.net/20160212_160/1455264467072qtFan_JPEG/Details_mobile.jpg?type=q70"));


            Comic.comic_data.add(new Comic(
                    //Cover COMIC
                    "http://swebtoon.phinf.naver.net/20151207_54/1449467195881kw8LT_JPEG/11_thumbnail_mobile.jpg?type=q70",
                    //Author Comic
                    "Herrad,Thoma Prayoga",
                    //JUDUL COMIC
                    "Ojek Story",
                    //DESKRIPSI COMIC
                    "Tidak hanya mengantarkan penumpangnya, tukang ojek ini ikut menghantarkan berbagai kisah",
                    //COMIC CATEGORY
                    ComicCategory.category_data.get(3).getId(),
                    //HARI COMIC RELEASE
                    Daily.release_day.get(5),
                    //URL WEBSITE yang menampilkan episode2 nya
                    "http://www.webtoons.com/id/drama/ojek-story/list?title_no=589",
                    //BACKGROUND URL
                    "http://swebtoon.phinf.naver.net/20151207_112/1449467209429OYmgN_JPEG/04_detail_mobile.jpg?type=q70"));


            Comic.comic_data.add(new Comic(
                    //Cover COMIC
                    "http://swebtoon.phinf.naver.net/20161031_210/1477878534884p7ABz_JPEG/Thumbnail_mobile.jpg?type=q70",
                    //Author Comic
                    "Didiwalker",
                    //JUDUL COMIC
                    "Kosan 95",
                    //DESKRIPSI COMIC
                    "Salah jika menganggap Kosan 95 sebagai kos-kosan biasa",
                    //COMIC CATEGORY
                    ComicCategory.category_data.get(3).getId(),
                    //HARI COMIC RELEASE
                    Daily.release_day.get(6),
                    //URL WEBSITE yang menampilkan episode2 nya
                    "http://www.webtoons.com/id/drama/kosan/list?title_no=840",
                    //BACKGROUND URL
                    "http://swebtoon.phinf.naver.net/20161031_206/1477878545145tgieF_JPEG/List_mobile.jpg?type=q70"));


            Comic.comic_data.add(new Comic(
                    //Cover COMIC
                    "http://swebtoon.phinf.naver.net/20161108_277/1478569259207wSFM3_PNG/thumb_mobile.png?type=q70",
                    //Author Comic
                    "Mas Hiro / k a i r n n",
                    //JUDUL COMIC
                    "Trickster",
                    //DESKRIPSI COMIC
                    "Anak pindahan itu benar-benar menggemparkan seisi kelas dengan trik menyonteknya",
                    //COMIC CATEGORY
                    ComicCategory.category_data.get(3).getId(),
                    //HARI COMIC RELEASE
                    Daily.release_day.get(0),
                    //URL WEBSITE yang menampilkan episode2 nya
                    "http://www.webtoons.com/id/drama/trickster/list?title_no=866",
                    //BACKGROUND URL
                    "http://swebtoon.phinf.naver.net/20161108_194/1478569268472cqDRK_JPEG/Details_mobile.jpg?type=q70"));


            Comic.comic_data.add(new Comic(
                    //Cover COMIC
                    "http://swebtoon.phinf.naver.net/20170411_32/1491903295498vY0G9_JPEG/thusb_M.jpg?type=q70",
                    //Author Comic
                    "Metalu",
                    //JUDUL COMIC
                    "7 Wonders",
                    //DESKRIPSI COMIC
                    "Kehidupan Jaka yang penuh dengan kesenangan tiba-tiba berubah",
                    //COMIC CATEGORY
                    ComicCategory.category_data.get(3).getId(),
                    //HARI COMIC RELEASE
                    Daily.release_day.get(1),
                    //URL WEBSITE yang menampilkan episode2 nya
                    "http://www.webtoons.com/id/drama/7-wonders/list?title_no=699",
                    //BACKGROUND URL
                    "http://swebtoon.phinf.naver.net/20170411_169/1491903313564qXBmQ_JPEG/M_details.jpg?type=q70"));

            Comic.comic_data.add(new Comic(
                    //Cover COMIC
                    "http://swebtoon.phinf.naver.net/20170120_247/14849035522654efCT_JPEG/_EB9AA1EB80AF_E383A1EABCA6_E296A0EB84B0_EB97A1EB80B7__11.jpg?type=q70",
                    //Author Comic
                    "Tan Feli",
                    //JUDUL COMIC
                    "Born From Death",
                    //DESKRIPSI COMIC
                    "Kuat,cepat,tidak dapat menjadi tua,mereka dibangkitkan untuk membasmi jinn gila",
                    //COMIC CATEGORY
                    ComicCategory.category_data.get(4).getId(),
                    //HARI COMIC RELEASE
                    Daily.release_day.get(2),
                    //URL WEBSITE yang menampilkan episode2 nya
                    "http://www.webtoons.com/id/fantasy/born-from-death/list?title_no=615",
                    //BACKGROUND URL
                    "http://swebtoon.phinf.naver.net/20170120_85/1484903572711BRQtf_JPEG/_EB9AA1EB80AF_E383A1EABCA6_E296A0EB84B0_EB97A1EB80B7__04.jpg?type=q70"));

            Comic.comic_data.add(new Comic(
                    //Cover COMIC
                    "http://swebtoon.phinf.naver.net/20151123_73/1448258110465CdkOG_JPEG/thumbnail_mobile.jpg?type=q70",
                    //Author Comic
                    "DEWE / BENY",
                    //JUDUL COMIC
                    "Super Santai",
                    //DESKRIPSI COMIC
                    "Kuat,cepat,tidak dapat menjadi tua,mereka dibangkitkan untuk membasmi jinn gila",
                    //COMIC CATEGORY
                    ComicCategory.category_data.get(4).getId(),
                    //HARI COMIC RELEASE
                    Daily.release_day.get(3),
                    //URL WEBSITE yang menampilkan episode2 nya
                    "http://www.webtoons.com/id/fantasy/super-santai/list?title_no=543",
                    //BACKGROUND URL
                    "http://swebtoon.phinf.naver.net/20151123_44/1448258126383JCwsx_JPEG/detail_mobile.jpg?type=q70"));

            Comic.comic_data.add(new Comic(
                    //Cover COMIC
                    "http://swebtoon.phinf.naver.net/20170314_280/1489483124862XyEkn_JPEG/thumb_M.jpg?type=q70",
                    //Author Comic
                    "Deruu Riota",
                    //JUDUL COMIC
                    "Deadly 7 Inside Me",
                    //DESKRIPSI COMIC
                    "Pertikaian antara 7 dosan besar melawan 7 kebajikan di dunia",
                    //COMIC CATEGORY
                    ComicCategory.category_data.get(4).getId(),
                    //HARI COMIC RELEASE
                    Daily.release_day.get(4),
                    //URL WEBSITE yang menampilkan episode2 nya
                    "http://www.webtoons.com/id/fantasy/deadly-7-inside-me/list?title_no=722",
                    //BACKGROUND URL
                    "http://swebtoon.phinf.naver.net/20170314_130/1489483140046jjCDr_JPEG/M_details.jpg?type=q70"));

            Comic.comic_data.add(new Comic(
                    //Cover COMIC
                    "http://swebtoon.phinf.naver.net/20150608_261/1433742675603B6pw9_JPEG/256.jpg?type=q70",
                    //Author Comic
                    "Sangyoung Seong / Sang-A",
                    //JUDUL COMIC
                    "The Gamer",
                    //DESKRIPSI COMIC
                    "Bagaimana Kalau hidup mu seperti bermain Game?",
                    //COMIC CATEGORY
                    ComicCategory.category_data.get(4).getId(),
                    //HARI COMIC RELEASE
                    Daily.release_day.get(5),
                    //URL WEBSITE yang menampilkan episode2 nya
                    "http://www.webtoons.com/id/fantasy/the-gamer/list?title_no=495",
                    //BACKGROUND URL
                    "http://swebtoon.phinf.naver.net/20150608_6/1433742682887GSsrg_JPEG/1030.jpg?type=q70"));

            Comic.comic_data.add(new Comic(
                    //Cover COMIC
                    "http://swebtoon.phinf.naver.net/20160930_265/14752237082791Ioyt_JPEG/EC8DB8EB84A4EC9DBC_mobile.jpg?type=q70",
                    //Author Comic
                    "KDee",
                    //JUDUL COMIC
                    "Minus Hand",
                    //DESKRIPSI COMIC
                    "Menghadapi segala tantanga dengan MINUS HAND!",
                    //COMIC CATEGORY
                    ComicCategory.category_data.get(4).getId(),
                    //HARI COMIC RELEASE
                    Daily.release_day.get(6),
                    //URL WEBSITE yang menampilkan episode2 nya
                    "http://www.webtoons.com/id/fantasy/minus-hand/list?title_no=794",
                    //BACKGROUND URL
                    "http://swebtoon.phinf.naver.net/20160930_152/1475223721501M44IL_JPEG/m_EC9E91ED9288EC8381EC84B8_ECA084EB8BAC.jpg?type=q70"));

            Comic.comic_data.add(new Comic(
                    //Cover COMIC
                    "http://swebtoon.phinf.naver.net/20161229_17/14829754516785xeaE_JPEG/Thumb_mobile.jpg?type=q70",
                    //Author Comic
                    "Vega Mandalika",
                    //JUDUL COMIC
                    "Nusantara Droid War",
                    //DESKRIPSI COMIC
                    "Nusantara Droid War adalah suatu permainan yang sedang Tren!",
                    //COMIC CATEGORY
                    ComicCategory.category_data.get(4).getId(),
                    //HARI COMIC RELEASE
                    Daily.release_day.get(0),
                    //URL WEBSITE yang menampilkan episode2 nya
                    "http://www.webtoons.com/id/fantasy/nusantara-droid-war/list?title_no=596",
                    //BACKGROUND URL
                    "http://swebtoon.phinf.naver.net/20151216_219/14502613019733sDjj_JPEG/EC9E91ED9288EC8381EC84B8_mobile.jpg?type=q70"));

            Comic.comic_data.add(new Comic(
                    //Cover COMIC
                    "http://swebtoon.phinf.naver.net/20160531_214/14646878203146LtDK_JPEG/thumb_mobile.jpg?type=q70",
                    //Author Comic
                    "Ino Septian",
                    //JUDUL COMIC
                    "Creep",
                    //DESKRIPSI COMIC
                    "Kumpulan cerita-cerita horor yang akan merayapi mimpi-mimpimu",
                    //COMIC CATEGORY
                    ComicCategory.category_data.get(2).getId(),
                    //HARI COMIC RELEASE
                    Daily.release_day.get(1),
                    //URL WEBSITE yang menampilkan episode2 nya
                    "http://www.webtoons.com/id/horror/creep/list?title_no=684",
                    //BACKGROUND URL
                    "http://swebtoon.phinf.naver.net/20160531_224/1464687830758enMIa_JPEG/M_details.jpg?type=q70"));

            Comic.comic_data.add(new Comic(
                    //Cover COMIC
                    "http://swebtoon.phinf.naver.net/20160712_299/1468313591985xffqA_JPEG/thumb_mobile.jpg?type=q70",
                    //Author Comic
                    "Fankycon",
                    //JUDUL COMIC
                    "Gloomy Sunday",
                    //DESKRIPSI COMIC
                    "Komik ini mengandung tema kekerasan dan pembunuhan",
                    //COMIC CATEGORY
                    ComicCategory.category_data.get(2).getId(),
                    //HARI COMIC RELEASE
                    Daily.release_day.get(2),
                    //URL WEBSITE yang menampilkan episode2 nya
                    "http://www.webtoons.com/id/horror/gloomy-sunday/list?title_no=711",
                    //BACKGROUND URL
                    "http://swebtoon.phinf.naver.net/20160712_241/1468313602390gOwYT_JPEG/M_details.jpg?type=q70"));

            Comic.comic_data.add(new Comic(
                    //Cover COMIC
                    "http://swebtoon.phinf.naver.net/20151026_248/1445840266210UzOls_JPEG/thumbnail_mobile.jpg?type=q70",
                    //Author Comic
                    "Seongdae Oh",
                    //JUDUL COMIC
                    "Tales of The Unusual",
                    //DESKRIPSI COMIC
                    "Aneh,Misterius,menegangkan,tidak biasa, kisah-kisah misterius",
                    //COMIC CATEGORY
                    ComicCategory.category_data.get(2).getId(),
                    //HARI COMIC RELEASE
                    Daily.release_day.get(3),
                    //URL WEBSITE yang menampilkan episode2 nya
                    "http://www.webtoons.com/id/horror/tales-of-the-unusual/list?title_no=439",
                    //BACKGROUND URL
                    "http://swebtoon.phinf.naver.net/20151026_238/1445840278032eS44m_JPEG/bg_mobile.jpg?type=q70"));

            Comic.comic_data.add(new Comic(
                    //Cover COMIC
                    "http://swebtoon.phinf.naver.net/20151116_188/144765275809279meK_JPEG/thumbnail_mobile.jpg?type=q70",
                    //Author Comic
                    "Hongtae Kim",
                    //JUDUL COMIC
                    "Possesed",
                    //DESKRIPSI COMIC
                    "Paranormal yang tidak percaya hantu bertemu gadis yang bisa melihat hantu",
                    //COMIC CATEGORY
                    ComicCategory.category_data.get(2).getId(),
                    //HARI COMIC RELEASE
                    Daily.release_day.get(4),
                    //URL WEBSITE yang menampilkan episode2 nya
                    "http://www.webtoons.com/id/horror/possessed/list?title_no=581",
                    //BACKGROUND URL
                    "http://swebtoon.phinf.naver.net/20151116_25/1447652782262PSD8J_JPEG/detail_mobile.jpg?type=q70"));

            Comic.comic_data.add(new Comic(
                    //Cover COMIC
                    "http://swebtoon.phinf.naver.net/20161111_300/1478836577633tNtqf_JPEG/thumb_mobile.jpg?type=q70",
                    //Author Comic
                    "Jennie Liandra",
                    //JUDUL COMIC
                    "Serba Salah",
                    //DESKRIPSI COMIC
                    "Galau selalu disalahkan? ngapain galau, ketawain aja",
                    //COMIC CATEGORY
                    ComicCategory.category_data.get(5).getId(),
                    //HARI COMIC RELEASE
                    Daily.release_day.get(5),
                    //URL WEBSITE yang menampilkan episode2 nya
                    "http://www.webtoons.com/id/slice-of-life/serba-salah/list?title_no=664",
                    //BACKGROUND URL
                    "http://swebtoon.phinf.naver.net/20161111_242/1478836587558TjL5T_JPEG/M_details.jpg?type=q70"));

            Comic.comic_data.add(new Comic(
                    //Cover COMIC
                    "http://swebtoon.phinf.naver.net/20161227_194/1482806737802jA6PR_JPEG/thumb_mobile.jpg?type=q70",
                    //Author Comic
                    "Roket Kertas",
                    //JUDUL COMIC
                    "Sekar X Populer",
                    //DESKRIPSI COMIC
                    "Sekar adalah seorang Gadis SMA biasa yang menyukai Seorang Ardan",
                    //COMIC CATEGORY
                    ComicCategory.category_data.get(5).getId(),
                    //HARI COMIC RELEASE
                    Daily.release_day.get(6),
                    //URL WEBSITE yang menampilkan episode2 nya
                    "http://www.webtoons.com/id/slice-of-life/sekar-x-popular/list?title_no=911",
                    //BACKGROUND URL
                    "http://swebtoon.phinf.naver.net/20161227_19/1482806748596nvGjT_JPEG/M_details.jpg?type=q70"));

            Comic.comic_data.add(new Comic(
                    //Cover COMIC
                    "http://swebtoon.phinf.naver.net/20170412_127/1491980687812W2ySg_JPEG/thumb_M.jpg?type=q70",
                    //Author Comic
                    "Sisifafa / Romy Hernadi",
                    //JUDUL COMIC
                    "Ngopi Yuk",
                    //DESKRIPSI COMIC
                    "Warung Kopi merupakan tempat yang asik buat ngomongin masa depan",
                    //COMIC CATEGORY
                    ComicCategory.category_data.get(5).getId(),
                    //HARI COMIC RELEASE
                    Daily.release_day.get(0),
                    //URL WEBSITE yang menampilkan episode2 nya
                    "http://www.webtoons.com/id/slice-of-life/ngopi/list?title_no=934",
                    //BACKGROUND URL
                    "http://swebtoon.phinf.naver.net/20170412_280/1491980710337NAPur_JPEG/M_details.jpg?type=q70"));

            Comic.comic_data.add(new Comic(
                    //Cover COMIC
                    "http://swebtoon.phinf.naver.net/20170113_205/1484290179922ufRGG_JPEG/Mobile_thumbnail.jpg?type=q70",
                    //Author Comic
                    "Indra AD",
                    //JUDUL COMIC
                    "Dracko Diary",
                    //DESKRIPSI COMIC
                    "Kisah Kehidupan sehari-hari seorang penjaga warnet",
                    //COMIC CATEGORY
                    ComicCategory.category_data.get(5).getId(),
                    //HARI COMIC RELEASE
                    Daily.release_day.get(1),
                    //URL WEBSITE yang menampilkan episode2 nya
                    "http://www.webtoons.com/id/slice-of-life/dracko-diary/list?title_no=710",
                    //BACKGROUND URL
                    "http://swebtoon.phinf.naver.net/20170113_135/148429020143335upj_JPEG/M_details.jpg?type=q70"));

            Comic.comic_data.add(new Comic(
                    //Cover COMIC
                    "http://swebtoon.phinf.naver.net/20170308_9/1488981279771Tr7XB_JPEG/thumb_M.jpg?type=q70",
                    //Author Comic
                    "Mas Okis / S.M.S",
                    //JUDUL COMIC
                    "Terlalu Tampan",
                    //DESKRIPSI COMIC
                    "Ayah, mengapa aku tampan?",
                    //COMIC CATEGORY
                    ComicCategory.category_data.get(1).getId(),
                    //HARI COMIC RELEASE
                    Daily.release_day.get(2),
                    //URL WEBSITE yang menampilkan episode2 nya
                    "http://www.webtoons.com/id/comedy/terlalu-tampan/list?title_no=954",
                    //BACKGROUND URL
                    "http://swebtoon.phinf.naver.net/20170223_31/1487814667408uNPsS_JPEG/M_details.jpg?type=q70"));

            Comic.comic_data.add(new Comic(
                    //Cover COMIC
                    "http://swebtoon.phinf.naver.net/20160927_139/1474967596735pDklb_JPEG/_EB9AA1EB80AF_E383A1EABCA6_E296A0EB84B0_EB97A1EB80B7__11.jpg?type=q70",
                    //Author Comic
                    "Sepulang Sekolah",
                    //JUDUL COMIC
                    "Sepulang Sekolah",
                    //DESKRIPSI COMIC
                    "Hore, Akhirnya jam pelajaran selesai! Ayo ikuti Koi dan Jui",
                    //COMIC CATEGORY
                    ComicCategory.category_data.get(1).getId(),
                    //HARI COMIC RELEASE
                    Daily.release_day.get(3),
                    //URL WEBSITE yang menampilkan episode2 nya
                    "http://www.webtoons.com/id/comedy/sepulang-sekolah/list?title_no=788",
                    //BACKGROUND URL
                    "http://swebtoon.phinf.naver.net/20160927_262/1474967638015xSOhF_JPEG/_EB9AA1EB80AF_E383A1EABCA6_E296A0EB84B0_EB97A1EB80B7__04.jpg?type=q70"));

            Comic.comic_data.add(new Comic(
                    //Cover COMIC
                    "http://swebtoon.phinf.naver.net/20160524_136/1464077440644x7Iek_JPEG/thumb_mobile.jpg?type=q70",
                    //Author Comic
                    "GHOSTYCORP",
                    //JUDUL COMIC
                    "GHOSTY's COMIC",
                    //DESKRIPSI COMIC
                    "Asam Manis perkhilafan dan cerita lainnya",
                    //COMIC CATEGORY
                    ComicCategory.category_data.get(1).getId(),
                    //HARI COMIC RELEASE
                    Daily.release_day.get(4),
                    //URL WEBSITE yang menampilkan episode2 nya
                    "http://www.webtoons.com/id/comedy/ghostys-comic/list?title_no=682",
                    //BACKGROUND URL
                    "http://swebtoon.phinf.naver.net/20160524_254/1464077479588frxa0_JPEG/M_details.jpg?type=q70"));

            Comic.comic_data.add(new Comic(
                    //Cover COMIC
                    "http://swebtoon.phinf.naver.net/20161004_294/147556438643180DSH_JPEG/EC8DB8EB84A4EC9DBC_mobile.jpg?type=q70",
                    //Author Comic
                    "Tim Komik Faktap",
                    //JUDUL COMIC
                    "Komik Faktap",
                    //DESKRIPSI COMIC
                    "Mager Baca Berita? Baca isu kekinian di webtoon ini!",
                    //COMIC CATEGORY
                    ComicCategory.category_data.get(1).getId(),
                    //HARI COMIC RELEASE
                    Daily.release_day.get(5),
                    //URL WEBSITE yang menampilkan episode2 nya
                    "www.webtoons.com/id/comedy/komik-faktap/list?title_no=798",
                    //BACKGROUND URL
                    "http://swebtoon.phinf.naver.net/20161004_273/1475564431686omxoR_JPEG/m_EC9E91ED9288EC8381EC84B8_ECA084EB8BAC.jpg?type=q70"));

            Comic.comic_data.add(new Comic(
                    //Cover COMIC
                    "http://swebtoon.phinf.naver.net/20160927_106/1474968644617ypONf_JPEG/thumb_mobile.jpg?type=q70",
                    //Author Comic
                    "Annisa Nisfihani",
                    //JUDUL COMIC
                    "Pasutri Gaje",
                    //DESKRIPSI COMIC
                    "Mas dan Adek sudah menikah tapi siapa yang bilang mereka tidak seperti suasana pacaran",
                    //COMIC CATEGORY
                    ComicCategory.category_data.get(0).getId(),
                    //HARI COMIC RELEASE
                    Daily.release_day.get(6),
                    //URL WEBSITE yang menampilkan episode2 nya
                    "http://www.webtoons.com/id/romance/pasturi-gaje/list?title_no=790",
                    //BACKGROUND URL
                    "http://swebtoon.phinf.naver.net/20160927_60/1474968667060MvDSn_JPEG/M_details.jpg?type=q70"));

            Comic.comic_data.add(new Comic(
                    //Cover COMIC
                    "http://swebtoon.phinf.naver.net/20160731_136/1469975987537hrTuR_PNG/thumb_mobile.png?type=q70",
                    //Author Comic
                    "Archie the RedCat",
                    //JUDUL COMIC
                    "Eggnoid",
                    //DESKRIPSI COMIC
                    "Hidup Ran yang kesepian jadi lebih berwarna akibat kehadiran Eggy",
                    //COMIC CATEGORY
                    ComicCategory.category_data.get(0).getId(),
                    //HARI COMIC RELEASE
                    Daily.release_day.get(0),
                    //URL WEBSITE yang menampilkan episode2 nya
                    "http://www.webtoons.com/id/romance/eggnoid/list?title_no=593",
                    //BACKGROUND URL
                    "http://swebtoon.phinf.naver.net/20160805_51/1470363496671pB09q_JPEG/Details_mobile.jpg?type=q70"));

            Comic.comic_data.add(new Comic(
                    //Cover COMIC
                    "http://swebtoon.phinf.naver.net/20160805_166/1470365963682SsMxT_JPEG/thumb_mobile.jpg?type=q70",
                    //Author Comic
                    "Angellina",
                    //JUDUL COMIC
                    "Alice",
                    //DESKRIPSI COMIC
                    "Kampus baru, dunia baru! Alice si cewek ceroboh kini ngekos",
                    //COMIC CATEGORY
                    ComicCategory.category_data.get(0).getId(),
                    //HARI COMIC RELEASE
                    Daily.release_day.get(1),
                    //URL WEBSITE yang menampilkan episode2 nya
                    "http://www.webtoons.com/id/romance/alice/list?title_no=639",
                    //BACKGROUND URL
                    "http://swebtoon.phinf.naver.net/20160805_248/14703659795974j6xS_JPEG/Details_mobile.jpg?type=q70"));

            Comic.comic_data.add(new Comic(
                    //Cover COMIC
                    "http://swebtoon.phinf.naver.net/20170222_180/14877336791670nrWS_JPEG/thumb_M.jpg?type=q70",
                    //Author Comic
                    "Shinshinhye",
                    //JUDUL COMIC
                    "Flawless",
                    //DESKRIPSI COMIC
                    "Sarah, si Cewek tangguh tidak sengaja bertemu Elios Pemuda buta",
                    //COMIC CATEGORY
                    ComicCategory.category_data.get(0).getId(),
                    //HARI COMIC RELEASE
                    Daily.release_day.get(2),
                    //URL WEBSITE yang menampilkan episode2 nya
                    "http://www.webtoons.com/id/romance/flawless/list?title_no=595",
                    //BACKGROUND URL
                    "http://swebtoon.phinf.naver.net/20170222_19/14877336992056Ya96_JPEG/M_details.jpg?type=q70"));


        }
    }

    public void isiComicEpisode(){//TAHILALATS - Mulai
        if(ComicEpisode.comic_episode_data == null){
            ComicEpisode.comic_episode_data = new ArrayList<>();

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(0).getId(),
                    "http://swebtoon.phinf.naver.net/20151005_157/1444035084691dqkfs_JPEG/144403508465454268.jpg?type=q70",
                    "Ep.06 KOLAM RENANG PALING",
                    new String[]{
                            "https://dl.dropboxusercontent.com/s/zwfucqk0ekmkyxq/tahilalatseps2_1.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/baqw6zip53rruq3/tahilalatseps2_2.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/1g32nw0168481j4/tahilalatseps2_3.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/mact7lsc9r305c2/tahilalatseps2_4.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/1yk2xwf5fcmfwxd/tahilalatseps2_5.jpg?dl=0"
                    },
                    new GregorianCalendar(2015, 9,1),
                    "m.webtoons.com/id/comedy/tahilalats/ep-6-kolam-renang-paling-ekstrem/viewer?title_no=542&episode_no=6"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(0).getId(),
                    "http://swebtoon.phinf.naver.net/20151005_130/1444034951840gaVEs_JPEG/144403495180354251.jpg?type=q70",
                    "Ep.05 HANTU PENASARAN",
                    new String[]{
                            "https://dl.dropboxusercontent.com/s/zwfucqk0ekmkyxq/tahilalatseps2_1.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/baqw6zip53rruq3/tahilalatseps2_2.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/1g32nw0168481j4/tahilalatseps2_3.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/mact7lsc9r305c2/tahilalatseps2_4.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/1yk2xwf5fcmfwxd/tahilalatseps2_5.jpg?dl=0"
                    },
                    new GregorianCalendar(2015, 9,6),
                    "m.webtoons.com/id/comedy/tahilalats/ep-5-hantu-penasaran/viewer?title_no=542&episode_no=5"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(0).getId(),
                    "http://swebtoon.phinf.naver.net/20150930_173/14436066414641PjGk_JPEG/144360664141854242.jpg?type=q70",
                    "Ep.04 MAHASISWA DAN",
                    new String[]{
                            "https://dl.dropboxusercontent.com/s/zwfucqk0ekmkyxq/tahilalatseps2_1.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/baqw6zip53rruq3/tahilalatseps2_2.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/1g32nw0168481j4/tahilalatseps2_3.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/mact7lsc9r305c2/tahilalatseps2_4.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/1yk2xwf5fcmfwxd/tahilalatseps2_5.jpg?dl=0"
                    },
                    new GregorianCalendar(2015, 9,5),
                    "m.webtoons.com/id/comedy/tahilalats/ep-4-mahasiswa-dan-bintang-jatuh/viewer?title_no=542&episode_no=4"));
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    //COMIC ID ny
                Comic.comic_data.get(0).getId(),
                    //Cover Episodenya
                "https://dl.dropboxusercontent.com/s/9y77ifdcv8gmar6/tahilalatscovereps3.jpg?dl=0",
                    //JUDUL EPISODE
                "Ep.03 LAMA JOMBLO",
                    //ISI KOMIK gambar2
                new String[]{
                    "https://dl.dropboxusercontent.com/s/9s3kaqrkq28ymo7/tahilalatseps3_1.jpg?dl=0",
                    "https://dl.dropboxusercontent.com/s/xsswg5r3i8i3vds/tahilalatseps3_2.jpg?dl=0",
                    "https://dl.dropboxusercontent.com/s/sqndi8hawr7auka/tahilalatseps3_3.jpg?dl=0",
                    "https://dl.dropboxusercontent.com/s/er42mqokhhnwaeb/tahilalatseps3_4.jpg?dl=0",
                    "https://dl.dropboxusercontent.com/s/jspygg1c6rlapv2/tahilalatseps3_5.jpg?dl=0"
                },
                    //TANGGAL RELELASE COMIC
                new GregorianCalendar(2015, 9,1),
                    //WEBISTE SAAT BACA KOMIK
                "http://www.webtoons.com/id/comedy/tahilalats/ep-3-lama-jomblo/viewer?title_no=542&episode_no=3"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                Comic.comic_data.get(0).getId(),
                "https://dl.dropboxusercontent.com/s/cvecfhkes9zzfbm/tahilalatscovereps2.jpg?dl=0",
                "Ep.02 SMS MAMA MINTA PULSA",
                new String[]{
                    "https://dl.dropboxusercontent.com/s/zwfucqk0ekmkyxq/tahilalatseps2_1.jpg?dl=0",
                    "https://dl.dropboxusercontent.com/s/baqw6zip53rruq3/tahilalatseps2_2.jpg?dl=0",
                    "https://dl.dropboxusercontent.com/s/1g32nw0168481j4/tahilalatseps2_3.jpg?dl=0",
                    "https://dl.dropboxusercontent.com/s/mact7lsc9r305c2/tahilalatseps2_4.jpg?dl=0",
                    "https://dl.dropboxusercontent.com/s/1yk2xwf5fcmfwxd/tahilalatseps2_5.jpg?dl=0"
                },
                new GregorianCalendar(2015, 9,1),
                "http://www.webtoons.com/id/comedy/tahilalats/ep-2-sms-mama-minta-pulsa/viewer?title_no=542&episode_no=2"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                Comic.comic_data.get(0).getId(),
                "https://dl.dropboxusercontent.com/s/i8w8e3bv79tga3t/tahilalatscovereps1.jpg?dl=0",
                "Ep.01 KEPALA SEKOLAH BARU",
                new String[]{
                    "https://dl.dropboxusercontent.com/s/ejdao8a99xyyab9/tahilalatseps1_1.jpg?dl=0",
                    "https://dl.dropboxusercontent.com/s/3o6gptaucrjpujd/tahilalatseps1_2.jpg?dl=0",
                    "https://dl.dropboxusercontent.com/s/le7g62avplio1go/tahilalatseps1_3.jpg?dl=0",
                    "https://dl.dropboxusercontent.com/s/a74o24o2vduuops/tahilalatseps1_4.jpg?dl=0",
                    "https://dl.dropboxusercontent.com/s/z2lzal0yjjxri5t/tahilalatseps1_5.jpg?dl=0"
                },
                new GregorianCalendar(2015, 9,1),
                "http://www.webtoons.com/id/comedy/tahilalats/ep-1-kepala-sekolah-baru/viewer?title_no=542&episode_no=1"));

            //TAHILALAT - End
            //7 wonders - Start
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(8).getId(),
                    "http://swebtoon.phinf.naver.net/20160626_169/1466952495771clU4e_JPEG/146695249575269930.jpg?type=q70",
                    "Ep.03 ABSOLUTE CONDITION",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20160626_231/1466952450783zobvq_JPEG/146695245075369937.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160626_289/1466952453853X09Lb_JPEG/146695245382769930.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160626_113/1466952453234FMD4J_JPEG/146695245320369938.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160626_113/1466952453234FMD4J_JPEG/146695245320369938.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160626_178/1466952454366AwhnJ_JPEG/146695245433669932.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 5,26),
                    "http://www.webtoons.com/id/drama/7-wonders/ep-3-absolute-condition/viewer?title_no=699&episode_no=3"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(8).getId(),
                    "http://swebtoon.phinf.naver.net/20160626_247/146695221461821I6y_JPEG/146695221459369926.jpg?type=q70",
                    "Ep.02 THE THIEF",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20160626_31/1466952236926VFQQb_JPEG/146695223690369920.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160626_43/14669522381896liVK_JPEG/146695223815769924.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160626_265/1466952237603VUV2j_JPEG/146695223757669929.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160626_277/1466952238053bBbFS_JPEG/146695223802169926.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160626_134/1466952237570XJKtD_JPEG/146695223754469928.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 5,26),
                    "http://www.webtoons.com/id/drama/7-wonders/ep-2-the-thief/viewer?title_no=699&episode_no=2"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(8).getId(),
                    "http://swebtoon.phinf.naver.net/20160626_169/1466952495771clU4e_JPEG/146695249575269930.jpg?type=q70",
                    "Ep.01 PARADISE",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20160626_299/14669518430514fmxW_JPEG/146695184301969916.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160626_299/14669518430514fmxW_JPEG/146695184301969916.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160626_45/1466951842853Q2YJU_JPEG/146695184282469912.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160626_249/1466951839691VgW1P_JPEG/146695183966369914.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160626_119/1466951841879gp5C8_JPEG/146695184185069911.jpg?type=q70"
                    },
                    new GregorianCalendar(2015, 9,1),
                    "http://www.webtoons.com/id/drama/7-wonders/ep-1-paradise/viewer?title_no=699&episode_no=1"));
            //7 wonders - end
            //CoD - Start
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(1).getId(),
                    "http://swebtoon.phinf.naver.net/20161125_14/1480041800135Ev3Db_PNG/thumb_148004177839787330.png?type=q70",
                    "Ep.03 BERENANG",
                    new String[]{
                            "https://dl.dropboxusercontent.com/s/s4vszws8217n2v7/codeps1_1.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/f0twxg8owdozk6f/codeps1_2.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/lg9u0ulxmg47cp1/codeps1_3.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/x4twn0646fantb8/codeps1_4.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/a59f3cktonath3e/codeps1_5.jpg?dl=0"
                    },
                    new GregorianCalendar(2016, 10,30),
                    "m.webtoons.com/id/horror/heisefangyingji/ep03-berenang/viewer?title_no=873&episode_no=3"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(1).getId(),
                    "https://dl.dropboxusercontent.com/s/ttz9fjylka8i32k/codcovereps2.jpg?dl=0",
                    "Ep.02 PEMBUNUH",
                    new String[]{
                            "https://dl.dropboxusercontent.com/s/ht0tcxintbq4yc5/codeps2_1.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/3ldhd4wgiv9owa7/codeps2_2.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/oatel8sxjvjk7w6/codeps2_3.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/f6ai229go2j9w84/codeps2_4.JPG?dl=0",
                            "https://dl.dropboxusercontent.com/s/5k556ymseiw8wet/codeps2_5.jpg?dl=0"
                    },
                    new GregorianCalendar(2016, 10,30),
                    "m.webtoons.com/id/horror/heisefangyingji/ep02-pembunuh/viewer?title_no=873&episode_no=2"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(1).getId(),
                    "https://dl.dropboxusercontent.com/s/213i6tzza59imr3/codcovereps1.jpg?dl=0",
                    "Ep.01 Bola Mata",
                    new String[]{
                            "https://dl.dropboxusercontent.com/s/y6hjv13anu7mirt/codeps3_1.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/stk78uvpelma3i4/codeps3_2.JPG?dl=0",
                            "https://dl.dropboxusercontent.com/s/0xrt87p1p6jvoif/codeps3_3.JPG?dl=0",
                            "https://dl.dropboxusercontent.com/s/f2y4yybc1tw85we/codeps3_4.JPG?dl=0",
                            "https://dl.dropboxusercontent.com/s/2errhcdgnpywdxi/codeps3_5.JPG?dl=0"
                    },
                    new GregorianCalendar(2016, 10,30),
                    "m.webtoons.com/id/horror/heisefangyingji/ep01-bola-mata/viewer?title_no=873&episode_no=1"));
            //COD End
            //LHI - Start
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(2).getId(),
                    "https://dl.dropboxusercontent.com/s/isa0xmeop5ptleh/lhicovereps3.jpg?dl=0",
                    "Ep.03 Ngirit",
                    new String[]{
                            "https://dl.dropboxusercontent.com/s/kvhv0r7niar6bcl/lhieps3_1.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/v4sxu4uvxq2x1t4/lhieps3_2.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/6cbl7lvdsizrjo2/lhieps3_3.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/fnf50eznjj13fel/lhieps3_4.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/h84zz0v1r640ovr/lhieps3_5.jpg?dl=0"
                    },
                    new GregorianCalendar(2017, 0,12),
                    "m.webtoons.com/id/slice-of-life/lucunya-hidup-ini/ep-3-ngirit/viewer?title_no=910&episode_no=3"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(2).getId(),
                    "https://dl.dropboxusercontent.com/s/ke1fpvm6g1wbc2t/lhicovereps2.jpg?dl=0",
                    "Ep.02 TAKUT",
                    new String[]{
                            "https://dl.dropboxusercontent.com/s/5qk9oc5f0lhqzhz/lhieps2_1.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/3on4rknx3fdej4i/lhieps2_2.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/6xtez0fb9q0vrml/lhieps2_3.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/crwv5kr4ax02ek1/lhieps2_4.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/32wv56j6i02u5v2/lhieps2_5.jpg?dl=0"
                    },
                    new GregorianCalendar(2017, 0,12),
                    "m.webtoons.com/id/slice-of-life/lucunya-hidup-ini/ep-2-takut/viewer?title_no=910&episode_no=2"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(2).getId(),
                    "https://dl.dropboxusercontent.com/s/6qx46v9bfomvq25/lhicovereps1.jpg?dl=0",
                    "Ep.01 LOVE YOU MAMA",
                    new String[]{
                            "https://dl.dropboxusercontent.com/s/32o3ic4d7z51ges/lhieps1_1.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/89aftry456t1vnu/lhieps1_2.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/q1arhsh3far2lcn/lhieps1_3.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/ki4p3yc1y57xjqk/lhieps1_4.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/jugzp4jbtv1568n/lhieps1_5.jpg?dl=0"
                    },
                    new GregorianCalendar(2017, 0,12),
                    "m.webtoons.com/id/slice-of-life/lucunya-hidup-ini/ep-1-love-you-mama/viewer?title_no=910&episode_no=1"));
            //LHI End
            //Moments - start
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(3).getId(),
                    "https://dl.dropboxusercontent.com/s/rc3ycj4tcsr7pfu/momentscovereps3.jpg?dl=0\n",
                    "Ep.02 #TOKOHUTAMA",
                    new String[]{
                            "https://dl.dropboxusercontent.com/s/212im3rhrgyxzbn/momentseps3_1.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/c7ht7uhf2u5pqn4/momentseps3_2.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/p9lv2e1kmjdr1kg/momentseps3_3.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/gi95jotbtwowwdk/momentseps3_4.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/dddv4sio307lp2s/momentseps3_5.jpg?dl=0"
                    },
                    new GregorianCalendar(2017, 0,12),
                    "m.webtoons.com/id/romance/moments/ep-2-tokohutama/viewer?title_no=698&episode_no=3"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(3).getId(),
                    "https://dl.dropboxusercontent.com/s/ed51iwytyz4w92c/momentscovereps2.jpg?dl=0",
                    "Ep.01 #USAHA",
                    new String[]{
                            "https://dl.dropboxusercontent.com/s/bdqtl5y8btjiz1o/momentseps2_1.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/wz8vequix00ai9e/momentseps2_2.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/mmmpjs8fbneftaa/momentseps2_3.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/zsdxvdvruowd9lr/momentseps2_4.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/xufwg8mc44dr6zk/momentseps2_5.jpg?dl=0"
                    },
                    new GregorianCalendar(2017, 0,12),
                    "m.webtoons.com/id/romance/moments/ep-1-usaha-/viewer?title_no=698&episode_no=2"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(3).getId(),
                    "https://dl.dropboxusercontent.com/s/f7c3dhw0hes5kqg/momentscovereps1.jpg?dl=0",
                    "PROLOG",
                    new String[]{
                            "https://dl.dropboxusercontent.com/s/cbkxiuy1851jfcv/momentseps1_1.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/9n62j1o37f7fn35/momentseps1_2.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/z0uqv2flw5dmemb/momentseps1_3.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/awv0x95mqxhq0ph/momentseps1_4.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/yy13e0slibzv2sc/momentseps1_5.jpg?dl=0"
                    },
                    new GregorianCalendar(2017, 0,12),
                    "m.webtoons.com/id/romance/moments/prolog/viewer?title_no=698&episode_no=1"));
            //Moment End
            //304thStudy Room - Start
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(4).getId(),
                    "http://swebtoon.phinf.naver.net/20160226_12/1456485899629oBgw5_JPEG/145648589960061736.jpg?type=q70",
                    "EPISODE 3",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20160226_176/14564940918226xymh_JPEG/145649409179061736.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160530_23/14645964391700P5Wm_JPEG/146459643914061738.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160509_270/1462761132756ntWpk_JPEG/146276113272861735.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160509_205/1462761196501yQvh6_JPEG/146276119646661730.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160509_204/14627611967387u4Lr_JPEG/146276119668161732.jpg?type=q70"
                    },
                    new GregorianCalendar(2017, 0,12),
                    "m.webtoons.com/id/drama/304th-study-room/episode-3/viewer?title_no=617&episode_no=3"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(4).getId(),
                    "http://swebtoon.phinf.naver.net/20160226_85/1456485807698U68pN_JPEG/145648580767561729.jpg?type=q70",
                    "EPISODE 2",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20160226_254/1456494072943h574A_JPEG/145649407291361720.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160226_193/1456485739015iNkYM_JPEG/145648573896861722.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160226_104/14564857391012dSY2_JPEG/145648573906761724.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160226_150/1456485739458vAp2L_JPEG/145648573942561724.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160226_275/1456485739357fM0eV_JPEG/145648573933061724.jpg?type=q70"
                    },
                    new GregorianCalendar(2017, 0,12),
                    "m.webtoons.com/id/drama/304th-study-room/episode-2/viewer?title_no=617&episode_no=2"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(4).getId(),
                    "http://swebtoon.phinf.naver.net/20160226_6/1456485573675jC1g1_JPEG/145648557365161710.jpg?type=q70",
                    "EPISODE 1",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20160226_55/1456494045059Mfuwt_JPEG/145649404502961712.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160226_277/1456485476327SD6Ju_JPEG/145648547629861719.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160226_172/1456485476855OtHMP_JPEG/145648547683061716.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160226_299/1456485476720DusTc_JPEG/145648547668661718.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160226_92/145648547693866LGa_JPEG/145648547690361714.jpg?type=q70"
                    },
                    new GregorianCalendar(2017, 0,12),
                    "m.webtoons.com/id/drama/304th-study-room/episode-1/viewer?title_no=617&episode_no=1"));
            //304th Study Room End
            //Ojek Story Start
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(5).getId(),
                    "https://dl.dropboxusercontent.com/s/dtpcvqt1oaddfqh/OjekStoryCoverEp2.jpg?dl=0",
                    "EP.2 Perempuan Lebam(2)",
                    new String[]{
                            "https://dl.dropboxusercontent.com/s/sfro4eibtw1dwiv/OjekStoryEp2_1.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/t65xmlj620mf07t/OjekStoryEp2_2.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/kvr9l8xql8a27qo/OjekStoryEp2_3.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/2e10lxd69ha7asq/OjekStoryEp2_4.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/s9a7w4j8n7pix76/OjekStoryEp2_5.jpg?dl=0"
                    },
                    new GregorianCalendar(2015, 11,7),
                    "m.webtoons.com/id/drama/ojek-story/ep-2-perempuan-lebam-2/viewer?title_no=589&episode_no=3"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(5).getId(),
                    "https://dl.dropboxusercontent.com/s/dlgo4eb7uw9pq0f/OjekStoryCoverEp1.jpg?dl=0",
                    "EP.1 Perempuan Lebam(1)",
                    new String[]{
                            "https://dl.dropboxusercontent.com/s/xfqaibixcb5p1h4/OjekStoryEp1_1.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/pff20dql35gzm5n/OjekStoryEp1_2.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/b4oqt9wq20l2goh/OjekStoryEp1_3.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/9w97m9w19y77x2w/OjekStoryEp1_4.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/fbh5t6l0c4cdori/OjekStoryEp1_5.jpg?dl=0"
                    },
                    new GregorianCalendar(2015, 11,7),
                    "m.webtoons.com/id/drama/ojek-story/ep-1-perempuan-lebam-1/viewer?title_no=589&episode_no=2"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(5).getId(),
                    "https://dl.dropboxusercontent.com/s/bhqcibcay27u388/OjekStoryCoverEp0.jpg?dl=0 ",
                    "PROLOG",
                    new String[]{
                            "https://dl.dropboxusercontent.com/s/yms1i38igmahurc/OjekStoryEp0_1.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/e5wu1oblvmckqig/OjekStoryEp0_2.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/pu95pvoli4rx3mn/OjekStoryEp0_3.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/87z9ck6un9dr1sn/OjekStoryEp0_4.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/3pmnsbeewi5htzj/OjekStoryEp0_5.jpg?dl=0"
                    },
                    new GregorianCalendar(2015, 11,7),
                    "m.webtoons.com/id/drama/ojek-story/prolog/viewer?title_no=589&episode_no=1"));
            //Ojek Story End
            //Kosan 95 Start
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(6).getId(),
                    "http://swebtoon.phinf.naver.net/20161102_106/1478061266388NbuNq_JPEG/147806126636684036.jpg?type=q70",
                    "EP.3 Permintaan",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20161102_50/1478061236198t4GRr_JPEG/147806123617584033.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20161102_278/1478061236566CSdd0_JPEG/147806123653484037.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20161102_200/1478061236636dUca7_JPEG/147806123660784036.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20161102_15/1478061236648pqdOC_JPEG/147806123662084039.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20161102_15/1478061236648pqdOC_JPEG/147806123662084039.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 10,2),
                    "m.webtoons.com/id/drama/kosan/ep-3-permintaan/viewer?title_no=840&episode_no=3"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(6).getId(),
                    "http://swebtoon.phinf.naver.net/20161102_49/1478061050175YRCz1_JPEG/147806105014084025.jpg?type=q70",
                    "EP.2 Petunjuk",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20161102_143/147806102959004Hof_JPEG/147806102956584024.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20161102_161/1478061029895bxE6B_JPEG/147806102986884025.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20161102_179/147806103020258neA_JPEG/147806103017084023.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20161102_74/14780610300767hR6U_JPEG/147806103004984026.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20161102_74/14780610300767hR6U_JPEG/147806103004984026.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 10,2),
                    "m.webtoons.com/id/drama/kosan/ep-2-petunjuk/viewer?title_no=840&episode_no=2"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(6).getId(),
                    "http://swebtoon.phinf.naver.net/20161102_96/1478060954599swbT5_JPEG/147806095457984014.jpg?type=q70",
                    "EP.1 Surat",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20161102_47/14780609213527Jt8t_JPEG/147806092132484018.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20161102_258/1478060921691oxDlq_JPEG/147806092166284016.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20161102_149/14780609217134jszs_JPEG/147806092168884017.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20161102_283/1478060921508J6sEa_JPEG/147806092147884011.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20161102_45/14780609215699k5ot_JPEG/147806092154284016.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 10,2),
                    "m.webtoons.com/id/drama/kosan/ep-1-surat/viewer?title_no=840&episode_no=1"));
            //Kosan95 End
            //Trickster Start
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(7).getId(),
                    "http://swebtoon.phinf.naver.net/20161109_219/14786945609475J8lK_PNG/thumb_147869448799486630.png?type=q70",
                    "EP.3 Hobiku Adalah",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20161109_136/1478694484702Y7Jdo_JPEG/147869448467286635.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20161109_141/1478694484030gyjpH_JPEG/147869448399186630.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20161109_107/1478694484206XYFgb_JPEG/147869448418286632.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20161109_250/1478694483981tCOWT_JPEG/147869448395786639.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20161109_161/1478694484192dPmMg_JPEG/147869448416386632.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 9,9),
                    "m.webtoons.com/id/drama/trickster/ep-3-hobiku-adalah-menyontek/viewer?title_no=866&episode_no=3"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(7).getId(),
                    "http://swebtoon.phinf.naver.net/20161109_113/1478694319990vUUzE_PNG/thumb_147869418379686621.png?type=q70",
                    "EP.2 Dia Datang",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20161109_73/1478694170952Kij1u_JPEG/147869417092786620.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20161109_207/1478694170557xahjg_JPEG/147869417053386629.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20161109_267/1478694171222P8ODc_JPEG/147869417119686621.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20161109_190/14786941701584YSx0_JPEG/147869417013986628.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20161109_247/1478694170918v4OFU_JPEG/147869417089886628.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 9,9),
                    "m.webtoons.com/id/drama/trickster/ep-2-dia-datang/viewer?title_no=866&episode_no=2"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(7).getId(),
                    "http://swebtoon.phinf.naver.net/20161109_92/1478694045696BBosB_PNG/thumb_147869398969986618.png?type=q70",
                    "EP.1 Murid Baru",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20161109_130/1478693988198Y9Ams_JPEG/147869398816986619.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20161109_178/1478693987766lEIxn_JPEG/147869398774086612.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20161109_128/1478693985406HsU30_JPEG/147869398538386611.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20161109_237/14786939862160Xsng_JPEG/147869398619186617.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20161109_173/1478693988192x8T8o_JPEG/147869398815686614.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 9,9),
                    "m.webtoons.com/id/drama/trickster/ep-1-murid-baru/viewer?title_no=866&episode_no=1"));
            //Trickster End
            //Born From Death Start
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(9).getId(),
                    "http://swebtoon.phinf.naver.net/20160209_108/1455008513389mcfcN_JPEG/145500851336661536.jpg?type=q70",
                    "EP.2 Keras Kepala",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20160209_117/1455008504039xNsg1_JPEG/145500850401061539.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160209_189/14550085038690DDEj_JPEG/145500850384461531.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160209_77/1455008503946Y8U3X_JPEG/145500850392061536.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160209_77/1455008503946Y8U3X_JPEG/145500850392061536.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160209_189/1455008503875a1hlj_JPEG/145500850384861539.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 1,9),
                    "m.webtoons.com/id/fantasy/born-from-death/ep-2-keras-kepala/viewer?title_no=615&episode_no=3"));
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(9).getId(),
                    "http://swebtoon.phinf.naver.net/20160209_49/1455008374695lJpim_JPEG/145500837466861527.jpg?type=q70",
                    "EP.1 Peringatan",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20160209_212/1455008369759Qqo9g_JPEG/145500836972261520.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160209_269/1455008368545Vu4aN_JPEG/145500836852161522.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160209_6/1455008368688MD8EO_JPEG/145500836866461527.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160209_95/145500836885439YcI_JPEG/145500836882761527.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160209_80/1455008369159Uh38z_JPEG/145500836912761525.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 1,9),
                    "m.webtoons.com/id/fantasy/born-from-death/ep-1-peringatan/viewer?title_no=615&episode_no=2"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(9).getId(),
                    "http://swebtoon.phinf.naver.net/20160209_139/14550082948463R4dF_JPEG/145500829482261511.jpg?type=q70",
                    "Prolog",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20160209_108/14550082835256PTgF_JPEG/145500828349661515.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160209_198/1455008283043G8w47_JPEG/145500828301661512.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160209_225/1455008283338JoEWu_JPEG/145500828331361511.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160209_75/1455008283351EgfQ7_JPEG/145500828332361510.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160209_72/1455008283179idlnt_JPEG/145500828315561510.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 1,9),
                    "m.webtoons.com/id/fantasy/born-from-death/prolog/viewer?title_no=615&episode_no=1"));
            //Born From Death End
            //Super Santai Start
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(10).getId(),
                    "https://dl.dropboxusercontent.com/s/yo5id9mkcl8sk0n/supersantaicovereps3.jpg?dl=0",
                    "EP.3 Super Santai",
                    new String[]{
                            "https://dl.dropboxusercontent.com/s/bildk6u1mslp0o3/supersantaieps3_1.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/6k30yayguc8u77q/supersantaieps3_2.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/9huip1dmygehb3c/supersantaieps3_3.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/n003zw3xh21a6hg/supersantaieps3_4.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/w8mc8ntjq2ud27e/supersantaieps3_5.jpg?dl=0"
                    },
                    new GregorianCalendar(2015, 9,4),
                    "m.webtoons.com/id/fantasy/super-santai/ep-3-super-santai-bertarung/viewer?title_no=543&episode_no=3"));
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(10).getId(),
                    "https://dl.dropboxusercontent.com/s/sfvf00ho76a3xpb/supersantaicovereps2.jpg?dl=0",
                    "EP.2 G.I.A.T",
                    new String[]{
                            "https://dl.dropboxusercontent.com/s/38bovc3vwh4mb16/supersantaieps2_1.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/bmkkc079pvvpmgl/supersantaieps2_2.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/kzeikh81qot3gnn/supersantaieps2_3.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/zfh1s9g67evv8y0/supersantaieps2_4.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/eoug0y0hwpa74og/supersantaieps2_5.jpg?dl=0"
                    },
                    new GregorianCalendar(2015, 9,4),
                    "m.webtoons.com/id/fantasy/super-santai/ep-2-giat-pasukan-dari-luar-angkasa/viewer?title_no=543&episode_no=2"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(10).getId(),
                    "https://dl.dropboxusercontent.com/s/zvcrnt1kgl0wkzh/supersantaicovereps1.jpg?dl=0",
                    "EP.1 Datangnya Super",
                    new String[]{
                            "https://dl.dropboxusercontent.com/s/e2s8ro5vzkam984/supersantaieps1_1.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/7479e7is8sqztst/supersantaieps1_2.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/dovcdbv4wtcgd0e/supersantaieps1_3.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/psa1614kk05x8si/supersantaieps1_4.jpg?dl=0",
                            "https://dl.dropboxusercontent.com/s/vh9uvfuqiuo58p3/supersantaieps1_5.jpg?dl=0"
                    },
                    new GregorianCalendar(2015, 9,4),
                    "m.webtoons.com/id/fantasy/super-santai/ep-1-datangnya-super-santai/viewer?title_no=543&episode_no=1"));
            //SuperSantai End

            //Deadly 7 Inside Me Start
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(11).getId(),
                    "http://swebtoon.phinf.naver.net/20160813_143/1471098407584zr9On_JPEG/147109840756172236.jpg?type=q70",
                    "EPISODE 2",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20160813_128/1471097859932xHz95_JPEG/147109785990172237.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160813_209/1471097856664xS5xD_JPEG/147109785663672230.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160813_184/1471097859260Hh3Bd_JPEG/147109785923372234.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160813_243/1471097858836v16Tz_JPEG/147109785880772238.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160813_148/1471097859009UP6fb_JPEG/147109785897972231.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 7,13),
                    "m.webtoons.com/id/fantasy/deadly-7-inside-me/episode-2/viewer?title_no=722&episode_no=3"));
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(11).getId(),
                    "http://swebtoon.phinf.naver.net/20160813_130/1471098386241gPwLJ_JPEG/147109838621972226.jpg?type=q70",
                    "EPISODE 1",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20160813_276/1471097707456MEML2_JPEG/147109770743072220.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160813_22/1471097708770L3nHE_JPEG/147109770874372229.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160813_153/1471097711968FfeIt_JPEG/147109771194072223.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160813_53/1471097710910xhUm3_JPEG/147109771088172223.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160813_209/1471097711925Ujroa_JPEG/147109771188272223.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 7,13),
                    "m.webtoons.com/id/fantasy/deadly-7-inside-me/episode-1/viewer?title_no=722&episode_no=2"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(11).getId(),
                    "http://swebtoon.phinf.naver.net/20160813_264/1471098281531SuVLb_JPEG/147109828150872215.jpg?type=q70",
                    "PROLOG",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20160813_113/1471097381138W87rf_JPEG/147109738110872214.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160813_85/1471097381290s1CrP_JPEG/147109738126272217.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160813_70/1471097380420JEBtj_JPEG/147109738039272212.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160813_173/14710973859529Dsro_JPEG/147109738592572213.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160813_108/1471097381665kNGel_JPEG/147109738163772218.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 7,13),
                    "m.webtoons.com/id/fantasy/deadly-7-inside-me/prolog/viewer?title_no=722&episode_no=1"));
            //Deadly 7 Inside Me End

            //The Gamer Start
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(12).getId(),
                    "http://swebtoon.phinf.naver.net/20150616_112/1434424441873m4aGv_JPEG/143442444183349537.jpg?type=q70",
                    "Ep. 3",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20160813_128/1471097859932xHz95_JPEG/147109785990172237.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160813_209/1471097856664xS5xD_JPEG/147109785663672230.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160813_184/1471097859260Hh3Bd_JPEG/147109785923372234.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160813_243/1471097858836v16Tz_JPEG/147109785880772238.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160813_148/1471097859009UP6fb_JPEG/147109785897972231.jpg?type=q70"
                    },
                    new GregorianCalendar(2015, 5,21),
                    "m.webtoons.com/id/fantasy/the-gamer/ep3/viewer?title_no=495&episode_no=3"));
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(12).getId(),
                    "http://swebtoon.phinf.naver.net/20150616_270/1434423278936dNtnN_JPEG/143442327889549522.jpg?type=q70",
                    "Ep. 2",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20160813_276/1471097707456MEML2_JPEG/147109770743072220.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160813_22/1471097708770L3nHE_JPEG/147109770874372229.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160813_153/1471097711968FfeIt_JPEG/147109771194072223.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160813_53/1471097710910xhUm3_JPEG/147109771088172223.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160813_209/1471097711925Ujroa_JPEG/147109771188272223.jpg?type=q70"
                    },
                    new GregorianCalendar(2015, 5,19),
                    "m.webtoons.com/id/fantasy/the-gamer/ep2-/viewer?title_no=495&episode_no=2"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(12).getId(),
                    "http://swebtoon.phinf.naver.net/20150616_287/1434422843792FUAGf_JPEG/143442284375449519.jpg?type=q70",
                    "Ep.1 Quest di Atas Kepala",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20160813_113/1471097381138W87rf_JPEG/147109738110872214.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160813_85/1471097381290s1CrP_JPEG/147109738126272217.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160813_70/1471097380420JEBtj_JPEG/147109738039272212.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160813_173/14710973859529Dsro_JPEG/147109738592572213.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160813_108/1471097381665kNGel_JPEG/147109738163772218.jpg?type=q70"
                    },
                    new GregorianCalendar(2015, 5,17),
                    "m.webtoons.com/id/fantasy/the-gamer/ep1-quest-di-atas-kepala/viewer?title_no=495&episode_no=1"));
            //The Gamer End

            //Minus Hand Start
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(13).getId(),
                    "http://swebtoon.phinf.naver.net/20160930_213/1475224661147eOogA_PNG/thumb_147522449505779431.png?type=q70",
                    "Ep. 03",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20160813_128/1471097859932xHz95_JPEG/147109785990172237.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160813_209/1471097856664xS5xD_JPEG/147109785663672230.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160813_184/1471097859260Hh3Bd_JPEG/147109785923372234.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160813_243/1471097858836v16Tz_JPEG/147109785880772238.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160813_148/1471097859009UP6fb_JPEG/147109785897972231.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 9,1),
                    "m.webtoons.com/id/fantasy/minus-hand/ep03/viewer?title_no=794&episode_no=3"));
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(13).getId(),
                    "http://swebtoon.phinf.naver.net/20160930_101/1475224464462zGjI0_PNG/thumb_147522440692379421.png?type=q70",
                    "Ep. 02",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20160813_276/1471097707456MEML2_JPEG/147109770743072220.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160813_22/1471097708770L3nHE_JPEG/147109770874372229.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160813_153/1471097711968FfeIt_JPEG/147109771194072223.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160813_53/1471097710910xhUm3_JPEG/147109771088172223.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160813_209/1471097711925Ujroa_JPEG/147109771188272223.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 9,1),
                    "m.webtoons.com/id/fantasy/minus-hand/ep02/viewer?title_no=794&episode_no=2"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(13).getId(),
                    "http://swebtoon.phinf.naver.net/20160930_67/1475224373786aWgJR_PNG/thumb_147522434932779412.png?type=q70",
                    "Ep. 01",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20160813_113/1471097381138W87rf_JPEG/147109738110872214.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160813_85/1471097381290s1CrP_JPEG/147109738126272217.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160813_70/1471097380420JEBtj_JPEG/147109738039272212.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160813_173/14710973859529Dsro_JPEG/147109738592572213.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160813_108/1471097381665kNGel_JPEG/147109738163772218.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 9,1),
                    "m.webtoons.com/id/fantasy/minus-hand/ep01/viewer?title_no=794&episode_no=1"));
            //Minus Hand End

            //Nusantara Droid War Start
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(14).getId(),
                    "http://swebtoon.phinf.naver.net/20151218_10/1450404262904PMRS6_JPEG/145040426287659631.jpg?type=q70",
                    "Ep. 03 Pemenangnya",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20151218_29/1450404089093A0BRz_JPEG/145040408906059639.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20151218_73/1450404089037XsckC_JPEG/145040408900459631.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20151218_160/1450404089078OTzbt_JPEG/145040408904859635.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20151218_250/14504040890200ySqD_JPEG/145040408898759631.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20151218_249/1450404089034mPSlR_JPEG/145040408900059638.jpg?type=q70"
                    },
                    new GregorianCalendar(2015, 11,18),
                    "m.webtoons.com/id/fantasy/nusantara-droid-war/ep-3-pemenangnya-adalah/viewer?title_no=596&episode_no=3"));
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(14).getId(),
                    "http://swebtoon.phinf.naver.net/20151218_46/14504039943649b4ET_JPEG/145040399433759626.jpg?type=q70",
                    "Ep. 02 Saling Serang",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20151218_99/14504039022258Bmfm_JPEG/145040390218659629.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20151218_150/1450403902718w3YRC_JPEG/145040390268259626.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20151218_281/14504039025998YabD_JPEG/145040390256859629.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20151218_124/14504039027263hHAo_JPEG/145040390268059626.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20151218_16/1450403903032rszfI_JPEG/145040390299559629.jpg?type=q70"
                    },
                    new GregorianCalendar(2015, 11,18),
                    "m.webtoons.com/id/fantasy/nusantara-droid-war/ep-2-saling-serang/viewer?title_no=596&episode_no=2"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(14).getId(),
                    "http://swebtoon.phinf.naver.net/20151218_131/1450403448972oTQgp_JPEG/145040344894859619.jpg?type=q70",
                    "Ep. 01 Semua Orang Suka",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20151218_271/1450403318045bY3xW_JPEG/145040331801459618.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20151218_294/1450403318317byLXj_JPEG/145040331828859612.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20151218_214/14504033183026unhS_JPEG/145040331827159610.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20151218_112/1450403318135bwlet_JPEG/145040331810159612.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20151218_194/14504033186435ydwK_JPEG/145040331861159615.jpg?type=q70"
                    },
                    new GregorianCalendar(2015, 11,18),
                    "m.webtoons.com/id/fantasy/nusantara-droid-war/ep-1-semua-orang-suka-game/viewer?title_no=596&episode_no=1"));
            //Nusantara Droid War End

            //Creep Start
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(15).getId(),
                    "http://swebtoon.phinf.naver.net/20160603_174/1464956966596ImnXf_JPEG/146495696657168431.jpg?type=q70",
                    "Ep. 03 Suara Sunyi",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20160603_160/1464956970542D7PN0_JPEG/146495697051468437.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160603_223/1464956970351kBROz_JPEG/146495697032968438.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160603_26/14649569705507gGFc_JPEG/146495697052968439.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160603_177/1464956971033P21pg_JPEG/146495697100968436.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160603_206/1464956971306tNO3u_JPEG/146495697128468437.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 3,3),
                    "m.webtoons.com/id/horror/creep/ep-3-suara-sunyi/viewer?title_no=684&episode_no=3"));
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(15).getId(),
                    "http://swebtoon.phinf.naver.net/20160603_272/1464954710810awXS7_JPEG/146495471078768423.jpg?type=q70",
                    "Ep. 02 Baaaaa!",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20160603_160/1464954715090ogWmQ_JPEG/146495471506668426.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160603_61/1464954715021fu4J3_JPEG/146495471499668428.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160603_207/146495471500287RV5_JPEG/146495471497768426.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160603_114/1464954715233vmFAP_JPEG/146495471520468421.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160603_243/1464954715316R8wpd_JPEG/146495471529268429.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 3,3),
                    "m.webtoons.com/id/horror/creep/ep-2-baaaaa/viewer?title_no=684&episode_no=2"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(15).getId(),
                    "http://swebtoon.phinf.naver.net/20160603_188/1464954648063qt4ut_JPEG/146495464804068418.jpg?type=q70",
                    "Ep. 03:03",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20160603_100/1464954656041MrpBs_JPEG/146495465601868410.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160603_195/1464954656205SNcqV_JPEG/146495465618068415.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160603_143/1464954656300Ke7tW_JPEG/146495465627568410.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160603_90/1464954656161MIS3d_JPEG/146495465613568413.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160603_55/1464954656280wkOt2_JPEG/146495465624268413.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 3,3),
                    "m.webtoons.com/id/horror/creep/ep-1-0303/viewer?title_no=684&episode_no=1"));
            //Creep End

            //Gloomy Sunday Start
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(16).getId(),
                    "http://swebtoon.phinf.naver.net/20160716_221/1468669413947ltfFa_JPEG/146866941392371135.jpg?type=q70",
                    "Ep. 03 Challenge(1)",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20160716_53/1468669404589g21ne_JPEG/146866940456071135.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160716_177/1468669407923g9PUt_JPEG/146866940788971131.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160716_177/1468669407923g9PUt_JPEG/146866940788971131.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160716_61/14686694073940JwS9_JPEG/146866940734871133.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160716_297/1468669407674z3KnI_JPEG/146866940764471137.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 6,16),
                    "m.webtoons.com/id/horror/gloomy-sunday/ep-3-challenge-1/viewer?title_no=711&episode_no=3"));
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(16).getId(),
                    "http://swebtoon.phinf.naver.net/20160716_64/14686693609312lp7i_JPEG/146866936090671125.jpg?type=q70",
                    "Ep. 02 Online Shop(2)",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20160716_267/1468669349526cNuU2_JPEG/146866934949571123.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160716_206/1468669352659CnYfk_JPEG/146866935261971127.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160716_63/1468669352371WP3s1_JPEG/146866935233971120.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160716_92/1468669352376eSYEX_JPEG/146866935234371129.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160716_11/1468669352311hNqkb_JPEG/146866935227771122.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 6,16),
                    "m.webtoons.com/id/horror/gloomy-sunday/ep-2-online-shop-2/viewer?title_no=711&episode_no=2"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(16).getId(),
                    "http://swebtoon.phinf.naver.net/20160716_118/1468669301448vBloB_JPEG/146866930142171118.jpg?type=q70",
                    "Ep.1 Online Shop(1)",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20160716_253/1468669286259XJ9Fe_JPEG/146866928622771110.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160716_104/1468669289222KM9ht_JPEG/146866928919071113.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160716_59/14686692886717q8TQ_JPEG/146866928862571111.jpg?type=q700",
                            "http://swebtoon.phinf.naver.net/20160716_283/1468669289090ouY87_JPEG/146866928905471116.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160716_283/1468669289090ouY87_JPEG/146866928905471116.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 6,16),
                    "m.webtoons.com/id/horror/gloomy-sunday/ep-1-online-shop-1/viewer?title_no=711&episode_no=1"));
            //Gloomy Sunday End

            //Tals Of the Unusual Start
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(17).getId(),
                    "http://swebtoon.phinf.naver.net/20150429_90/1430242865539TJ8e2_JPEG/143024286550043930.jpg?type=q70",
                    "Ep. 2 Galeri Jiwa-Jiwa",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20150429_179/1430242894372MWNOF_JPEG/143024289432043936.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20150429_207/1430242924017YaPzh_JPEG/143024292393743931.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20150429_283/14302429026668MVxw_JPEG/143024290259743930.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20150429_170/1430242904784FBLlA_JPEG/143024290471443938.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20150429_36/1430242899713WAfI8_JPEG/143024289964343934.jpg?type=q70"
                    },
                    new GregorianCalendar(2015, 3,20),
                    "m.webtoons.com/id/horror/tales-of-the-unusual/ep2-galeri-jiwa-jiwa-terkutuk2/viewer?title_no=439&episode_no=3"));
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(17).getId(),
                    "http://swebtoon.phinf.naver.net/20150420_114/1429457037662dwr6u_JPEG/142945703762443925.jpg?type=q70",
                    "Ep. 1 Galeri Jiwa Jiwa",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20150429_238/1430242611947mAPle_JPEG/143024261188543925.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20150429_102/1430242614076CbXHY_JPEG/143024261400143920.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20150429_102/1430242614076CbXHY_JPEG/143024261400143920.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20150429_63/1430242615515w9lk3_JPEG/143024261544143923.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20150429_88/1430242622702rs1Fb_JPEG/143024262262943924.jpg?type=q70"
                    },
                    new GregorianCalendar(2015, 3,20),
                    "m.webtoons.com/id/horror/tales-of-the-unusual/ep1-galeri-jiwa-jiwa-terkutuk1/viewer?title_no=439&episode_no=2"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(17).getId(),
                    "http://swebtoon.phinf.naver.net/20150419_108/1429455383340ykxlN_JPEG/142945538330243916.jpg?type=q70",
                    "Prolog",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20150419_266/1429455411936cCGrp_JPEG/142945541187843915.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20150419_213/1429455413013DFpPE_JPEG/142945541292943910.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20150419_77/1429455412799Cajiy_JPEG/142945541273443910.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20150419_125/1429455414471kG7kh_JPEG/142945541440643916.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20150419_262/1429455412884iDDG7_JPEG/142945541282843914.jpg?type=q70"
                    },
                    new GregorianCalendar(2015, 3,20),
                    "m.webtoons.com/id/horror/tales-of-the-unusual/prolog/viewer?title_no=439&episode_no=1"));
            //Tales of the Unusual End

            //Possesed Start
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(18).getId(),
                    "http://swebtoon.phinf.naver.net/20151119_282/1447922615807SLj8j_JPEG/144792261578058130.jpg?type=q70",
                    "Ep. 3 Pengusir Hantu",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20150429_179/1430242894372MWNOF_JPEG/143024289432043936.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20150429_207/1430242924017YaPzh_JPEG/143024292393743931.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20150429_283/14302429026668MVxw_JPEG/143024290259743930.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20150429_170/1430242904784FBLlA_JPEG/143024290471443938.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20150429_36/1430242899713WAfI8_JPEG/143024289964343934.jpg?type=q70"
                    },
                    new GregorianCalendar(2015, 3,21),
                    "m.webtoons.com/id/horror/possessed/ep03-pengusir-hantu-yang-tidak-percaya-hantu1/viewer?title_no=581&episode_no=3"));
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(18).getId(),
                    "http://swebtoon.phinf.naver.net/20151119_185/1447922568606CAbtd_JPEG/144792256857958123.jpg?type=q70",
                    "Ep. 2 Wanita yang melihat",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20150429_238/1430242611947mAPle_JPEG/143024261188543925.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20150429_102/1430242614076CbXHY_JPEG/143024261400143920.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20150429_102/1430242614076CbXHY_JPEG/143024261400143920.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20150429_63/1430242615515w9lk3_JPEG/143024261544143923.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20150429_88/1430242622702rs1Fb_JPEG/143024262262943924.jpg?type=q70"
                    },
                    new GregorianCalendar(2015, 3,21),
                    "m.webtoons.com/id/horror/possessed/ep02-wanita-yang-melihat-hantu/viewer?title_no=581&episode_no=2"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(18).getId(),
                    "http://swebtoon.phinf.naver.net/20151119_233/1447922524030JMEkN_JPEG/144792252400258118.jpg?type=q70",
                    "Ep. 1 Kerasukan Hantu",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20150419_266/1429455411936cCGrp_JPEG/142945541187843915.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20150419_213/1429455413013DFpPE_JPEG/142945541292943910.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20150419_77/1429455412799Cajiy_JPEG/142945541273443910.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20150419_125/1429455414471kG7kh_JPEG/142945541440643916.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20150419_262/1429455412884iDDG7_JPEG/142945541282843914.jpg?type=q70"
                    },
                    new GregorianCalendar(2015, 3,21),
                    "m.webtoons.com/id/horror/possessed/ep01-kerasukan-hantu/viewer?title_no=581&episode_no=1"));
            //Possesed End

            //Serba Salah Start
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(19).getId(),
                    "http://swebtoon.phinf.naver.net/20160426_175/1461654635739auVnf_JPEG/146165463569666431.jpg?type=q70",
                    "Ep. 3 Jangan Teriak-teriak",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20160426_155/1461666047565FdnDN_JPEG/146166604753166432.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160426_273/14616660475944hFOu_JPEG/146166604756466438.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160426_209/1461666047627gjuS8_JPEG/146166604759466438.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160426_129/1461666047614kovfq_JPEG/146166604757166434.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160426_22/1461666047647LH9Yt_JPEG/146166604760566432.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 3,26),
                    "m.webtoons.com/id/slice-of-life/serba-salah/jangan-teriak-teriak-ep-2/viewer?title_no=664&episode_no=3"));
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(19).getId(),
                    "http://swebtoon.phinf.naver.net/20160426_142/1461654605023x3GdI_JPEG/146165460500066421.jpg?type=q70",
                    "Ep. 1 Papa!",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20160426_247/1461665982555bPB2i_JPEG/146166598252066424.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160426_80/14616659833978qkVh_JPEG/146166598336666421.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160426_253/1461665982468mkpid_JPEG/146166598243166426.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160426_218/1461665982755uG2Ks_JPEG/146166598272666424.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160426_234/1461665982576ad9zz_JPEG/146166598252366420.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 3,26),
                    "m.webtoons.com/id/slice-of-life/serba-salah/papa-ep-1/viewer?title_no=664&episode_no=2"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(19).getId(),
                    "http://swebtoon.phinf.naver.net/20160426_36/1461665133367zENG5_JPEG/146166513334066417.jpg?type=q70",
                    "Intro",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20160426_289/1461666768109B2Wjj_JPEG/146166676807866416.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160426_213/1461666768344HWfYX_JPEG/146166676831066414.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160426_31/1461666769207kVvi7_JPEG/146166676917166418.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160426_271/14616667693517Xw8L_JPEG/146166676931666415.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20160426_235/1461666769219llggs_JPEG/146166676918866414.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 3,26),
                    "m.webtoons.com/id/slice-of-life/serba-salah/intro/viewer?title_no=664&episode_no=1"));
            //Serba Salah End

            //Sekar X Populer Start
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(20).getId(),
                    "http://swebtoon.phinf.naver.net/20170108_248/1483884050718STEFO_JPEG/148388405069891132.jpg?type=q70",
                    "Ep. 3 Sarung",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20170108_101/1483884058085p7RdY_JPEG/148388405805791133.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_39/1483884057489yJg29_JPEG/148388405746191134.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_280/1483884058842LiYHO_JPEG/148388405881391135.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_195/1483884058803BM7bM_JPEG/148388405876791133.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_236/1483884057742yXCLI_JPEG/148388405771991137.jpg?type=q70"
                    },
                    new GregorianCalendar(2017, 0,8),
                    "m.webtoons.com/id/slice-of-life/sekar-x-popular/ep-3-sarung/viewer?title_no=911&episode_no=3"));
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(20).getId(),
                    "http://swebtoon.phinf.naver.net/20170108_116/1483883977404NgfDV_JPEG/148388397738191128.jpg?type=q70",
                    "Ep. 2 Nggak Peka",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20170108_284/14838840253498OGpw_JPEG/148388402532391127.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_9/1483884024624gsERy_JPEG/148388402459791122.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_223/1483884026447YIJII_JPEG/148388402642091124.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_277/1483884026277m5f0E_JPEG/148388402625491129.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_244/1483884026330nR2A5_JPEG/148388402630791121.jpg?type=q70"
                    },
                    new GregorianCalendar(2017, 0,8),
                    "m.webtoons.com/id/slice-of-life/sekar-x-popular/ep-2-nggak-peka/viewer?title_no=911&episode_no=2"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(20).getId(),
                    "http://swebtoon.phinf.naver.net/20170108_80/1483883946131y9Bvp_JPEG/148388394610691117.jpg?type=q70",
                    "Ep. 1 Aku Ingin Populer",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20170108_233/1483883941825PuL9S_JPEG/148388394179791115.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_86/1483883941236o2uEl_JPEG/148388394120891118.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_115/1483883941236fpYKA_JPEG/148388394120891118.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_287/14838839426647oeNi_JPEG/148388394263791112.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_251/1483883942609sjgEC_JPEG/148388394258391118.jpg?type=q70"
                    },
                    new GregorianCalendar(2017, 0,8),
                    "m.webtoons.com/id/slice-of-life/sekar-x-popular/ep-1-aku-ingin-populer/viewer?title_no=911&episode_no=1"));
            //Sekar X Populer End

            //Ngopi Yuk Start
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(21).getId(),
                    "http://swebtoon.phinf.naver.net/20170201_159/1485959296308j3F2N_JPEG/148595929628493430.jpg?type=q70",
                    "Ep. 3 Handuk Pak Gundul",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20170108_101/1483884058085p7RdY_JPEG/148388405805791133.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_39/1483884057489yJg29_JPEG/148388405746191134.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_280/1483884058842LiYHO_JPEG/148388405881391135.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_195/1483884058803BM7bM_JPEG/148388405876791133.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_236/1483884057742yXCLI_JPEG/148388405771991137.jpg?type=q70"
                    },
                    new GregorianCalendar(2017, 0,8),
                    "m.webtoons.com/id/slice-of-life/ngopi/ep-3-handuk-pak-gundul/viewer?title_no=934&episode_no=3"));
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(21).getId(),
                    "http://swebtoon.phinf.naver.net/20170201_167/14859591956378Psky_JPEG/148595919561593423.jpg?type=q70",
                    "Ep. 2 Horang Kayah",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20170108_284/14838840253498OGpw_JPEG/148388402532391127.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_9/1483884024624gsERy_JPEG/148388402459791122.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_223/1483884026447YIJII_JPEG/148388402642091124.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_277/1483884026277m5f0E_JPEG/148388402625491129.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_244/1483884026330nR2A5_JPEG/148388402630791121.jpg?type=q70"
                    },
                    new GregorianCalendar(2017, 0,8),
                    "m.webtoons.com/id/slice-of-life/ngopi/ep-2-horang-kayah/viewer?title_no=934&episode_no=2"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(21).getId(),
                    "http://swebtoon.phinf.naver.net/20170201_158/1485959160783g4lVF_JPEG/148595916075993413.jpg?type=q70",
                    "Ep. 1 Secangkir Kopi",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20170108_233/1483883941825PuL9S_JPEG/148388394179791115.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_86/1483883941236o2uEl_JPEG/148388394120891118.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_115/1483883941236fpYKA_JPEG/148388394120891118.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_287/14838839426647oeNi_JPEG/148388394263791112.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_251/1483883942609sjgEC_JPEG/148388394258391118.jpg?type=q70"
                    },
                    new GregorianCalendar(2017, 0,8),
                    "m.webtoons.com/id/slice-of-life/ngopi/ep-1-secangkir-kopi/viewer?title_no=934&episode_no=1"));
            //Ngopi Yuk End

            //Dracko Diary Start
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(22).getId(),
                    "http://swebtoon.phinf.naver.net/20160711_90/1468249070017hkglg_JPEG/146824906999471033.jpg?type=q70",
                    "Ep. 3 Malming",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20170108_101/1483884058085p7RdY_JPEG/148388405805791133.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_39/1483884057489yJg29_JPEG/148388405746191134.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_280/1483884058842LiYHO_JPEG/148388405881391135.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_195/1483884058803BM7bM_JPEG/148388405876791133.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_236/1483884057742yXCLI_JPEG/148388405771991137.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 6,11),
                    "m.webtoons.com/id/slice-of-life/dracko-diary/ep-3-malming/viewer?title_no=710&episode_no=3"));
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(22).getId(),
                    "http://swebtoon.phinf.naver.net/20160711_179/14682490318981aPyC_JPEG/146824903187671025.jpg?type=q70",
                    "Ep. 2 Buatin Akun",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20170108_284/14838840253498OGpw_JPEG/148388402532391127.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_9/1483884024624gsERy_JPEG/148388402459791122.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_223/1483884026447YIJII_JPEG/148388402642091124.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_277/1483884026277m5f0E_JPEG/148388402625491129.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_244/1483884026330nR2A5_JPEG/148388402630791121.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 6,11),
                    "m.webtoons.com/id/slice-of-life/dracko-diary/ep-2-buatin-akun/viewer?title_no=710&episode_no=2"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(22).getId(),
                    "http://swebtoon.phinf.naver.net/20160711_28/1468248972300QKCnx_JPEG/146824897227571012.jpg?type=q70",
                    "Ep. 1 Jaga Warnet",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20170108_233/1483883941825PuL9S_JPEG/148388394179791115.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_86/1483883941236o2uEl_JPEG/148388394120891118.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_115/1483883941236fpYKA_JPEG/148388394120891118.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_287/14838839426647oeNi_JPEG/148388394263791112.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_251/1483883942609sjgEC_JPEG/148388394258391118.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 6,11),
                    "m.webtoons.com/id/slice-of-life/dracko-diary/ep-1-jaga-warnet/viewer?title_no=710&episode_no=1"));
            //Dracko Diary End

            //Terlalu Tampan Start
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(23).getId(),
                    "http://swebtoon.phinf.naver.net/20170306_233/1488798868763C2vvW_JPEG/148879886873995438.jpg?type=q70",
                    "Ep. 3 Doa Orang Tampang",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20170108_101/1483884058085p7RdY_JPEG/148388405805791133.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_39/1483884057489yJg29_JPEG/148388405746191134.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_280/1483884058842LiYHO_JPEG/148388405881391135.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_195/1483884058803BM7bM_JPEG/148388405876791133.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_236/1483884057742yXCLI_JPEG/148388405771991137.jpg?type=q70"
                    },
                    new GregorianCalendar(2017, 2,6),
                    "m.webtoons.com/id/comedy/terlalu-tampan/ep-3-doa-orang-tampan/viewer?title_no=954&episode_no=3"));
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(23).getId(),
                    "http://swebtoon.phinf.naver.net/20170306_4/14887988332840Pszb_JPEG/148879883324895424.jpg?type=q70",
                    "Ep. 2 Keluarga Orang Tampan",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20170108_284/14838840253498OGpw_JPEG/148388402532391127.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_9/1483884024624gsERy_JPEG/148388402459791122.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_223/1483884026447YIJII_JPEG/148388402642091124.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_277/1483884026277m5f0E_JPEG/148388402625491129.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_244/1483884026330nR2A5_JPEG/148388402630791121.jpg?type=q70"
                    },
                    new GregorianCalendar(2017, 2,6),
                    "m.webtoons.com/id/comedy/terlalu-tampan/ep-2-keluarga-orang-tampan/viewer?title_no=954&episode_no=2"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(23).getId(),
                    "http://swebtoon.phinf.naver.net/20170306_273/1488798798178GJBzU_JPEG/148879879815495411.jpg?type=q70",
                    "Ep. 1 Orang Tampan",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20170108_233/1483883941825PuL9S_JPEG/148388394179791115.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_86/1483883941236o2uEl_JPEG/148388394120891118.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_115/1483883941236fpYKA_JPEG/148388394120891118.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_287/14838839426647oeNi_JPEG/148388394263791112.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_251/1483883942609sjgEC_JPEG/148388394258391118.jpg?type=q70"
                    },
                    new GregorianCalendar(2017, 2,6),
                    "m.webtoons.com/id/comedy/terlalu-tampan/ep-1-orang-tampan/viewer?title_no=954&episode_no=1"));
            //Terlalu Tampan End

            //Sepulang Sekolah Start
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(24).getId(),
                    "http://swebtoon.phinf.naver.net/20161003_140/1475421437552xSLll_JPEG/147542143752978839.jpg?type=q70",
                    "Ep. 3 Fast Food",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20170108_101/1483884058085p7RdY_JPEG/148388405805791133.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_39/1483884057489yJg29_JPEG/148388405746191134.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_280/1483884058842LiYHO_JPEG/148388405881391135.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_195/1483884058803BM7bM_JPEG/148388405876791133.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_236/1483884057742yXCLI_JPEG/148388405771991137.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 6,11),
                    "m.webtoons.com/id/comedy/sepulang-sekolah/ep-3-fast-food/viewer?title_no=788&episode_no=3"));
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(24).getId(),
                    "http://swebtoon.phinf.naver.net/20161003_49/1475421366047GMQc7_JPEG/147542136602578820.jpg?type=q70",
                    "Ep. 2 Karaoke",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20170108_284/14838840253498OGpw_JPEG/148388402532391127.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_9/1483884024624gsERy_JPEG/148388402459791122.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_223/1483884026447YIJII_JPEG/148388402642091124.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_277/1483884026277m5f0E_JPEG/148388402625491129.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_244/1483884026330nR2A5_JPEG/148388402630791121.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 6,11),
                    "m.webtoons.com/id/comedy/sepulang-sekolah/ep-2-karaoke/viewer?title_no=788&episode_no=2"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(24).getId(),
                    "http://swebtoon.phinf.naver.net/20161003_56/1475421290225aHj5n_JPEG/147542129020178811.jpg?type=q70",
                    "Ep. 1 Pertemuan",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20170108_233/1483883941825PuL9S_JPEG/148388394179791115.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_86/1483883941236o2uEl_JPEG/148388394120891118.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_115/1483883941236fpYKA_JPEG/148388394120891118.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_287/14838839426647oeNi_JPEG/148388394263791112.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_251/1483883942609sjgEC_JPEG/148388394258391118.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 6,11),
                    "m.webtoons.com/id/comedy/sepulang-sekolah/ep-1-pertemuan/viewer?title_no=788&episode_no=1"));
            //Sepulang Sekolah End

            //Ghosty Comic Start
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(25).getId(),
                    "http://swebtoon.phinf.naver.net/20160525_220/146416490378330N73_JPEG/146416490375868232.jpg?type=q70",
                    "Ep. 3 Bedgeting",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20170108_101/1483884058085p7RdY_JPEG/148388405805791133.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_39/1483884057489yJg29_JPEG/148388405746191134.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_280/1483884058842LiYHO_JPEG/148388405881391135.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_195/1483884058803BM7bM_JPEG/148388405876791133.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_236/1483884057742yXCLI_JPEG/148388405771991137.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 4,25),
                    "m.webtoons.com/id/comedy/ghostys-comic/ep-3-budgeting/viewer?title_no=682&episode_no=3"));
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(25).getId(),
                    "http://swebtoon.phinf.naver.net/20160525_64/1464164814429qfPdo_JPEG/146416481440268222.jpg?type=q70",
                    "Ep. 2 Sultan di Restaurant",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20170108_284/14838840253498OGpw_JPEG/148388402532391127.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_9/1483884024624gsERy_JPEG/148388402459791122.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_223/1483884026447YIJII_JPEG/148388402642091124.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_277/1483884026277m5f0E_JPEG/148388402625491129.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_244/1483884026330nR2A5_JPEG/148388402630791121.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 4,25),
                    "m.webtoons.com/id/comedy/ghostys-comic/ep-2-sultan-di-restoran/viewer?title_no=682&episode_no=2"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(25).getId(),
                    "http://swebtoon.phinf.naver.net/20160525_294/14641647683168TjC5_JPEG/146416476828768213.jpg?type=q70",
                    "Ep. 1 Khilaf Itu",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20170108_233/1483883941825PuL9S_JPEG/148388394179791115.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_86/1483883941236o2uEl_JPEG/148388394120891118.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_115/1483883941236fpYKA_JPEG/148388394120891118.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_287/14838839426647oeNi_JPEG/148388394263791112.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_251/1483883942609sjgEC_JPEG/148388394258391118.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 4,25),
                    "m.webtoons.com/id/comedy/ghostys-comic/ep-1-khilaf-itu/viewer?title_no=682&episode_no=1"));
            //ghosty comic End

            //Komik Faktap Start
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(26).getId(),
                    "http://swebtoon.phinf.naver.net/20161008_106/1475935887785HQWoR_JPEG/147593588774779831.jpg?type=q70",
                    "Ep. 3 Jagal",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20170108_101/1483884058085p7RdY_JPEG/148388405805791133.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_39/1483884057489yJg29_JPEG/148388405746191134.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_280/1483884058842LiYHO_JPEG/148388405881391135.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_195/1483884058803BM7bM_JPEG/148388405876791133.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_236/1483884057742yXCLI_JPEG/148388405771991137.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 9,8),
                    "m.webtoons.com/id/comedy/komik-faktap/ep-3-jagal/viewer?title_no=798&episode_no=3"));
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(26).getId(),
                    "http://swebtoon.phinf.naver.net/20161008_58/1475935847020fUXAg_JPEG/147593584699379829.jpg?type=q70",
                    "Ep. 2 Granat",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20170108_284/14838840253498OGpw_JPEG/148388402532391127.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_9/1483884024624gsERy_JPEG/148388402459791122.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_223/1483884026447YIJII_JPEG/148388402642091124.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_277/1483884026277m5f0E_JPEG/148388402625491129.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_244/1483884026330nR2A5_JPEG/148388402630791121.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 9,8),
                    "m.webtoons.com/id/comedy/komik-faktap/ep-2-granat/viewer?title_no=798&episode_no=2"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(26).getId(),
                    "http://swebtoon.phinf.naver.net/20161008_219/1475935805109qUr6E_JPEG/147593580508479813.jpg?type=q70",
                    "Ep. 1 Selembar",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20170108_233/1483883941825PuL9S_JPEG/148388394179791115.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_86/1483883941236o2uEl_JPEG/148388394120891118.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_115/1483883941236fpYKA_JPEG/148388394120891118.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_287/14838839426647oeNi_JPEG/148388394263791112.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_251/1483883942609sjgEC_JPEG/148388394258391118.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 9,8),
                    "m.webtoons.com/id/comedy/komik-faktap/ep-1-selembar/viewer?title_no=798&episode_no=1"));
            //Komik Faktap End

            //Pasutri Gaje Start
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(27).getId(),
                    "http://swebtoon.phinf.naver.net/20161021_259/1477060294704XyBic_JPEG/147706029467979035.jpg?type=q70",
                    "Ep. 3 Mengambil",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20170108_101/1483884058085p7RdY_JPEG/148388405805791133.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_39/1483884057489yJg29_JPEG/148388405746191134.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_280/1483884058842LiYHO_JPEG/148388405881391135.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_195/1483884058803BM7bM_JPEG/148388405876791133.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_236/1483884057742yXCLI_JPEG/148388405771991137.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 9,7),
                    "m.webtoons.com/id/romance/pasturi-gaje/ep-3-mengambil-keputusan/viewer?title_no=790&episode_no=3"));
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(27).getId(),
                    "http://swebtoon.phinf.naver.net/20161014_10/1476454560932ySeMm_JPEG/147645456090779023.jpg?type=q70",
                    "Ep. 2 Dia Ningsih",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20170108_284/14838840253498OGpw_JPEG/148388402532391127.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_9/1483884024624gsERy_JPEG/148388402459791122.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_223/1483884026447YIJII_JPEG/148388402642091124.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_277/1483884026277m5f0E_JPEG/148388402625491129.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_244/1483884026330nR2A5_JPEG/148388402630791121.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 9,7),
                    "m.webtoons.com/id/romance/pasturi-gaje/ep-2-dia-ningsih/viewer?title_no=790&episode_no=2"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(27).getId(),
                    "http://swebtoon.phinf.naver.net/20161007_27/1475852056867gga1T_JPEG/147585205684179018.jpg?type=q70",
                    "Ep. 1 New Life",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20170108_233/1483883941825PuL9S_JPEG/148388394179791115.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_86/1483883941236o2uEl_JPEG/148388394120891118.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_115/1483883941236fpYKA_JPEG/148388394120891118.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_287/14838839426647oeNi_JPEG/148388394263791112.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_251/1483883942609sjgEC_JPEG/148388394258391118.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 9,7),
                    "m.webtoons.com/id/romance/pasturi-gaje/ep-1-new-life/viewer?title_no=790&episode_no=1"));
            //Pasutri Gaje End

            //Eggnoid Start
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(28).getId(),
                    "http://swebtoon.phinf.naver.net/20151213_18/1450013514493nB8dy_JPEG/145001351446459338.jpg?type=q70",
                    "Ep. 3",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20170108_101/1483884058085p7RdY_JPEG/148388405805791133.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_39/1483884057489yJg29_JPEG/148388405746191134.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_280/1483884058842LiYHO_JPEG/148388405881391135.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_195/1483884058803BM7bM_JPEG/148388405876791133.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_236/1483884057742yXCLI_JPEG/148388405771991137.jpg?type=q70"
                    },
                    new GregorianCalendar(2015, 11,13),
                    "m.webtoons.com/id/romance/eggnoid/ep-3/viewer?title_no=593&episode_no=3"));
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(28).getId(),
                    "http://swebtoon.phinf.naver.net/20151213_212/1450012803369g1Dhs_JPEG/145001280334259322.jpg?type=q70",
                    "Ep. 2",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20170108_284/14838840253498OGpw_JPEG/148388402532391127.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_9/1483884024624gsERy_JPEG/148388402459791122.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_223/1483884026447YIJII_JPEG/148388402642091124.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_277/1483884026277m5f0E_JPEG/148388402625491129.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_244/1483884026330nR2A5_JPEG/148388402630791121.jpg?type=q70"
                    },
                    new GregorianCalendar(2015, 11,13),
                    "m.webtoons.com/id/romance/eggnoid/ep-2/viewer?title_no=593&episode_no=2"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(28).getId(),
                    "http://swebtoon.phinf.naver.net/20151213_184/1450012555615GaVTP_JPEG/145001255558959314.jpg?type=q70",
                    "Ep. 1",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20170108_233/1483883941825PuL9S_JPEG/148388394179791115.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_86/1483883941236o2uEl_JPEG/148388394120891118.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_115/1483883941236fpYKA_JPEG/148388394120891118.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_287/14838839426647oeNi_JPEG/148388394263791112.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_251/1483883942609sjgEC_JPEG/148388394258391118.jpg?type=q70"
                    },
                    new GregorianCalendar(2015, 11,13),
                    "m.webtoons.com/id/romance/eggnoid/ep-1/viewer?title_no=593&episode_no=1"));
            //Eggnoid End

            //Alice Start
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(29).getId(),
                    "http://swebtoon.phinf.naver.net/20160316_111/1458125649192G4HR4_JPEG/145812564916963936.jpg?type=q70",
                    "Ep. 3 First Meet",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20170108_101/1483884058085p7RdY_JPEG/148388405805791133.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_39/1483884057489yJg29_JPEG/148388405746191134.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_280/1483884058842LiYHO_JPEG/148388405881391135.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_195/1483884058803BM7bM_JPEG/148388405876791133.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_236/1483884057742yXCLI_JPEG/148388405771991137.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 2,16),
                    "m.webtoons.com/id/romance/alice/ep-3-first-meet/viewer?title_no=639&episode_no=3"));
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(29).getId(),
                    "http://swebtoon.phinf.naver.net/20160316_71/14581256044113u0Bj_JPEG/145812560438963927.jpg?type=q70",
                    "Ep. 2 Tikungan Maut",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20170108_284/14838840253498OGpw_JPEG/148388402532391127.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_9/1483884024624gsERy_JPEG/148388402459791122.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_223/1483884026447YIJII_JPEG/148388402642091124.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_277/1483884026277m5f0E_JPEG/148388402625491129.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_244/1483884026330nR2A5_JPEG/148388402630791121.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 2,16),
                    "m.webtoons.com/id/romance/alice/ep-2-tikungan-maut/viewer?title_no=639&episode_no=2"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(29).getId(),
                    "http://swebtoon.phinf.naver.net/20160316_25/1458125439080l80az_JPEG/145812543905863910.jpg?type=q70",
                    "Ep. 1 Prolog",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20170108_233/1483883941825PuL9S_JPEG/148388394179791115.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_86/1483883941236o2uEl_JPEG/148388394120891118.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_115/1483883941236fpYKA_JPEG/148388394120891118.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_287/14838839426647oeNi_JPEG/148388394263791112.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_251/1483883942609sjgEC_JPEG/148388394258391118.jpg?type=q70"
                    },
                    new GregorianCalendar(2016, 2,16),
                    "m.webtoons.com/id/romance/alice/ep-1-prolog/viewer?title_no=639&episode_no=1"));
            //Alice End

            //Flawless Start
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(30).getId(),
                    "http://swebtoon.phinf.naver.net/20151215_202/1450172796027qRLYj_JPEG/145017279598659534.jpg?type=q70",
                    "Ep. 2 Dari Balik Tembok",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20170108_101/1483884058085p7RdY_JPEG/148388405805791133.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_39/1483884057489yJg29_JPEG/148388405746191134.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_280/1483884058842LiYHO_JPEG/148388405881391135.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_195/1483884058803BM7bM_JPEG/148388405876791133.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_236/1483884057742yXCLI_JPEG/148388405771991137.jpg?type=q70"
                    },
                    new GregorianCalendar(2015, 11,15),
                    "m.webtoons.com/id/romance/flawless/ep-2-dari-balik-tembok/viewer?title_no=595&episode_no=3"));
            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(30).getId(),
                    "http://swebtoon.phinf.naver.net/20151215_99/14501727540836QLWd_JPEG/145017275405459529.jpg?type=q70",
                    "Ep. 1 Bertemu",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20170108_284/14838840253498OGpw_JPEG/148388402532391127.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_9/1483884024624gsERy_JPEG/148388402459791122.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_223/1483884026447YIJII_JPEG/148388402642091124.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_277/1483884026277m5f0E_JPEG/148388402625491129.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_244/1483884026330nR2A5_JPEG/148388402630791121.jpg?type=q70"
                    },
                    new GregorianCalendar(2015, 11,15),
                    "m.webtoons.com/id/romance/flawless/ep-1-bertemu/viewer?title_no=595&episode_no=2"));

            ComicEpisode.comic_episode_data.add(new ComicEpisode(
                    Comic.comic_data.get(30).getId(),
                    "http://swebtoon.phinf.naver.net/20151215_244/1450172710772wo9ua_JPEG/145017271074259519.jpg?type=q70",
                    "Prolog",
                    new String[]{
                            "http://swebtoon.phinf.naver.net/20170108_233/1483883941825PuL9S_JPEG/148388394179791115.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_86/1483883941236o2uEl_JPEG/148388394120891118.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_115/1483883941236fpYKA_JPEG/148388394120891118.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_287/14838839426647oeNi_JPEG/148388394263791112.jpg?type=q70",
                            "http://swebtoon.phinf.naver.net/20170108_251/1483883942609sjgEC_JPEG/148388394258391118.jpg?type=q70"
                    },
                    new GregorianCalendar(2015, 11,15),
                    "m.webtoons.com/id/romance/flawless/prolog/viewer?title_no=595&episode_no=1"));
            //Flawless End


        }
    }

    public void isiComicCategory(){
        if(ComicCategory.category_data == null){
            ComicCategory.category_data = new ArrayList<>();
            ComicCategory.category_data.add(new ComicCategory("Romantis"));
            ComicCategory.category_data.add(new ComicCategory("Komedi"));
            ComicCategory.category_data.add(new ComicCategory("Horor"));
            ComicCategory.category_data.add(new ComicCategory("Drama"));
            ComicCategory.category_data.add(new ComicCategory("Fantasi"));
            ComicCategory.category_data.add(new ComicCategory("Slice Of Life"));
        }
    }

    public void isiComicComment(){
        if(ComicComment.comment_data == null){
            ComicComment.comment_data = new ArrayList<>();
            ComicComment.comment_data.add(new ComicComment("0", "EPS2", "DJKFSLDFdfjdkf dfdff", User.users.get(1).getId() ,new GregorianCalendar(2017, 2,18), new ArrayList<String>()));
            ComicComment.comment_data.add(new ComicComment("0", "EPS1", "bbbbbbb", User.users.get(1).getId() ,new GregorianCalendar(2017, 2,18), new ArrayList<String>(){{
                add("CMT4");
                add("CMT5");
            }}));
            ComicComment.comment_data.add(new ComicComment("CMT2", "EPS1", "child1", User.users.get(1).getId() ,new GregorianCalendar(2017, 2,18), new ArrayList<String>()));
            ComicComment.comment_data.add(new ComicComment("CMT2", "EPS1", "child2", User.users.get(1).getId() ,new GregorianCalendar(2017, 2,18), new ArrayList<String>()));
            ComicComment.comment_data.add(new ComicComment("0", "EPS1", "zzz", User.users.get(1).getId() ,new GregorianCalendar(2017, 2,18), new ArrayList<String>()));
            ComicComment.comment_data.add(new ComicComment("0", "EPS1", "qqqq", User.users.get(1).getId() ,new GregorianCalendar(2017, 2,18), new ArrayList<String>()));
            ComicComment.comment_data.add(new ComicComment("0", "EPS1", "111", User.users.get(1).getId() ,new GregorianCalendar(2017, 2,18), new ArrayList<String>()));
            ComicComment.comment_data.add(new ComicComment("0", "EPS1", "2222", User.users.get(1).getId() ,new GregorianCalendar(2017, 2,18), new ArrayList<String>()));
            ComicComment.comment_data.add(new ComicComment("0", "EPS1", "3333", User.users.get(1).getId() ,new GregorianCalendar(2017, 2,18), new ArrayList<String>()));
            ComicComment.comment_data.add(new ComicComment("0", "EPS1", "4444", User.users.get(1).getId() ,new GregorianCalendar(2017, 2,18), new ArrayList<String>()
            {{
                add("CMT14");
            }}
            ));
            ComicComment.comment_data.add(new ComicComment("0", "EPS1", "55555", User.users.get(1).getId() ,new GregorianCalendar(2017, 2,18, 10, 0, 0), new ArrayList<String>()));
            ComicComment.comment_data.add(new ComicComment("0", "EPS1", "66666", User.users.get(1).getId() ,new GregorianCalendar(2017, 2,18, 10, 0, 0), new ArrayList<String>()));
            ComicComment.comment_data.add(new ComicComment("CMT11", "EPS1", "77777", User.users.get(1).getId() ,new GregorianCalendar(2017, 2,18, 10, 0, 0), new ArrayList<String>()));
        }
    }

}
