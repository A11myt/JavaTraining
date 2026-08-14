package org.EA4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SerialisierungTest {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    Node root = new Node("root");
    Node n1 = new Node("1");
    Node n2 = new Node("2");
    Node n3 = new Node("3");
    Node n4 = new Node("4");
    Node n5 = new Node("5");
    Node n6 = new Node("6");
    Node n7 = new Node("7");

    root.addEdgeTo(n7);
    root.addEdgeTo(n2);
    n2.addEdgeTo(n3);
    n3.addEdgeTo(n4);
    n4.addEdgeTo(n5);
    n5.addEdgeTo(n3);
    n3.addEdgeTo(n6);
    n1.addEdgeTo(n7);
    n7.addEdgeTo(n1);
    n6.addEdgeTo(n1);
    /* 1 */
    // Kanten (Geflecht):
    // (root) --> (n7)
    // (root) --> (n2)
    // (n2)   --> (n3)
    // (n3)   --> (n4)
    // (n4)   --> (n5)
    // (n5)   --> (n3)
    // (n3)   --> (n6)
    // (n1)   --> (n7)
    // (n7)   --> (n1)
    // (n6)   --> (n1)
    //
    // Erreichbarkeit von root aus (Pfad angeben):
    // root:  Startknoten
    // n7:    root -> n7
    // n2:    root -> n2
    // n1:    root -> n7 -> n1
    // n3:    root -> n2 -> n3
    // n4:    root -> n2 -> n3 -> n4
    // n5:    root -> n2 -> n3 -> n4 -> n5
    // n6:    root -> n2 -> n3 -> n6
    //
    // Zyklen im Geflecht:
    // 2er-Zyklus: n1 <--> n7
    // 3er-Zyklus: n3 -> n4 -> n5 -> n3 
    ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream("foo1"));
    oos1.writeObject(n2);
    oos1.close();
    ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("foo2"));
    oos2.writeObject(n7);
    oos2.close();
    root = new Node("root");
    ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("foo1"));
    root.addEdgeTo((Node) ois1.readObject());
    ois1.close();
    ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("foo2"));
    root.addEdgeTo((Node) ois2.readObject());
    ois2.close();
    /* 2 */
    // root (neues, leeres Objekt seit Zeile 65) hat genau zwei ausgehende Kanten:
    // (root) --> (n2ᵃ)   -- Ergebnis von ois1.readObject(), Kopie A
    // (root) --> (n7ᵇ)   -- Ergebnis von ois2.readObject(), Kopie B
    // Kopie A und Kopie B sind komplett getrennte Objekte (zwei unabhaengige
    // ObjectInputStreams), obwohl beide urspruenglich denselben n1/n7-Zyklus
    // enthielten -- keine Kante verbindet Kopie A mit Kopie B.
    //
    // Kanten in Kopie A (Werte n2,n3,n4,n5,n6,n1,n7 -- aus foo1 = alles ab n2 erreichbare):
    // (n2ᵃ) --> (n3ᵃ)
    // (n3ᵃ) --> (n4ᵃ)
    // (n4ᵃ) --> (n5ᵃ)
    // (n5ᵃ) --> (n3ᵃ)
    // (n3ᵃ) --> (n6ᵃ)
    // (n6ᵃ) --> (n1ᵃ)
    // (n1ᵃ) --> (n7ᵃ)
    // (n7ᵃ) --> (n1ᵃ)
    // Zyklen in Kopie A: 2er n1ᵃ <--> n7ᵃ, 3er n3ᵃ -> n4ᵃ -> n5ᵃ -> n3ᵃ
    //
    // Kanten in Kopie B (Werte n7,n1 -- aus foo2 = alles ab n7 erreichbare):
    // (n7ᵇ) --> (n1ᵇ)
    // (n1ᵇ) --> (n7ᵇ)
    // Zyklus in Kopie B: 2er n7ᵇ <--> n1ᵇ (eigenstaendiges Objektpaar, nicht identisch mit n1ᵃ/n7ᵃ)
    }
}

class Node implements Serializable {
  String value;
  private List<Node> edgesTo = new ArrayList<Node>();

  public Node(String value) {
    this.value = value;
  }

  void addEdgeTo(Node node) {
    edgesTo.add(node);
  }
}
