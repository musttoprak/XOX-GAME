import java.util.Scanner;

public class XOX {
    static String[][] xoxMatris;
    static String kazanan;
    public static void main(String[] args) {
        xoxMatris = new String[3][3];
        kazanan="YOK";
        do {
            oyunBasla();
            if(kazanan!="YOK"){
               System.out.println(kazanan+" oyuncusu kazandı.");
            }else{
                System.out.println("kazanan "+kazanan);
            kazanan="YOK";
            }
            System.out.println("OYUN BİTTİ...");
        } while (true);
    }

    public static void oyunBasla() {
        baslangıc();
        yazdır();
        for (int i = 0; i < 5; i++) {
            oyna("x ");
            yazdır();
            kontrol();
            if(kazanan!="YOK"){
                break;
            }
            if(i==4){
               
                break;
            }
            oyna("y ");
            yazdır();
            kontrol();
            if(kazanan!="YOK"){
                break;
            }
        }

    }
    
    public static void yazdır(){
        String[][] tasarim=new String[4][4];
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(xoxMatris[i][j]);
                
            }
            System.out.print("|");
            System.out.println("");
        }
        System.out.println("");
    }
    
    public static void kontrol() {
        String harf = xoxMatris[1][1];
        if (!harf.equalsIgnoreCase("- ")) {
            if (xoxMatris[1][0].equals(harf) && xoxMatris[1][2].equals(harf)) {
                System.out.println("orta yatay");
                kazanan=harf;
              
            } else if (xoxMatris[2][0].equals(harf) && xoxMatris[0][2].equals(harf)) {
                System.out.println("sag ustten,sol alta capraz");
                kazanan=harf;
               
            } else if (xoxMatris[0][0].equals(harf) && xoxMatris[2][2].equals(harf)) {
                System.out.println("sol ustten,sag alta capraz");
                kazanan=harf;
            
            } else if (xoxMatris[0][1].equals(harf) && xoxMatris[2][1].equals(harf)) {
                System.out.println("orda dikey");
                kazanan=harf;
              
            }
        }

        harf = xoxMatris[0][0];
        if (!harf.equalsIgnoreCase("- ")) {
            if (xoxMatris[0][1].equals(harf) && xoxMatris[0][2].equals(harf)) {
                System.out.println("ust yatay");
                kazanan=harf;
                
            } else if (xoxMatris[1][0].equals(harf) && xoxMatris[2][0].equals(harf)) {
                System.out.println("ust dikey");
                kazanan=harf;
                
            }
        }

        harf = xoxMatris[2][0];
        if (!harf.equalsIgnoreCase("- ")) {

            if (xoxMatris[2][1].equals(harf) && xoxMatris[2][2].equals(harf)) {
                System.out.println("alt yatay");
                kazanan=harf;
            }
        }

        harf = xoxMatris[0][2];
        if (!harf.equalsIgnoreCase("- ")) {
            if (xoxMatris[1][2].equals(harf) && xoxMatris[2][2].equals(harf)) {
                System.out.println("son dikey");
                kazanan=harf;
            }
        }
        System.out.println("Sırada ki.");
    }

    public static void oyna(String oyuncu) {
        System.out.println("Sıra " + oyuncu + " oyuncusunda lütfen satır ve sütün numarasını giriniz.");
        System.out.print("Sütün: ");
        Scanner sutunScanner = new Scanner(System.in);
        int sutunNumarası = sutunScanner.nextInt();
        System.out.print("Satır: ");
        Scanner satırScanner = new Scanner(System.in);
        int satırNumarası = satırScanner.nextInt();
        if(xoxMatris[sutunNumarası - 1][satırNumarası - 1]=="- "){
            xoxMatris[sutunNumarası - 1][satırNumarası - 1] = oyuncu;
        }else{
            System.out.println("Lütfen boş satır sütün seçiniz");
            oyna(oyuncu);
        }
       
    }

    public static void baslangıc() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                xoxMatris[i][j] = "- ";
            }
        }
    }
}
