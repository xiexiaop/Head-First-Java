import java.io.*;

class DungeonGame implements Serializable {
    int x = 3;
    transient int y = 4;
    int z = 5;

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    int getZ() {
        return z;
    }
}

class DungeonTest{
    public static void main(String[] args) {
        DungeonGame d = new DungeonGame();
        System.out.println(d.getX()+d.getY()+d.getZ());

        try {
            //Output
            FileOutputStream fos = new FileOutputStream("dg.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(d);
            oos.close();


            //Input
            FileInputStream fis = new FileInputStream("dg.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            d = (DungeonGame) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(d.getX()+d.getY()+d.getZ());
    }
}