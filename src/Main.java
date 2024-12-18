import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static HashMap<Integer, String> kategoriHash = new HashMap<Integer, String>();
    public static int a = 4;

    public static void main(String[] args) {

        Kategori();
    }

    public static void Kategori() {

        kategoriHash.put(1, "İş");
        kategoriHash.put(2, "Okul");
        kategoriHash.put(3, "Günlük Yaşam");

        Scanner scanner = new Scanner(System.in);
        boolean baskaislem = true;
        while (baskaislem) {
            System.out.println("Hangi islemi yapmak istiyorsunuz ? \n1-Kategori Ekleme\n2-Kategori Silme\n3-Kategori Goruntuleme");
            int islem = scanner.nextInt();
            scanner.nextLine();
            if (islem == 1) {
                KategoriEkleme();
            } else if (islem == 2) {
                KategoriCikarma();

            } else if (islem == 3) {
                KategoriGoruntuleme();
            } else {
                System.out.println("Hatali giris lutfen tekrar giriniz!!!");
            }
            System.out.println("Baska bir islem yapmak ister misiniz ? \n1-Evet \n2-Hayir");
            int baskaIslemIsterMisin = scanner.nextInt();
            scanner.nextLine();
            if (baskaIslemIsterMisin == 1) {
                continue;
            } else if (baskaIslemIsterMisin == 2) {
                break;
            } else {
                System.out.println("Hatali giris lutfen tekrar giriniz!!!");
                continue;
            }
        }

    }

    public static void KategoriEkleme() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Gorevi Hangi Kategoriye Kaydetmek Istersiniz ?\n1-" + kategoriHash.get(1) +
                "\n2-" + kategoriHash.get(2) + "\n3-" + kategoriHash.get(3) + "\n4-Yeni Kategori Olustur");
        int hangiKategoriye = scanner.nextInt();
        scanner.nextLine();
        switch (hangiKategoriye) {
            case 1:
                System.out.println("Goreviniz " + kategoriHash.get(1) + " Adli Kategoriye Basariyla Eklendi");
                break;
            case 2:
                System.out.println("Goreviniz " + kategoriHash.get(2) + " Adli Kategoriye Basariyla Eklendi");
                break;
            case 3:
                System.out.println("Goreviniz " + kategoriHash.get(3) + " Adli Kategoriye Basariyla Eklendi");
                break;
            case 4:
                boolean kategorieklemebabapro = true;

                while (kategorieklemebabapro) {

                    for (int i = a; i > kategoriHash.size(); i += 0) {

                        System.out.println("Ekleyeceginiz Kategorinin Adi Ne Olsun");
                        String kategoriAdi = scanner.nextLine();
                        kategoriHash.put(i, kategoriAdi);
                        System.out.println(kategoriHash.get(i) + " Adli Kategori Basariyla Eklendi");
                    }
                    a++;
                    boolean baskaKategoriEkleme = true;
                    while (baskaKategoriEkleme) {
                        System.out.println("Baska bir kategori eklemek ister misiniz ? \n1-Evet \n2-Hayir");

                        int baskaKategoriIsterMisiniz = scanner.nextInt();
                        scanner.nextLine();
                        if (baskaKategoriIsterMisiniz == 1) {
                            break;
                        } else if (baskaKategoriIsterMisiniz == 2) {
                            kategorieklemebabapro = false;
                            break;
                        } else {
                            System.out.println("Hatali giris lutfen tekrar giriniz!!!");
                            continue;
                        }
                    }
                }
        }
    }

    public static void KategoriCikarma() {
        Scanner scanner = new Scanner(System.in);
        boolean choiseCikarma = true;
        while (choiseCikarma) {
            System.out.println("Silmek istediginiz kategorinin numarasini giriniz : ");
            KategoriGoruntuleme();
            int kategoriCikarma = scanner.nextInt();
            if (kategoriCikarma <= kategoriHash.size()) {
                kategoriHash.remove(kategoriCikarma);
                System.out.println("Kategori basariyla kaldirildi.");
                System.out.println("Baska bir kategori silmek istiyor musunuz ?\n1-Evet \n2-Hayir");
                int baskaSilme = scanner.nextInt();
                if (baskaSilme == 1) {
                    KategoriCikarma();
                } else if (baskaSilme == 2) {
                   break;
                } else {
                    System.out.println("Hatali giris lutfen tekrar giriniz!!!");
                }
            } else {
                System.out.println("Hatali giris lutfen tekrar giriniz!!!");
            }
        }
    }

    public static void KategoriGoruntuleme() {
        System.out.println(kategoriHash);
    }

    public static void KategoriFiltreleme() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hangi numarali kategorinin icerigini gormek istiyorsunuz ?");
        KategoriGoruntuleme();
        int kategorigoruntuleme = scanner.nextInt();

    }

}
import java.util.ArrayList;
import java.util.Scanner;


public class main {

    public static void main(String[] args) {
        System.out.println("TO-DO-LIST");

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> gorevler = new ArrayList<>();
        ArrayList<String> copler = new ArrayList<>();


        while (true) {
            Giris();


            int tercih = scanner.nextInt();


            switch (tercih) {
                case 1:
                    GorevEkleme(scanner,gorevler);
                    break;
                case 2:
                    GorevSilme(scanner,gorevler,copler);
                    break;
                case 3:
                    GorevGoruntuleme(gorevler);
                    break;
                case 4:
                    CopKutusu(copler);
                    break;
                case 5:
                    GorevGeriGetirme(scanner,copler,gorevler);
                    break;
                default:
                    System.out.println("Gecersiz bir deger girdiniz.1,2,3,4 veya 5 değerini giriniz.");



            }
        }
    }

    public static void Giris(){
        System.out.println("Görev eklemek için 1'e basınız.");
        System.out.println("Gorev silmek için 2'ye basınız.");
        System.out.println("Görevleri goruntulemek icin 3'e basiniz.");
        System.out.println("Çöp kutusunu görüntülemek için 4'e basiniz.");
        System.out.println("Çöp kutusundan bir görev çıkartmak için 5'e basınız.");
    }
    public static void GorevEkleme(Scanner scanner,ArrayList<String> gorevler){
        System.out.println("Bir gorev ekleyiniz.");
        scanner.nextLine();
        gorevler.add(scanner.nextLine());
    }
    public static void GorevSilme(Scanner scanner,ArrayList<String> gorevler,ArrayList<String> copler){
        System.out.println("Silmek istediğiniz görevi giriniz.");
        if (gorevler.isEmpty()) {
            System.out.println("Silinecek görev bulunmuyor.");
        } else {
            System.out.println("Silmek istediğiniz görevi seçiniz:");
        }
        for (int i = 0; i < gorevler.size(); i++) {
            System.out.println((i) + ". " + gorevler.get(i));
        }
        int index = scanner.nextInt();
        if (index >= 0 && index < gorevler.size()) {
            String silinenGorev = gorevler.remove(index);
            copler.add(silinenGorev);
            System.out.println("Görev çöpe atıldı");
        }

    }

    public static void GorevGoruntuleme(ArrayList<String> gorevler){
        System.out.println("GÖREVLER:");
        System.out.println(gorevler);
    }
    public static void CopKutusu( ArrayList<String> copler){
        if (copler.isEmpty()) {
            System.out.println("Çöp kutusu boş.");
        } else {
            System.out.println("ÇÖP KUTUSU:");
            System.out.println(copler);
        }


    }
    public static void GorevGeriGetirme(Scanner scanner,ArrayList<String> copler,ArrayList<String> gorevler){
        if (copler.isEmpty()) {
            System.out.println("Çöp kutusu boş.");
        } else {
            System.out.println("Çöp kutusundan çıkarmak istediğiniz görevi yazınız");
        } for (int i = 0; i < copler.size(); i++) {
            System.out.println((i) + ". " + copler.get(i));
            int index2 = scanner.nextInt();
            if (index2 >= 0 && index2 < copler.size()) {
                String geriGetirilenGorev = copler.remove(index2);
                gorevler.add(geriGetirilenGorev);
                System.out.println("Görev çöpten çıkarıldı");
            }
        }

    }



}
