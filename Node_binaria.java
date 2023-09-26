package com.mycompany.node_binaria;

public class Node_binaria {
    
    public static void removerMaior(Node atual, Node pai){

        if(atual.direita != null){
            removerMaior(atual.direita, atual);
        }else{
        
            System.out.println("Removendo "+atual.info+" de seu pai "+pai.info);
            pai.direita = null;
        }
    }
    
    public static void removerMenor(Node atual, Node pai){

        if(atual.esquerda != null){
            removerMenor(atual.esquerda, atual);
        }else{
        
            System.out.println("Removendo "+atual.info+" de seu pai "+pai.info);
            pai.esquerda = null;
        }
    }

    public static void criar_entrada(Node pai, int info) {
        
        if (info < pai.info) { 
            
            if (pai.esquerda != null) { 
                
                criar_entrada(pai.esquerda, info);
            } 
            else {
                
                Node n = new Node();
                n.info = info;
                pai.esquerda = n;       
            }
        }
                
        else{
            
          if (pai.direita != null) {
            criar_entrada(pai.direita, info);
          } 
          
          else {
            Node n = new Node();
            n.info = info;
            pai.direita = n;
          }
        }
      }
    
    public static void main(String[] args) {
        
        int[] valores = {14, 15, 4, 9, 7, 18, 3, 5, 16, 4, 20, 17, 9, 14, 5};
        ArvoreBinaria arvore = new ArvoreBinaria();
        
        arvore.raiz = new Node();
        arvore.raiz.info = valores[0];
        
        for(int i = 1; i<=13; i++){
            
            criar_entrada(arvore.raiz, valores[i]);
           
        }
        arvore.printPreOrder(arvore.raiz);
        System.out.println("\n");
        arvore.printInOrder(arvore.raiz);
        System.out.println("\n");
        arvore.printPostOrder(arvore.raiz);
        
        removerMaior(arvore.raiz, arvore.raiz);
        removerMenor(arvore.raiz, arvore.raiz);
    }
}
