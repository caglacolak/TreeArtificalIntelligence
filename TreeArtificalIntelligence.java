/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treeartificalıntelligence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class TreeArtificalIntelligence {
    static ArrayList<Node> str = new ArrayList<Node>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        File file = new File("bn.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileReader fileReader = new FileReader(file);
        String line;

        BufferedReader br = new BufferedReader(fileReader);

        int i=0,nodecount=0;
        
        
        List<String> temp = new ArrayList<>();
        String m="";
        boolean inArray=false;
        while ((line = br.readLine()) != null) {
            if(i==0){
                nodecount=Integer.parseInt(line);
                i++;
            }else{
                i++;
                char nodeChar;
                for(int k=0;k<=2;k++){
                    nodeChar=line.charAt(k);
                    k++;
                    m=m+nodeChar;
                    temp.add(String.valueOf(nodeChar));   
                }
                
            }

        }
        
        String tempp="";
 
      for (int ii = 0; ii < m.length(); ii++) {
         if(tempp.indexOf(m.charAt(ii)) == -1 ){
            tempp = tempp + m.charAt(ii);
            str.add(new Node<String>(String.valueOf(m.charAt(ii))));
         }
      }
 
      double resultab=1.0,resultoabc=1.0,A=1.0,B=1.0,C=1.0,O=1.0,negA=1.0,negB=1.0;
      System.out.println(tempp);
      for(int p=0;p<tempp.length();p++){
          readtext(String.valueOf(tempp.charAt(p)));
          if(tempp.charAt(p)=='H'){
              
              A=readtext(String.valueOf(tempp.charAt(p)));
              resultab=resultab*A;
              negA=1-A;
              resultoabc=resultoabc*negA;
          }if(tempp.charAt(p)=='L'){
               B=readtext(String.valueOf(tempp.charAt(p)));
              resultab=resultab*readtext(String.valueOf(tempp.charAt(p)));
               negB=1-B;
              resultoabc=resultoabc*negB;
          }
          if(tempp.charAt(p)=='P'){
              resultab=resultab*readtext(String.valueOf(tempp.charAt(p)));
              C=readtext(String.valueOf(tempp.charAt(p)));
              resultoabc=resultoabc*C;
          }
          if(tempp.charAt(p)=='E'){
              resultab=resultab*readtext(String.valueOf(tempp.charAt(p)));

              O=readtext(String.valueOf(tempp.charAt(p)));
              resultoabc=resultoabc*O;
          }
          if(tempp.charAt(p)=='I'){
             resultab=resultab*readtext(String.valueOf(tempp.charAt(p)));

              O=readtext(String.valueOf(tempp.charAt(p)));
              resultoabc=resultoabc*O;
          }
      }
      System.out.println("Prob(H,E,L,P,E): "+resultab);
      System.out.println("Prob(H,-L,-P,E): "+resultoabc);

    
      createTree(m);
    

        

        br.close();
        
       
     
        
        
       // printTree(createTree(),"");
        

    }
    
     private static Node<String> createTree(String m) {
         for(int o=0;o<m.length()-1;o++){             
             for(int w=0;w<str.size();w++){
                if(str.get(w).getData().equals(m.charAt(o))){
                   for(int y=0;y<str.size();y++){
                        if(m.charAt(o+1)==str.get(y).getData().toString().charAt(0)){
                           str.get(w).addChild(str.get(y)); 
                        } 
                   } 
                } 
            }
             o++;
    
        }
        System.out.print(str.get(0).getParents());
        printTree(str.get(0),"");
        Node<String> root = new Node<>("0");
        Node<String> nodeA = root.addChild(new Node<String>("A"));
        Node<String> nodeB = root.addChild(new Node<String>("B"));

        Node<String> nodeC = nodeA.addChild(new Node<String>("C"));
        nodeC =nodeB.addChild(nodeC);
        
        
        System.out.print(nodeC.getParents().size());
        
        
        return root;
    }
     private static <T> void printTree(Node<T> node, String appender) {
        System.out.println(appender + node.getData());
        node.getChildren().forEach(each ->  printTree(each, appender + appender));
 }
     
     private static double readtext(String name) throws IOException{
          File file = new File(name+".txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileReader fileReader = new FileReader(file);
        String line;
         int i=0,nodecount=0;
         List<String> temp = new ArrayList<>();
        String m="";
        BufferedReader br = new BufferedReader(fileReader);
        double probtrue= Double.parseDouble(br.readLine());
        
        return probtrue;

        
     }
}
