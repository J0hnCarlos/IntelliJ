public class LibrarySystem {
    public static void main(String[] args){
//        Book b1 = new Book("B001" , "Divergent" , "Veronica Roth");
//        Book b2 = new Book("B002" , "Green Eggs and Ham" , "Dr Seuss");

        Book[] b = new Book[2];
        b[0] = new Book("B001" , "Divergent" , "Veronica Roth");
        b[1] = new Book("B002" , "Green Eggs and Ham" , "Dr Seuss");

        System.out.println(b[0].toString());
        System.out.println(b[1].toString());

        b[0].borrow("m1234");
        System.out.println(b[0].toString());

        b[0].returnBook();
        b[1].returnBook();

        int i = 0;

        while (i < b.length){
            System.out.println("\n" + b[i].toString());
            i++;
        }

//        System.out.println("\n" + b[0].toString());
//        System.out.println(b[1].toString());
    }
}
