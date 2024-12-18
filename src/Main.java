import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
//    public static HashMap<Integer, String> kategoriHash = new HashMap<Integer, String>(); Mert
    public static ArrayList<String> categoryList = new ArrayList<>();
    public static int a = 4;

//    public static void main(String[] args) {
//
//        Kategori(); Mert
//    }

    public static void main(String[] args) {
        System.out.println("TO-DO-LIST");

        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, ArrayList<String>> gorevlerHashMap = new HashMap<>();
        HashMap<Integer, ArrayList<String>> coplerHashMap = new HashMap<>();
        ArrayList<String> gorevler = new ArrayList<>();
        ArrayList<String> copler = new ArrayList<>();
        categoryList.add("İş");
        categoryList.add("Okul");
        categoryList.add("Günlük Yaşam");


        while (true) {
            Giris();

            int tercih = scanner.nextInt();
            scanner.nextLine();

            switch (tercih) {
                case 1:
                    GorevEkleme(scanner,gorevlerHashMap);
                    break;
                case 2:
                    GorevSilme(scanner,gorevlerHashMap,coplerHashMap);
                    break;
                case 3:
                    GorevGoruntuleme(gorevlerHashMap);
                    break;
                case 4:
                    CopKutusu(coplerHashMap);
                    break;
                case 5:
                    GorevGeriGetirme(scanner,gorevlerHashMap,coplerHashMap);
                    break;
                case 6:
                    Kategori();
                    break;
                default:
                    System.out.println("Gecersiz bir deger girdiniz.1,2,3,4,5 veya 6 değerini giriniz.");
            }
        }
    }
    public static void Giris(){
        System.out.println("Görev eklemek için 1'e basınız.");
        System.out.println("Gorev silmek için 2'ye basınız.");
        System.out.println("Görevleri goruntulemek icin 3'e basiniz.");
        System.out.println("Çöp kutusunu görüntülemek için 4'e basiniz.");
        System.out.println("Çöp kutusundan bir görev çıkartmak için 5'e basınız.");
        System.out.println("Kategori için 6'ya basınız.");
    }
    public static void GorevEkleme(Scanner scanner,HashMap<Integer, ArrayList<String>> gorevlerHashMap){
        System.out.println("Bir gorev ekleyiniz.");
        String gorev = scanner.nextLine();
        System.out.println("Bir kategori seçiniz ");
        for (int i = 0; i < categoryList.size(); i++) {
            System.out.println("\t" + categoryList.get(i));
        }
        System.out.println("Kategori eklemek istemiyorsanız boş bırakınız");
        String category = scanner.nextLine();
        if (isCategoryValid(category) || category.isEmpty()) {
            gorevlerHashMap.put(gorevlerHashMap.size()+1,new ArrayList<String>());
            gorevlerHashMap.get(gorevlerHashMap.size()).add(gorev);
            gorevlerHashMap.get(gorevlerHashMap.size()).add(category);
            gorevlerHashMap.get(gorevlerHashMap.size()).add("0");
        } else {
            System.out.println("Geçersiz kategori lütfen kategori ismini doğru yazdığınızdan emin olun!");
        }

//        gorevler.add(scanner.nextLine()); Aylin

    }
    public static void GorevSilme(Scanner scanner,HashMap<Integer, ArrayList<String>> gorevlerHashMap,HashMap<Integer, ArrayList<String>> coplerHashMap){
//        System.out.println("Silmek istediğiniz görevi giriniz.");
        if (gorevlerHashMap.isEmpty()) {
            System.out.println("Silinecek görev bulunmuyor.");
        } else {
            System.out.println("Silmek istediğiniz görevi seçiniz:");
            System.out.printf("%s %-30s %-10s %-10s %n", "N", "Görev", "Kategori", "Yapılma durumu");
        }
        for (Integer x : gorevlerHashMap.keySet()) {
            String gorevName = gorevlerHashMap.get(x).get(0);
            String category = gorevlerHashMap.get(x).get(1);
            String isDone = gorevlerHashMap.get(x).get(2);
            System.out.printf("%d %-30s %-10s %-10s %n", x, gorevName, category, isDone);
        }
//        for (int i = 0; i < gorevler.size(); i++) {
//            System.out.println((i) + ". " + gorevler.get(i));   Aylin
//        }
        int index = scanner.nextInt();
        if (index >= 0 && index <= gorevlerHashMap.size()) {
            coplerHashMap.put(coplerHashMap.size()+1,new ArrayList<String>());
            coplerHashMap.get(coplerHashMap.size()).add(gorevlerHashMap.get(index).get(0));
            coplerHashMap.get(coplerHashMap.size()).add(gorevlerHashMap.get(index).get(1));
            coplerHashMap.get(coplerHashMap.size()).add(gorevlerHashMap.get(index).get(2));
            gorevlerHashMap.remove(index);
            System.out.println("Görev çöpe atıldı");
        }

    }

    public static void GorevGoruntuleme(HashMap<Integer, ArrayList<String>> gorevlerHashMap){
//        System.out.println("GÖREVLER:");
//        System.out.println(gorevler); Aylin
        System.out.printf("%s %-30s %-10s %-10s %n", "N", "Görev", "Kategori", "Yapılma durumu");
        if (gorevlerHashMap.isEmpty()) {
            System.out.printf("%s%n", "Boş");
        }
        for (Integer x : gorevlerHashMap.keySet()) {
            String gorevName = gorevlerHashMap.get(x).get(0);
            String category = gorevlerHashMap.get(x).get(1);
            String isDone = gorevlerHashMap.get(x).get(2);
            System.out.printf("%d %-30s %-10s %-10s %n", x, gorevName, category, isDone);
        }

    }
    public static void CopKutusu(HashMap<Integer, ArrayList<String>> coplerHashMap){
        if (coplerHashMap.isEmpty()) {
            System.out.println("Çöp kutusu boş.");
        } else {
            System.out.println("ÇÖP KUTUSU:");
            System.out.printf("%s %-30s %-10s %-10s %n", "N", "Görev", "Kategori", "Yapılma durumu");
            for (Integer x : coplerHashMap.keySet()) {
                String gorevName = coplerHashMap.get(x).get(0);
                String category = coplerHashMap.get(x).get(1);
                String isDone = coplerHashMap.get(x).get(2);
                System.out.printf("%d %-30s %-10s %-10s %n", x, gorevName, category, isDone);
            }
        }


    }
    public static void GorevGeriGetirme(Scanner scanner,HashMap<Integer, ArrayList<String>> gorevlerHashMap,HashMap<Integer, ArrayList<String>> coplerHashMap){
        if (coplerHashMap.isEmpty()) {
            System.out.println("Çöp kutusu boş.");
        } else {
            System.out.println("Çöp kutusundan çıkarmak istediğiniz görevi yazınız");
        }
//        for (int i = 0; i <= coplerHashMap.size(); i++) {
//            System.out.println((i) + ". " + copler.get(i));
//            int index2 = scanner.nextInt();
//            if (index2 >= 0 && index2 < copler.size()) {
//                String geriGetirilenGorev = copler.remove(index2);
//                gorevler.add(geriGetirilenGorev);
//                System.out.println("Görev çöpten çıkarıldı");
//            }
//        }
        System.out.printf("%s %-30s %-10s %-10s %n", "N", "Görev", "Kategori", "Yapılma durumu");
        for (Integer x : coplerHashMap.keySet()) {
            String gorevName = coplerHashMap.get(x).get(0);
            String category = coplerHashMap.get(x).get(1);
            String isDone = coplerHashMap.get(x).get(2);
            System.out.printf("%d %-30s %-10s %-10s %n", x, gorevName, category, isDone);
        }
        int index = scanner.nextInt();
        if (index >= 0 && index <= gorevlerHashMap.size()) {
            gorevlerHashMap.put(gorevlerHashMap.size()+1,new ArrayList<String>());
            gorevlerHashMap.get(gorevlerHashMap.size()).add(coplerHashMap.get(index).get(0));
            gorevlerHashMap.get(gorevlerHashMap.size()).add(coplerHashMap.get(index).get(1));
            gorevlerHashMap.get(gorevlerHashMap.size()).add(coplerHashMap.get(index).get(2));
            coplerHashMap.remove(index);
            System.out.println("Görev çöpten çıkarıldı");
        }

    }

    public static void Kategori() {

//        kategoriHash.put(1, "İş");
//        kategoriHash.put(2, "Okul");
//        kategoriHash.put(3, "Günlük Yaşam");

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

    private static boolean isCategoryValid(String category) {
        return categoryList.contains(category);
    }

    public static void KategoriEkleme() {
        Scanner scanner = new Scanner(System.in);

//        System.out.println("Gorevi Hangi Kategoriye Kaydetmek Istersiniz ?\n1-" + kategoriHash.get(1) +
//                "\n2-" + kategoriHash.get(2) + "\n3-" + kategoriHash.get(3) + "\n4-Yeni Kategori Olustur");

        System.out.println("Yeni kategori ismini giriniz.");

        boolean kategorieklemebabapro = true;

        while (kategorieklemebabapro) {


            System.out.println("Ekleyeceginiz Kategorinin Adi Ne Olsun");
            String kategoriAdi = scanner.nextLine();
            categoryList.add(kategoriAdi);
            System.out.println(kategoriAdi + " Adli Kategori Basariyla Eklendi");

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

    public static void KategoriCikarma() {
        Scanner scanner = new Scanner(System.in);
        boolean choiseCikarma = true;
        while (choiseCikarma) {
            System.out.println("Silmek istediginiz kategorinin numarasini giriniz : ");
            KategoriGoruntuleme();
            int kategoriCikarma = scanner.nextInt();
            if (kategoriCikarma <= categoryList.size()) {
                categoryList.remove(kategoriCikarma);
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
//        System.out.println(kategoriHash); Mert
        for (int i = 0; i < categoryList.size(); i++) {
            System.out.println(i+". "+categoryList.get(i));
        }
    }

    public static void KategoriFiltreleme(String category) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hangi numarali kategorinin icerigini gormek istiyorsunuz ?");
        KategoriGoruntuleme();
        int kategorigoruntuleme = scanner.nextInt();
    }

}

