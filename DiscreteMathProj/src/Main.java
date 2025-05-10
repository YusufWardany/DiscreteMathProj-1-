import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner Console = new Scanner(System.in);

        //To read the input in the matrix

        System.out.print("Enter the number of the vertices:");

        int number = Console.nextInt();
        int[][] Matrix = new int[number][number];
        System.out.print("Enter the adjacency matrix:");

        for (int i = 0; i < number; i++) {
            for (int y = 0; y < number; y++) {
                Matrix[i][y] = Console.nextInt();

            }
        }

        //To check if the graph is reflexive

        boolean reflexive = true;
        for (int i = 0; i < number; i++) {
            if (Matrix[i][i] != 1) {
                reflexive = false;
            }
        }
        if (reflexive) {
            System.out.println("The graph is reflexive");
        } else {
            System.out.println("The graph isn't reflexive");
        }

        //To check the symmetry

        boolean symmetric = true;
        for (int i = 0; i < number; i++) {
            for (int y = 0; y < number; y++) {
                if (Matrix[i][y] != Matrix[y][i]) {
                    symmetric = false;
                }
            }
        }
        if (symmetric) {
            System.out.println("The graph is symmetric");
        } else {
            System.out.println("The graph isn't symmetric");
        }

        //To check the transitivity

        boolean transitive = true;
        for (int i = 0; i < number; i++) {
            for (int y = 0; y < number; y++) {
                if (Matrix[i][y] == 1) {
                    for (int m = 0; m < number; m++) {
                        if (Matrix[y][m] == 1 && Matrix[i][m] != 1) {
                            transitive = false;
                        }
                    }

                }
            }
        }
        if (transitive) {
            System.out.println("The graph is tansitive");
        } else {
            System.out.println("The graph isn't transitive");
        }

        //To check the Acyclicity

        boolean acyclicity = true;

        for (int i = 0; i < number; i++) {
            if (Matrix[i][i] == 1) {
                acyclicity = false;
            }
        }
        if (acyclicity) {
            System.out.println("The graph is acyclitic");
        } else {
            System.out.println("The graph isn't acyclitic");
        }

        //To check the connection

        boolean[] Visited = new boolean[number];

        mat(0,Matrix,Visited);

        boolean connected=true;

        for (int i=0;i<number;i++){
            if(!Visited[i]){
                connected=false;

            }
        }
        if(connected){
            System.out.println("The graph is connected");
        }else {
            System.out.println("The graph isn't connected");
        }

        //To check if the graph has an EulerianPath

        boolean EulerianPath=true;
        int oddCount=0;
        for (int i=0;i<number;i++){
            int deg=0;
            for (int y=0;y<number;y++){
                deg+=Matrix[i][y];
            }if(deg%2!=0){
                oddCount++;
            }
        }if(oddCount==0 || oddCount==2){
            System.out.println("The graph has an eularian path");
        }else {
            System.out.println("The graph doens't have an eularian path");
        }

    }
    //the first search to check connectivity

    public static void mat(int vertex,int[][]Matrix,boolean[]Visited){
        Visited[vertex]=true;
        for (int i=0;i< Matrix.length;i++){
            if(!Visited[i] && Matrix[vertex][i]==1){
                mat(i,Matrix,Visited);
            }
        }
    }


}
