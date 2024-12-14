import java.util.HashMap;
import java.util.Scanner;

public class To_Do_List {
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